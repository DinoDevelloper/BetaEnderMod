package ed.enderdeath.mod.AnvilDragon;

import ed.enderdeath.mod.common.GuiHandler;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockAnvilDragon extends Block
{

    public BlockAnvilDragon()
    {
        super(Material.anvil);
        this.setBlockTextureName(enderdeath.MODID + ":BlockAnvilDragon");
        this.setBlockName("BlockAnvilDragon");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if(!world.isRemote)
        {
            player.openGui(enderdeath.instance, GuiHandler.guiCraftingTableID, world, x, y, z);
        }
        return true;
    }
}