package ed.enderdeath.mod.anvildragon;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class TutorielShapelessRecipe implements IRecipe
{

    /** Is the ItemStack that you get when craft the recipe. */
    private final ItemStack recipeOutput;
    /** Is a List of ItemStack that composes the recipe. */
    public final List recipeItems;
    private static int getHeight;
    private static int getWidth;

    public TutorielShapelessRecipe(ItemStack output, List inputList)
    {
        this.recipeOutput = output;
        this.recipeItems = inputList;
        System.out.println("Test TutorielShapelessRecipe");
    }

    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }

    public ItemStack[] getRemainingItems(InventoryCrafting inv)
    {
        ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];
        for(int i = 0; i < aitemstack.length; ++i)
        {
            ItemStack itemstack = inv.getStackInSlot(i);
            aitemstack[i] = recipeOutput.getItem().getContainerItem(recipeOutput);
        }
        return aitemstack;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     * Retourne true si la recette correspond � la matrice donn�e (le craft que le joueur a fait)
     * La fonction prend une liste des items requis pour le craft, puis pour chaque item rencontr� dans la matrice, le retire de la liste des items,
     * si la liste ne contient pas l'item, c'est qu'il y a un item en trop dans le craft et la fonction retourne false, � la fin, si la liste est vide, la
     * fonction retourne true.
     */
    public boolean matches(InventoryCrafting inv, World worldIn)
    {
        ArrayList arraylist = Lists.newArrayList(this.recipeItems); // Copie les items du craft dans une nouvelle liste
        for(int i = 0; i < this.getHeight(); ++i)
        {
            for(int j = 0; j < this.getWidth(); ++j)
            {
                ItemStack itemstack = inv.getStackInRowAndColumn(j, i);
                if(itemstack != null)
                {
                    boolean flag = false;
                    for(Object component : arraylist)
                    {
                        if(component instanceof String) // Search in ore dictionary
                        {
                            List<ItemStack> stacks = OreDictionary.getOres((String)component);
                            for(ItemStack itemstack1 : stacks)
                            {
                                if(TutorielShapedRecipes.areItemStacksEquals(itemstack, itemstack1))
                                {
                                    flag = true;
                                    arraylist.remove(itemstack1);
                                    break;
                                }
                            }
                        }
                        else
                        {
                            ItemStack itemstack1 = (ItemStack)component;
                            if(TutorielShapedRecipes.areItemStacksEquals(itemstack, itemstack1))
                            {
                                flag = true;
                                arraylist.remove(itemstack1);
                                break;
                            }
                        }
                    }
                    if(!flag)
                        return false;
                }
            }
        }
        return arraylist.isEmpty();
    }

    private int getWidth()
    {
        return getWidth;
    }

    private int getHeight()
    {
        return getHeight;
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting inv)
    {
        return this.recipeOutput.copy();
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize()
    {
        return this.recipeItems.size();
    }

}
