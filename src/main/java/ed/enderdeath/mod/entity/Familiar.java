package ed.enderdeath.mod.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.Enderdeath;
import ed.enderdeath.mod.food.Baie;
import ed.enderdeath.mod.item.Croquette;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Familiar extends EntityTameable implements IMob, IBossDisplayData
{

    private float field_70926_e;
    private float field_70924_f;
    /** true is the wolf is wet else false */
    private boolean isShaking;
    private boolean field_70928_h;
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;
    public int lvl = 0;
    private static final String __OBFID = "CL_00001654";
    private static RenderFamiliar render;

    private World world;
    private int x;
    private int y;
    private int z;
    private Random random;
    private int short1;
    private double d3;
    private double d4;
    private double d5;
    private int rubis;
    private int k = 3;
    private int ultime = 5;
    private EntityLivingBase p_70624_1_;
    private EntityPlayer player;

    private int fire;
    private int blue;
    private int dirt;
    private int ender;
    private UUID propietaire;
    private int skin;
    private NBTTagCompound nbt;

    private ResourceLocation ressource;
    private ItemStack stack;;

    public Familiar(World p_i1696_1_)
    {
        super(p_i1696_1_);
        this.setSize(0.6F, 0.8F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);

        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));

        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntitySheep.class, 200, false));

        this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 3, true));

    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);

        if(this.isTamed())
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
        }
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Sets the active target the Task system uses for tracking
     */
    public void setAttackTarget(EntityLivingBase p_70624_1_)
    {
        super.setAttackTarget(p_70624_1_);

        if(p_70624_1_ == null)
        {
            this.setAngry(false);
        }
        else if(!this.isTamed())
        {
            this.setAngry(true);

        }
        else if(this.lvl == 0)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 210, 0));
            this.clearActivePotions();
        }

    }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
    protected void updateAITick()
    {
        this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));

    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, new Float(this.getHealth()));
        this.dataWatcher.addObject(19, new Byte((byte)0));
        this.dataWatcher.addObject(20, new Byte((byte)BlockColored.func_150032_b(1)));

    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setBoolean("Angry", this.isAngry());
        p_70014_1_.setByte("CollarColor", (byte)this.getCollarColor());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
        this.setAngry(p_70037_1_.getBoolean("Angry"));

        if(p_70037_1_.hasKey("CollarColor", 99))
        {
            this.setCollarColor(p_70037_1_.getByte("CollarColor"));
        }
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    public void updateEntityActionState()
    {

        List list = worldObj.getEntitiesWithinAABB(EntityCreature.class, AxisAlignedBB.getBoundingBox(posX, posY, posZ, posX + 1, posY + 1, posZ + 1));
        for(int i = 0; i < list.size(); i++)
        {
            Entity entity = (Entity)list.get(i);
            if(!list.isEmpty())
            {
                if(!(entity instanceof EntityPlayer))
                {
                    this.setTarget(entity);
                }
            }
        }
        super.updateEntityActionState();
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    public static ArrayList<UUID> propietairea = new ArrayList();

    /**
     * Called frequently so the entity can update its state every tick as
     * required. For example, zombies and skeletons use this to react to
     * sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if(!this.worldObj.isRemote && this.isShaking && !this.field_70928_h && !this.hasPath() && this.onGround)
        {
            this.field_70928_h = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
            this.worldObj.setEntityState(this, (byte)8);
        }
        for(k = 0; k < 2; ++k)
        {
            this.worldObj.spawnParticle("enchantmenttable", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
        }
    }

    public void onUpdate()
    {
        super.onUpdate();
        this.field_70924_f = this.field_70926_e;

        if(this.func_70922_bv())
        {
            this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
        }
        else
        {
            this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
        }

        if(this.func_70922_bv())
        {
            this.numTicksToChaseTarget = 10;
        }

        if(this.isWet())
        {
            this.isShaking = true;
            this.field_70928_h = false;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        }
        else if((this.isShaking || this.field_70928_h) && this.field_70928_h)
        {
            if(this.timeWolfIsShaking == 0.0F)
            {
                this.playSound("mob.wolf.shake", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }

            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05F;

            if(this.prevTimeWolfIsShaking >= 2.0F)
            {
                this.isShaking = false;
                this.field_70928_h = false;
                this.prevTimeWolfIsShaking = 0.0F;
                this.timeWolfIsShaking = 0.0F;
            }

            if(this.timeWolfIsShaking > 0.4F)
            {
                float f = (float)this.boundingBox.minY;
                int i = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);

                for(int j = 0; j < i; ++j)
                {
                    float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    this.worldObj.spawnParticle("splash", this.posX + (double)f1, (double)(f + 0.8F), this.posZ + (double)f2, this.motionX, this.motionY, this.motionZ);
                }
            }
        }
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the
     * faceEntity method. This is only currently use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        if(this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            Entity entity = p_70097_1_.getEntity();
            this.aiSit.setSitting(false);

            if(entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
            {
                p_70097_2_ = (p_70097_2_ + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(p_70097_1_, p_70097_2_);
        }
    }

    public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        int i = this.isTamed() ? 4 : 2;

        this.worldObj.setEntityState(this, (byte)4);

        if(this.lvl == 0)
        {
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.poison.id, 1000, 0));
        }

        if(this.lvl == 0)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 0));
        }
        if(this.lvl == 1)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 1));
        }
        if(this.lvl == 2)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 1));
        }
        if(this.lvl == 3)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 2));
        }
        if(this.lvl == 4)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 2));
        }
        if(this.lvl == 5)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 2));
        }
        if(this.lvl == 6)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 3));
        }
        if(this.lvl == 7)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 3));
        }
        if(this.lvl == 8)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 3));
        }
        if(this.lvl == 9)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 3));
        }
        if(this.lvl == 10)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 3));
        }
        if(this.lvl == 11)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 3));
        }
        if(this.lvl == 12)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 4));
        }
        if(this.lvl == 13)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 4));
        }
        if(this.lvl == 14)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 4));
        }
        if(this.lvl == 15)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 4));
        }
        if(this.lvl == 16)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 4));
        }
        if(this.lvl == 17)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 4));
        }
        if(this.lvl == 18)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 4));
        }
        if(this.lvl == 19)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 4));
        }
        if(this.lvl == 20)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 5));
        }
        if(this.lvl == 21)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 5));
        }
        if(this.lvl == 22)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 5));
        }
        if(this.lvl == 23)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 5));
        }
        if(this.lvl == 24)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 5));
        }
        if(this.lvl == 25)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 6));
        }
        if(this.lvl == 26)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 6));
        }
        if(this.lvl == 27)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 6));
        }
        if(this.lvl == 28)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 6));
        }
        if(this.lvl == 29)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 6));
        }
        if(this.lvl == 30)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 7));
        }
        if(this.lvl == 31)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 7));
        }
        if(this.lvl == 32)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 7));
        }
        if(this.lvl == 33)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 7));
        }
        if(this.lvl == 34)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 7));
        }
        if(this.lvl == 35)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 7));
        }
        if(this.lvl == 36)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 7));
        }
        if(this.lvl == 37)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 7));
        }
        if(this.lvl == 38)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 7));
        }
        if(this.lvl == 39)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 7));
        }
        if(this.lvl == 40)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 41)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 42)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 43)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 44)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 45)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 46)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 47)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 48)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 49)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 50)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 51)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 52)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 53)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 54)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 55)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 56)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 57)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 58)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 59)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 8));
        }
        if(this.lvl == 60)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 61)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 62)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 63)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 64)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 65)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 66)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 67)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 68)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 69)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 70)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 71)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 72)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 73)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 74)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 75)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 76)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 77)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 78)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 79)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 80)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 81)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 82)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 83)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 84)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 9));
        }
        if(this.lvl == 85)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 86)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 87)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 88)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 89)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 90)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 91)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 92)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 93)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 94)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 95)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 96)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 97)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }
        if(this.lvl == 98)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }

        if(this.lvl == 99)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 10));
        }

        if(this.lvl == 100)
        {
            this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 100, 12));
        }

        if(this.lvl > 10)
        {
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.poison.id, 1000, 0));
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 2000, 0));
        }
        if(this.lvl > 40)
        {
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.weakness.id, 2000, 1));
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.wither.id, 2000, 1));
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 2000, 1));
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).setFire(10000);
        }
        if(this.lvl > 50)
        {
            this.motionY = 2.0F;
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.weakness.id, 2000, 1));
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.wither.id, 2000, 1));
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 2000, 1));
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).setFire(10000);
        }

        if(this.lvl > 99)
        {
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.wither.id, 2000, 3));
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 2000, 3));
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.hunger.id, 2000, 3));
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.confusion.id, 500, 3));
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.blindness.id, 1000, 3));
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 2000, 3));
            this.motionY = 2.0F;
            ((net.minecraft.entity.EntityLivingBase)p_70652_1_).setFire(10000);

        }
        return p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);

    }

    public void setTamed()
    {

        if(this.lvl == 1)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);

        }
        if(this.lvl == 2)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(110.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.57D);
        }
        if(this.lvl == 3)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(120.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.589D);
        }
        if(this.lvl == 4)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(130.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5897D);
        }
        if(this.lvl == 5)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(140.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.58986D);
        }
        if(this.lvl == 6)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.59986D);
        }
        if(this.lvl == 7)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(160.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.59996D);
        }
        if(this.lvl == 8)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(170.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.59999D);
        }
        if(this.lvl == 9)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(180.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.59999D);
        }
        if(this.lvl == 10)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(190.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.69999D);
        }
        if(this.lvl == 11)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.699999D);
        }
        if(this.lvl == 12)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(210.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.699999D);
        }
        if(this.lvl == 13)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(220.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6999999D);
        }
        if(this.lvl == 12)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(230.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.799999D);
        }
        if(this.lvl == 13)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(240.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
        }
        if(this.lvl == 14)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(250.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
        }
        if(this.lvl == 15)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(260.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
        }
        if(this.lvl == 16)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(270.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
        }
        if(this.lvl == 17)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(280.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
        }
        if(this.lvl == 18)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(290.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
        }
        if(this.lvl == 19)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
        }
        if(this.lvl == 20)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(310.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 21)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(320.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 22)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(330.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 23)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(340.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 24)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(350.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 25)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(360.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 26)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(370.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 27)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(380.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 28)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(390.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 29)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 30)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(410.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 31)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(420.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 32)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(420.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 33)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(430.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 34)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(440.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.1D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 35)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(450.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.1D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 36)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(460.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.2D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 37)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(470.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.2D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }

        if(this.lvl == 38)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(480.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.2D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 39)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(490.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.3D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 40)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(500.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.3D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 41)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(510.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.3D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 42)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(520.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.4D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 43)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(530.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.4D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 44)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(540.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.4D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 45)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(550.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.4D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 46)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(560.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.4D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 47)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(570.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.5D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 48)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(570.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.5D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 49)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(580.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.5D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 50)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(580.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.6D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 51)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(590.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.6D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 52)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(600.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.6D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 52)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(610.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.6D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 53)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(620.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.6D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 54)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(630.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.6D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 55)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(640.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.6D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }

        if(this.lvl == 55)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(650.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }

        if(this.lvl == 56)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(660.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 57)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(670.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 58)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(680.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 59)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(690.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 60)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(700.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 61)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(710.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 62)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(720.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 63)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(730.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 64)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(740.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 65)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(750.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 66)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(760.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 67)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(770.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 68)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(780.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 69)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(790.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 70)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(800.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 71)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(810.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 72)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(820.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.7D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 73)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(830.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 74)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(840.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 75)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(850.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 76)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(860.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 77)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(870.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 78)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(880.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 79)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(890.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 80)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(900.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 81)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(910.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 82)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(920.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 83)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(930.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.8D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 84)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(930.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 85)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(940.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 86)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(940.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 87)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(940.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 88)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(940.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 89)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(940.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 90)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(950.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 91)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(960.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 92)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(970.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 93)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(980.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 94)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(990.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 95)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(990.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 96)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(990.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 97)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(990.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 98)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(990.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 99)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(990.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }
        if(this.lvl == 100)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1200.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.25D);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
        }

        else if(this.lvl == 0)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
        }

    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow,
     * gets into the saddle on a pig.
     */
    @Override
    public boolean interact(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

        if(this.lvl > 0)
        {
            if(itemstack != null)
            {
                if(itemstack.getItem() instanceof Baie)
                {
                    Baie itemfood = (Baie)itemstack.getItem();

                    if(itemfood.isFamiliarFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 20.0F)
                    {
                        if(!p_70085_1_.capabilities.isCreativeMode)
                        {
                            --itemstack.stackSize;
                        }

                        this.heal((float)itemfood.func_150905_g(itemstack));

                        if(itemstack.stackSize <= 0)
                        {
                            p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
                        }

                        return true;
                    }
                }
            }
            if(this.func_152114_e(p_70085_1_) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack))
            {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.setPathToEntity((PathEntity)null);
                this.setTarget((Entity)null);
                this.setAttackTarget((EntityLivingBase)null);
            }

        }

        if(itemstack != null && itemstack.getItem() instanceof Croquette)
        {

            if(!p_70085_1_.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }

            if(propietaire == null || propietaire.equals(player.getUniqueID()))
            {
                System.out.println("propietaire = player.getUniqueID();");
                propietaire = player.getUniqueID();

            }
            if(itemstack.stackSize <= 0)
            {
                p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
            }

            if(!this.worldObj.isRemote)
            {
                if(this.rand.nextInt(3) == 0)
                {

                    this.setPathToEntity((PathEntity)null);
                    this.setAttackTarget((EntityLivingBase)null);
                    this.aiSit.setSitting(true);

                    if(this.lvl == 10)
                    {
                        System.out.println("lvl 10!!!");

                    }
                    if(itemstack != null && itemstack.getItem() == Enderdeath.rubisCroquette)
                    {
                        if(lvl > rubis)
                        {
                            this.lvl++;
                            this.lvl++;
                            this.lvl++;
                        }

                    }

                    if(itemstack != null && itemstack.getItem() == Enderdeath.saphirCroquette)
                    {
                        if(lvl > ultime)
                        {
                            this.lvl++;
                            this.lvl++;
                            this.lvl++;
                            this.lvl++;
                            this.lvl++;
                        }

                    }

                    this.lvl++;
                    System.out.println(lvl);
                    this.func_152115_b(p_70085_1_.getUniqueID().toString());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                    this.setTamed();

                }
                else
                {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }

            }
            if(itemstack != null && itemstack.getItem() == Enderdeath.skinFire)
            {
                this.skin = 1;

            }
            return true;
        }

        return super.interact(p_70085_1_);
    }

    public void onSkin()
    {
        if(this.skin == 1)
        {
            this.render.onskin(this);

        }
    }

    public void onParticuleFire()
    {
        for(k = 0; k < 2; ++k)
        {
            this.worldObj.spawnParticle("fire", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
        }
    }

    @SideOnly(Side.CLIENT)
    public float getTailRotation()
    {
        return this.isAngry() ? 1.5393804F : (this.isTamed() ? (0.55F - (20.0F - this.dataWatcher.getWatchableObjectFloat(18)) * 0.02F) * (float)Math.PI : ((float)Math.PI / 5F));
    }

    public boolean isBreedingItem(ItemStack p_70877_1_)
    {
        return p_70877_1_ == null ? false : (!(p_70877_1_.getItem() instanceof Baie) ? false : ((Baie)p_70877_1_.getItem()).isFamiliarFavoriteMeat());
    }

    public boolean isAngry()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }

    public void setAngry(boolean p_70916_1_)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if(p_70916_1_)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 2)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
        }
    }

    public int getCollarColor()
    {
        return this.dataWatcher.getWatchableObjectByte(20) & 15;
    }

    public void setCollarColor(int p_82185_1_)
    {
        this.dataWatcher.updateObject(20, Byte.valueOf((byte)(p_82185_1_ & 15)));
    }

    public Familiar createChild(EntityAgeable p_90011_1_)
    {
        Familiar entitywolf = new Familiar(this.worldObj);
        String s = this.func_152113_b();

        if(s != null && s.trim().length() > 0)
        {
            entitywolf.func_152115_b(s);
            if(this.lvl >= 1)
                ;
        }

        return entitywolf;
    }

    public void func_70918_i(boolean p_70918_1_)
    {
        if(p_70918_1_)
        {
            this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
        }
        else
        {
            this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
        }
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(EntityAnimal p_70878_1_)
    {
        if(p_70878_1_ == this)
        {
            return false;
        }
        else if(!this.isTamed())
        {
            return false;
        }
        else if(!(p_70878_1_ instanceof Familiar))
        {
            return false;
        }
        else
        {
            Familiar familiar = (Familiar)p_70878_1_;
            return !familiar.isTamed() ? false : (familiar.isSitting() ? false : this.isInLove() && familiar.isInLove());
        }
    }

    public boolean func_70922_bv()
    {
        return this.dataWatcher.getWatchableObjectByte(19) == 1;
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return !this.isTamed() && this.ticksExisted > 2400;
    }

    public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_)
    {
        if(!(p_142018_1_ instanceof EntityCreeper) && !(p_142018_1_ instanceof EntityGhast))
        {
            if(p_142018_1_ instanceof Familiar)
            {
                Familiar entitywolf = (Familiar)p_142018_1_;

                if(entitywolf.isTamed() && entitywolf.getOwner() == p_142018_2_)
                {
                    return false;
                }
            }

            return p_142018_1_ instanceof EntityPlayer && p_142018_2_ instanceof EntityPlayer && !((EntityPlayer)p_142018_2_).canAttackPlayer((EntityPlayer)p_142018_1_) ? false : !(p_142018_1_ instanceof EntityHorse) || !((EntityHorse)p_142018_1_).isTame();
        }
        else
        {
            return false;
        }
    }
}