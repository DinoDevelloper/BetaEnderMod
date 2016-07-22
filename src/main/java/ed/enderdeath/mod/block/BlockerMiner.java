package ed.enderdeath.mod.block;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockerMiner extends Block
{

    public BlockerMiner()
    {
        super(Material.rock);
        setBlockName("BlockMiner");
        setBlockTextureName(Enderdeath.MODID + ":BlockMiner");
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(1.0F);
        setResistance(1.0F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(Block.soundTypeAnvil);
    }

}
