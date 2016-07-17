package ed.enderdeath.mod.Tool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class SwordSkin extends ItemSword
{

	public SwordSkin(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		
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
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
		super.onUpdate(stack, world, entity, par4, par5);

		if (stack.isItemEnchanted() == false) {
			stack.addEnchantment(Enchantment.sharpness, 5);
			stack.addEnchantment(Enchantment.unbreaking, 3);
			stack.addEnchantment(Enchantment.smite, 5);
			stack.addEnchantment(Enchantment.baneOfArthropods, 5);
			
			super.onUpdate(stack, world, entity, par4, par5);
		}

	}
}
