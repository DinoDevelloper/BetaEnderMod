package ed.enderdeath.mod.item;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.item.Item;

public class Croquette extends Item
{
    public Croquette(Item item)
    {
        super();
    }

    public static final Item goldcroquette = new Croquette(Enderdeath.goldenCroquette);

    public void onLvl()
    {

    }
}
