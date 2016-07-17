package ed.enderdeath.mod.Block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class XpOre extends Block
{

	public XpOre() {
		super(Material.rock);
		setBlockName("XpOre");
		setBlockTextureName(enderdeath.MODID + ":XpOre");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(50.0F);
		setHarvestLevel("pickaxe", 4);
	}
	 private Random rand = new Random();
	    @Override
	    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
	    {
	        if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item.getItemFromBlock(this))
	        {
	            int j1 = 0;

	            if (this == enderdeath.XpOre)
	            {
	                j1 = MathHelper.getRandomIntegerInRange(rand, 2, 500);
	            }

	            return j1;
	        }
	        return 0;
	    }
	    public Item getItemDropped(int metadata, Random random,int fortune)
		{
			return  enderdeath.FattingXp;
		}
		public int quantityDropped(Random random)
		{
			return 15;
		}

}
