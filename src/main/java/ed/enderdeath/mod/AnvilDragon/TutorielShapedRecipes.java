package ed.enderdeath.mod.AnvilDragon;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.oredict.OreDictionary;

public class TutorielShapedRecipes implements IRecipe
 
{  /** How many horizontal slots this recipe is wide. */
	   public final int recipeWidth;
	   /** How many vertical slots this recipe uses. */
	   public final int recipeHeight;
	   /** Is a array of ItemStack that composes the recipe. */
	   public final Object[] recipeItems;
	   /** Is the ItemStack that you get when craft the recipe. */
	   private final ItemStack recipeOutput;
	   private boolean copyIngredientNBT;
	   private static World world;
	   private static InventoryPlayer inv;
	   private static int x;
	   private static int y;
	   private static int z;
	   public static  int craftWidth = 4;

		public static int craftHeigth = 4;

	   
	   public TutorielShapedRecipes(int width, int height, Object[] items, ItemStack output)
	   {
	       this.recipeWidth = width;
	       this.recipeHeight = height;
	       this.recipeItems = items;
	       this.recipeOutput = output;
	   	System.out.println("Test TutorielShapedRecipes");
	   }

	   public ItemStack getRecipeOutput()
	   {
	       return this.recipeOutput;
	   }

	   public ItemStack[] getRemainingItems(InventoryCrafting inv)
	   {
	       ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];
	       for (int i = 0; i < aitemstack.length; ++i)
	       {
	           ItemStack itemstack = inv.getStackInSlot(i);
	           aitemstack[i] = recipeOutput.getItem().getContainerItem(recipeOutput);
	       }
	       return aitemstack;
	   }

	   /**
	    * Used to check if a recipe matches current crafting inventory
	    * Retourne true si la recette correspond à la matrice donnée (le craft que le joueur a fait)
	    */
	   public boolean matches(InventoryCrafting inv, World worldIn)
	   {
	       for (int i = 0; i <= this.craftWidth - this.recipeWidth; ++i)
	       {
	           for (int j = 0; j <= this.craftHeigth - this.recipeHeight; ++j)
	           {
	               if (this.checkMatch(inv, i, j, true))
	               {
	                   return true;
	               }
	               if (this.checkMatch(inv, i, j, false))
	               {
	                   return true;
	               }
	           }
	       }
	       return false;
	   }

	   /**
	    * Checks if the region of a crafting inventory is match for the recipe.
	    * Compare deux parties du craft
	    */
	   private boolean checkMatch(InventoryCrafting inv, int regionX, int regionY, boolean mirror)
	   {
	     for (int x = 0 ; x < this.craftWidth ; ++x)
	       {
	           for (int y = 0 ; y < this.craftHeigth ; ++y)
	           {
	               int x1 = x - regionX;
	               int y1 = y - regionY;
	               Object patternStack = null;
	               if (x1 >= 0 && y1 >= 0 && x1 < this.recipeWidth && y1 < this.recipeHeight)
	               {
	                if (mirror) 
	                patternStack = this.recipeItems[this.recipeWidth - x1 - 1 + y1 * this.recipeWidth];
	                else
	                patternStack = this.recipeItems[x1 + y1 * this.recipeWidth];
	                if(patternStack instanceof String)
	                {
	                List<ItemStack> stacks = OreDictionary.getOres((String) patternStack);
	                boolean matches = false;
	                for(ItemStack stack : stacks)
	                {
	                if(areItemStacksEquals(stack, inv.getStackInRowAndColumn(x, y))) //If the pattern's stack doesn't match with the stack in the inv crafting
	                {
	                matches = true;
	                }
	                }
	                if(!matches)
	                return false;
	                }
	                else if(!areItemStacksEquals((ItemStack) patternStack, inv.getStackInRowAndColumn(x, y)))
	                {
	                return false;
	                }
	               }
	           }
	       }
	       return true;
	   }
	   
	   
	   /**
	    * Compare les deux stacks
	    */
	   public static boolean areItemStacksEquals(ItemStack stack1, ItemStack stack2)
	   {
	    if(stack1 == null || stack2 == null) return stack1 == stack2;
	    return stack1.getItem() == stack2.getItem() && (stack1.getItemDamage() == OreDictionary.WILDCARD_VALUE || stack1.getItemDamage() == stack2.getItemDamage());
	   }

	   /**
	    * Returns an Item that is the result of this recipe
	    */
	   public ItemStack getCraftingResult(InventoryCrafting inv)
	   {
	       ItemStack itemstack = this.getRecipeOutput().copy();
	       if (this.copyIngredientNBT)
	       {
	           for (int i = 0; i < inv.getSizeInventory(); ++i)
	           {
	               ItemStack itemstack1 = inv.getStackInSlot(i);
	               if (itemstack1 != null && itemstack1.hasTagCompound())
	               {
	                   itemstack.setTagCompound((NBTTagCompound)itemstack1.getTagCompound().copy());
	               }
	           }
	       }
	       return itemstack;
	   }

	   /**
	    * Returns the size of the recipe area
	    */
	   public int getRecipeSize()
	   {
	       return this.recipeWidth * this.recipeHeight;
	   }

	   /**
	    * Set this crafting recipe to copy the NBT tag compound of the last ItemStack that has one in the crafting table.
	    */
	   public TutorielShapedRecipes setCopyIngredientNBT()
	   {
	       this.copyIngredientNBT = true;
	       return this;
	   }
	 

}
