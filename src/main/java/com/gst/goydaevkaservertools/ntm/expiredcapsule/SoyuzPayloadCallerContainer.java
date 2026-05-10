package com.gst.goydaevkaservertools.ntm.expiredcapsule;

import com.hbm.tileentity.machine.storage.TileEntitySoyuzCapsule;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.chunk.IChunkProvider;

public class SoyuzPayloadCallerContainer extends Container {

    public InventoryBasic buffetInventory;
    private int _x;
    private int _y;
    private int _z;
    public SoyuzPayloadCallerContainer(InventoryPlayer invPlayer, int x, int y, int z) {
        buffetInventory = new InventoryBasic("tmp_capsule", true, 18);

        _x = x;
        _y = y;
        _z = z;

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                this.addSlotToContainer(new Slot(buffetInventory, j + i * 6, 8 + j * 18 + 18 * 2, 17 + i * 18));
            }
        }

        //this.addSlotToContainer(new Slot(buffetInventory, 18, 8, 35));

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int i = 0; i < 9; i++)
        {
            this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int par2)
    {
        ItemStack var3 = null;
        Slot var4 = (Slot) this.inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();

            if (par2 <= buffetInventory.getSizeInventory() - 1) {
                if (!this.mergeItemStack(var5, buffetInventory.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var5, 0, buffetInventory.getSizeInventory(), false))
            {
                return null;
            }

            if (var5.stackSize == 0)
            {
                var4.putStack((ItemStack) null);
            }
            else
            {
                var4.onSlotChanged();
            }
        }

        return var3;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }


    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_) {
        super.onContainerClosed(p_75134_1_);
        if (!p_75134_1_.worldObj.isRemote) {
            ExpiredSoyuzEntityCapsule capsule = new ExpiredSoyuzEntityCapsule(p_75134_1_.getEntityWorld());

            ItemStack[] buffer = new ItemStack[18];

            for (int i = 0; i < 18; i++) {
                buffer[i] = buffetInventory.getStackInSlot(i);
            }

            capsule.payload = buffer;

            capsule.setPosition(_x + 0.5, _y, _z + 0.5);

            IChunkProvider provider = p_75134_1_.getEntityWorld().getChunkProvider();
            provider.loadChunk(_x >> 4, _z >> 4);

            p_75134_1_.getEntityWorld().spawnEntityInWorld(capsule);
        }
    }
}

