package ed.enderdeath.mod.block;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AntiPiston extends Block
{

    public AntiPiston(Material p_i45394_1_)
    {
        super(p_i45394_1_.rock);
        setBlockName("AntiPiston");
        setBlockTextureName(Enderdeath.MODID + ":C");
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(1.0F);

    }

    public int getMobilityFlag()

    {

        return 2;

    }

}
