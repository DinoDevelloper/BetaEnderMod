package ed.enderdeath.mod.Item; 

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.client.renderer.texture.TextureClock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemEnchantmentTest extends Item
{
Enchantment currentEnchantment = Enchantment.fortune;//Je ne mets pas de tableau car je pense que ton item aura uniquement qu'un seul enchantement � la fois. Car tu ne vas pas superposer les textures, sinon dis moi je corrige
private IIcon icon1;
private IIcon icon2;


public ItemEnchantmentTest()
{
this.currentEnchantment = null;
this.setTextureName(enderdeath.MODID + ":logo");
this.setUnlocalizedName(enderdeath.version);
this.setCreativeTab(CreativeTabs.tabMisc);
}

 @SideOnly(Side.CLIENT)
   public IIcon getIconIndex(ItemStack stack)
   {
       if(currentEnchantment != null)
       {
        int id = currentEnchantment.effectId;
        //Je t'ai ajout� un swtich pour tes connaissances personnelles, c'est toujours mieux de s'en servir. Apr�s tu peux connaitre les ID en regardant toutes les d�claration d'enchantement dans la classse Enchantment. Regarde le premier argument de chaque instance, c'est l'id =)
        switch(id)
        {
        case 0://Si il s'agit du protection
        return icon1;
        case 1://Si il s'agit du fire protection
        return icon2;
        default:
        return super.getIconFromDamage(stack.getItemDamage());
        }
       }
       else
        return super.getIconFromDamage(stack.getItemDamage());
   }

@Override
public void onUpdate(ItemStack stack, World world, Entity entity, int slotIndex, boolean isInHand)
{
super.onUpdate(stack, world, entity, slotIndex, isInHand);
if(stack.hasTagCompound())
{
       NBTTagList nbttaglist = stack.getEnchantmentTagList();
       if (nbttaglist != null)
       {
           for (int index = 0; index < nbttaglist.tagCount(); ++index)
           {
               short enchantmentId = nbttaglist.getCompoundTagAt(index).getShort("id");//L'id de l'enchantement
               short enchantmentLevel = nbttaglist.getCompoundTagAt(index).getShort("lvl");//Je t'ai laiss� le lvl au cas o� il t'int�resserait =)
               if (Enchantment.enchantmentsList[enchantmentId] != null)
               {
                   currentEnchantment = Enchantment.enchantmentsList[enchantmentId];
               }
           }
       }
}
}
}

 
