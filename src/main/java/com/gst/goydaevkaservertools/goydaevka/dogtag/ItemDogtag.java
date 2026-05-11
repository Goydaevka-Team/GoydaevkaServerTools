package com.gst.goydaevkaservertools.goydaevka.dogtag;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;

public class ItemDogtag extends Item {

    public static Item DOGTAG;

    public static ItemStack CreateItemStackFromPlayer(EntityPlayer player, DamageSource damageSource) {
        ItemStack stack = new ItemStack(DOGTAG);
        stack.setTagCompound(new NBTTagCompound());
        String itemName = "Жетон игрока " + player.getDisplayName();
        stack.getTagCompound()
            .setString("CustomName", itemName);
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
        super.addInformation(stack, player, list, advanced);

        list.add("Опредленно, для кого то эти жетоны могут представлять особую ценность...");
    }

    public ItemDogtag() {
        super();
        this.setMaxStackSize(16);
        this.setUnlocalizedName("dogtag");
        this.setTextureName("goydaevkaservertools:dogtag");
    }
}
