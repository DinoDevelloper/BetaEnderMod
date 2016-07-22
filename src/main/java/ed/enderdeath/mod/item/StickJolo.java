package ed.enderdeath.mod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StickJolo extends Item
{

    public StickJolo()
    {

        this.maxStackSize = 1;
        this.setMaxDamage(150);
        setCreativeTab(CreativeTabs.tabTools);
        this.setTextureName(Enderdeath.MODID + ":StickJolo");
        this.setUnlocalizedName("StickJolo");
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
    {
        par1ItemStack.damageItem(1, player); // on d�clare la durabilit�

        player.clearActivePotions();

        return par1ItemStack;

    }

    public boolean isFull3D() // on met de la 3D a l'item
    {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.rare;
    }

}
