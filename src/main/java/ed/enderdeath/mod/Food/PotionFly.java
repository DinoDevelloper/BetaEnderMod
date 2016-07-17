package ed.enderdeath.mod.Food;

import ed.enderdeath.mod.Item.FlyPotion;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class PotionFly extends ItemFood {
	public PotionFly(int foundamount, float saturation, boolean iswoolFood) {
		super(foundamount, saturation, iswoolFood);
		this.setUnlocalizedName("PotionFly");
		this.setTextureName(enderdeath.MODID + ":PotionFly");
		setCreativeTab(CreativeTabs.tabBrewing);
		
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
		player.addPotionEffect(new PotionEffect(FlyPotion.customEffect.id,1500,0));
   
    }
}
