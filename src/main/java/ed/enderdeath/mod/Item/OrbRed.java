package ed.enderdeath.mod.Item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OrbRed extends Item {
	  public OrbRed()
	   {
	    
	       this.maxStackSize = 1;
	       this.setMaxDamage(2000);
			setCreativeTab(CreativeTabs.tabTools);
	       this.setTextureName(enderdeath.MODID + ":OrbRed");
	       this.setUnlocalizedName("OrbRed");
	   }
	  public boolean getIsRepairable(ItemStack input, ItemStack repair)
	    {
		 if(input.getItem() ==  this && repair.getItem() == enderdeath.Rubis)
		 {
			 return true;
		 }
	        return false;
	    }
	    
	 
	    
	   public boolean isFull3D() // on met de la 3D a l'item
	   {
	       return true;
	   }
	   @Override
		@SideOnly(Side.CLIENT)
		public EnumRarity getRarity(ItemStack itemstack)
		{
		   return EnumRarity.epic;
		}
	   @Override
	  	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected)
	  	{
	  		if(entity instanceof EntityPlayer) 
	  		{
	  			EntityPlayer player = (EntityPlayer) entity; 
	  			for(int i = 0; i < 4; i++) 
	  			{
	  				ItemStack armor = player.getCurrentArmor(i);
	  				if(armor != null) 
	  				{
	                                         
	  					if(armor.getItemDamage() > 0 && stack.getItemDamage() < stack.getMaxDamage())
	  					{
	  						stack.setItemDamage(stack.getItemDamage() +10); 
	  						armor.setItemDamage(armor.getItemDamage() -10); 
	  						
	  						int durability = stack.getMaxDamage() - stack.getItemDamage(); 
	  					}
	  				}
	  			}
	  		}
	  	}
}
