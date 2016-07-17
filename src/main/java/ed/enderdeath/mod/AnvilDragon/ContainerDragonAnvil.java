package ed.enderdeath.mod.AnvilDragon;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerDragonAnvil extends Container
{


	/** Largeur du craft */
	public static  int craftWidth = 4;
	/** Hauteur du craft */
	public static int craftHeigth = 4;

	/** Inventaire contenant le craft */
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, craftWidth, craftHeigth);
	/** Inventaire contenant le résultat du craft */
	public IInventory craftResult = new InventoryCraftResult();

	public World worldObj;
	public int pos;
	public int x;
	public int y;
	public int z;
	public int Width;

	public ContainerDragonAnvil(InventoryPlayer invPlayer, World world, int pos,int y,int z) 
	{
	this.worldObj = world; 
	this.pos = pos;

	//Ajout du slot pour le résultat
	this.addSlotToContainer(new DragonSlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 141, 43));

	int startX = 8; //Position x ou les slots de craft commencent à être dessinés
	int startY = 7; //Position y ou les slots de craft commencent à être dessinés
	//Ajout des slots de craft
	for (int y1 = 0; y1 < craftHeigth; ++y1)
	{
	for(int x = 0; x < craftWidth; ++x) 
	{
	this.addSlotToContainer(new Slot(craftMatrix, x + y1 * craftWidth, startX + x * 18, startY + y1 * 18));
	}
	}

	startX = 8; //Position x ou les slots de l'inventaire commencent à être dessinés
	startY = 106; //Position y ou les slots de l'inventaire commencent à être dessinés
	//Ajout des slots de l'inventaire du joueur
	for (int y1 = 0; y1 < 3; ++y1) 
	{
	for(int x = 0; x < 9; ++x)
	{
	this.addSlotToContainer(new Slot(invPlayer, x + y1 * 9 + 9, startX + x * 18, startY + y1 * 18));
	}
	}
	startY = 164; //Position y ou les slots de la hotbar commencent à être dessinés
	//Ajout des slots de la hotbar
	for (int x = 0; x < 9; ++x) 
	{
	this.addSlotToContainer(new Slot(invPlayer, x, startX + x * 18, startY));
	}
	}

	/**
	* Appelé quand la matrice (les slots de craft) change
	*/
	@Override
	public void onCraftMatrixChanged(IInventory iiventory)
	{
	//On met le résultat du craft dans le slot de résultat
	craftResult.setInventorySlotContents(0, TutorielCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}

	/**
	* Retourne true si le joueur peut interagir avec ce gui, en général on teste la distance par rapport au joueur dans cette fonction
	*/
	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
	return this.worldObj.getBlock(x, y, z) == enderdeath.AnvilDragon;
	}

	/**
	* Appelé quand le container est fermé
	*/
	@Override
	public void onContainerClosed(EntityPlayer player) 
	{
	       super.onContainerClosed(player);
	       if (!this.worldObj.isRemote) //Si on est sur le serveur, on loot les items à la fermeture du gui
	       {
	           for (int i = 0; i < 9; ++i)
	           {
	               ItemStack itemstack = this.craftMatrix.getStackInSlot(i);
	               if (itemstack != null)
	               {
	            	   player.dropPlayerItemWithRandomChoice(itemstack, false);
	                   //player.dropPlayerItemWithRandomChoice(itemstack, false); //TODO A utiliser en 1.8
	               }
	           }
	       }
	   }

	/**
	* Cette fonction est appelée lors du shift+clic (je vous conseille de la laisser comme tel, mais je précise quel ne s'adaptera pas en fonction de la taille du craft)
	*/
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotId)
	{
	       ItemStack itemstack = null;
	       Slot slot = (Slot) this.inventorySlots.get(slotId);

	       if (slot != null && slot.getHasStack())
	       {
	           ItemStack itemstack1 = slot.getStack();
	           itemstack = itemstack1.copy();

	           if (slotId == 0)
	           {
	               if (!this.mergeItemStack(itemstack1, 10, 46, true))
	               {
	                   return null;
	               }
	               slot.onSlotChange(itemstack1, itemstack);
	           }
	           else if (slotId >= 10 && slotId < 37)
	           {
	               if (!this.mergeItemStack(itemstack1, 37, 46, false))
	               {
	                   return null;
	               }
	           }
	           else if (slotId >= 37 && slotId < 46)
	           {
	               if (!this.mergeItemStack(itemstack1, 10, 37, false))
	               {
	                   return null;
	               }
	           }
	           else if (!this.mergeItemStack(itemstack1, 10, 46, false))
	           {
	               return null;
	           }
	           if (itemstack1.stackSize == 0)
	           {
	               slot.putStack((ItemStack)null);
	           }
	           else
	           {
	               slot.onSlotChanged();
	           }
	           if (itemstack1.stackSize == itemstack.stackSize)
	           {
	               return null;
	           }

	           slot.onPickupFromSlot(player, itemstack1);
	       }
	       return itemstack;
	   }

	/**
	* Appelé quand on double clic sur un slot :
	    * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
	    * is null for the initial slot that was double-clicked.
	*/
	   public boolean canMergeSlot(ItemStack stack, Slot slotIn)
	   {
	       return slotIn.inventory != this.craftResult && super.canDragIntoSlot(slotIn);
	   }
}
