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

public class Baie extends ItemFood {

	
	public Baie(int foundamount, float saturation, boolean isWolfFood) {
		super(foundamount, saturation, isWolfFood);
		this.setUnlocalizedName("Baie");
		this.setTextureName(enderdeath.MODID + ":Baie");
		setCreativeTab(CreativeTabs.tabFood);
		   this.isFamiliarFavoriteMeat = isWolfFood;
		
	}
    private boolean isFamiliarFavoriteMeat;
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.eat;
    }
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)

    {

    	player.setItemInUse(stack, this.getMaxItemUseDuration(stack));

        return stack;
 
    }
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
    {
        
   
    }
	  public boolean isFamiliarFavoriteMeat()
	    {
	        return this.isFamiliarFavoriteMeat;
	    }
}
