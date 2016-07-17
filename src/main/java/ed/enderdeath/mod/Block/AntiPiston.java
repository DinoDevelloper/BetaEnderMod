package ed.enderdeath.mod.Block;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AntiPiston extends Block {

	public AntiPiston(Material p_i45394_1_) {
		super(p_i45394_1_.rock);
		setBlockName("AntiPiston");
		setBlockTextureName(enderdeath.MODID + ":C");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(1.0F);


		
	}

    public int getMobilityFlag()

    {

        return 2;

    
	}

}
