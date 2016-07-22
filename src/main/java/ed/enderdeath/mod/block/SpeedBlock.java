package ed.enderdeath.mod.block;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class SpeedBlock extends Block
{

    public SpeedBlock(Material material)
    {
        super(material.rock);
        setBlockName("SpeedBlock");
        setBlockTextureName(Enderdeath.MODID + ":SpeedBlock");
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(1.0F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 1);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1), (double)((float)(y + 1) - f), (double)(z + 1));
    }

    public void onEntityCollidedWithBlock(World world, int X, int Y, int Z, Entity player)
    {
        player.motionX *= 1.25D;
        player.motionZ *= 1.15D;

    }

}
