package ed.enderdeath.mod.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Goblin extends EntityMob
{

	private int attackgoblin = 0;
	public Goblin(World world) {
		super(world);
        this.tasks.addTask(8, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(0, new EntityAISwimming(this));
	}

	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(35D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(5.0D);
	}
	
	public Item getDropItem()
		{
			return Items.gold_ingot;
		}
	 protected int getExperiencePoints(EntityPlayer p_70693_1_)
	    {
	        if (this.isChild())
	        {
	            this.experienceValue = (int)((float)this.experienceValue * 5.5F);
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
	    public boolean attackEntityAsMob(Entity p_70652_1_)
	    {
	    	  
	        if (super.attackEntityAsMob(p_70652_1_))
	        {
	            if (this.attackEntityAsMob(p_70652_1_))
	            {
	         
	                this.worldObj.setEntityState(this, (byte)4);
	              
	              	this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 210,1));
	              	this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 210,0));
	                  
	            }
	            return true;
	        }
	    	return true;
	        }
}
