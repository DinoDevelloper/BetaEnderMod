package ed.enderdeath.mod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;

public class BaieSeedRainbow extends ItemReed
{

    public BaieSeedRainbow(Block block)
    {
        super(block);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureName(Enderdeath.MODID + ":BaieSeedRainbow");
        this.setUnlocalizedName("BaieSeedRainbow");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.epic;
    }
}
