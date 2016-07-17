package ed.enderdeath.mod.Block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockInvisible extends Block
{
	private static final String __OBFID = "CL_00000249";
	public BlockInvisible(Material material,boolean p_i45408_2_) {
		super(material.glass);
		setBlockName("InvisibleBlock");
		setBlockTextureName(enderdeath.MODID + ":InvisibleBlock");
		setBlockUnbreakable();
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
   public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
   {
       super.dropBlockAsItemWithChance(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
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
