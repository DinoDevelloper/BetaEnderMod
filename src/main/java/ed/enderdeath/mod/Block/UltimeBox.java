package ed.enderdeath.mod.Block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
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

public class UltimeBox extends Block {
	private Item[] Tableau;

	public UltimeBox() {
		super(Material.rock);
		this.setBlockTextureName(enderdeath.MODID + ":UltimeBox");
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

	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_,
			EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		/* Quand tu click droit avec l'item en question */
		if (p_149727_5_.getHeldItem() != null && p_149727_5_.getHeldItem().getItem() == enderdeath.UltimeKey) {

			/* Le Random + le tableau */
			Random rand = new Random();
			p_149727_5_.inventory.decrStackSize(p_149727_5_.inventory.currentItem, 1);
			ItemStack[] prices = new ItemStack[] { new ItemStack(enderdeath.DarkaniteBoots),
					new ItemStack(enderdeath.DarkaniteHelmet), new ItemStack(enderdeath.DarkaniteLeggings),
					new ItemStack(enderdeath.DarkaniteChestplate), new ItemStack(enderdeath.EnderiteSwordA),
					new ItemStack(enderdeath.SwordDarkanite), new ItemStack(enderdeath.SwordFire),
					 new ItemStack(enderdeath.DarkaniteSwordA),
					new ItemStack(enderdeath.Pickaxe3x3Item, 1), new ItemStack(Blocks.dirt),
					new ItemStack(enderdeath.BaieCake, 50),
					new ItemStack(enderdeath.BaieOfChocolate, 8), new ItemStack(enderdeath.PickaxeSpawner),
					 new ItemStack(enderdeath.AxeEnderite,1),
					new ItemStack(enderdeath.StickHeal, 1),
					new ItemStack(enderdeath.BaieOrange, 15), new ItemStack(enderdeath.DeathKey, 5), 
					new ItemStack(enderdeath.NaturalKey, 5),new ItemStack(enderdeath.NuggetEnderite, 1),
					new ItemStack(enderdeath.BaieHeal, 10), new ItemStack(Blocks.obsidian, 250), new ItemStack(enderdeath.ObsiRenforced, 10),
					new ItemStack(enderdeath.UltimeKey, 2) };
			if( p_149727_5_.getHeldItem() != null && p_149727_5_.getHeldItem().getItem() == enderdeath.UltimeKey)
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
				prices[6].addEnchantment(enderdeath.Fight, 1);
			
				prices.clone();
				
			}

			ItemStack price = prices[rand.nextInt(prices.length)];

			p_149727_5_.inventory.addItemStackToInventory(price);
		}
		return true;
	}

	/* Pour des particule */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_,
			Random p_149734_5_) {
		for (int l = 0; l < 5; ++l) {
			double d6 = (double) ((float) p_149734_2_ + p_149734_5_.nextFloat());
			double d1 = (double) ((float) p_149734_3_ + p_149734_5_.nextFloat());
			d6 = (double) ((float) p_149734_4_ + p_149734_5_.nextFloat());
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			int i1 = p_149734_5_.nextInt(2) * 2 - 1;
			int j1 = p_149734_5_.nextInt(2) * 2 - 1;
			d3 = ((double) p_149734_5_.nextFloat() - 0.5D) * 0.2D;
			d4 = ((double) p_149734_5_.nextFloat() - 0.5D) * 0.2D;
			d5 = ((double) p_149734_5_.nextFloat() - 0.5D) * 0.2D;
			double d2 = (double) p_149734_4_ + 0.5D + 0.25D * (double) j1;
			d5 = (double) (p_149734_5_.nextFloat() * 1.0F * (float) j1);
			double d0 = (double) p_149734_2_ + 0.5D + 0.25D * (double) i1;
			d3 = (double) (p_149734_5_.nextFloat() * 1.0F * (float) i1);
			p_149734_1_.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
		}
	}
}
