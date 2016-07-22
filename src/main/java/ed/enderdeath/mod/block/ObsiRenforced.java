package ed.enderdeath.mod.block;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ObsiRenforced extends Block
{

    public ObsiRenforced()
    {
        super(Material.rock);
        setBlockName("ObsidienRenforced");
        setBlockTextureName(Enderdeath.MODID + ":ObsidienRenforced");
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(1.0F);
        setResistance(250000.0F);
        setHarvestLevel("pickaxe", 3);

    }

    public int getMobilityFlag()

    {

        return 2;

    }

}
