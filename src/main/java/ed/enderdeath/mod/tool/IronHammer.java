package ed.enderdeath.mod.tool;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class IronHammer extends Item
{
    private final Item.ToolMaterial field_150933_b;
    private float field_150934_a;

    private static final String __OBFID = "CL_00000072";

    public IronHammer(Item.ToolMaterial p_i45356_1_)
    {
        this.field_150933_b = p_i45356_1_;
        this.maxStackSize = 1;
        this.setMaxDamage(p_i45356_1_.getMaxUses());

        this.field_150934_a = 4.0F + p_i45356_1_.getDamageVsEntity();

        this.setMaxDamage(1000);
    }

    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(p_77648_2_, p_77648_1_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_);
            if(MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if(event.getResult() == Result.ALLOW)
            {
                p_77648_1_.damageItem(50, p_77648_2_);
                return true;
            }

            Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);

            if(p_77648_7_ != 0 && p_77648_3_.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_).isAir(p_77648_3_, p_77648_4_, p_77648_5_ + 1, p_77648_6_) && (block == Blocks.anvil || block == Blocks.anvil))
            {
                Block block1 = Blocks.anvil;

                if(p_77648_3_.isRemote)
                {
                    return true;
                }
                else
                {
                    p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, block1);
                    p_77648_1_.damageItem(50, p_77648_2_);
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    public float func_150931_i()
    {
        return this.field_150933_b.getDamageVsEntity();
    }

    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_)
    {
        p_77644_1_.damageItem(1000, p_77644_3_);
        return true;
    }

    private boolean isGiantBlock(Block block)
    {
        return block instanceof BlockStone;
    }
}
