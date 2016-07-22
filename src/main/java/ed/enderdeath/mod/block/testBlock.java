package ed.enderdeath.mod.block;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class testBlock extends Block
{

    public testBlock()
    {
        super(Material.rock);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName("testBlock");
        setBlockTextureName(Enderdeath.MODID + ":testBlock");
        setHardness(5.0F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 2);
        setLightLevel(1.0F);
        setStepSound(Block.soundTypeMetal);

    }

}
