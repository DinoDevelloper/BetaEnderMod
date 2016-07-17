package ed.enderdeath.mod.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public  class DragonRed extends EntityHorse
{
public DragonRed(World model)
{
super(model);
this.setSize(1.0F, 1.2F);
}

public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(3D);    
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.85D);
    }  

public boolean canBeSteered()
    {
        return true;
    }
public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
	return false;
}
    public boolean isHorseSaddled()
    {
        return true;
    }
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
    	  this.motionY *= 0.6D;
    	 
    		  this.addPotionEffect(new PotionEffect(Potion.jump.id, 210,22));
    	  
    		
    }
public boolean isHorseJumping()
    {
        return false;
    }

public boolean isTame()
    {
        return true;
    }

    public boolean isChested()
    {
        return false;
    } 

public boolean interact(EntityPlayer par1EntityPlayer)
  {
      if (super.interact(par1EntityPlayer))
      {
          par1EntityPlayer.mountEntity(this);
          return true;
      }
      for (int i = 0; i < 2; ++i)
      {
          this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
      }
      return false;
  }

public boolean jumpRearingCounter()
{
return true;
}
public boolean jumpPower()
{
return true;
}
public boolean horsejumping()
{
return true;
}
public boolean isEatingHaystack()
{
return true;
}
public boolean isRearing()
{
return true;
}
@Override
public EntityAgeable createChild(EntityAgeable p_90011_1_)
{
return null;
}

}
