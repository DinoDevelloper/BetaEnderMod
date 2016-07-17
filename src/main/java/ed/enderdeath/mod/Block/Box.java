package ed.enderdeath.mod.Block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class Box extends Block {
	private IIcon top;
	private static final Item[] dropA = new Item[] { Items.glowstone_dust, Items.sugar, Items.redstone,
			Items.spider_eye, Items.glass_bottle, Items.gunpowder, Items.stick, Items.stick };
	private static final Item[] dropB = new Item[] { Items.apple, Items.arrow, Items.blaze_rod, Items.bow,
			Items.chest_minecart, Items.glass_bottle, Items.minecart, Items.record_far };

	private static Item[] drop;
	private EntityPlayer player;

	public Box() {

		super(Material.rock);

		this.setBlockName("Box");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(10.0F);

	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int pos) {
		if (world.canMineBlock(player, x, y, z)) {
			Random rand = new Random();
			System.out.println("TestDragon");
			this.dropItem(dropA);
		}

	}

	private void dropItem(Item[] item) {
		
		
	}

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
			p_149734_1_.spawnParticle("enchantmenttable", d0, d1, d2, d3, d4, d5);
		}
	}

	public void registerBlockIcons(IIconRegister iiconRegister) {
		this.blockIcon = iiconRegister.registerIcon(enderdeath.MODID + ":Box");
		this.top = iiconRegister.registerIcon(enderdeath.MODID + ":Box_top");

	}

	public IIcon getIcon(int side, int metadata) {

		if (side == 1)
			return this.top;

		else if (side == 0)
			return this.top;

		return this.blockIcon;

	}
}