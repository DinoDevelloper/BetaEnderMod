package ed.enderdeath.mod.block;

import java.util.Random;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockMiner extends Block
{

    public BlockMiner(Material material)
    {
        super(material.rock);
        setBlockName("BlockMiner");
        setBlockTextureName(Enderdeath.MODID + ":block_miner");
        setHardness(30.0F);
        setResistance(30.0F);
        setStepSound(Block.soundTypePiston);
        setCreativeTab(CreativeTabs.tabBlock);
        setHarvestLevel("pickaxe", 3);
    }

    public Item getItemDropped(int metadata, Random random, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }
}
