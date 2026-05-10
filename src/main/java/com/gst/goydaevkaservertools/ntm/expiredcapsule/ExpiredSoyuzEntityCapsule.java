package com.gst.goydaevkaservertools.ntm.expiredcapsule;

import com.gst.goydaevkaservertools.CORE;
import com.hbm.entity.missile.EntitySoyuzCapsule;
import com.hbm.inventory.container.ContainerSoyuzCapsule;
import com.hbm.inventory.gui.GUISoyuzCapsule;
import com.hbm.tileentity.IGUIProvider;
import com.hbm.tileentity.machine.storage.TileEntitySoyuzCapsule;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.logging.Logger;

public class ExpiredSoyuzEntityCapsule extends EntitySoyuzCapsule {
    private SoyuzPayloadCallerContainer phantomContainer;

    public ExpiredSoyuzEntityCapsule(World p_i1582_1_) {
        super(p_i1582_1_);
    }
    //Переделать на адекватные миксины
    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!worldObj.isRemote && this.isDead) {

            TileEntitySoyuzCapsule capsule = (TileEntitySoyuzCapsule) worldObj.getTileEntity((int) (this.posX), (int) (this.posY + 1), (int) (this.posZ));

            if (capsule != null) {
                capsule.setInventorySlotContents(18, null);
            }

        }

    }

}
