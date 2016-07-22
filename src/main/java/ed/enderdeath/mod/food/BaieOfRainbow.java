package ed.enderdeath.mod.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BaieOfRainbow extends Baie
{
    public BaieOfRainbow(int foundamount, float saturation, boolean iswoolFood)
    {
        super(foundamount, saturation, iswoolFood);
        this.setUnlocalizedName("BaieOfRainbow");
        this.setTextureName(Enderdeath.MODID + ":BaieOfRainbow");
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
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 5000, 1));
        player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5000, 0));
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 700, 100));

        player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5000, 0));
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
