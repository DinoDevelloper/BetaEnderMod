package ed.enderdeath.mod.food;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BaieChocolate extends Baie
{
    public BaieChocolate(int foundamount, float saturation, boolean iswoolFood)
    {
        super(foundamount, saturation, iswoolFood);
        this.setUnlocalizedName("BaieChocolate");
        this.setTextureName(Enderdeath.MODID + ":BaieChocolate");
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
        player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 3500, 0));
        player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3500, 1));
    }
}
