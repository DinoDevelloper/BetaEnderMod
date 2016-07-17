package ed.enderdeath.mod.Tool.ToolBase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ToolPickaxe extends ItemPickaxe
{

	public ToolPickaxe(ToolMaterial material) {
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
