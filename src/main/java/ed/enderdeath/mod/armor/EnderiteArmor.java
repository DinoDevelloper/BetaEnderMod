package ed.enderdeath.mod.armor;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import ed.enderdeath.mod.item.FlyPotion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EnderiteArmor extends ItemArmor
{

    private AttributeModifier maxHealth = new AttributeModifier("ArmorHealth0", 1.5D, 0);

    public EnderiteArmor(ArmorMaterial material, int type)
    {
        super(material, 0, type);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(slot == 2)
        {
            return Enderdeath.MODID + ":textures/enderite_layer_2.png";
        }
        return Enderdeath.MODID + ":textures/enderite_layer_1.png";
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if(this.armorType == 0 && world.getBlockLightValue(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ)) < 7)
        {
            player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 800, 0));
        }
        if(this.armorType == 0)
        {

            player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 0));
            player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 100, 0));
        }
        /* Chestplate */
        if(this.armorType == 1)
        {
            player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 0));
        }
        /* Leggings */
        if(this.armorType == 2)
        {
            player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 100, 1));
            player.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 100, 1));
        }
        /* Boots */
        if(this.armorType == 3)
        {
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 1));
            player.addPotionEffect(new PotionEffect(FlyPotion.fall.id, 100, 1));

        }
        if(this.armorType == 0 && this.armorType == 1 && this.armorType == 2 && this.armorType == 3)
        {

        }

    }

    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = HashMultimap.create();

        multimap.put(SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName(), this.maxHealth);

        return multimap;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.epic;
    }

    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(input.getItem() == this && repair.getItem() == Enderdeath.hulmini)
        {
            return true;
        }
        return false;
    }

    public boolean hasEffect(ItemStack stack, int pass)
    {
        return true;
    }

    private boolean hasJumped = false;

    private void playerTick(EntityPlayer player)
    {

        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && (player.jumpMovementFactor == 0.02F || player.isAirBorne) && player.motionY < 0.07 && !hasJumped)

        {

            player.addVelocity(0, 0.1, 0);
            System.out.println("Test");
            hasJumped = true;
        }
        if(!player.isAirBorne)
            hasJumped = false;
    }
}
