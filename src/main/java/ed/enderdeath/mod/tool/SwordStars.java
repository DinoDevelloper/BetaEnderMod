package ed.enderdeath.mod.tool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import ed.enderdeath.mod.tool.toolBase.ToolAxe;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SwordStars extends ToolAxe
{

    public SwordStars(ToolMaterial material)
    {
        super(material);
        // TODO Auto-generated constructor stub
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.epic;
    }

    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
    {
        super.onUpdate(stack, world, entity, par4, par5);

        if(stack.isItemEnchanted() == false)
        {
            stack.addEnchantment(Enderdeath.fight, 1);
            super.onUpdate(stack, world, entity, par4, par5);
        }
    }
}
