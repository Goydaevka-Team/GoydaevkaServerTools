package com.gst.goydaevkaservertools.ntm.expiredcapsule;

import com.gst.goydaevkaservertools.CORE;
import com.hbm.entity.missile.EntitySoyuzCapsule;
import com.hbm.inventory.container.ContainerSoyuzCapsule;
import com.hbm.inventory.gui.GUISoyuzCapsule;
import com.hbm.items.ModItems;
import com.hbm.particle.ParticleExSmoke;
import com.hbm.tileentity.IGUIProvider;
import com.hbm.tileentity.machine.storage.TileEntitySoyuzCapsule;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.logging.Logger;

public class ExpiredSoyuzEntityCapsule extends EntitySoyuzCapsule {

    public ExpiredSoyuzEntityCapsule(World p_i1582_1_) {
        super(p_i1582_1_);
    }
    //Переделать на адекватные миксины
    @Override
    public void onUpdate() {
        super.onUpdate();

        if (worldObj.isRemote && this.ticksExisted % 5 == 0) {
            ParticleExSmoke fx = new ParticleExSmoke(
                Minecraft.getMinecraft().renderEngine,
                worldObj, posX, posY, posZ
            );
            fx.maxAge = 400;
            fx.motionY = 4.0;
            Minecraft.getMinecraft().effectRenderer.addEffect(fx);
        }

        if (!worldObj.isRemote && this.isDead) {

            TileEntitySoyuzCapsule capsule = (TileEntitySoyuzCapsule) worldObj.getTileEntity((int) (this.posX), (int) (this.posY + 1), (int) (this.posZ));

            capsule.setInventorySlotContents(18, null);
        }

    }

}
