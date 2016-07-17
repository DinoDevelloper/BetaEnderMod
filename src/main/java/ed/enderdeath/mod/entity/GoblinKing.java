package ed.enderdeath.mod.entity;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GoblinKing extends Goblin implements IBossDisplayData
{
	
	private static ItemStack defaultHeldItem;
	public GoblinKing(World world) {
		super(world);
	
	
	   this.tasks.addTask(8, new EntityAIOpenDoor(this, true));
       this.tasks.addTask(0, new EntityAISwimming(this));
	}

	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(250D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(5.0D);
	}

	 protected int getExperiencePoints(EntityPlayer p_70693_1_)
	    {
	        if (this.isChild())
	        {
	            this.experienceValue = (int)((float)this.experienceValue * 2.5F);
	        }

	        return super.getExperiencePoints(p_70693_1_);
	    }
	 protected String getHurtSound()
	    {
	        return "mob.zombie.hurt";
	    }
	    protected String getDeathSound()
	    {
	        return "mob.zombie.death";
	    }
	    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	    {
	        this.playSound("mob.zombie.step", 0.15F, 1.0F);
	    }
	    public int getSkeletonType()
	    {
	        return this.dataWatcher.getWatchableObjectByte(13);
	    }

		public ItemStack getHeldItem()
	    {
	        return defaultHeldItem;
	    }
		 static 
		    {
		  
		    }
		  public void dropFewItems(boolean b, int looting)
		    {
		       
		        this.dropItem(enderdeath.Rubis, 8);
		        this.dropItem(enderdeath.Saphir, 6);
		        this.dropItem(enderdeath.Royalite, 3);
		        this.dropItem(enderdeath.NuggetEnderite, 1);
		        
		    }
}
