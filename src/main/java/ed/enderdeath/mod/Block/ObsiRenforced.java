package ed.enderdeath.mod.Block;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ObsiRenforced extends Block 
{

	public ObsiRenforced() {
		super(Material.rock);
		setBlockName("ObsidienRenforced");
		setBlockTextureName(enderdeath.MODID + ":ObsidienRenforced");
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
