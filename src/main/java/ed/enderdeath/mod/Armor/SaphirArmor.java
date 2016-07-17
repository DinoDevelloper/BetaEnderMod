package ed.enderdeath.mod.Armor;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class SaphirArmor extends ItemArmor
{

	public SaphirArmor(ArmorMaterial material,  int type) {
		super(material, 0, type);
	}
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(slot == 2)
		{
			return enderdeath.MODID + ":textures/saphir_layer_2.png";
		}
		return enderdeath.MODID + ":textures/saphir_layer_1.png";
	}
	 public boolean getIsRepairable(ItemStack input, ItemStack repair)
	    {
		 if(input.getItem() ==  this && repair.getItem() == enderdeath.hulmini)
		 {
			 return true;
		 }
	        return false;
	    }
	 
}
