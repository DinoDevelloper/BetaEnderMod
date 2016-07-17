package ed.enderdeath.mod.Armor;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class RoyaliteArmor extends ItemArmor
{

	public RoyaliteArmor(ArmorMaterial material , int type) {
		super(material, 0, type);
	}
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(slot == 2)
		{
			return enderdeath.MODID + ":textures/royalite_layer_2.png";
		}
		return enderdeath.MODID + ":textures/royalite_layer_1.png";
	}
	 public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	    {
	    	player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 210,0));
	    	
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
