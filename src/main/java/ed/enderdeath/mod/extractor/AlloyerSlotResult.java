package ed.enderdeath.mod.extractor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class AlloyerSlotResult extends Slot
{
    public AlloyerSlotResult(TileEntityAlloyer tile, int id, int x, int y)
    {
        super((IInventory)tile, id, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return false;
    }

    public ItemStack decrStackSize(int amount)
    {
        return super.decrStackSize(amount);
    }

    public void onPickupFromSlot(EntityPlayer player, ItemStack stack)
    {
        super.onCrafting(stack);
        super.onPickupFromSlot(player, stack);
    }
}
