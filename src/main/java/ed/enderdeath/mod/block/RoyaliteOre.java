package ed.enderdeath.mod.block;

import java.util.Random;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class RoyaliteOre extends Block
{

    public RoyaliteOre(Material material)
    {
        super(material.rock);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName("RoyaliteOre");
        setBlockTextureName(Enderdeath.MODID + ":RoyaliteOre");
        setHardness(5.0F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 3);
    }

    public Item getItemDropped(int metadata, Random random, int fortune)
    {
        return Enderdeath.royalite;
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

            if(this == Enderdeath.royaliteOre)
            {
                j1 = MathHelper.getRandomIntegerInRange(rand, 2, 10);
            }

            return j1;
        }
        return 0;
    }

}
