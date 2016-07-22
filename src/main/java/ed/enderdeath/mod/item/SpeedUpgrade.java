package ed.enderdeath.mod.item;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SpeedUpgrade extends Item
{
    static int speedUp;

    public SpeedUpgrade(String speedUpgrade, int i)
    {
        setUnlocalizedName("speedUpgrade");
        this.setTextureName(Enderdeath.MODID + ":SpeedUpgrade");
        this.setCreativeTab(CreativeTabs.tabTools);
        this.setMaxStackSize(1);

        speedUp = i;
    }

    public static int getSpeedUp()
    {
        return speedUp;
    }
}
