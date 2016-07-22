package ed.enderdeath.mod.block;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BrickStonarck extends Block
{

    public BrickStonarck()
    {
        super(Material.rock);
        setBlockName("BrickStonarck");
        setBlockTextureName(Enderdeath.MODID + ":BrickStonarck");
        setCreativeTab(CreativeTabs.tabBlock);

        setHarvestLevel("pickaxe", 3);
    }

}
