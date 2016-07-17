package ed.enderdeath.mod.AnvilDragon;

import com.sun.istack.internal.Nullable;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

public class DragonSlotCrafting extends Slot {
	/** The craft matrix inventory linked to this result slot. */
	   private final InventoryCrafting craftMatrix;
	   /** The player that is using the GUI where this slot resides. */
	   private final EntityPlayer thePlayer;
	   /** The number of items that have been crafted so far. Gets passed to ItemStack.onCrafting before being reset. */
	   private int amountCrafted;

	   public DragonSlotCrafting(EntityPlayer player, InventoryCrafting craftingInventory, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
	   {
	       super(inventoryIn, slotIndex, xPosition, yPosition);
	       this.thePlayer = player;
	       this.craftMatrix = craftingInventory;

	   }

	   /**
	    * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
	    */
	   @Override
	   public boolean isItemValid(@Nullable ItemStack stack)
	   {
	       return false;
	   }

	   /**
	    * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
	    * stack.
	    */
	   @Override
	   public ItemStack decrStackSize(int amount)
	   {
	       if (this.getHasStack())
	       {
	           this.amountCrafted += Math.min(amount, this.getStack().stackSize);
	       }
	       return super.decrStackSize(amount);
	   }

	   /**
	    * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
	    * internal count then calls onCrafting(item).
	    */
	   @Override
	   protected void onCrafting(ItemStack stack, int amount)
	   {
	       this.amountCrafted += amount;
	       this.onCrafting(stack);
	   }

	   /**
	    * Appelé quand on craft, permet de gérer les achievements
	    */
	   @Override
	   protected void onCrafting(ItemStack stack)
	   {
	       if (this.amountCrafted > 0)
	       {
	           stack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.amountCrafted);
	       }
	       this.amountCrafted = 0;
	  
	       if (stack.getItem() == Item.getItemFromBlock(Blocks.bookshelf))
	       {
	           this.thePlayer.addStat(AchievementList.bookcase, 1);
	       }
	   }

	   /**
	    * Appelée quand le j
	    * 
	    * oueur retire l'item du slot, permet de retirer le composants utilisés pour le craft
	    */
	  
	    public void onPickupFromSlot(EntityPlayer p_82870_1_, ItemStack p_82870_2_)
	    {
	        FMLCommonHandler.instance().firePlayerCraftingEvent(p_82870_1_, p_82870_2_, craftMatrix);
	        this.onCrafting(p_82870_2_);

	        for (int i = 0; i < this.craftMatrix.getSizeInventory(); ++i)
	        {
	            ItemStack itemstack1 = this.craftMatrix.getStackInSlot(i);

	            if (itemstack1 != null)
	            {
	                this.craftMatrix.decrStackSize(i, 1);

	                if (itemstack1.getItem().hasContainerItem(itemstack1))
	                {
	                    ItemStack itemstack2 = itemstack1.getItem().getContainerItem(itemstack1);

	                    if (itemstack2 != null && itemstack2.isItemStackDamageable() && itemstack2.getItemDamage() > itemstack2.getMaxDamage())
	                    {
	                        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(thePlayer, itemstack2));
	                        continue;
	                    }

	                    if (!itemstack1.getItem().doesContainerItemLeaveCraftingGrid(itemstack1) || !this.thePlayer.inventory.addItemStackToInventory(itemstack2))
	                    {
	                        if (this.craftMatrix.getStackInSlot(i) == null)
	                        {
	                            this.craftMatrix.setInventorySlotContents(i, itemstack2);
	                        }
	                        else
	                        {
	                            this.thePlayer.dropPlayerItemWithRandomChoice(itemstack2, false);
	                        }
	                    }
	                }
	            }
	        }
	    
	    }
	
}
