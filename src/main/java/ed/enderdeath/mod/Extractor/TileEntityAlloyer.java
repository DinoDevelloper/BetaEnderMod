
package ed.enderdeath.mod.Extractor;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.Item.SpeedUpgrade;
import ed.enderdeath.mod.common.enderdeath;

public class TileEntityAlloyer extends TileEntity implements IInventory
{
    private byte direction;
    public byte getDirection()
    {
        return direction;
    }

    public void setDirection(byte direction)
    {
        this.direction = direction;
        this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
    }

    private ItemStack[] contents = new ItemStack[6];
    protected int workingTime = 0;
    protected int workingTimeNeededDefault = 9200;
    protected int workingTimeNeeded = 1200;
    protected int burnTime = 0;
    protected int burnTimeTotal = 0;

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        NBTTagList nbttaglist = new NBTTagList();
        compound.setByte("Direction", this.direction);
        for(int i = 0; i < this.contents.length; ++i)
        {
            if(this.contents[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.contents[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        compound.setTag("Items", nbttaglist);
        compound.setShort("workingTime", (short)this.workingTime);
        compound.setShort("burnTime", (short)this.burnTime);
        compound.setShort("burnTimeTotal", (short)this.burnTimeTotal);
        //compound.setShort("workingTimeNeeded", (short)this.workingTimeNeeded);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.direction = compound.getByte("Direction");
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.contents = new ItemStack[this.getSizeInventory()];

        for(int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if(j >= 0 && j < this.contents.length)
            {
                this.contents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
        this.workingTime = compound.getShort("workingTime");
        this.burnTime = compound.getShort("burnTime");
        //this.workingTimeNeeded = compound.getShort("workingTimeNeeded");
    }

    public int getSizeInventory()
    {
        return this.contents.length;
    }

    public ItemStack getStackInSlot(int slotIndex)
    {
        return this.contents[slotIndex];
    }

    public ItemStack decrStackSize(int slotIndex, int amount)
    {
        if(this.contents[slotIndex] != null)
        {
            ItemStack itemstack;

            if(this.contents[slotIndex].stackSize <= amount)
            {
                itemstack = this.contents[slotIndex];
                this.contents[slotIndex] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.contents[slotIndex].splitStack(amount);

                if(this.contents[slotIndex].stackSize == 0)
                {
                    this.contents[slotIndex] = null;
                }
                this.markDirty();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int slotIndex)
    {
        if(this.contents[slotIndex] != null)
        {
            ItemStack itemstack = this.contents[slotIndex];
            this.contents[slotIndex] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int slotIndex, ItemStack stack)
    {
        this.contents[slotIndex] = stack;

        if(stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
        this.markDirty();
    }

    public String getInventoryName()
    {
        return enderdeath.alloyer.getLocalizedName();
    }

    public boolean hasCustomInventoryName()
    {
        return false;
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        return slot == 3 ? false : true;
    }

    public boolean isBurning()
    {
        return this.workingTime > 0;
    }

    protected boolean canSmelt()
    {
        if(this.contents[0] == null || this.contents[1] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = AlloyerRecipes.smelting().getSmeltingResult(new ItemStack[] {this.contents[0], this.contents[1]});
            if(itemstack == null)
                return false;
            if(this.contents[3] == null)
                return true;
            if(!this.contents[3].isItemEqual(itemstack))
                return false;
            int result = contents[3].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.contents[3].getMaxStackSize();
        }
    }

    public void updateEntity()
    {
        if (this.burnTime > 0)
        {
            burnTime--;
        }
        if (this.canSmelt())
        {
            if (this.burnTime <= 0)
            {
                int time = TileEntityFurnace.getItemBurnTime(contents[2]);
                if (time > 0)
                {
                    this.decrStackSize(2, 1);
                    this.burnTimeTotal = time;
                    this.burnTime = time;
                }
            }
            if (burnTime > 0)
            {
                workingTime++;
            }
        }
        if (this.workingTime >= this.workingTimeNeeded)
        {
            this.smeltItem();
            this.workingTime = 0;
        }
        if (!this.canSmelt() || burnTime <= 0)
        {
            this.workingTime = 0;
        }

        // Update WorkingTime --> Speed Upgrade

        if (contents[4] != null)
        {
            if (contents[4].getItem() == enderdeath.speedUpgrade)
            {
                workingTimeNeeded = SpeedUpgrade.getSpeedUp();
            }

        }
        else
        {
            workingTimeNeeded = workingTimeNeededDefault;
        }
    }
    public void smeltItem()
    {
        if(this.canSmelt())
        {
            ItemStack itemstack = AlloyerRecipes.smelting().getSmeltingResult(new ItemStack[] {this.contents[0], this.contents[1]});
            if(this.contents[3] == null)
            {
                this.contents[3] = itemstack.copy();
            }
            else if(this.contents[3].getItem() == itemstack.getItem())
            {
                this.contents[3].stackSize += itemstack.stackSize;
            }

            this.decrStackSize(0, 1);
            this.decrStackSize(1, 1);
        }
    }

    @SideOnly(Side.CLIENT)
    public int getCookProgress()
    {
        return this.workingTime * 24 / this.workingTimeNeeded;
    }

   
}