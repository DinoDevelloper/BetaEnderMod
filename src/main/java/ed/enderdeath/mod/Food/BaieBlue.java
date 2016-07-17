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

public class BaieBlue extends Baie
{

	public BaieBlue(int foundamount, float saturation, boolean iswoolFood) {
		super(foundamount, saturation, iswoolFood);
		this.setUnlocalizedName("BaieBlue");
		this.setTextureName(enderdeath.MODID + ":BaieBlue");
		setCreativeTab(CreativeTabs.tabFood);
		
	}
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
		player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 5500,0));
   
    }
}
