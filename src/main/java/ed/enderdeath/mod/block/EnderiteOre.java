package ed.enderdeath.mod.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EnderiteOre extends Block
{

    public EnderiteOre()
    {
        super(Material.rock);
        this.setBlockName("EnderiteOre");
        this.setBlockTextureName(Enderdeath.MODID + ":EnderiteOre");
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(5.0F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 4);

    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        for(int l = 0; l < 5; ++l)
        {
            double d6 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
            double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
            d6 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = p_149734_5_.nextInt(2) * 2 - 1;
            int j1 = p_149734_5_.nextInt(2) * 2 - 1;
            d3 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.2D;
            d4 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.2D;
            d5 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.2D;
            double d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)j1;
            d5 = (double)(p_149734_5_.nextFloat() * 1.0F * (float)j1);
            double d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
            d3 = (double)(p_149734_5_.nextFloat() * 1.0F * (float)i1);
            p_149734_1_.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

    private Random rand = new Random();

    @Override
    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
    {
        if(this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item.getItemFromBlock(this))
        {
            int j1 = 0;

            if(this == Enderdeath.enderiteOre)
            {
                j1 = MathHelper.getRandomIntegerInRange(rand, 2, 10);
            }

            return j1;
        }
        return 0;
    }
}
