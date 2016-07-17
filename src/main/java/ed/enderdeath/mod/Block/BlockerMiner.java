package ed.enderdeath.mod.Block;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockerMiner extends Block {

	public BlockerMiner() {
		super(Material.rock);
		setBlockName("BlockMiner");
		setBlockTextureName(enderdeath.MODID + ":BlockMiner");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(1.0F);
		setResistance(1.0F);
		setHarvestLevel("pickaxe", 1);
		setStepSound(Block.soundTypeAnvil);
	}

}
