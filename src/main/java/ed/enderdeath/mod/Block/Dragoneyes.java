package ed.enderdeath.mod.Block;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Dragoneyes extends Block {

	public Dragoneyes(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setBlockTextureName(enderdeath.MODID + ":Dragoneyes");
		this.setBlockName("Dragoneyes");
		this.setLightLevel(5.0F);
	}

}
