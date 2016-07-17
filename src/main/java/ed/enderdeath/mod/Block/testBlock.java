package ed.enderdeath.mod.Block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.world.World;

public class testBlock extends Block {

	public testBlock() {
		super(Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("testBlock");
		setBlockTextureName(enderdeath.MODID + ":testBlock");
		setHardness(5.0F);
		setResistance(5.0F);
	    setHarvestLevel("pickaxe", 2);
	   setLightLevel(1.0F);
	   setStepSound(Block.soundTypeMetal);

	}
	 
}
