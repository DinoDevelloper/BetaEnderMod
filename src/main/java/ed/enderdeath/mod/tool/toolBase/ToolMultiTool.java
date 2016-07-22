package ed.enderdeath.mod.tool.toolBase;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

public class ToolMultiTool extends ItemTool
{
    private static final Set field_150916_c = Sets.newHashSet(new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});

    public ToolMultiTool(float p_i45333_1_, ToolMaterial p_i45333_2_, Set p_i45333_3_)
    {
        super(p_i45333_1_, p_i45333_2_, p_i45333_3_);

    }

    public boolean func_150897_b(Block p_150897_1_)
    {
        return p_150897_1_ == Blocks.snow_layer ? true : p_150897_1_ == Blocks.snow;
    }
}
