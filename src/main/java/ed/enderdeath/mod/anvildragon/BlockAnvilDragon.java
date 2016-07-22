package ed.enderdeath.mod.anvildragon;

import ed.enderdeath.mod.common.Enderdeath;
import ed.enderdeath.mod.common.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockAnvilDragon extends Block
{

    public BlockAnvilDragon()
    {
        super(Material.anvil);
        this.setBlockTextureName(Enderdeath.MODID + ":BlockAnvilDragon");
        this.setBlockName("BlockAnvilDragon");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
            player.openGui(Enderdeath.instance, GuiHandler.guiCraftingTableID, world, x, y, z);
        }
        return true;
    }
}