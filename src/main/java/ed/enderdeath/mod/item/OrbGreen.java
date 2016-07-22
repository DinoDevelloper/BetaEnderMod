package ed.enderdeath.mod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class OrbGreen extends Item
{
    public OrbGreen()
    {

        this.maxStackSize = 1;
        this.setMaxDamage(2000);
        setCreativeTab(CreativeTabs.tabTools);
        this.setTextureName(Enderdeath.MODID + ":OrbGreen");
        this.setUnlocalizedName("OrbGreen");
    }

    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(input.getItem() == this && repair.getItem() == Items.emerald)
        {
            return true;
        }
        return false;
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

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)entity;
            for(int i = 0; i < 4; i++)
            {
                player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 210, 0));
            }
        }
    }
}
