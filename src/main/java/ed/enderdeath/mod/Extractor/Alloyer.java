package ed.enderdeath.mod.Extractor;



import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.Block.RoyaliteOre;
import ed.enderdeath.mod.Block.RubisOre;
import ed.enderdeath.mod.Block.SaphirOre;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Alloyer extends Block implements ITileEntityProvider
{
    public Alloyer(Material material)
    {
        super(material);
        setResistance(30);
        setHardness(3);
        setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockName("Alloyer");
    }

    private static String machineType = "alloyer";
    public static String[] blockTexture = new String[]
    {
    		/* 0 */enderdeath.TEXTURE_NAME + "machine_side",
			/* 1 */enderdeath.TEXTURE_NAME + "machine_side",
			/* 2 */enderdeath.TEXTURE_NAME + "machine_top",
			/* 3 */enderdeath.TEXTURE_NAME + "machine_bottom",
			/* 4 */enderdeath.TEXTURE_NAME + "machine_top"
    };

    private IIcon top, bottom, side, frontOn, frontOff;


	public void registerBlockIcons(IIconRegister iiconRegister)
	{
        this.frontOn = iiconRegister.registerIcon(blockTexture[2]);
        this.frontOff = iiconRegister.registerIcon(blockTexture[1]);
		this.top = iiconRegister.registerIcon(blockTexture[4]);
		this.bottom = iiconRegister.registerIcon(blockTexture[3]);
		this.side = iiconRegister.registerIcon(blockTexture[0]);
	}


    @SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
    {
		if (side == 0)
        {
            return this.bottom;
        }
		else if (side == 1)
        {
            return this.top;
        }

        if ((side == 3 && metadata == 0) || (side == 4 && metadata == 1) || (side == 2 && metadata == 2) || (side == 5 && metadata == 3))
        {
            return this.frontOff;
        }
        return this.side;
	}

    

 
    
   
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
        	player.openGui(enderdeath.instance, 2, world, x, y, z);
        	return true;
        }
    }
    @SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_,
			Random p_149734_5_) {
		for (int l = 0; l < 5; ++l) {
			double d6 = (double) ((float) p_149734_2_ + p_149734_5_.nextFloat());
			double d1 = (double) ((float) p_149734_3_ + p_149734_5_.nextFloat());
			d6 = (double) ((float) p_149734_4_ + p_149734_5_.nextFloat());
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			int i1 = p_149734_5_.nextInt(2) * 2 - 1;
			int j1 = p_149734_5_.nextInt(2) * 2 - 1;
			d3 = ((double) p_149734_5_.nextFloat() - 0.5D) * 0.2D;
			d4 = ((double) p_149734_5_.nextFloat() - 0.5D) * 0.2D;
			d5 = ((double) p_149734_5_.nextFloat() - 0.5D) * 0.2D;
			double d2 = (double) p_149734_4_ + 0.5D + 0.25D * (double) j1;
			d5 = (double) (p_149734_5_.nextFloat() * 1.0F * (float) j1);
			double d0 = (double) p_149734_2_ + 0.5D + 0.25D * (double) i1;
			d3 = (double) (p_149734_5_.nextFloat() * 1.0F * (float) i1);
			p_149734_1_.spawnParticle("lava", d0, d1, d2, d3, d4, d5);
		}
	}
    
    
    
    
    
    public void func_149749_a(World world, int x, int y, int z, Block block, int metadata)
    {
      TileEntity tileentity = world.getTileEntity(x, y, z);
      if ((tileentity instanceof IInventory))
      {
        IInventory inv = (IInventory)tileentity;
        for (int i1 = 0; i1 < inv.getSizeInventory(); i1++)
        {
          ItemStack itemstack = inv.getStackInSlot(i1);
          if (itemstack != null)
          {
            float f = world.rand.nextFloat() * 0.8F + 0.1F;
            float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
            EntityItem entityitem;
            for (float f2 = world.rand.nextFloat() * 0.8F + 0.1F; itemstack.animationsToGo > 0; world.spawnEntityInWorld(entityitem))
            {
              int j1 = world.rand.nextInt(21) + 10;
              if (j1 > itemstack.animationsToGo) {
                j1 = itemstack.animationsToGo;
              }
              itemstack.animationsToGo -= j1;
              
              entityitem = new EntityItem(world, x + f, y + f1, z + f2,new ItemStack(block, j1,metadata));
              float f3 = 0.05F;
              entityitem.distanceWalkedModified = ((float)world.rand.nextGaussian() * f3);
              entityitem.distanceWalkedModified = ((float)world.rand.nextGaussian() * f3 + 0.2F);
              entityitem.distanceWalkedModified = ((float)world.rand.nextGaussian() * f3);
              
            }
          }
        }
        world.func_147453_f(x, y, z, block);
      }
    }
    
 
   

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		
		return new TileEntityAlloyer();
	}
	 

}
