package ed.enderdeath.mod.Block;

import java.util.Random;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BaiePlantFire extends Block implements IPlantable
{

public IIcon fastIcons[];
public IIcon fancyIcons[];
public String textureNames[];
public IIcon icon;
public Item item;

public BaiePlantFire(Item item)
{
    super(Material.leaves);
    setTickRandomly(true);
    setHardness(0.0F);
    setBlockName("BaiePlantFire");
    setStepSound(soundTypeGrass);
    disableStats();
    setTickRandomly(true);
    float minZ;
    float minX = minZ = 0.125F;
    float maxZ;
    float maxX = maxZ = 0.875F;
    float maxY = 1.0F;
    setBlockBounds(minX, (float)minY, minZ, maxX, maxY, maxZ);
    this.item = item;
    textureNames = new String[2];
    textureNames[0] = "Fire1";
    textureNames[1] = "Fire2";
}

public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
{
    if(!world.isRemote)
    {
        int meta = world.getBlockMetadata(x, y, z);
        if(meta > 1)
        {
            world.setBlock(x, y, z, this, 0, 3);
            world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(item)));
        }
    }
}

public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, 
        float par8, float par9)
{
    int meta = world.getBlockMetadata(x, y, z);
    if(meta >= 1)
    {
        if(world.isRemote)
        {
            return true;
        } else
        {
            world.setBlock(x, y, z, this, 0, 3);
            world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(enderdeath.BaieRed)));
            return true;
        }
    } else
    {
        return false;
    }
}

public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
{
    return enderdeath.BaiePlantFireItem;
}

public void updateTick(World world, int x, int y, int z, Random random1)
{
    if(world.isRemote)
    {
        return;
    }
    if(random1.nextInt(20) == 0)
    {
        int meta = world.getBlockMetadata(x, y, z);
        if(meta < 2)
        {
            world.setBlock(x, y, z, this, meta + 1, 3);
        }
    }
}

public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
{
    return EnumPlantType.Cave;
}

public Block getPlant(IBlockAccess world, int x, int y, int i)
{
    return this;
}

public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
{
    return world.getBlockMetadata(x, y, z);
}

public void registerBlockIcons(IIconRegister icon)
{
    fastIcons = new IIcon[2];
    fancyIcons = new IIcon[2];
    for(int i = 0; i < fastIcons.length; i++)
    {
        if(textureNames[i] != "")
        {
            fancyIcons[i] = icon.registerIcon((new StringBuilder()).append("enderdeath:").append(textureNames[i]).append("Fancy").toString());
            fastIcons[i] = icon.registerIcon((new StringBuilder()).append("enderdeath:").append(textureNames[i]).append("Fast").toString());
            this.icon = icon.registerIcon(enderdeath.MODID + ":Fire2Fast");
        }
    }

}

public IIcon getIcon(int side, int metadata)
{
    if(metadata < 2)
    {
        return fancyIcons[metadata];
    } else
    {
        return icon;
    }
}

public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int x, int y, int z, int meta)
{
    if(meta > 1)
    {
        return super.shouldSideBeRendered(iblockaccess, x, y, z, meta);
    } else
    {
        return true;
    }
}


public boolean isOpaqueCube()
{
    return false;
}

public boolean canPlaceBlockAt(World world, int x, int y, int z)
{
    return world.getBlock(x, y - 1, z).isOpaqueCube();
}
}
