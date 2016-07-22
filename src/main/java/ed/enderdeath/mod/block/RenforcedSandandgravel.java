package ed.enderdeath.mod.block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class RenforcedSandandgravel extends BlockFalling
{

    public RenforcedSandandgravel()
    {
        super(Material.rock);
    }

    public int getMobilityFlag()

    {

        return 2;

    }

}
