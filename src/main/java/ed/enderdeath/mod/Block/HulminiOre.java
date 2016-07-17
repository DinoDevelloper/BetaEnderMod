package ed.enderdeath.mod.Block;

import java.util.Random;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class HulminiOre extends Block 
{

	public HulminiOre(Material material) 
	{
		super(Material.rock);
		setBlockName("HulminiOre");
		setBlockTextureName(enderdeath.MODID + ":HulminiOre");
		setCreativeTab(CreativeTabs.tabBlock);
	    setHardness(5.0F);
	    setResistance(5.0F);
	    setHarvestLevel("pickaxe", 3);
		
	}
	public Item getItemDropped(int metadata, Random random,int fortune)
	{
		return  enderdeath.hulmini;
	}
	public int quantityDropped(Random random)
	{
		return 1;
	}
	
	 private Random rand = new Random();
	    @Override
	    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
	    {
	        if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item.getItemFromBlock(this))
	        {
	            int j1 = 0;

	          
	             if (this == enderdeath.HulminiOre)
	            {
	                j1 = MathHelper.getRandomIntegerInRange(rand, 5, 15);
	            }
	         
	         

	            return j1;
	        }
	        return 0;
	    }
}
