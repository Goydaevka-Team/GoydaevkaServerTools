package com.gst.goydaevkaservertools.goydaevka.dogtag;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerDiedDogtagHandler {

    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent e) {
        // Проверяем, что умер именно игрок
        if (e.entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.entityLiving;

            // Проверяем, что код выполняется на стороне сервера, а не клиента
            if (!player.worldObj.isRemote) {
                // Создаем и спавним TNT на координатах игрока
                ItemStack dogTagI = ItemDogtag.CreateItemStackFromPlayer(player, e.source);
                EntityItem entityItem = new EntityItem(player.worldObj, player.posX, player.posY, player.posZ, dogTagI);
                player.worldObj.spawnEntityInWorld(entityItem);
            }
        }
    }
}
