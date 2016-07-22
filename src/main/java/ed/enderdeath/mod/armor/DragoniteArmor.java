package ed.enderdeath.mod.armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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

public class DragoniteArmor extends ItemArmor
{

    private AttributeModifier maxHealth = new AttributeModifier("ArmorHealth0", 3.5D, 0);

    public DragoniteArmor(ArmorMaterial material, int slot)
    {
        super(material, 0, slot);

    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(slot == 2)
        {
            return Enderdeath.MODID + ":textures/Dragonite_layer_2.png";
        }
        return Enderdeath.MODID + ":textures/Dragonite_layer_1.png";
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if(this.armorType == 0 && world.getBlockLightValue(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ)) < 7)
        {
            player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 800, 0));
        }
        if(this.armorType == 0)
        {
            player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 100, 0));
            player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 0));
            player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 0));
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 1));
            player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 100, 1));

        }
        /* Chestplate */
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

    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
    {
        super.onUpdate(stack, world, entity, par4, par5);

        if(stack.isItemEnchanted() == false)
        {
            stack.addEnchantment(Enchantment.protection, 4);
            stack.addEnchantment(Enchantment.thorns, 3);
            super.onUpdate(stack, world, entity, par4, par5);
        }

    }

    public boolean hasEffect(ItemStack stack, int pass)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
    {
        return Enderdeath.proxy.getKnightlyArmorModel(armorSlot);
    }

}
