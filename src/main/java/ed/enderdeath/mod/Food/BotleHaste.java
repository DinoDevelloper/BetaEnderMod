package ed.enderdeath.mod.Food;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BotleHaste extends ItemFood {

	public BotleHaste(int foundAmount, float saturation, boolean isWolfFood) {
		super(foundAmount, saturation, isWolfFood);
		setCreativeTab(CreativeTabs.tabBrewing);
		this.setUnlocalizedName("BottleHaste");
		this.setTextureName(enderdeath.MODID + ":BottleHaste");
		this.setMaxStackSize(1);
	}
	 public EnumAction getItemUseAction(ItemStack par1ItemStack)
	    {
	        return EnumAction.drink;
	    }
	 public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)

	    {

	    	player.setItemInUse(stack, this.getMaxItemUseDuration(stack));

	        return stack;
	 
	    }
	 protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	    {
	        player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 5000, 0));

	    }
	 

}
