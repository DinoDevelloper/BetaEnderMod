package ed.enderdeath.mod.Item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;

public class BaieSeedRainbow extends ItemReed {

	public BaieSeedRainbow(Block block) {
		super(block);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setTextureName(enderdeath.MODID + ":BaieSeedRainbow");
		this.setUnlocalizedName("BaieSeedRainbow");
	}
	  @Override
		@SideOnly(Side.CLIENT)
		public EnumRarity getRarity(ItemStack itemstack)
		{
		   return EnumRarity.epic;
		}
}
