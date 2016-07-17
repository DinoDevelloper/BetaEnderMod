package ed.enderdeath.mod.secret;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.Food.BaieOfRainbow;
import ed.enderdeath.mod.Item.FlyPotion;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Maxitomate extends ItemFood {

	public Maxitomate(int foundamount, float saturation, boolean iswoolFood) {
		super(foundamount, saturation, iswoolFood);
		this.setUnlocalizedName("Maxitomate");
		this.setTextureName(enderdeath.MODID + ":Maxitomate");
		this.setCreativeTab(null);
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
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10000,1));
		player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 5000,1));
		player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5000,1));
		player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 5000,1));
		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10000,1));
		player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 5000,1));
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 5000,1));
		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 5000,1));
		player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 5000,1));
		player.addPotionEffect(new PotionEffect(Potion.resistance.id, 5000,1));
		player.addPotionEffect(new PotionEffect(FlyPotion.customEffect.id, 5000,1));
		player.addPotionEffect(new PotionEffect(FlyPotion.fall.id, 5000,1));
    }
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemstack)
	{
	   return EnumRarity.epic;
	}
	@SideOnly(Side.CLIENT)
	   public boolean hasEffect(ItemStack stack)
	   {
	       return true;
	   }

}
