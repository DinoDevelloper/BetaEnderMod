package ed.enderdeath.mod.armor;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class DarkaniteArmor extends ItemArmor
{

    public DarkaniteArmor(ArmorMaterial material, int type)
    {
        super(material, 0, type);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(slot == 2)
        {
            return Enderdeath.MODID + ":textures/darkanite_layer_2.png";
        }
        return Enderdeath.MODID + ":textures/darkanite_layer_1.png";
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {

        if(this.armorType == 0)
        {
            player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 210, 0));
        }
        if(this.armorType == 1)
        {

        }
        if(this.armorType == 2)
        {

        }
        if(this.armorType == 3)
        {
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 210, 0));
        }
    }

    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(input.getItem() == this && repair.getItem() == Enderdeath.hulmini)
        {
            return true;
        }
        return false;
    }

}
