package ed.enderdeath.mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOre extends Block
{

    public BlockOre()
    {
        super(Material.iron);
        setHardness(5.0F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 2);
        setStepSound(soundTypeMetal);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

}
