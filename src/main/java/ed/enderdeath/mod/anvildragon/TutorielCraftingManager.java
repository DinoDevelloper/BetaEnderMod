package ed.enderdeath.mod.anvildragon;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.istack.internal.Nullable;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class TutorielCraftingManager
{
    private static final TutorielCraftingManager INSTANCE = new TutorielCraftingManager();

    public static TutorielCraftingManager getInstance()
    {
        return INSTANCE;
    }

    /** La liste des recettes */
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();
    private Block cratingTable;

    private TutorielCraftingManager()
    {
        System.out.println("Test TutorielCraftingManager");
        addShapelessRecipe(new ItemStack(Blocks.anvil), Items.carrot, Items.golden_apple);
        addRecipe(new ItemStack(cratingTable), " C ", "X X", " C ", 'C', "slabWood", 'X', Blocks.planks); // "slabWood" est le nom des dalles de bois dans l'ore dictionnary, ceci est ajout� par Forge
        addRecipe(new ItemStack(Items.golden_apple), "A  A", "X  X", "X  X", "A  A", 'A', Items.carrot, 'X', Blocks.planks);

    }

    public TutorielShapedRecipes addRecipe(ItemStack result, Object... recipeComponents)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;
        if(recipeComponents[i] instanceof String[])
        {
            String[] astring = (String[])((String[])recipeComponents[i++]);
            for(int l = 0; l < astring.length; ++l)
            {
                String s2 = astring[l];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }
        else
        {
            while(recipeComponents[i] instanceof String)
            {
                String s1 = (String)recipeComponents[i++];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        Character character;
        Map<Character, Object> components = Maps.<Character, Object>newHashMap();
        Object in;
        for(; i < recipeComponents.length; i += 2)
        {
            in = recipeComponents[i + 1];
            Object component = null;
            character = (Character)recipeComponents[i];
            if(in instanceof Item)
            {
                component = new ItemStack((Item)recipeComponents[i + 1]);
            }
            else if(in instanceof Block)
            {
                component = new ItemStack((Block)recipeComponents[i + 1], 1, 32767);
            }
            else if(in instanceof ItemStack)
            {
                component = (ItemStack)recipeComponents[i + 1];
            }
            else if(in instanceof String)
            {
                component = (String)in;
            }
            else
            {
                throw new IllegalArgumentException("Invalid shaped recipe: unknown type " + in.getClass().getName() + "!");
            }
            components.put(character, component);
        }
        Object[] aitemstack = new Object[j * k];
        char key;
        Object component;
        for(int i1 = 0; i1 < j * k; ++i1)
        {
            key = s.charAt(i1);
            if(components.containsKey(Character.valueOf(key)))
            {
                component = components.get(Character.valueOf(key));
                if(component instanceof ItemStack)
                    aitemstack[i1] = ((ItemStack)component).copy();
                else
                    aitemstack[i1] = component;
            }
            else
                aitemstack[i1] = null;
        }
        TutorielShapedRecipes shapedrecipes = new TutorielShapedRecipes(j, k, aitemstack, result);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack result, Object... recipeComponents)
    {
        List list = Lists.newArrayList();
        for(Object component : recipeComponents) // Pour chaque composant de la recette
        {
            if(component instanceof ItemStack)
            {
                list.add(((ItemStack)component).copy());
            }
            else if(component instanceof Item)
            {
                list.add(new ItemStack((Item)component));
            }
            else if(component instanceof Block)
            {
                list.add(new ItemStack((Block)component));
            }
            else if(component instanceof String) // Pour l'ore dictionnary
            {
                list.add(component);
            }
            else
                throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + component.getClass().getName() + "!");
        }
        this.recipes.add(new TutorielShapelessRecipe(result, list));
    }

    /**
     * Adds a shaped recipe to the games recipe list.
     */

    /**
     * Adds an IRecipe to the list of crafting recipes.
     */
    public void addRecipe(IRecipe recipe)
    {
        this.recipes.add(recipe);
    }

    /**
     * Retourne le r�sultat de la recette ou null si il n'y en a aucun
     */
    @Nullable
    public ItemStack findMatchingRecipe(InventoryCrafting craftMatrix, World worldIn)
    {
        for(IRecipe irecipe : this.recipes) // Pour chaque recette
        {
            if(irecipe.matches(craftMatrix, worldIn)) // Si elle correspond � la matrice actuelle
            {
                return irecipe.getCraftingResult(craftMatrix); // On donne son r�sultat
            }
        }
        return null;
    }

    /**
     * Retourne les items retants apr�s un craft
     */

    public List<IRecipe> getRecipeList()
    {
        return this.recipes;
    }
}
