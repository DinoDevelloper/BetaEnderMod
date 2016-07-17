package ed.enderdeath.mod.Tool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.Tool.ToolBase.ToolSword;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class UltimateSword extends ToolSword {

	public UltimateSword(ToolMaterial ToolMaterial) {
		super(ToolMaterial);

	}


	 @Override
	  	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected)
	  	{
	  		
	  			 if(stack.isItemEnchanted() == false) {
	                 stack.addEnchantment(enderdeath.StarsPower, 1);
	                 super.onUpdate(stack, world, entity, slot, selected);
	  			 }
	  		
	  	}
	 
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemstack) {
		return EnumRarity.epic;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
