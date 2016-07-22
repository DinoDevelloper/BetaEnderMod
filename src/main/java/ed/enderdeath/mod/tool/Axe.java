package ed.enderdeath.mod.tool;

import ed.enderdeath.mod.common.Enderdeath;
import ed.enderdeath.mod.tool.toolBase.ToolAxe;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Axe extends ToolAxe
{

    public Axe(ToolMaterial material)
    {
        super(material);
        this.setTextureName(Enderdeath.MODID + ":WoodAxe");
        this.setUnlocalizedName("WoodAxe");
    }

    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase living)
    {
        for(int i = y; i < 256; i++)
        {
            if(world.getBlock(x, i, z).isWood(world, x, i, z))
            {
                stack.damageItem(1, living); // endommage l'item � chaque buche cass�e
                if(!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) // si la r�gle de jeu drop est activ�
                {
                    float f = 0.7F;
                    double d0 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    EntityItem entityitem = new EntityItem(world, (double)x + d0, (double)i + d1, (double)z + d2, new ItemStack(world.getBlock(x, i, z), 1, world.getBlockMetadata(x, i, z))); // instancie
                                                                                                                                                                                               // une
                                                                                                                                                                                               // nouvelle
                                                                                                                                                                                               // entit�
                                                                                                                                                                                               // item
                                                                                                                                                                                               // avec
                                                                                                                                                                                               // les
                                                                                                                                                                                               // coordonn�es
                                                                                                                                                                                               // + l'id
                                                                                                                                                                                               // et le
                                                                                                                                                                                               // metadata
                                                                                                                                                                                               // du
                                                                                                                                                                                               // bois
                    entityitem.delayBeforeCanPickup = 10;
                    world.spawnEntityInWorld(entityitem); // spawn l'entit� item
                }
                world.setBlockToAir(x, i, z); // met de l'air � la place du bloc
            }
            else
            {
                return super.onBlockDestroyed(stack, world, block, x, i, z, living);
            }
        }
        return super.onBlockDestroyed(stack, world, block, x, y, z, living);
    }
}
