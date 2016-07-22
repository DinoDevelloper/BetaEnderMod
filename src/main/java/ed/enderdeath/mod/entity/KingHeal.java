package ed.enderdeath.mod.entity;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class KingHeal extends EntityMob implements IBossDisplayData, IRangedAttackMob
{

    private double d6;
    private double d7;
    private double d8;
    private EntityLivingBase EntityLivingBase;
    private double d5;

    public KingHeal(World p_i1734_1_)
    {
        super(p_i1734_1_);
        this.setSize(0.6F, 2.9F);
        this.stepHeight = 1.0F;
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
    {

        EntityPotion entitypotion = new EntityPotion(this.worldObj, this, 32732);
        entitypotion.rotationPitch -= -20.0F;
        double d0 = p_82196_1_.posX + p_82196_1_.motionX - this.posX;
        double d1 = p_82196_1_.posY + (double)p_82196_1_.getEyeHeight() - 1.100000023841858D - this.posY;
        double d2 = p_82196_1_.posZ + p_82196_1_.motionZ - this.posZ;
        float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);

        if(f1 >= 8.0F && !p_82196_1_.isPotionActive(Potion.wither))
        {
            entitypotion.setPotionDamage(39698);
        }
        else if(p_82196_1_.getHealth() >= 8.0F && !p_82196_1_.isPotionActive(Potion.poison))
        {
            entitypotion.setPotionDamage(3980);
        }
        else if(p_82196_1_.getHealth() >= 9.0F && !p_82196_1_.isPotionActive(Potion.wither))
        {
            entitypotion.setPotionDamage(39780);

        }

        entitypotion.setThrowableHeading(d0, d1 + (double)(f1 * 0.2F), d2, 0.75F, 8.0F);
        this.worldObj.spawnEntityInWorld(entitypotion);

    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(950D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        if(this.isFinal())
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(950D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(5.0D);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(800D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
    }

    private boolean isFinal()
    {
        if(this.getHealth() == 100.0F)
        {
            return true;
        }
        return false;

    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
        this.dataWatcher.addObject(17, new Byte((byte)0));
        this.dataWatcher.addObject(18, new Byte((byte)0));
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.endermen.scream";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.endermen.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.endermen.death";
    }

    public void dropFewItems(boolean b, int looting)
    {

        this.dropItem(Enderdeath.rubis, 64);
        this.dropItem(Enderdeath.rubis, 64);
        this.dropItem(Enderdeath.rubis, 64);
        this.dropItem(Enderdeath.saphir, 64);
        this.dropItem(Enderdeath.saphir, 64);
        this.dropItem(Enderdeath.royalite, 64);
        this.dropItem(Enderdeath.darkanite, 32);
        this.dropItem(Enderdeath.enderite, 8);
        this.dropItem(Enderdeath.enderHeart, 1);
        this.dropItem(Enderdeath.boneSacred, 3);
        this.dropItem(Enderdeath.deathKey, 5);
        this.dropItem(Enderdeath.ultimeKey, 3);
        this.dropItem(Enderdeath.naturalKey, 10);
        this.dropItem(Items.diamond, 64);
        this.dropItem(Items.diamond, 64);
        this.dropItem(Items.diamond, 64);
        this.dropItem(Items.diamond, 64);
        this.dropItem(Items.iron_ingot, 64);
        this.dropItem(Items.iron_ingot, 64);
        this.dropItem(Items.iron_ingot, 64);
        this.dropItem(Items.iron_ingot, 64);
        this.dropItem(Items.iron_ingot, 64);
    }

    public boolean attackEntityAsMob(Entity p_70652_1_)
    {

        if(super.attackEntityAsMob(p_70652_1_))
        {
            if(this.attackEntityAsMob(p_70652_1_))
            {

                this.worldObj.setEntityState(this, (byte)4);

                this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 210, 2));
                this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 210, 1));

                p_70652_1_.motionX += 2.9000000059604645D;
                p_70652_1_.motionZ += 2.9000000059604645D;
                p_70652_1_.motionY += 2.9000000059604645D;
                ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.wither.id, 2000, 3));
                ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 2000, 3));
                ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.hunger.id, 2000, 3));
                ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.confusion.id, 500, 3));
                ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.blindness.id, 1000, 3));
                ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 2000, 3));

            }
            return true;
        }
        return true;
    }

}
