package ed.enderdeath.mod.Event;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.common.enderdeath;
import ed.enderdeath.mod.entity.Boss;
import ed.enderdeath.mod.entity.EntityCreeperBoss;
import ed.enderdeath.mod.entity.Goblin;
import ed.enderdeath.mod.entity.GoblinKing;
import ed.enderdeath.mod.entity.KCreeper;
import ed.enderdeath.mod.entity.KingHeal;
import ed.enderdeath.mod.entity.WolfNether;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;

public class EnchantForge {
	String fpsString;
	String biomeString;
	private Entity entity;
	String directions;
	private int var25;
	private int x;
	private int z;
	private ItemStack stack;
	public boolean showCape = true;
	public boolean onGround;
	private Object worldObj;
	private int posX;
	private Random rand;
	private double width;
	private double height;
	private double posY;
	private double posZ;

	@SubscribeEvent
	public void onNameFormat(PlayerEvent.NameFormat event) {
		if (event.username.equals("leo01418")) {
			event.displayname = "Fonda-leo01418";
			this.particule();
		}
		
	}
	public void particule() {
		for (k = 0; k < 2; ++k) {
			((World) this.worldObj).spawnParticle("fire", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width,
					this.posY + this.rand.nextDouble() * (double) this.height - 0.25D,
					this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width,
					(this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(),
					(this.rand.nextDouble() - 0.5D) * 2.0D);
		}
	}
	public float field_70886_e;
	public float destPos;
	public float field_70884_g;
	public float field_70888_h;
	public float field_70889_i = 1.0F;
	private int i;
	private int j;
	private int k;
	private EntityPlayer player;

	@SubscribeEvent
	public void onPotion(LivingUpdateEvent event) {

		if (event.entityLiving.isPotionActive(30)) {

		
			event.entity.fallDistance = (long) -1000000000;
			event.entityLiving.motionY *= 0.6D;
			event.entityLiving.addPotionEffect(new PotionEffect(Potion.jump.id, 210, 2));
			if (event.entity.fallDistance == (long) -1000000000)
			{
				event.entity.fallDistance = 0;
			}
		}

		if (event.entityLiving.isPotionActive(27)) {
			event.entity.fallDistance = (long) -1000000000;
			if (event.entity.fallDistance == (long) -1000000000)
			{
				event.entity.fallDistance = 0;
			}
		}

	}

	@SubscribeEvent
	public void onNameFormatA(PlayerEvent.NameFormat event) {
		if (event.username.equals("Guiguipl1213")) {
			event.displayname = "MrGuiGuipl";
		}
	}

	@SubscribeEvent
	public void onHurft(LivingHurtEvent event) {
		if (event.source.getEntity() instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) event.source.getEntity();
			if (entity.getHeldItem() != null) {
				if (hasEnchantment(entity.getHeldItem(), 125)) {
					event.entityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, 400, 0));

				}
			}
		}
	}

	@SubscribeEvent
	public void onHurtMob(LivingHurtEvent e) {
		if (e.entity instanceof KingHeal) {

			Goblin skeletona = new Goblin(e.entity.worldObj);
			skeletona.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));
			Goblin skeletonas = new Goblin(e.entity.worldObj);
			skeletonas.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));

			Goblin skeletonaq = new Goblin(e.entity.worldObj);
			skeletonaq.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));

			Goblin skeletoncxa = new Goblin(e.entity.worldObj);
			skeletoncxa.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));
			Goblin skeletonadsq = new Goblin(e.entity.worldObj);
			skeletonadsq.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));

		}
		if (e.entity instanceof Boss) {
			Goblin skeletona = new Goblin(e.entity.worldObj);
			skeletona.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));
			Goblin skeletonas = new Goblin(e.entity.worldObj);
			skeletonas.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));

			Goblin skeletonaq = new Goblin(e.entity.worldObj);
			skeletonaq.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));

			Goblin skeletoncxa = new Goblin(e.entity.worldObj);
			skeletoncxa.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));
			Goblin skeletonadsq = new Goblin(e.entity.worldObj);
			skeletonadsq.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));

		}
		if (e.entity instanceof EntityCreeperBoss) {
			KCreeper skeletonq = new KCreeper(e.entity.worldObj);
			skeletonq.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));
			e.entity.worldObj.spawnEntityInWorld(skeletonq);
		
		}
		if (e.entity instanceof WolfNether) {
			EntityWitch skeletonq = new EntityWitch(e.entity.worldObj);
			skeletonq.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));
			e.entity.worldObj.spawnEntityInWorld(skeletonq);
		}
	}

	@SubscribeEvent
	public void onHurtMobGoblin(LivingHurtEvent e) {
		if (e.entity instanceof GoblinKing) {

			Goblin skeleton = new Goblin(e.entity.worldObj);
			skeleton.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));
			e.entity.worldObj.spawnEntityInWorld(skeleton);
			Goblin skeletonA = new Goblin(e.entity.worldObj);
			skeletonA.setPosition(e.entity.posX - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posY - 5 + e.entity.worldObj.rand.nextInt(10),
					e.entity.posZ - 5 + e.entity.worldObj.rand.nextInt(10));
			e.entity.worldObj.spawnEntityInWorld(skeletonA);

		}
	}

	public boolean hasEnchantment(ItemStack stack, int id) {
		boolean flag = false;
		if (stack.getEnchantmentTagList() != null) {
			for (int i = 0; i < stack.getEnchantmentTagList().tagCount(); i++) {
				if (stack.getEnchantmentTagList().getCompoundTagAt(i).getShort("id") == id) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}

	@SubscribeEvent
	public void onHurtss(LivingHurtEvent event) {
		if (event.source.getEntity() instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) event.source.getEntity();
			if (entity.getHeldItem() != null) {
				if (hasEnchantment(entity.getHeldItem(), 124)) {

					event.entityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, 400, 0));

					event.entityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 80, 0));

				}

			}
		}
	}

	public boolean hasEnchantmentSs(ItemStack stack, int id) {
		boolean flag = false;
		if (stack.getEnchantmentTagList() != null) {
			for (int i = 0; i < stack.getEnchantmentTagList().tagCount(); i++) {
				if (stack.getEnchantmentTagList().getCompoundTagAt(i).getShort("id") == id) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}

	public boolean hasEnchantments(ItemStack stack, int id) {
		boolean flag = false;
		if (stack.getEnchantmentTagList() != null) {
			for (int i = 0; i < stack.getEnchantmentTagList().tagCount(); i++) {
				if (stack.getEnchantmentTagList().getCompoundTagAt(i).getShort("id") == id) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}

	@SubscribeEvent
	@SideOnly(Side.SERVER)
	public void whenDeath(LivingDeathEvent e) {
		if (e.entity instanceof EntityPlayer && (e.source.getEntity() instanceof EntityPlayer)) {
			EntityPlayer player = (EntityPlayer) e.source.getEntity();
			player.addPotionEffect(new PotionEffect(Potion.heal.id, 10, 100));
		}
	}

	@SubscribeEvent
	public void onDrops(BlockEvent.HarvestDropsEvent event) {

		if (event.block == Blocks.mob_spawner && event.harvester.getHeldItem() == null) {
			event.drops.clear();

		} else if (event.block == Blocks.mob_spawner && event.harvester.getHeldItem().getItem() != null
				&& event.harvester.getHeldItem().getItem() == enderdeath.PickaxeSpawner) {
			event.drops.clear();
			event.drops.add(new ItemStack(Blocks.mob_spawner, 1));

		}
	}

	private String string;

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onRenderPre(RenderGameOverlayEvent.Pre event) {
		if (event.type == RenderGameOverlayEvent.ElementType.DEBUG) {
			Minecraft mc = Minecraft.getMinecraft();
			event.setCanceled(true);
			this.drawString(Minecraft.getMinecraft().fontRenderer, mc.debug.split(",", 2)[0], 0, 15, 0xFF0000);
			this.drawString(Minecraft.getMinecraft().fontRenderer,
					mc.theWorld.getBiomeGenForCoords(MathHelper.floor_double(mc.thePlayer.posX),
							MathHelper.floor_double(mc.thePlayer.posZ)).biomeName,
					0, 65, 0xFF0000);

			this.drawString(Minecraft.getMinecraft().fontRenderer, "x : " + (int) mc.thePlayer.posX, 0, 25, 0xFF0000);
			this.drawString(Minecraft.getMinecraft().fontRenderer, "y : " + (int) mc.thePlayer.posY, 0, 35, 0xFF0000);
			this.drawString(Minecraft.getMinecraft().fontRenderer, "z : " + (int) mc.thePlayer.posZ, 0, 45, 0xFF0000);
			string = "Enderdeath Version 1.0.5";
			this.drawString(Minecraft.getMinecraft().fontRenderer, string, 0, 7, 0xFF0000);
			int angle = MathHelper
					.floor_double((double) (Minecraft.getMinecraft().thePlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			String direction = Direction.directions[angle];
			this.drawString(Minecraft.getMinecraft().fontRenderer, direction, 0, 55, 0xFF0000);
		}
	}

	@SideOnly(Side.CLIENT)
	public void drawString(FontRenderer fontRenderer, String str, int x, int y, int color) {
		fontRenderer.drawStringWithShadow(str, x, y, color);

	}
	@SubscribeEvent
	    public void onLivingDrops(LivingDropsEvent event)
	    {
		  if(event.entity instanceof EntityGiantZombie)
	        {
			  EntityGiantZombie skeleton = (EntityGiantZombie)event.entity;
	           
	    			for(int i = 0; i < event.drops.size(); i ++) 
	    			{
	    				
	    				EntityItem newdrop = new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ,
	    						 new ItemStack(enderdeath.Rubis, 16));
	    									event.drops.add(newdrop);
	    				
	    			
	            }
	        }
	    }
}
