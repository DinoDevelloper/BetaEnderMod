package ed.enderdeath.mod.Block;

import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.world.World;

public class TileEntityMega extends TileEntity
{
    private final MegaspawnerInfo field_145882_a = new MegaspawnerInfo()
    {

        public void func_98267_a(int p_98267_1_)
        {
            TileEntityMega.this.worldObj.addBlockEvent(TileEntityMega.this.xCoord, TileEntityMega.this.yCoord, TileEntityMega.this.zCoord, Blocks.mob_spawner, p_98267_1_, 0);
        }
        public World getSpawnerWorld()
        {
            return TileEntityMega.this.worldObj;
        }
        public int getSpawnerX()
        {
            return TileEntityMega.this.xCoord;
        }
        public int getSpawnerY()
        {
            return TileEntityMega.this.yCoord;
        }
        public int getSpawnerZ()
        {
            return TileEntityMega.this.zCoord;
        }
        public void setRandomEntity(WeightedRandomMinecart p_98277_1_)
        {
            super.setRandomEntity(p_98277_1_);

            if (this.getSpawnerWorld() != null)
            {
                this.getSpawnerWorld().markBlockForUpdate(TileEntityMega.this.xCoord, TileEntityMega.this.yCoord, TileEntityMega.this.zCoord);
            }
        }
    };


    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        super.readFromNBT(p_145839_1_);
        this.field_145882_a.readFromNBT(p_145839_1_);
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        this.field_145882_a.writeToNBT(p_145841_1_);
    }

    public void updateEntity()
    {
        this.field_145882_a.updateSpawner();
        super.updateEntity();
    }

    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        nbttagcompound.removeTag("SpawnPotentials");
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);
    }


    public boolean receiveClientEvent(int p_145842_1_, int p_145842_2_)
    {
        return this.field_145882_a.setDelayToMin(p_145842_1_) ? true : super.receiveClientEvent(p_145842_1_, p_145842_2_);
    }

    public MegaspawnerInfo func_145881_a()
    {
        return this.field_145882_a;
    }
}