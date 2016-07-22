package ed.enderdeath.mod.extractor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AlloyerRecipes
{
    private static final AlloyerRecipes smeltingBase = new AlloyerRecipes();
    private Map<ItemStack[], ItemStack> smeltingList = new HashMap<ItemStack[], ItemStack>();

    public AlloyerRecipes()
    {

        this.addRecipe(Enderdeath.orbBlue, Items.ender_pearl, new ItemStack(Enderdeath.megaEnder, 1, 1));
        this.addRecipe(Items.ender_pearl, Enderdeath.saphir, new ItemStack(Enderdeath.orbBlue, 1, 1));
        this.addRecipe(Enderdeath.orbBlue, Enderdeath.enderHeart, new ItemStack(Enderdeath.orbRed, 1, 1));
        this.addRecipe(Enderdeath.orbBlue, Items.gold_ingot, new ItemStack(Enderdeath.orbYellow, 1, 1));
        this.addRecipe(Enderdeath.orbBlue, Items.emerald, new ItemStack(Enderdeath.orbGreen, 1, 1));
        this.addRecipe(Items.leather, Items.slime_ball, new ItemStack(Items.saddle, 1, 1));
        this.addRecipe(Enderdeath.nuggetEnderite, Items.apple, new ItemStack(Items.golden_apple, 1, 1));
        this.addRecipe(Items.bone, Enderdeath.baie, new ItemStack(Enderdeath.sitckJolo, 1, 1));
        this.addRecipe(Enderdeath.stickIron, Enderdeath.saphirCroquette, new ItemStack(Enderdeath.stickSpeed, 1, 1));
        this.addRecipe(Items.stick, Enderdeath.orbRed, new ItemStack(Enderdeath.stickHeal, 1, 1));
        this.addRecipe(Enderdeath.sitckJolo, Items.iron_ingot, new ItemStack(Enderdeath.stickJump, 1, 1));
    }

    public void addRecipe(ItemStack input1, ItemStack input2, ItemStack output1)
    {
        ItemStack[] stackList = new ItemStack[] {input1, input2};
        this.smeltingList.put(stackList, output1);
    }

    public void addRecipe(Item input1, Item input2, ItemStack output1)
    {
        this.addRecipe(new ItemStack(input1), new ItemStack(input2), output1);
    }

    public ItemStack getSmeltingResult(ItemStack[] stack)
    {
        Iterator<Entry<ItemStack[], ItemStack>> iterator = this.smeltingList.entrySet().iterator();
        Entry<ItemStack[], ItemStack> entry;

        do
        {
            if(!iterator.hasNext())
            {
                return null;
            }
            entry = (Entry<ItemStack[], ItemStack>)iterator.next();
        }
        while(!this.isSameKey(stack, (ItemStack[])entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean isSameKey(ItemStack[] stackList, ItemStack[] stackList2)
    {
        boolean isSame = false;
        for(int i = 0; i < 2; i++)
        {
            if(stackList[i].getItem() == stackList2[i].getItem())
            {
                isSame = true;
            }
            else
            {
                return false;
            }
        }
        return isSame;
    }

    public Map<ItemStack[], ItemStack> getSmeltingList()
    {
        return this.smeltingList;
    }

    public static AlloyerRecipes smelting()
    {
        return smeltingBase;
    }
}