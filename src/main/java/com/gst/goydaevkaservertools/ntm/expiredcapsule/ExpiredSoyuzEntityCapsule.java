package com.gst.goydaevkaservertools.ntm.expiredcapsule;

import com.gst.goydaevkaservertools.CORE;
import com.hbm.entity.missile.EntitySoyuzCapsule;
import com.hbm.inventory.container.ContainerSoyuzCapsule;
import com.hbm.inventory.gui.GUISoyuzCapsule;
import com.hbm.tileentity.IGUIProvider;
import com.hbm.tileentity.machine.storage.TileEntitySoyuzCapsule;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ExpiredSoyuzEntityCapsule extends EntitySoyuzCapsule implements IInventory {
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

    @Override
    public int getSizeInventory() {
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(int slotIn) {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {

    }

    @Override
    public String getInventoryName() {
        return "";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return false;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }
}
