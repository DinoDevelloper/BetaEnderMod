package ed.enderdeath.mod.Item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class MegaEnder extends Item {
	public MegaEnder()
	{
		super();
		this.setUnlocalizedName("MegaEnder");
		this.setTextureName(enderdeath.MODID + ":MegaEnder");
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setMaxStackSize(1);
	}
	
		@Override
		public void onUpdate(ItemStack item, World world, Entity player, int slotIndex, boolean inHand)

		{

		if(item.hasTagCompound())//Si ton item n'a pas de tag alors on ne fait rien

		{

		if(item.stackTagCompound.getInteger("timer") > 0)//si ton timer est   0 ( un clic droit logiquement)

		{

		item.stackTagCompound.setInteger("timer", (int) (item.stackTagCompound.getInteger("timer") + 1));//On  de 1  chaque tick

		}

		if(item.stackTagCompound.getInteger("timer") >= (int) (6*20))//Remplace 6 par le nombre de secondes du timer souhait

		{

		item.stackTagCompound.setInteger("timer", 0);//On remet  0 si le timer est   la limite 

		}

		}

		super.onUpdate(item, world, player, slotIndex, inHand);

		}

		public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)

		{

		if(!p_77659_1_.hasTagCompound())//M�me condition, si ton item n'a pas de tag on lui en ajoute avec l'int timer en +

		{

			p_77659_1_.setTagCompound(new NBTTagCompound());

			p_77659_1_.stackTagCompound.setInteger("timer", 0);

		}

		if(p_77659_1_.stackTagCompound.getInteger("timer") == 0)

		{

			  if (p_77659_3_.capabilities.isCreativeMode)
		        {
		            return p_77659_1_;
		        }
		        else
		        {
		        
		            p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		            if (!p_77659_2_.isRemote)
		            {
		                p_77659_2_.spawnEntityInWorld(new EntityEnderPearl(p_77659_2_, p_77659_3_));
		            }

		            p_77659_1_.stackTagCompound.setInteger("timer", 1);//On le met  1 pour pouvoir rentrer dans la condition de onUpdate()

		        }
		}

		else

		{

		if(p_77659_2_.isRemote)

			p_77659_3_.addChatComponentMessage(new ChatComponentTranslation("Tu dois attendre avant de relanc� une enderpearl"));//On indique au joueur via ce message si le timer n'est pas encore   la limite 
		}
		
		return p_77659_1_;
		
		}



		@SideOnly(Side.CLIENT)

		public boolean hasEffect(ItemStack item)

		{

			return item.hasTagCompound() ? (item.stackTagCompound.getInteger("timer") == 0 ? true : false) : false;//On   si l'ItemStack a set un NBTTagCompound si oui, on  si Timer en fait partie et si il est   0, si oui, on return true  la 

		}


		
		   
		
			public boolean getIsRepairable(ItemStack input, ItemStack repair)
		    {
			 if(input.getItem() ==  this && repair.getItem() == enderdeath.Royalite)
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
}
