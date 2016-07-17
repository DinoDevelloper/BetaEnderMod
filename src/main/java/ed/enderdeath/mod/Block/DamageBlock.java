package ed.enderdeath.mod.Block;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class DamageBlock  extends Block 
{

	public DamageBlock() {
		super(Material.rock);
		setBlockName("DamageBlock");
		setBlockTextureName(enderdeath.MODID + ":DamageBlock");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(1.0F);
	    setResistance(5.0F);
	    setHarvestLevel("pickaxe", 1);
	    this.setLightLevel(0.1F);
	}

	 public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	    {
	        float f = 0.125F;
	        return AxisAlignedBB.getBoundingBox((double)p_149668_2_, (double)p_149668_3_, (double)p_149668_4_, (double)(p_149668_2_ + 1), (double)((float)(p_149668_3_ + 1) - f), (double)(p_149668_4_ + 1));
	    }

	  
	    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
	    {
	    	p_149670_5_.fallDistance = 5;
	    	p_149670_5_.setFire(300);
	    }

}
