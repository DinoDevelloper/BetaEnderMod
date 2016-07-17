package ed.enderdeath.mod.Tool;

import cpw.mods.fml.common.Mod;
import ed.enderdeath.mod.Tool.ToolBase.HandlerTool;
import ed.enderdeath.mod.Tool.ToolBase.PiocheSpecial;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class Pickaxe3x3 extends PiocheSpecial
{
	private boolean smelt;
	private int fortune;
	public Pickaxe3x3(ToolMaterial toolMaterial,float nombre)
	{
	super(toolMaterial);

	}
	public void breakOtherBlock(EntityPlayer player, ItemStack stack, int x, int y, int z, int originX, int originY, int originZ, int side)
	{
	World world = player.worldObj;
	Material mat = world.getBlock(x, y, z).getMaterial();
	if (world.isAirBlock(x, y, z)) {
	return;
	}
	ForgeDirection direction = ForgeDirection.getOrientation(side);

	int range = Math.max(0, 1);
	int rangeY = Math.max(1, range);

	boolean doX = direction.offsetX == 0;
	boolean doY = direction.offsetY == 0;
	boolean doZ = direction.offsetZ == 0;

	HandlerTool.removeBlocksInIteration(player, stack, world, x, y, z, doX ? -range : 0, doY ? -1 : 0, doZ ? -range : 0, doX ? range + 1 : 1, doY ? rangeY * 2 : 1, doZ ? range + 1 : 1, null, MATERIALS, smelt, fortune, true);
	}

	

	
}
