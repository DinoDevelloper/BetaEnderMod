package ed.enderdeath.mod.Item;

import java.util.Iterator;



import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import scala.collection.immutable.List;

public class ItemClass extends Item
{
	 public boolean isBeaconPayment(ItemStack stack)
	    {
	        return this == Items.emerald || this == Items.diamond || this == Items.gold_ingot || this == Items.iron_ingot || this == enderdeath.Darkanite || this == enderdeath.hulmini || this == enderdeath.Royalite || this == enderdeath.Rubis || this == enderdeath.Saphir;
	    }
	
	 
	
	
}
