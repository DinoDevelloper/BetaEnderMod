package ed.enderdeath.mod.tool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import ed.enderdeath.mod.tool.toolBase.ToolSword;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class UltimateSword extends ToolSword
{

    public UltimateSword(ToolMaterial ToolMaterial)
    {
        super(ToolMaterial);

    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {

        if(stack.isItemEnchanted() == false)
        {
            stack.addEnchantment(Enderdeath.starsPower, 1);
            super.onUpdate(stack, world, entity, slot, selected);
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.epic;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}
