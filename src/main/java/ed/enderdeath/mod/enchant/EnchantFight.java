package ed.enderdeath.mod.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantFight extends Enchantment
{

    public EnchantFight()
    {
        super(125, 0, EnumEnchantmentType.weapon);
    }

    public int getMaxLevel()
    {
        return 1;
    }

}
