package ed.enderdeath.mod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import ed.enderdeath.mod.entity.BomberEntity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class Wand extends Item
{

    public Wand()
    {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(500);
        this.setTextureName(Enderdeath.MODID + ":Wand");
        this.setCreativeTab(CreativeTabs.tabTools);

    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int slotIndex, boolean inHand)

    {

        if(item.hasTagCompound())// Si ton item n'a pas de tag alors on ne fait rien

        {

            if(item.stackTagCompound.getInteger("timer") > 0)// si ton timer est 0 ( un clic droit logiquement)

            {

                item.stackTagCompound.setInteger("timer", (int)(item.stackTagCompound.getInteger("timer") + 1));// On de 1 chaque tick

            }

            if(item.stackTagCompound.getInteger("timer") >= (int)(6 * 20))// Remplace 6 par le nombre de secondes du timer souhait

            {

                item.stackTagCompound.setInteger("timer", 0);// On remet 0 si le timer est la limite

            }

        }

        super.onUpdate(item, world, player, slotIndex, inHand);

    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)

    {

        if(!item.hasTagCompound())// M�me condition, si ton item n'a pas de tag on lui en ajoute avec l'int timer en +

        {

            item.setTagCompound(new NBTTagCompound());

            item.stackTagCompound.setInteger("timer", 0);

        }

        if(item.stackTagCompound.getInteger("timer") == 0)

        {

            if(!world.isRemote)
            {
                world.spawnEntityInWorld(new BomberEntity(world, player));
            }

            item.stackTagCompound.setInteger("timer", 1);// On le met 1 pour pouvoir rentrer dans la condition de onUpdate()

        }

        else

        {

            if(world.isRemote)

                player.addChatComponentMessage(new ChatComponentTranslation("Tu dois attendre que le baton se recharge !"));// On indique au joueur via ce message si le timer n'est pas encore la
                                                                                                                            // limite
        }

        return item;

    }

    @SideOnly(Side.CLIENT)

    public boolean hasEffect(ItemStack item)

    {

        return item.hasTagCompound() ? (item.stackTagCompound.getInteger("timer") == 0 ? true : false) : false;// On si l'ItemStack a set un NBTTagCompound si oui, on si Timer en fait partie et si il
                                                                                                               // est 0, si oui, on return true la

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
