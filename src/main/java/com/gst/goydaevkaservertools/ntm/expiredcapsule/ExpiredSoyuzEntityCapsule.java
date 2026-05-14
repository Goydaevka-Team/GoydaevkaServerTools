package com.gst.goydaevkaservertools.ntm.expiredcapsule;

import net.minecraft.world.World;

import com.hbm.entity.missile.EntitySoyuzCapsule;
import com.hbm.tileentity.machine.storage.TileEntitySoyuzCapsule;

public class ExpiredSoyuzEntityCapsule extends EntitySoyuzCapsule {

    public ExpiredSoyuzEntityCapsule(World p_i1582_1_) {
        super(p_i1582_1_);
    }

    // Переделать на адекватные миксины
    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!worldObj.isRemote && this.isDead) {

            TileEntitySoyuzCapsule capsule = (TileEntitySoyuzCapsule) worldObj
                .getTileEntity((int) (this.posX), (int) (this.posY + 1), (int) (this.posZ));

            capsule.setInventorySlotContents(18, null);
        }

    }

}
