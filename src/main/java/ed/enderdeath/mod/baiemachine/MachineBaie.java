package ed.enderdeath.mod.baiemachine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MachineBaie extends BlockContainer
{

    public MachineBaie()
    {
        super(Material.rock);
        this.setResistance(8.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setBlockName("MachineBaie");
        this.setCreativeTab(CreativeTabs.tabDecorations);

    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileEntityMachineTuto();
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }

    private static String machineType = "baie";
    public static String[] blockTexture = new String[] {/* 0 */Enderdeath.TEXTURE_NAME + "baie_side", /* 1 */Enderdeath.TEXTURE_NAME + "baie_side", /* 2 */Enderdeath.TEXTURE_NAME + "baie_top", /* 3 */Enderdeath.TEXTURE_NAME + "baie_bottom", /* 4 */Enderdeath.TEXTURE_NAME + "baie_top"};

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
        if(side == 0)
        {
            return this.bottom;
        }
        else if(side == 1)
        {
            return this.top;
        }

        if((side == 3 && metadata == 0) || (side == 4 && metadata == 1) || (side == 2 && metadata == 2) || (side == 5 && metadata == 3))
        {
            return this.frontOff;
        }
        return this.side;
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        TileEntity tileentity = world.getTileEntity(x, y, z);

        if(tileentity instanceof IInventory)
        {
            IInventory inv = (IInventory)tileentity;
            for(int i1 = 0; i1 < inv.getSizeInventory(); ++i1)
            {
                ItemStack itemstack = inv.getStackInSlot(i1);

                if(itemstack != null)
                {
                    float f = world.rand.nextFloat() * 0.8F + 0.1F;
                    float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for(float f2 = world.rand.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
                    {
                        int j1 = world.rand.nextInt(21) + 10;

                        if(j1 > itemstack.stackSize)
                        {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)world.rand.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)world.rand.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)world.rand.nextGaussian() * f3);

                        if(itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }
                    }
                }
            }

            world.func_147453_f(x, y, z, block);
        }

        super.breakBlock(world, x, y, z, block, metadata);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(world.isRemote)
        {
            return true;
        }
        else
        {
            player.openGui(Enderdeath.instance, 0, world, x, y, z);
            return true;
        }
    }

}
