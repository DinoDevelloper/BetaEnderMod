package ed.enderdeath.mod.Block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemLead;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class IronFence extends BlockLadder
{
	
	public IronFence(Material material)
	{
		super();
		this.setBlockTextureName(enderdeath.MODID + ":IronFence");
		this.setBlockName("IronLadder");
		
	}

	
	
	

    /**
     * Called upon block activation (right click on the block.)
     */
    
    @Override
	 public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
   {
       if (entity.onGround || entity.isCollidedVertically) { return; }
       if (entity.motionY >= 0.1) {
           entity.setPosition(entity.posX, entity.posY + 0.2F, entity.posZ);
       } else if (entity.motionY <= -0.1) {
           Block blockUnder = world.getBlock(MathHelper.floor_double(entity.posX), MathHelper.floor_double(entity.posY) - 3, MathHelper.floor_double(entity.posZ));
           if (blockUnder == null || blockUnder == this) {
               entity.setPosition(entity.posX, entity.posY - 0.2F, entity.posZ);
           }
       }
   }
}
