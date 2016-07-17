package ed.enderdeath.mod.entity;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Boss extends EntityMob implements IBossDisplayData,IRangedAttackMob
{
    private static final UUID field_110184_bp = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
	 private static final AttributeModifier field_110185_bq = (new AttributeModifier(field_110184_bp, "Drinking speed penalty", -0.35D, 0)).setSaved(false);
	  private int witchAttackTimer;
	private double d5;
	private double d6;
	private double d7;
	private EntityPlayer player;
	private Entity entity;
	public Boss(World p_i1738_1_) {
		super(p_i1738_1_);
		  this.isImmuneToFire = true;
	    this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 60, 10.0F));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	
	}
	
	  protected void entityInit()
	    {
	        super.entityInit();
	        this.getDataWatcher().addObject(21, Byte.valueOf((byte)0));
	     
	    }

	
	    public void setAggressive(boolean p_82197_1_)
	    {
	        this.getDataWatcher().updateObject(21, Byte.valueOf((byte)(p_82197_1_ ? 1 : 0)));
	    }

	 
	    protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1200.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(100D);
	    	this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(75.0D);
	    	this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(5.0D);
	    }
	      
	
	    public boolean isAIEnabled()
	    {
	        return true;
	    }

	    public void onLivingUpdate()
	    {
	        if (!this.worldObj.isRemote)
	        {
	                if (this.witchAttackTimer-- <= 0)
	                {
	                    this.setAggressive(false);
	                    ItemStack itemstack = this.getHeldItem();
	                    this.setCurrentItemOrArmor(0, (ItemStack)null);

	                    if (itemstack != null && itemstack.getItem() == Items.potionitem)
	                    {
	                        List list = Items.potionitem.getEffects(itemstack);

	                        if (list != null)
	                        {
	                            Iterator iterator = list.iterator();

	                            while (iterator.hasNext())
	                            {
	                                PotionEffect potioneffect = (PotionEffect)iterator.next();
	                                this.addPotionEffect(new PotionEffect(potioneffect));
	                            }
	                        }
	                    
	                    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).removeModifier(field_110185_bq);
	                }
	            }
	            else
	            {
	                short short1 = -1;

	                if (this.rand.nextFloat() < 0.15F && this.isInsideOfMaterial(Material.water) && !this.isPotionActive(Potion.waterBreathing))
	                {
	                    short1 = 8237;
	                }
	                else if (this.rand.nextFloat() < 0.15F && this.isBurning() && !this.isPotionActive(Potion.fireResistance))
	                {
	                    short1 = 16307;
	                }
	                else if (this.rand.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth())
	                {
	                    short1 = 18341;
	                }
	                else if (this.rand.nextFloat() < 0.25F && this.getAttackTarget() != null && !this.isPotionActive(Potion.blindness) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0D)
	                {
	                    short1 = 17274;
	                }
	                else if (this.rand.nextFloat() < 0.25F && this.getAttackTarget() != null && !this.isPotionActive(Potion.blindness) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0D)
	                {
	                    short1 = 17274;
	                }

	                if (short1 > -1)
	                {
	                    this.setCurrentItemOrArmor(0, new ItemStack(Items.potionitem, 1, short1));
	                    this.witchAttackTimer = this.getHeldItem().getMaxItemUseDuration();
	                    this.setAggressive(true);
	                    IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
	                    iattributeinstance.removeModifier(field_110185_bq);
	                    iattributeinstance.applyModifier(field_110185_bq);
	                }
	            }

	            if (this.rand.nextFloat() < 7.5E-4F)
	            {
	                this.worldObj.setEntityState(this, (byte)15);
	            }
	        }

	        super.onLivingUpdate();
	    }

	    @SideOnly(Side.CLIENT)
	    public void handleHealthUpdate(byte p_70103_1_)
	    {
	        if (p_70103_1_ == 15)
	        {
	            for (int i = 0; i < this.rand.nextInt(35) + 10; ++i)
	            {
	                this.worldObj.spawnParticle("witchMagic", this.posX + this.rand.nextGaussian() * 0.12999999523162842D, this.boundingBox.maxY + 0.5D + this.rand.nextGaussian() * 0.12999999523162842D, this.posZ + this.rand.nextGaussian() * 0.12999999523162842D, 0.0D, 0.0D, 0.0D);
	            }
	        }
	        else
	        {
	            super.handleHealthUpdate(p_70103_1_);
	        }
	    }

	    protected float applyPotionDamageCalculations(DamageSource p_70672_1_, float p_70672_2_)
	    {
	        p_70672_2_ = super.applyPotionDamageCalculations(p_70672_1_, p_70672_2_);

	        if (p_70672_1_.getEntity() == this)
	        {
	            p_70672_2_ = 0.0F;
	        }

	        if (p_70672_1_.isMagicDamage())
	        {
	            p_70672_2_ = (float)((double)p_70672_2_ * 0.15D);
	        }

	        return p_70672_2_;
	    }

	    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
	    {
	    	for(int i = 0 ; i < 5 ; i++)
			{
	            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
	            EntityLargeFireball entitylargefireball = new EntityLargeFireball(this.worldObj, this, d5, d6, d7);
	     
	            double d8 = 4.0D;
	            Vec3 vec3 = this.getLook(1.0F);
	            entitylargefireball.posX = this.posX + vec3.xCoord * d8;
	            entitylargefireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
	            entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
	            this.worldObj.spawnEntityInWorld(entitylargefireball);
			}
	    	for(int i = 0 ; i < 19 ; i++)
	    	{
	    		   this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
		            EntityWitherSkull skull = new EntityWitherSkull(this.worldObj, this, d5, d6, d7);
		     
		            double d8 = 4.0D;
		            Vec3 vec3 = this.getLook(1.0F);
		            skull.posX = this.posX + vec3.xCoord * d8;
		            skull.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
		            skull.posZ = this.posZ + vec3.zCoord * d8;
		            this.worldObj.spawnEntityInWorld(skull);
	    	}
	    	for(int i = 0 ; i < 11 ; i++)
			{
	            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
	            EntityLargeFireball entitylargefireball = new EntityLargeFireball(this.worldObj, this, d5, d6, d7);
	     
	            double d8 = 4.0D;
	            Vec3 vec3 = this.getLook(1.0F);
	            entitylargefireball.posX = this.posX + vec3.xCoord * d8;
	            entitylargefireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
	            entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
	            this.worldObj.spawnEntityInWorld(entitylargefireball);
			}
	    	for(int i = 0 ; i < 24 ; i++)
	    	{
	    		   this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
		            EntityWitherSkull skull = new EntityWitherSkull(this.worldObj, this, d5, d6, d7);
		     
		            double d8 = 4.0D;
		            Vec3 vec3 = this.getLook(1.0F);
		            skull.posX = this.posX + vec3.xCoord * d8;
		            skull.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
		            skull.posZ = this.posZ + vec3.zCoord * d8;
		            this.worldObj.spawnEntityInWorld(skull);
	    	}
	     	for(int i = 0 ; i < 28 ; i++)
	     	{
	     		this.addPotionEffect(new PotionEffect(Potion.resistance.id, 450,0));
	     	
	     	}
	     	for(int i = 0 ; i < 45 ; i++)
	     	{

				
			
	     	}
	            EntityPotion entitypotion = new EntityPotion(this.worldObj, this, 32732);
	            entitypotion.rotationPitch -= -20.0F;
	            double d0 = p_82196_1_.posX + p_82196_1_.motionX - this.posX;
	            double d1 = p_82196_1_.posY + (double)p_82196_1_.getEyeHeight() - 1.100000023841858D - this.posY;
	            double d2 = p_82196_1_.posZ + p_82196_1_.motionZ - this.posZ;
	            float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);

	            if (f1 >= 8.0F && !p_82196_1_.isPotionActive(Potion.wither))
	            {
	                entitypotion.setPotionDamage(39698);
	            }
	            else if (p_82196_1_.getHealth() >= 8.0F && !p_82196_1_.isPotionActive(Potion.poison))
	            {
	                entitypotion.setPotionDamage(3980);
	            }
	            else if (p_82196_1_.getHealth() >= 9.0F && !p_82196_1_.isPotionActive(Potion.wither))
	            {
	                entitypotion.setPotionDamage(39780);
	                
	            }
	        

	            entitypotion.setThrowableHeading(d0, d1 + (double)(f1 * 0.2F), d2, 0.75F, 8.0F);
	            this.worldObj.spawnEntityInWorld(entitypotion);
	        
	    }
	    
}
