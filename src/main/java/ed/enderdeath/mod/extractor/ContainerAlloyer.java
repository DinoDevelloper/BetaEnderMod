package ed.enderdeath.mod.extractor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAlloyer extends Container
{
    private TileEntityAlloyer tileAlloyer;
    private int workingTime;
    private int workingTimeNeeded;

    public ContainerAlloyer(TileEntityAlloyer tile, InventoryPlayer inventory)
    {
        this.tileAlloyer = tile;
        this.addSlotToContainer(new Slot((IInventory)tile, 0, 43, 17));
        this.addSlotToContainer(new Slot((IInventory)tile, 1, 69, 17));
        this.addSlotToContainer(new Slot((IInventory)tile, 2, 56, 53));
        this.addSlotToContainer(new AlloyerSlotResult(tile, 3, 116, 35));
        this.addSlotToContainer(new Slot((IInventory)tile, 4, 150, 17));
        this.bindPlayerInventory(inventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.tileAlloyer.isUseableByPlayer(player);
    }

    private void bindPlayerInventory(InventoryPlayer inventory)
    {
        int i;
        for(i = 0; i < 3; ++i)
        {
            for(int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int quantity)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(quantity);

        if(slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if(quantity < this.tileAlloyer.getSizeInventory())
            {
                if(!this.mergeItemStack(itemstack1, this.tileAlloyer.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if(!this.mergeItemStack(itemstack1, 0, this.tileAlloyer.getSizeInventory(), false))
            {
                return null;
            }

            if(itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }

    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        this.tileAlloyer.closeInventory();
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for(int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if(this.workingTime != this.tileAlloyer.workingTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tileAlloyer.workingTime);
            }

            if(this.workingTimeNeeded != this.tileAlloyer.workingTimeNeeded)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tileAlloyer.workingTimeNeeded);
            }
        }

        this.workingTime = this.tileAlloyer.workingTime;
        this.workingTimeNeeded = this.tileAlloyer.workingTimeNeeded;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value)
    {
        if(id == 0)
        {
            this.tileAlloyer.workingTime = value;
        }

    }
}
