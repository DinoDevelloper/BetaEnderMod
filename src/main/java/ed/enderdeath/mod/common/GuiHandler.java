package ed.enderdeath.mod.common;

import cpw.mods.fml.common.network.IGuiHandler;
import ed.enderdeath.mod.AnvilDragon.ContainerDragonAnvil;
import ed.enderdeath.mod.AnvilDragon.GuiAnvilDragon;
import ed.enderdeath.mod.BaieMachine.ContainerMachineTuto;
import ed.enderdeath.mod.BaieMachine.GuiMachineTuto;
import ed.enderdeath.mod.BaieMachine.TileEntityMachineTuto;
import ed.enderdeath.mod.Extractor.ContainerAlloyer;
import ed.enderdeath.mod.Extractor.GuiAlloyer;
import ed.enderdeath.mod.Extractor.TileEntityAlloyer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
	  public static final int guiCraftingTableID = 3;
	  public static final int alloyer = 1;
	  public static final int baie = 2;
	    @Override
	    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	    {
	        TileEntity tile = world.getTileEntity(x, y, z);
	        if(ID == alloyer)
	        {
	            return new ContainerAlloyer((TileEntityAlloyer)tile, player.inventory);
	        }
	       
	          if(ID == baie)
	            {
	                return new ContainerMachineTuto((TileEntityMachineTuto)tile, player.inventory);
	            }
	   
	          if(ID == guiCraftingTableID)
	          {
	              System.out.println("Test getServerGuiElement");
	              return new ContainerDragonAnvil(player.inventory, world, x, y, z);
	          }
	        return null;
	    }
	 
	    @Override
	    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	    {
	 
	        TileEntity tile = world.getTileEntity(x, y, z);
	        if(ID == alloyer)
	        {
	            return new GuiAlloyer((TileEntityAlloyer)tile, player.inventory);
	        }
	          if(ID == baie)
	            {
	                return new GuiMachineTuto((TileEntityMachineTuto)tile, player.inventory);
	            }
	          if(ID == guiCraftingTableID)
	          {
	              System.out.println("Test getClientGuiElement");
	              return new GuiAnvilDragon(player.inventory, world, x,y,z);
	          }
	        return null;
	    }
	 

}
