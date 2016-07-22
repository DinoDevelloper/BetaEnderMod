package ed.enderdeath.mod.item;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemClass extends Item
{
    public boolean isBeaconPayment(ItemStack stack)
    {
        return this == Items.emerald || this == Items.diamond || this == Items.gold_ingot || this == Items.iron_ingot || this == Enderdeath.darkanite || this == Enderdeath.hulmini || this == Enderdeath.royalite || this == Enderdeath.rubis || this == Enderdeath.saphir;
    }

}
