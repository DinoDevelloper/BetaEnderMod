package ed.enderdeath.mod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OrbBlue extends Item
{
    public OrbBlue()
    {

        this.maxStackSize = 1;
        this.setMaxDamage(550);
        setCreativeTab(CreativeTabs.tabTools);
        this.setTextureName(Enderdeath.MODID + ":OrbBlue");
        this.setUnlocalizedName("OrbBlue");
    }

    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(input.getItem() == this && repair.getItem() == Enderdeath.saphir)
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
        if(entity instanceof EntityPlayer) // Si c'est un joueur
        {
            EntityPlayer player = (EntityPlayer)entity; // On cast
            for(int i = 0; i < 4; i++) // Il y a 4 pi�ces d'armure
            {
                ItemStack armor = player.getCurrentArmor(i); // On r�cup�re la pi�ce
                if(armor != null) // Cas o� le slot est vide on ne rentre pas
                {
                    // V�rifie qu'on r�pare pas un item enti�rement r�par� et qu'il reste de la durabilit� � l'item qui r�pare
                    if(armor.getItemDamage() > 0 && stack.getItemDamage() < stack.getMaxDamage())
                    {
                        stack.setItemDamage(stack.getItemDamage() + 1); // On enl�ve de la durabilit� � l'item qui r�pare
                        armor.setItemDamage(armor.getItemDamage() - 1); // On rajoute de la durabilit� � la pi�ce d'armure

                        int durability = stack.getMaxDamage() - stack.getItemDamage();
                    }
                }
            }
        }
    }
}
