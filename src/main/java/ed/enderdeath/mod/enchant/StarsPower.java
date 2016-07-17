package ed.enderdeath.mod.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class StarsPower extends Enchantment
{

	public StarsPower()
	{
		super(124, 0, EnumEnchantmentType.weapon);
	}
	public int getMaxLevel() {
	     return 1;
	}
}
