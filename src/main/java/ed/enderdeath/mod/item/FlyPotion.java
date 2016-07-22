package ed.enderdeath.mod.item;

import java.awt.Color;

import net.minecraft.potion.Potion;

public class FlyPotion extends Potion
{

    public static FlyPotion customEffect;
    public static int falleffect;
    public static FlyPotion fall;
    public static int customEffectID;

    protected FlyPotion(int id, boolean isBadEffectOrNot, int color, String name)
    {
        super(id, isBadEffectOrNot, color);
        this.setPotionName("potion." + name);
    }

    public FlyPotion setIconIndex(int x, int y)
    {
        super.setIconIndex(x, y);
        return this;
    }

    public static void loadEffects()
    {
        customEffect = new FlyPotion(customEffectID, true, Color.white.getRGB(), "customEffect").setIconIndex(4, 2);
        fall = new FlyPotion(falleffect, true, Color.gray.getRGB(), "fall").setIconIndex(4, 2);
    }

    public static void register()
    {
        FlyPotion.potionTypes[customEffect.getId()] = customEffect;
        FlyPotion.potionTypes[fall.getId()] = fall;

    }
}
