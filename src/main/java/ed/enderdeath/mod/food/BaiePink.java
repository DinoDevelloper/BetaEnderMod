package ed.enderdeath.mod.food;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BaiePink extends Baie
{
    public BaiePink(int foundamount, float saturation, boolean iswoolFood)
    {
        super(foundamount, saturation, iswoolFood);
        this.setUnlocalizedName("BaiePink");
        this.setTextureName(Enderdeath.MODID + ":BaiePink");
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
        player.heal(8F);

    }
}
