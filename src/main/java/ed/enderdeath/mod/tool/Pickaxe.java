package ed.enderdeath.mod.tool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.tool.toolBase.ToolPickaxe;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class Pickaxe extends ToolPickaxe
{

    public Pickaxe(ToolMaterial p_i45347_1_)
    {
        super(p_i45347_1_);
        setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.epic;
    }

}
