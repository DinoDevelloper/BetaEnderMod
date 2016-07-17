package ed.enderdeath.mod.Block;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class JumpBlock extends Block 
{



	public JumpBlock() {
		super(Material.rock);
		setBlockName("JumpBlock");
		setBlockTextureName(enderdeath.MODID + ":JumpBlock");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(1.0F);
	    setResistance(5.0F);
	    setHarvestLevel("pickaxe", 1);
	}
	
	 public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	    {
	          
	                  
	    }
	 public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	    {
	        float f = 0.125F;
	        return AxisAlignedBB.getBoundingBox((double)p_149668_2_, (double)p_149668_3_, (double)p_149668_4_, (double)(p_149668_2_ + 1), (double)((float)(p_149668_3_ + 1) - f), (double)(p_149668_4_ + 1));
	    }

	    /**
	     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
	     */
	    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
	    {
	    	p_149670_5_.motionY = 1.3F;
	    	p_149670_5_.fallDistance = -10000000;
	    	if (p_149670_5_.fallDistance == (long) -1000000000)
			{
	    		p_149670_5_.fallDistance = 0;
			}	
	    }
}
