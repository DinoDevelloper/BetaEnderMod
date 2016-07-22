package ed.enderdeath.mod.block;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Dragoneyes extends Block
{

    public Dragoneyes(Material p_i45394_1_)
    {
        super(p_i45394_1_);
        this.setBlockTextureName(Enderdeath.MODID + ":Dragoneyes");
        this.setBlockName("Dragoneyes");
        this.setLightLevel(5.0F);
    }

}
