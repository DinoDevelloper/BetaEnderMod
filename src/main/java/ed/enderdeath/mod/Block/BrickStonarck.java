package ed.enderdeath.mod.Block;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BrickStonarck extends Block{

	public BrickStonarck() {
		super(Material.rock);
		setBlockName("BrickStonarck");
		setBlockTextureName(enderdeath.MODID + ":BrickStonarck");
		setCreativeTab(CreativeTabs.tabBlock);

	    setHarvestLevel("pickaxe", 3);
	}

}
