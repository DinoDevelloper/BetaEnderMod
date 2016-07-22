package ed.enderdeath.mod.tool.toolBase;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ToolPickaxe extends ItemPickaxe
{

    public ToolPickaxe(ToolMaterial material)
    {
        super(material);
    }

    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(input.getItem() == this && repair.getItem() == Enderdeath.hulmini)
        {
            return true;
        }
        return false;
    }

    public boolean hasEffect(ItemStack stack, int pass)
    {
        return false;
    }

}
