package ed.enderdeath.mod.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class UltimeBox extends Block
{
    private Item[] Tableau;

    public UltimeBox()
    {
        super(Material.rock);
        this.setBlockTextureName(Enderdeath.MODID + ":UltimeBox");
        this.setBlockName("UltimeBox");
        this.setCreativeTab(CreativeTabs.tabDecorations);

    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube? This determines whether
     * or not to render the shared face of two adjacent blocks and also whether
     * the player can attach torches, redstone wire, etc to this block.
     */

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y,
     * z
     */

    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        /* Quand tu click droit avec l'item en question */
        if(p_149727_5_.getHeldItem() != null && p_149727_5_.getHeldItem().getItem() == Enderdeath.ultimeKey)
        {

            /* Le Random + le tableau */
            Random rand = new Random();
            p_149727_5_.inventory.decrStackSize(p_149727_5_.inventory.currentItem, 1);
            ItemStack[] prices = new ItemStack[] {new ItemStack(Enderdeath.darkaniteBoots), new ItemStack(Enderdeath.darkaniteHelmet), new ItemStack(Enderdeath.darkaniteLeggings), new ItemStack(Enderdeath.darkaniteChestplate), new ItemStack(Enderdeath.enderiteSwordA), new ItemStack(Enderdeath.swordDarkanite), new ItemStack(Enderdeath.swordFire), new ItemStack(Enderdeath.darkaniteSwordA), new ItemStack(Enderdeath.pickaxe3x3Item, 1), new ItemStack(Blocks.dirt), new ItemStack(Enderdeath.baieCake, 50), new ItemStack(Enderdeath.baieOfChocolate, 8), new ItemStack(Enderdeath.pickaxeSpawner), new ItemStack(Enderdeath.axeEnderite, 1), new ItemStack(Enderdeath.stickHeal, 1), new ItemStack(Enderdeath.baieOrange, 15), new ItemStack(Enderdeath.deathKey, 5), new ItemStack(Enderdeath.naturalKey, 5), new ItemStack(Enderdeath.nuggetEnderite, 1), new ItemStack(Enderdeath.baieHeal, 10), new ItemStack(Blocks.obsidian, 250), new ItemStack(Enderdeath.obsiRenforced, 10), new ItemStack(Enderdeath.ultimeKey, 2)};
            if(p_149727_5_.getHeldItem() != null && p_149727_5_.getHeldItem().getItem() == Enderdeath.ultimeKey)
            {
                p_149727_5_.addChatMessage(new ChatComponentTranslation("Tu a ouvert une cle Ender!!!"));

            }
            {
                prices[0].addEnchantment(Enchantment.protection, 4);
                prices[0].addEnchantment(Enchantment.unbreaking, 3);
                prices[1].addEnchantment(Enchantment.protection, 4);
                prices[1].addEnchantment(Enchantment.unbreaking, 3);
                prices[2].addEnchantment(Enchantment.protection, 4);
                prices[2].addEnchantment(Enchantment.unbreaking, 3);
                prices[3].addEnchantment(Enchantment.protection, 4);
                prices[3].addEnchantment(Enchantment.unbreaking, 3);
                prices[4].addEnchantment(Enchantment.sharpness, 4);
                prices[4].addEnchantment(Enchantment.fireAspect, 2);
                prices[5].addEnchantment(Enchantment.sharpness, 4);
                prices[5].addEnchantment(Enchantment.knockback, 2);

                prices[6].addEnchantment(Enchantment.sharpness, 3);
                prices[6].addEnchantment(Enderdeath.fight, 1);

                prices.clone();

            }

            ItemStack price = prices[rand.nextInt(prices.length)];

            p_149727_5_.inventory.addItemStackToInventory(price);
        }
        return true;
    }

    /* Pour des particule */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        for(int l = 0; l < 5; ++l)
        {
            double d6 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
            double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
            d6 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = p_149734_5_.nextInt(2) * 2 - 1;
            int j1 = p_149734_5_.nextInt(2) * 2 - 1;
            d3 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.2D;
            d4 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.2D;
            d5 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.2D;
            double d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)j1;
            d5 = (double)(p_149734_5_.nextFloat() * 1.0F * (float)j1);
            double d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
            d3 = (double)(p_149734_5_.nextFloat() * 1.0F * (float)i1);
            p_149734_1_.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }
    }
}
