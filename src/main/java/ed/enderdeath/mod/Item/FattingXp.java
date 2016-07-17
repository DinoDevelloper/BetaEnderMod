package ed.enderdeath.mod.Item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FattingXp extends Item
{
	public FattingXp()
	{
		this.setUnlocalizedName("FattingXp");
		this.setFull3D();
		this.setTextureName(enderdeath.MODID + ":FattingXp");
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack p_77636_1_)
    {
        return true;
    }
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        if (!p_77659_3_.capabilities.isCreativeMode)
        {
            --p_77659_1_.stackSize;
        }

        p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 1.9F, 1.5F / (itemRand.nextFloat() * 1.8F + 1.5F));

        if (!p_77659_2_.isRemote)
        {
            p_77659_2_.spawnEntityInWorld(new EntityExpBottle(p_77659_2_, p_77659_3_));
        }

        return p_77659_1_;
    }
   
}
