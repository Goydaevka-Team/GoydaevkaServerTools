package com.gst.goydaevkaservertools.goydaevka.dogtag;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;

import com.gst.goydaevkaservertools.CORE;

public class ItemDogtag extends Item {

    public static Item DOGTAG;

    public static ItemStack CreateItemStackFromPlayer(EntityPlayer player, DamageSource damageSource) {
        ItemStack stack = new ItemStack(DOGTAG);

        NBTTagCompound nbt = new NBTTagCompound();

        boolean isNotPVP = false;
        EntityPlayer killer = null;

        if (damageSource.getEntity() instanceof EntityPlayer) {
            killer = (EntityPlayer) damageSource.getEntity();
            // Проверка на самоубийство (игрок убил самого себя)
            if (killer == player) {
                isNotPVP = true;
                killer = null;
            }
        } else if (damageSource.getSourceOfDamage() instanceof EntityPlayer) {
            killer = (EntityPlayer) damageSource.getSourceOfDamage();
            if (killer == player) {
                isNotPVP = true;
                killer = null;
            }
        }
        String itemName = "Жетон игрока " + player.getDisplayName();
        nbt.setString("CustomName", itemName);

        String deathReason;

        if (killer != null) {
            deathReason = "Боестолкновение с игроком" + killer.getDisplayName();

        } else {
            deathReason = "Естественный отбор";
        }

        nbt.setString("ReasonOfDeath", deathReason);
        nbt.setBoolean("IsGainedByPVP", killer != null);

        stack.setTagCompound(nbt);
        return stack;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        // Если название еще не установлено - генерируем его
        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound nbt = stack.getTagCompound();
        if (!nbt.hasKey("CustomName")) {
            nbt.setString("CustomName", "CHEATED DOGTAG");
        }
        return nbt.getString("CustomName");
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {

        if (stack.getTagCompound() == null) {
            CORE.LOG.info("RECREATING NBT TAG");
            stack.setTagCompound(new NBTTagCompound());
        }

        NBTTagCompound nbt = stack.getTagCompound();

        if (nbt.getString("ReasonOfDeath") == "Боестолкновение с игроком " + player.getDisplayName()) {
            list.add("МЫ ОБА ЗНАЕМ, КТО В ЭТОМ ВИНОВАТ, НЕ ТАК ЛИ, " + player.getDisplayName() + "?");
        }
        list.add("Причина смерти: " + nbt.getString("ReasonOfDeath"));

        super.addInformation(stack, player, list, advanced);
    }

    public ItemDogtag() {
        super();
        this.setMaxStackSize(16);
        this.setUnlocalizedName("dogtag");
        this.setTextureName("goydaevkaservertools:dogtag");
    }
}
