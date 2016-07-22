package ed.enderdeath.mod.entity;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.block.material.Material;
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
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class WolfNether extends EntityMob implements IRangedAttackMob, IBossDisplayData
{
    private static final UUID field_110184_bp = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
    private static final AttributeModifier field_110185_bq = (new AttributeModifier(field_110184_bp, "Drinking speed penalty", -0.35D, 0)).setSaved(false);
    /** List of items a witch should drop on death. */

    /**
     * Timer used as interval for a witch's attack, decremented every tick if aggressive and when reaches zero the witch
     * will throw a potion at the target entity.
     */
    private int witchAttackTimer;
    private static final String __OBFID = "CL_00001701";

    public WolfNether(World p_i1744_1_)
    {
        super(p_i1744_1_);
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

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.witch.idle";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.witch.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.witch.death";
    }

    /**
     * Set whether this witch is aggressive at an entity.
     */
    public void setAggressive(boolean p_82197_1_)
    {
        this.getDataWatcher().updateObject(21, Byte.valueOf((byte)(p_82197_1_ ? 1 : 0)));
    }

    /**
     * Return whether this witch is aggressive at an entity.
     */
    public boolean getAggressive()
    {
        return this.getDataWatcher().getWatchableObjectByte(21) == 1;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(700.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3511111111111D);
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if(!this.worldObj.isRemote)
        {
            if(this.getAggressive())
            {
                if(this.witchAttackTimer-- <= 0)
                {
                    this.setAggressive(false);
                    ItemStack itemstack = this.getHeldItem();
                    this.setCurrentItemOrArmor(0, (ItemStack)null);

                    if(itemstack != null && itemstack.getItem() == Items.potionitem)
                    {
                        List list = Items.potionitem.getEffects(itemstack);

                        if(list != null)
                        {
                            Iterator iterator = list.iterator();

                            while(iterator.hasNext())
                            {
                                PotionEffect potioneffect = (PotionEffect)iterator.next();
                                this.addPotionEffect(new PotionEffect(potioneffect));
                            }
                        }
                    }

                    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).removeModifier(field_110185_bq);
                }
            }
            else
            {
                short short1 = -1;

                if(this.rand.nextFloat() < 0.15F && this.isInsideOfMaterial(Material.water) && !this.isPotionActive(Potion.waterBreathing))
                {
                    short1 = 8237;
                }
                else if(this.rand.nextFloat() < 0.15F && this.isBurning() && !this.isPotionActive(Potion.fireResistance))
                {
                    short1 = 16307;
                }
                else if(this.rand.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth())
                {
                    short1 = 18341;
                }
                else if(this.rand.nextFloat() < 0.25F && this.getAttackTarget() != null && !this.isPotionActive(Potion.moveSpeed) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0D)
                {
                    short1 = 17274;
                }
                else if(this.rand.nextFloat() < 0.25F && this.getAttackTarget() != null && !this.isPotionActive(Potion.moveSpeed) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0D)
                {
                    short1 = 17274;
                }

                if(short1 > -1)
                {
                    this.setCurrentItemOrArmor(0, new ItemStack(Items.potionitem, 1, short1));
                    this.witchAttackTimer = this.getHeldItem().getMaxItemUseDuration();
                    this.setAggressive(true);
                    IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
                    iattributeinstance.removeModifier(field_110185_bq);
                    iattributeinstance.applyModifier(field_110185_bq);
                }
            }

            if(this.rand.nextFloat() < 7.5E-4F)
            {
                this.worldObj.setEntityState(this, (byte)15);
            }
        }

        super.onLivingUpdate();
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_)
    {
        if(p_70103_1_ == 15)
        {
            for(int i = 0; i < this.rand.nextInt(35) + 10; ++i)
            {
                this.worldObj.spawnParticle("witchMagic", this.posX + this.rand.nextGaussian() * 0.12999999523162842D, this.boundingBox.maxY + 0.5D + this.rand.nextGaussian() * 0.12999999523162842D, this.posZ + this.rand.nextGaussian() * 0.12999999523162842D, 0.0D, 0.0D, 0.0D);
            }
        }
        else
        {
            super.handleHealthUpdate(p_70103_1_);
        }
    }

    /**
     * Reduces damage, depending on potions
     */
    protected float applyPotionDamageCalculations(DamageSource p_70672_1_, float p_70672_2_)
    {
        p_70672_2_ = super.applyPotionDamageCalculations(p_70672_1_, p_70672_2_);

        if(p_70672_1_.getEntity() == this)
        {
            p_70672_2_ = 0.0F;
        }

        if(p_70672_1_.isMagicDamage())
        {
            p_70672_2_ = (float)((double)p_70672_2_ * 0.15D);
        }

        return p_70672_2_;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        this.dropItem(Enderdeath.stickHeal, 1);
        this.dropItem(Enderdeath.stickSpeed, 1);
        this.dropItem(Enderdeath.sitckJolo, 1);
        this.dropItem(Enderdeath.stickStrenght, 1);

    }

    /**
     * Attack the specified entity using a ranged attack.
     */
    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
    {
        if(!this.getAggressive())
        {
            EntityPotion entitypotion = new EntityPotion(this.worldObj, this, 32732);
            entitypotion.rotationPitch -= -20.0F;
            double d0 = p_82196_1_.posX + p_82196_1_.motionX - this.posX;
            double d1 = p_82196_1_.posY + (double)p_82196_1_.getEyeHeight() - 1.100000023841858D - this.posY;
            double d2 = p_82196_1_.posZ + p_82196_1_.motionZ - this.posZ;
            float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);

            if(f1 >= 8.0F && !p_82196_1_.isPotionActive(Potion.moveSlowdown))
            {
                entitypotion.setPotionDamage(32698);
            }
            else if(p_82196_1_.getHealth() >= 8.0F && !p_82196_1_.isPotionActive(Potion.poison))
            {
                entitypotion.setPotionDamage(39780);
            }
            else if(p_82196_1_.getHealth() >= 9.0F && !p_82196_1_.isPotionActive(Potion.wither))
            {
                entitypotion.setPotionDamage(39780);

            }
            else if(f1 <= 3.0F && !p_82196_1_.isPotionActive(Potion.weakness) && this.rand.nextFloat() < 0.25F)
            {
                entitypotion.setPotionDamage(36696);
            }

            entitypotion.setThrowableHeading(d0, d1 + (double)(f1 * 0.2F), d2, 0.75F, 8.0F);
            this.worldObj.spawnEntityInWorld(entitypotion);
        }
    }
}
