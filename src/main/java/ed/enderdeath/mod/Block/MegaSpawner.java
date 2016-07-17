package ed.enderdeath.mod.Block;

import java.util.Random;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MegaSpawner extends BlockContainer
{

	  public MegaSpawner()
	  {
		  super(Material.rock);
		  
this.setBlockName("MegaSpanwer");
this.setBlockTextureName(enderdeath.MODID + ":MegaSpawners");
this.setCreativeTab(CreativeTabs.tabDecorations);
	  }
	  
	  public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	    {
	        return new TileEntityMega();
	    }
	  public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
	    {
	        super.dropBlockAsItemWithChance(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
	    }

	  public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	    {
	        return null;
	    }

	    public int quantityDropped(Random p_149745_1_)
	    {
	        return 0;
	    }

	    public boolean isOpaqueCube()
	    {
	        return false;
	    }
}
