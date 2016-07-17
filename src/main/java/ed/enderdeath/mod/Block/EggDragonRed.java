package ed.enderdeath.mod.Block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EggDragonRed extends BlockDragonEgg
{

	public EggDragonRed(Material material) {
		super();
		this.setBlockTextureName(enderdeath.MODID + ":EggDragonRed");
		this.setBlockName("EggDragonRed");
		setCreativeTab(CreativeTabs.tabBlock);
	}
	 public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	     {
		 this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
	     }
	 public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	    {
	        return new TileEntityMobSpawner();
	    }

	    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	    {
	        return null;
	    }

	    /**
	     * Returns the quantity of items to drop on block destruction.
	     */
	    public int quantityDropped(Random p_149745_1_)
	    {
	        return 0;
	    }

	    /**
	     * Drops the block items with a specified chance of dropping the specified items
	     */
	    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
	    {
	        if (!p_149674_1_.isRemote)
	        {
	            if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && p_149674_1_.getBlockLightOpacity(p_149674_2_, p_149674_3_ + 1, p_149674_4_) > 2)
	            {
	                p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.air);
	            }
	            else if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9)
	            {
	                for (int l = 0; l < 4; ++l)
	                {
	                    int i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
	                    int j1 = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
	                    int k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
	                    Block block = p_149674_1_.getBlock(i1, j1 + 1, k1);

	                    if (p_149674_1_.getBlock(i1, j1, k1) == this && p_149674_1_.getBlockMetadata(i1, j1, k1) == 0 && p_149674_1_.getBlockLightValue(i1, j1 + 1, k1) >= 4 && p_149674_1_.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
	                    {
	                        p_149674_1_.setBlock(i1, j1, k1, Blocks.air);
	                        System.out.println("Test REUSSI");
	                    }
	                }
	            }
	        }
	    }

	    private Random rand = new Random();
	    @Override
	    public int getExpDrop(IBlockAccess world, int metadata, int fortune)
	    {
	        return 15 + rand.nextInt(15) + rand.nextInt(15);
	    }

	    /**
	     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	     */
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }

	    /**
	     * Gets an item for the block being called on. Args: world, x, y, z
	     */
	    @SideOnly(Side.CLIENT)
	    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
	    {
	        return Item.getItemById(0);
	    }
	 
   
}
