package com.gst.goydaevkaservertools.ntm.expiredcapsule;

import com.gst.goydaevkaservertools.CORE;
import com.hbm.inventory.gui.GUISoyuzCapsule;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class SoyuzPayloadCallerGUIHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        CORE.LOG.info("ORDER TO DRAW UI SERVERSIDE");
        return new SoyuzPayloadCallerContainer(player.inventory, x,y,z);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        CORE.LOG.info("ORDER TO DRAW UI CLIENTSIDE");
        return new SoyuzPayloadCallerGUI(player,x,y,z);
    }


}
