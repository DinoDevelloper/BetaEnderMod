package ed.enderdeath.mod.Tool.ToolBase;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ToolShovel extends ItemSpade
{

	public ToolShovel(ToolMaterial material) {
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
