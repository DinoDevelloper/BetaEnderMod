package ed.enderdeath.mod.Block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class RenforcedSandandgravel extends BlockFalling {
	
	public RenforcedSandandgravel()
	{
		super(Material.rock);
	}
	 public int getMobilityFlag()

	    {

	        return 2;

	    }
	  
}
