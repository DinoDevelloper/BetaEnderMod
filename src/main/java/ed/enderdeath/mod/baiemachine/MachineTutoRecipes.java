package ed.enderdeath.mod.baiemachine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MachineTutoRecipes
{

    private static final MachineTutoRecipes smeltingBase = new MachineTutoRecipes(); // Permet d'instancier votre classe car vous le l'instancierez nul part ailleur
    private Map smeltingList = new HashMap(); // Ceci permet de mettre vos recettes

    public MachineTutoRecipes()
    {
        this.addRecipe(Enderdeath.baieBlue, Enderdeath.baieRed, Enderdeath.baieGreen, new ItemStack(Enderdeath.baieBlack));
        this.addRecipe(Enderdeath.baie, Enderdeath.baie, Enderdeath.baie, new ItemStack(Enderdeath.baieWhite));
        this.addRecipe(Enderdeath.baie, Enderdeath.baieRed, Enderdeath.baie, new ItemStack(Enderdeath.baiePink));
        this.addRecipe(Enderdeath.baie, Enderdeath.baieRed, Enderdeath.baieYellow, new ItemStack(Enderdeath.baiePink));
        this.addRecipe(Enderdeath.baieBlue, Enderdeath.baiePink, Enderdeath.baiePink, new ItemStack(Enderdeath.baieHeal));
        this.addRecipe(Enderdeath.baieHeal, Enderdeath.baieHeal, Enderdeath.baiePink, new ItemStack(Enderdeath.baieSpeed));
        this.addRecipe(Enderdeath.baieSpeed, Enderdeath.baieSpeed, Enderdeath.baiePink, new ItemStack(Enderdeath.baieOfChocolate));
        this.addRecipe(Enderdeath.baie, Enderdeath.baieWhite, Enderdeath.baieBlack, new ItemStack(Enderdeath.baieResistance));
    }

    @SuppressWarnings("unchecked")
    public void addRecipe(ItemStack stack1, ItemStack stack2, ItemStack stack3, ItemStack stack4) // Cette fonction de comprend que des ItemStack, c'est celle qui ajoute les recettes � la HashMap
    {
        ItemStack[] stackList = new ItemStack[] {stack1, stack2, stack3};
        this.smeltingList.put(stackList, stack4);
    }

    public void addRecipe(Item item1, Item item2, Item item3, ItemStack stack) // 1er cas
    {
        this.addRecipe(new ItemStack(item1), new ItemStack(item2), new ItemStack(item3), stack);
    }

    public void addRecipe(Block block1, Item item2, Item item3, ItemStack stack) // 2nd cas
    {
        this.addRecipe(Item.getItemFromBlock(block1), item2, item3, stack);
    }

    public void addRecipe(Block block1, Block block2, Item item3, ItemStack stack) // 3�me cas
    {
        this.addRecipe(Item.getItemFromBlock(block1), Item.getItemFromBlock(block2), item3, stack);
    }

    public void addRecipe(Block block1, Block block2, Block block3, ItemStack stack) // 4�me cas
    {
        this.addRecipe(Item.getItemFromBlock(block1), Item.getItemFromBlock(block2), Item.getItemFromBlock(block3), stack);
    }

    public ItemStack getSmeltingResult(ItemStack[] stack) // En argument : un tableau avec le contenu des trois slots d'input
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do
        {
            if(!iterator.hasNext()) // Si il n'y a plus de recettes dans la liste
            {
                return null; // Il n'y a pas de recette correspondante
            }
            entry = (Entry)iterator.next(); // prend la recette suivante
        }
        while(!this.isSameKey(stack, (ItemStack[])entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean isSameKey(ItemStack[] stackList, ItemStack[] stackList2)
    {
        boolean isSame = false;
        for(int i = 0; i <= 2; i++)
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

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public static MachineTutoRecipes smelting()
    {
        return smeltingBase;
    }
}
