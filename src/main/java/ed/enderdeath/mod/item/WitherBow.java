package ed.enderdeath.mod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class WitherBow extends ItemBow
{
    private IIcon[] iconbuffer;
    private double x;
    private double y;
    private double z;
    private EntityLivingBase entity;
    private static String[] bowpullname = new String[] {"_pull0", "_pull1", "_pull2"};

    public WitherBow()
    {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(10000);
        this.setFull3D();
        this.setTextureName(Enderdeath.MODID + ":WitherBow");
        this.setUnlocalizedName("WitherBow");

    }

    @Override
    public void registerIcons(IIconRegister iconregister)
    {
        iconbuffer = new IIcon[bowpullname.length];
        itemIcon = iconregister.registerIcon(this.getIconString());
        for(int i = 0; i < bowpullname.length; i++)
        {
            iconbuffer[i] = iconregister.registerIcon(this.getIconString() + bowpullname[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        if(usingItem != null && usingItem.getItem().equals(this))
        {
            int k = usingItem.getMaxItemUseDuration() - useRemaining;
            if(k >= 21)
                return iconbuffer[2];
            if(k >= 18)
                return iconbuffer[2];
            if(k > 13)
                return iconbuffer[1];
            if(k > 0)
                return iconbuffer[0];
        }
        return getIconIndex(stack);
    }

    public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_)
    {
        int j = this.getMaxItemUseDuration(p_77615_1_) - p_77615_4_;

        ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
        MinecraftForge.EVENT_BUS.post(event);
        if(event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = p_77615_3_.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, p_77615_1_) > 0;

        if(flag || p_77615_3_.inventory.hasItem(Enderdeath.deathArrow))
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if((double)f < 0.1D)
            {
                return;
            }

            if(f > 1.0F)
            {
                f = 1.0F;
            }

            EntityWitherSkull entityarrow = new EntityWitherSkull(p_77615_2_, entity, x, y, z);

            if(f == 1.0F)
            {

            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, p_77615_1_);

            if(k > 0)
            {

            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, p_77615_1_);

            if(l > 0)
            {

            }

            if(EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, p_77615_1_) > 0)
            {
                entityarrow.setFire(700);
            }

            p_77615_1_.damageItem(1, p_77615_3_);
            p_77615_2_.playSoundAtEntity(p_77615_3_, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if(flag)
            {

            }
            else
            {
                p_77615_3_.inventory.consumeInventoryItem(Enderdeath.deathArrow);
            }

            if(!p_77615_2_.isRemote)
            {
                p_77615_2_.spawnEntityInWorld(entityarrow);
            }
        }
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
    {
        return stack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 200000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.bow;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        ArrowNockEvent event = new ArrowNockEvent(player, stack);
        MinecraftForge.EVENT_BUS.post(event);
        if(event.isCanceled())
        {
            return event.result;
        }

        if(player.capabilities.isCreativeMode || player.inventory.hasItem(Enderdeath.deathArrow))
        {
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        }

        return stack;
    }

    @Override
    public int getItemEnchantability()
    {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.epic;
    }
}
