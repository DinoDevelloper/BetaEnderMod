package ed.enderdeath.mod.Tool.ToolBase;

import org.lwjgl.opengl.GL11;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword
{

	public ToolSword(ToolMaterial material) {
		super(material);
	}
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
	 if(input.getItem() ==  this && repair.getItem() == enderdeath.hulmini)
	 {
		 return true;
	 }
        return false;
    }
	   public boolean hasEffect(ItemStack stack, int pass)
	    {
	        return false;
	    }
	
}
