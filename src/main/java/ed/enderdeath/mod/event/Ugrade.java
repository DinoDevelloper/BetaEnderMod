package ed.enderdeath.mod.event;

import java.util.HashMap;

import ed.enderdeath.mod.tool.toolBase.PiocheSpecial;
import ed.enderdeath.mod.tool.toolBase.ToolSword;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Ugrade
{
    public static HashMap<Integer, Integer> upgrades;
    public static HashMap<Integer, Integer> upgradeType;
    public static final int PHAMMER = 0;
    public static final int PSWORD = 1;
    public static final int SMELT = 0;
    public static final int FORTUNE = 1;
    public static final int SPEED = 2;
    public static final int DAMAGE = 3;
    public static final int FLAME = 4;
    public static final int KNOCKBACK = 5;
    public static final int DoubleDamage = 6;

    public static void init()
    {
        upgrades = new HashMap();
        upgradeType = new HashMap();

        upgrades.put(Integer.valueOf(1), Integer.valueOf(3));
        upgradeType.put(Integer.valueOf(1), Integer.valueOf(0));

        upgrades.put(Integer.valueOf(0), Integer.valueOf(1));
        upgradeType.put(Integer.valueOf(0), Integer.valueOf(0));

        upgrades.put(Integer.valueOf(2), Integer.valueOf(3));
        upgradeType.put(Integer.valueOf(2), Integer.valueOf(0));

        upgrades.put(Integer.valueOf(3), Integer.valueOf(3));
        upgradeType.put(Integer.valueOf(3), Integer.valueOf(1));

        upgrades.put(Integer.valueOf(4), Integer.valueOf(1));
        upgradeType.put(Integer.valueOf(4), Integer.valueOf(1));

        upgrades.put(Integer.valueOf(5), Integer.valueOf(2));
        upgradeType.put(Integer.valueOf(5), Integer.valueOf(1));
    }

    public static boolean canApplyUpgrade(ItemStack stack, int type, ItemStack tool)
    {
        if(getMaxEnchants(tool) <= getEnchants(tool))
        {
            return false;
        }
        int toolType = -1;
        if((tool.getItem() instanceof PiocheSpecial))
        {
            toolType = 0;
        }
        if(((tool.getItem() instanceof ToolSword)) || ((tool.getItem() instanceof ToolSword)))
        {
            toolType = 1;
        }
        if(getModifier(tool, type) >= ((Integer)upgrades.get(Integer.valueOf(type))).intValue())
        {
            return false;
        }
        if(toolType != ((Integer)upgradeType.get(Integer.valueOf(type))).intValue())
        {
            return false;
        }
        return true;
    }

    private static int getEnchants(ItemStack stack)
    {
        createDefaultNBT(stack);
        NBTTagCompound tag = stack.getTagCompound();
        return tag.func_150299_b("modifiersammount");
    }

    public static int getMaxEnchants(ItemStack stack)
    {
        createDefaultNBT(stack);
        NBTTagCompound tag = stack.getTagCompound();

        return tag.func_150299_b("modifiersmax");
    }

    public static int getModifier(ItemStack stack, int type)
    {
        createDefaultNBT(stack);
        NBTTagCompound tag = stack.getTagCompound();
        if(!tag.hasKey("upgradearray"))
        {
            tag.setIntArray("upgradearray", new int[0]);
            return 0;
        }
        int[] upgrades = tag.getIntArray("upgradearray");
        for(int i = 0; i < upgrades.length; i += 2)
        {
            if(upgrades[i] == type)
            {
                return upgrades[(i + 1)];
            }
        }
        return 0;
    }

    public static void createDefaultNBT(ItemStack stack)
    {
        if(!stack.isItemStackDamageable())
        {
            int modifiers = 3;
            if((stack.getItem() instanceof ToolSword))
            {
                modifiers = 6;
            }
            stack.loadItemStackFromNBT(new NBTTagCompound());
            stack.getTagCompound().setInteger("modifiersammount", 0);
            stack.getTagCompound().setInteger("modifiersmax", modifiers);
        }
    }

    public static void applyUpgrade(ItemStack stack, int type)
    {
        createDefaultNBT(stack);
        NBTTagCompound tag = stack.getTagCompound();
        if(!tag.hasKey("upgradearray"))
        {
            int[] array = {type, 1};
            tag.setIntArray("upgradearray", new int[2]);
            return;
        }
        int[] upgrades = tag.getIntArray("upgradearray");
        for(int i = 0; i < upgrades.length; i += 2)
        {
            if(upgrades[i] == type)
            {
                upgrades[(i + 1)] += 1;
                tag.setIntArray("upgradearray", upgrades);
                tag.setString("modifiersammount", tag.getString("modifiersammount") + 1);
                return;
            }
        }
        int[] array = new int[upgrades.length + 2];
        for(int i = 0; i < upgrades.length; i++)
        {
            array[i] = upgrades[i];
        }
        array[(array.length - 2)] = type;
        array[(array.length - 1)] = 1;
        tag.setIntArray("upgradearray", array);
        tag.setString("modifiersammount", tag.getString("modifiersammount") + 1);
    }

    public static String getUpgradeName(int type)
    {
        if(type == 0)
        {
            return "Smelt";
        }
        if(type == 1)
        {
            return "Fortune";
        }
        if(type == 2)
        {
            return "Speed";
        }
        if(type == 3)
        {
            return "Damage";
        }
        if(type == 4)
        {
            return "Flame";
        }
        if(type == 5)
        {
            return "Knockback";
        }
        if(type == 6)
        {
            return "DoubleDamage";
        }
        return "";
    }

    public static int[] getUpgradeAmmount(ItemStack stack)
    {
        createDefaultNBT(stack);
        NBTTagCompound tag = stack.getTagCompound();
        if(!tag.hasKey("upgradearray"))
        {
            tag.setIntArray("upgradearray", new int[0]);
            return null;
        }
        return tag.getIntArray("upgradearray");
    }

}
