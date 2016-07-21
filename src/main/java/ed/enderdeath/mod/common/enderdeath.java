package ed.enderdeath.mod.common;

import java.awt.Color;
import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ed.enderdeath.mod.AnvilDragon.BlockAnvilDragon;
import ed.enderdeath.mod.Armor.DarkaniteArmor;
import ed.enderdeath.mod.Armor.DragoniteArmor;
import ed.enderdeath.mod.Armor.EnderiteArmor;
import ed.enderdeath.mod.Armor.RoyaliteArmor;
import ed.enderdeath.mod.Armor.RubisArmor;
import ed.enderdeath.mod.Armor.SaphirArmor;
import ed.enderdeath.mod.BaieMachine.MachineBaie;
import ed.enderdeath.mod.BaieMachine.TileEntityMachineTuto;
import ed.enderdeath.mod.Block.AntiPiston;
import ed.enderdeath.mod.Block.BaieCake;
import ed.enderdeath.mod.Block.BaiePlant;
import ed.enderdeath.mod.Block.BaiePlantFire;
import ed.enderdeath.mod.Block.BaiePlantGreen;
import ed.enderdeath.mod.Block.BaiePlantRainBow;
import ed.enderdeath.mod.Block.BaiePlantWater;
import ed.enderdeath.mod.Block.BaiePlantYellow;
import ed.enderdeath.mod.Block.BlockInvisible;
import ed.enderdeath.mod.Block.BlockOre;
import ed.enderdeath.mod.Block.BlockerMiner;
import ed.enderdeath.mod.Block.Box;
import ed.enderdeath.mod.Block.BoxKey;
import ed.enderdeath.mod.Block.BrickStonarck;
import ed.enderdeath.mod.Block.DamageBlock;
import ed.enderdeath.mod.Block.DarkaniteNetherack;
import ed.enderdeath.mod.Block.DragonCrystalOre;
import ed.enderdeath.mod.Block.Dragoneyes;
import ed.enderdeath.mod.Block.EggDragonRed;
import ed.enderdeath.mod.Block.EnderiteOre;
import ed.enderdeath.mod.Block.HulminiOre;
import ed.enderdeath.mod.Block.IronFence;
import ed.enderdeath.mod.Block.JumpBlock;
import ed.enderdeath.mod.Block.MegaSpawner;
import ed.enderdeath.mod.Block.NaturalBox;
import ed.enderdeath.mod.Block.ObsiRenforced;
import ed.enderdeath.mod.Block.ObsiRenforced;
import ed.enderdeath.mod.Block.RoyaliteOre;
import ed.enderdeath.mod.Block.RubisOre;
import ed.enderdeath.mod.Block.SaphirOre;
import ed.enderdeath.mod.Block.SlowBlock;
import ed.enderdeath.mod.Block.SpeedBlock;
import ed.enderdeath.mod.Block.TileEntityMega;
import ed.enderdeath.mod.Block.UltimeBox;
import ed.enderdeath.mod.Block.XpOre;
import ed.enderdeath.mod.Block.testBlock;
import ed.enderdeath.mod.Event.EnchantForge;
import ed.enderdeath.mod.Event.TickHandler;
import ed.enderdeath.mod.Extractor.Alloyer;
import ed.enderdeath.mod.Extractor.TileEntityAlloyer;
import ed.enderdeath.mod.Food.Baie;
import ed.enderdeath.mod.Food.BaieBlack;
import ed.enderdeath.mod.Food.BaieBlue;
import ed.enderdeath.mod.Food.BaieChocolate;
import ed.enderdeath.mod.Food.BaieGreen;
import ed.enderdeath.mod.Food.BaieHeal;
import ed.enderdeath.mod.Food.BaieOfRainbow;
import ed.enderdeath.mod.Food.BaieOrange;
import ed.enderdeath.mod.Food.BaiePink;
import ed.enderdeath.mod.Food.BaieRed;
import ed.enderdeath.mod.Food.BaieResistance;
import ed.enderdeath.mod.Food.BaieSpeed;
import ed.enderdeath.mod.Food.BaieWhite;
import ed.enderdeath.mod.Food.BaieYellow;
import ed.enderdeath.mod.Food.BotleHaste;
import ed.enderdeath.mod.Food.PotionFly;
import ed.enderdeath.mod.Item.BaieSeedRainbow;
import ed.enderdeath.mod.Item.BoatTnt;
import ed.enderdeath.mod.Item.Bomber;
import ed.enderdeath.mod.Item.Croquette;
import ed.enderdeath.mod.Item.FattingXp;
import ed.enderdeath.mod.Item.FlyPotion;
import ed.enderdeath.mod.Item.ItemClass;
import ed.enderdeath.mod.Item.ItemEnchantmentTest;
import ed.enderdeath.mod.Item.MegaEnder;
import ed.enderdeath.mod.Item.OrbBlue;
import ed.enderdeath.mod.Item.OrbGreen;
import ed.enderdeath.mod.Item.OrbRed;
import ed.enderdeath.mod.Item.OrbYellow;
import ed.enderdeath.mod.Item.PotionFall;
import ed.enderdeath.mod.Item.RareItem;
import ed.enderdeath.mod.Item.SpeedUpgrade;
import ed.enderdeath.mod.Item.StickHeal;
import ed.enderdeath.mod.Item.StickJolo;
import ed.enderdeath.mod.Item.StickJump;
import ed.enderdeath.mod.Item.StickSpeed;
import ed.enderdeath.mod.Item.Wand;
import ed.enderdeath.mod.Item.WitherBow;
import ed.enderdeath.mod.Tool.Axe;
import ed.enderdeath.mod.Tool.BowGreetWood;
import ed.enderdeath.mod.Tool.IronHammer;
import ed.enderdeath.mod.Tool.Pickaxe;
import ed.enderdeath.mod.Tool.Pickaxe3x3;
import ed.enderdeath.mod.Tool.SwordSkin;
import ed.enderdeath.mod.Tool.SwordStars;
import ed.enderdeath.mod.Tool.UltimateSword;
import ed.enderdeath.mod.Tool.ToolBase.ToolAxe;
import ed.enderdeath.mod.Tool.ToolBase.ToolHoe;
import ed.enderdeath.mod.Tool.ToolBase.ToolPickaxe;
import ed.enderdeath.mod.Tool.ToolBase.ToolShovel;
import ed.enderdeath.mod.Tool.ToolBase.ToolSword;
import ed.enderdeath.mod.enchant.EnchantFight;
import ed.enderdeath.mod.enchant.StarsPower;
import ed.enderdeath.mod.entity.BomberEntity;
import ed.enderdeath.mod.entity.DragonRed;
import ed.enderdeath.mod.entity.EntityArrowDeath;
import ed.enderdeath.mod.entity.EntityBoatTnT;
import ed.enderdeath.mod.entity.EntityCreeperBoss;
import ed.enderdeath.mod.entity.Familiar;
import ed.enderdeath.mod.entity.Goblin;
import ed.enderdeath.mod.entity.GoblinKing;
import ed.enderdeath.mod.entity.KCreeper;
import ed.enderdeath.mod.entity.KingHeal;
import ed.enderdeath.mod.entity.WolfNether;
import ed.enderdeath.mod.proxy.CommonProxy;
import ed.enderdeath.mod.secret.Maxitomate;
import ed.enderdeath.mod.world.OreGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = "enderdeath", name = "enderdeath", version = "1.0")
public class enderdeath {

	@Instance("enderdeath")
	public static enderdeath instance;

	public static final String MODID = "enderdeath";
	public static final String version = "1.0.6";
	@SidedProxy(clientSide = "ed.enderdeath.mod.proxy.ClientProxy", serverSide = "ed.enderdeath.mod.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static final String TEXTURE_NAME = MODID + ":";

	public static Item WitherBow;

	/* Material armure */

	public static ToolMaterial RubisTool = EnumHelper.addToolMaterial("RubisTool", 4, 1650, 11.5F, 4, 8);
	public static ToolMaterial SaphirTool = EnumHelper.addToolMaterial("SaphirTool", 5, 1750, 13.5F, (float) 4.5, 7);
	public static ToolMaterial ObsidienTool = EnumHelper.addToolMaterial("ObsidienTool", 3, 3000, 10F, (float) 3.5, 15);
	public static ToolMaterial AUtre = EnumHelper.addToolMaterial("Autre", 3, 2500, 10F, (float) 3.75, 15);
	public static ToolMaterial RoyaliteTool = EnumHelper.addToolMaterial("RoyaliteTool", 6, 1850, 15.5F, 5, 6);
	public static ToolMaterial DarkaniteTool = EnumHelper.addToolMaterial("DarkaniteTool", 6, 1950, 19.5F, (float) 5.5,
			5);

	public static ToolMaterial SpawnerPickaxe = EnumHelper.addToolMaterial("SpawnerPickaxe", 1, 1, 15.5F, 6, 15);

	public static ToolMaterial EnderiteTool = EnumHelper.addToolMaterial("EnderiteTool", 6, 2500, 25.5F, 6, 4);
	public static ArmorMaterial RubisArmor = EnumHelper.addArmorMaterial("RubisArmor", 45, new int[] { 3, 7, 6, 3 }, 9);
	public static ArmorMaterial SaphirArmor = EnumHelper.addArmorMaterial("SaphirArmor", 50, new int[] { 4, 8, 7, 4 },
			25);

	public static ToolMaterial Hammer = EnumHelper.addToolMaterial("Hammer", 4, 1650, 11.5F, 1, 8);
	public static ArmorMaterial RoyaliteArmor = EnumHelper.addArmorMaterial("RoyaliteArmor", 55,
			new int[] { 4, 8, 7, 5 }, 10);
	public static ArmorMaterial DarkaniteArmor = EnumHelper.addArmorMaterial("DarkaniteArmor", 65,
			new int[] { 4, 9, 7, 5 }, 35);

	public static ArmorMaterial EnderiteArmor = EnumHelper.addArmorMaterial("EnderiteArmor", 85,
			new int[] { 4, 10, 7, 6 }, 100);
	public static ArmorMaterial DragoniteArmor = EnumHelper.addArmorMaterial("DragoniteArmor", -2,
			new int[] { 12, 1, 1, 1 }, 500);
	public static ToolMaterial Test = EnumHelper.addToolMaterial("Test", 4, 1650, 11.5F, 4, 8);

	public static ToolMaterial pickaxe = EnumHelper.addToolMaterial("pickaxe", 7, (int) 0.2500, 1000F, 1, 7);
	public static ToolMaterial ASwordStars = EnumHelper.addToolMaterial("ASwordStars", 7, (int) 0.2500, 825F, 7, 7);
	public static ToolMaterial BSwordStars = EnumHelper.addToolMaterial("BSwordStars", 7, (int) 0.2500, 825F, 8, 7);

	public static Item DragoniteHelmet;

	/* Material */
	public static Item StickIron;
	public static Item Rubis;
	public static Item Saphir;
	public static Item hulmini;
	public static Item Royalite;
	public static Item Darkanite;

	public static Item NuggetDarkanite;
	public static Item Enderite;

	public static Item NuggetEnderite;

	public static Block BlockMiner;
	public static Item EnderHeart;
	public static Item PickaxeSpawner;
	public static Block DragonCrystalOre;
	public static Item Pickaxe3x3Item;
	/*Ugrade*/
	public static Item UgradeSpeed;
	public static Item UgradeDamage;
	public static Item UgradeFire;
	public static Item UgradeFortune;
	public static Item UgradeSmelt;
	public static Item Ugradedoubledamage;
	/* Rubis Tool */
	public static Item PickaxeRubis;
	public static Item AxeRubis;
	public static Item ShovelRubis;
	public static Item HoeRubis;
	public static Item RubisSword;
	public static Item IronHammer;
	/* Pckaxe3x3 */
	public static Item Pickaxe3x3;
	/* SaphirTool */
	public static Item PickaxeSaphir;
	public static Item AxeSaphir;
	public static Item ShovelSaphir;
	public static Item HoeSaphir;
	public static Item SwordSaphir;
	/*Secret Saison*/
	public static Item Maxitomate;
	/* Royalite */
	public static Item PickaxeRoyalite;
	public static Item AxeRoyalite;
	public static Item ShovelRoyalite;
	public static Item HoeRoyalite;
	public static Item SwordRoyalite;
	/* RoyaliteArmor */
	public static Item RoyaliteHelmet;
	public static Item RoyaliteChestplate;
	public static Item RoyaliteLeggings;
	public static Item RoyaliteBoots;

	/* DefenseBlock */
	public static Block RenforcedSandandgravel;
	public static Block DeadAirBlock;

	/* darkanite */
	public static Item PickaxeDarkanite;
	public static Item AxeDarkanite;
	public static Item ShovelDarkanite;
	public static Item HoeDarkanite;
	public static Item SwordDarkanite;
	/* DarkaniteArmor */
	public static Item DarkaniteHelmet;
	public static Item DarkaniteChestplate;
	public static Item DarkaniteLeggings;
	public static Item DarkaniteBoots;
	public static Item MegaEnder;
	/* EnderiteTool */
	public static Item PickaxeEnderite;
	public static Item AxeEnderite;
	public static Item ShovelEnderite;
	public static Item HoeEnderite;
	public static Item SwordEnderite;
	/* RubisArmor */
	public static Item RubisHelmet;
	public static Item RubisChestplate;
	public static Item RubisLeggings;
	public static Item RubisBoot;
	/* SaphirArmor */
	public static Item SaphirHelmet;
	public static Item SaphirChestplate;
	public static Item SaphirLeggings;
	public static Item SaphirBoot;
	public static Block Dragoneyes;
	
	/**/
	/* Test */
	public static Item ItemEnchantmentTest;

	public static Block DamageBlock;
	public static Item DragonCrystal;
	/* EnderiteArmor */
	public static Item EnderiteHelmet;
	public static Item EnderiteChestplate;
	public static Item EnderiteLeggings;
	public static Item EnderiteBoots;
	public static Block Mega;
	/* IngotNetherStars */

	/* Block */
	/* Personnilation sword */
	public static Item RubisSwordA;
	public static Item SaphirSwordA;
	public static Item RoyaliteSwordA;
	public static Item DarkaniteSwordA;
	public static Item EnderiteSwordA;
	/* Ore */
	public static Block RubisOre;
	public static Block SaphirOre;
	public static Block HulminiOre;
	public static Block RoyaliteOre;
	public static Block DarkaniteNetherack;
	public static Block EnderiteOre;
	/* Chateau block */
	public static Block Box;
	/* Block ore */
	public static net.minecraft.block.Block RubisBlock;
	public static Block SaphirBlock;
	public static Block RoyaliteBlock;
	public static Block DarkaniteBlock;
	public static Block ObsiRenforced;
	public static Block EnderiteBlock;
	/* Box */
	public static Block DeathBox;
	public static Item DeathKey;
	public static Item NaturalKey;
	public static Block NaturalBox;
	public static Item UltimeKey;
	public static Block UltimeBox;
	/* Extractor */
	public static Block alloyer;
	public static Item speedUpgrade;
	/* Food */
	public static Item Banana;
	/* Achievement */

	/* Block admin */
	public static net.minecraft.block.Block BlockInvisible;
	public static Item InvisibleBlock;
	/* Block F/M */
	public static net.minecraft.block.Block SpeedBlock;
	public static net.minecraft.block.Block JumpBlock;
	public static net.minecraft.block.Block SpeedAdmin;
	public static net.minecraft.block.Block JumpAdmin;

	public static Block AntiPiston;
	public static Block IronFence;
	/* Legendary */

	public static Item SwordF;
	public static Item SwordFire;
	public static Item FeatherHelmet;

	public static Item FeatherLeggings;
	public static Item FeatherBoot;
	public static Item BoneSacred;
	public static Item Spectral;
	public static Block testBlock;
	public static Item AxePlant;

	public static Item DirtShovel;
	public static Item Pickaxe;
	public static Item SwordOfStars;
	public static Item SwordStars;
	public static Item SwordStarsA;
	public static Item SwordStarsB;
	public static Item Wand;

	/* Vanilla */
	public static Block ObsidienBlock;
	/* Autre */
	public static Block TnTMeeb;
	/* Enchant */
	public static Enchantment enchantTest;
	public static Enchantment Slowness;
	public static Enchantment StarsPower;
	public static Enchantment Fight;
	/*Official*/
	public static Item Axe;
	/* Faction */
	public static Item Cobalt;
	public static Block MegaSpawner;
	/* Vanilla */
	/* Bottle */
	public static ItemFood BottleHaste;

	/* Robber */


	/* Arica */
	public static Block BrickStonarck;
	public static Item BowGreetWood;
	public static Item DeathArrow;
	/* Autre */

	/* Familiar */
	public static Item GoldenCroquette;
	public static Item RubisCroquette;
	public static Item SaphirCroquette;

	public static Item RainbownCroquette;
	public static Item SkinFire;
	public static Item SkinBlue;
	public static Item SkinDirt;
	public static Item SkinEnder;
	/*MystaryDoor*/

	/* Baie */
	public static Item Baie;
	public static Item BaieRed;
	public static Item BaieGreen;
	public static Item BaieBlue;
	public static Item BaieYellow;
	public static Item BaieOfChocolate;
	public static Item BaieOfRainbow;
	public static Block BaieCake;
	public static Item PieceBaieRainbow;
	public static Item BaiePink;
	public static Item BaieOrange;
	public static Item BaieWhite;
	public static Item BaieBlack;
	public static Item BaieHeal;
	public static Item BaieSpeed;
	public static Item BaieResistance;
	static Item PotionFly;
	static Item PotionFall;
	public static BiomeGenBase[] biomes = new BiomeGenBase[] { BiomeGenBase.plains, BiomeGenBase.extremeHills,
			BiomeGenBase.beach, BiomeGenBase.desert,

			BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills,
			BiomeGenBase.icePlains, BiomeGenBase.iceMountains, BiomeGenBase.river, BiomeGenBase.birchForest,
			BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills,
			BiomeGenBase.deepOcean, BiomeGenBase.extremeHillsPlus, BiomeGenBase.jungleEdge, BiomeGenBase.megaTaiga,
			BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F,
			BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach };
	/* PlantBaie */
	public static Block BaiePlant;
	public static Block BaiePlantWater;
	public static Block BaiePlantFire;
	public static Block BaiePlantGreen;
	public static Block BaiePlantYellow;
	public static Block BaiePlantRainBow;
	public static Block BaiePlantXp;
	/* BaiePlant Item */
	public static Item BaiePlantItem;
	public static Item BaiePlantItemWater;
	public static Item BaiePlantFireItem;
	public static Item BaiePlantGreenItem;
	public static Item BaiePlantYellowItem;
	public static Item BaiePlantRainBowItem;
	public static Item BaieSeedRainbow;
	/* DragonRed */
	public static Block DragonEggRed;
	public static Item BoatTnt;
	/* autre */
	public static Item FeatherChestplate;
	/* Magic */
	public static Item SitckJolo;
	public static Item StickHeal;
	public static Item StickSpeed;
public static Item StickJump;
	public static Item OrbRed;
	public static Item OrbBlue;
	public static Item OrbYellow;
	
	public static Item StickStrenght;
	public static Item Bomber;
	public static Block machineBaie;
	/* Xp */
	public static Item FattingXp;
	public static Block XpOre;
	/* Shield */
	public static Block SlowBlock;
	public static AchievementPage EnderAchivement;

	public static Random random;

	private static Item GreatNuggetEnderite;

	public static  OrbGreen OrbGreen;

	public static BlockAnvilDragon BlockAnvilDragon;

	private EntityPlayer player;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("preInit");
		/* Hub */
        
		EnderHeart = new RareItem().setUnlocalizedName("EnderHeart").setCreativeTab(CreativeTabs.tabMaterials)
				.setTextureName(enderdeath.MODID + ":EnderHeart");

		GameRegistry.registerItem(EnderHeart, "Ender_Titan_Heart");

		/* Material */

		Rubis = new ItemClass().setUnlocalizedName("Rubis").setCreativeTab(CreativeTabs.tabMaterials)
				.setTextureName(enderdeath.MODID + ":Rubis");

		Saphir = new ItemClass().setUnlocalizedName("Saphir").setCreativeTab(CreativeTabs.tabMaterials)
				.setTextureName(enderdeath.MODID + ":Saphir");

		hulmini = new ItemClass().setUnlocalizedName("hulmini").setCreativeTab(CreativeTabs.tabMaterials)
				.setTextureName(enderdeath.MODID + ":testItem");

		Royalite = new ItemClass().setUnlocalizedName("Royalite").setCreativeTab(CreativeTabs.tabMaterials)
				.setTextureName(enderdeath.MODID + ":Royalite");

		PotionFly = new PotionFly(0, 0, false).setMaxStackSize(1);

		PotionFall = new PotionFall(0, 0, false).setMaxStackSize(1);

		GameRegistry.registerItem(PotionFly, "PotionFly");

		GameRegistry.registerItem(PotionFall, "PotionFall");

		Darkanite = new ItemClass().setUnlocalizedName("Darkanite").setCreativeTab(CreativeTabs.tabMaterials)
				.setTextureName(enderdeath.MODID + ":Darkanite");

		NuggetDarkanite = new ItemClass().setUnlocalizedName("NuggetDarkanite")
				.setCreativeTab(CreativeTabs.tabMaterials).setTextureName(enderdeath.MODID + ":NuggetDarkanite");

		GameRegistry.registerItem(Darkanite, "Darkanite");

		GameRegistry.registerItem(Rubis, "Rubis");

		GameRegistry.registerItem(Saphir, "Saphir");

		GameRegistry.registerItem(hulmini, "hulmini");

		GameRegistry.registerItem(Royalite, "Royalite");

		GameRegistry.registerItem(NuggetDarkanite, "Nugget_Darkanite");

		/* Test */
		ItemEnchantmentTest = new ItemEnchantmentTest();

		GameRegistry.registerItem(ItemEnchantmentTest, "logo");
		
		
		Box = new Box();

		Dragoneyes = new Dragoneyes(Material.rock);
		
		
		GameRegistry.registerBlock(Dragoneyes, "Dragoneyes");
		GameRegistry.registerBlock(Box, "Box");
		Items.boat.setMaxStackSize(16);
		Items.iron_door.setMaxStackSize(16);
		Items.wooden_door.setMaxStackSize(16);

		Items.minecart.setMaxStackSize(16);
		Items.tnt_minecart.setMaxStackSize(12);
		Items.golden_apple.setMaxStackSize(16);

		/* Pickaxe3 */
		Pickaxe3x3 = new Pickaxe3x3(EnderiteTool, 100.0F).setUnlocalizedName("Pickaxe3x3")
				.setTextureName(enderdeath.MODID + ":Pickaxe3x3");

		GameRegistry.registerItem(Pickaxe3x3, "Pickaxe3x3");

		/* Block */
		RubisBlock = new BlockOre().setBlockName("RubisBlock").setBlockTextureName(enderdeath.MODID + ":RubisBlock");
		SaphirBlock = new BlockOre().setBlockName("SaphirBlock").setBlockTextureName(enderdeath.MODID + ":SaphirBlock");
		RoyaliteBlock = new BlockOre().setBlockName("RoyaliteBlock")
				.setBlockTextureName(enderdeath.MODID + ":RoyaliteBlock");
		DarkaniteBlock = new BlockOre().setBlockName("DarkaniteBlock")
				.setBlockTextureName(enderdeath.MODID + ":DarkaniteBlock");

		ObsiRenforced = new ObsiRenforced();
		BlockMiner = new BlockerMiner();

		;
		BoatTnt = new BoatTnt();
		
		
		
		GameRegistry.registerItem(BoatTnt, "BoatTnt");
		GameRegistry.registerBlock(BlockMiner, "Block_Miner");
		GameRegistry.registerBlock(ObsiRenforced, "Obsidien_Renforced");
		GameRegistry.registerBlock(DarkaniteBlock, "Darkanite_Block");
		GameRegistry.registerBlock(RoyaliteBlock, "Royalite_Block");
		GameRegistry.registerBlock(RubisBlock, "Rubis_Block");
		GameRegistry.registerBlock(SaphirBlock, "Saphir_Block");
		/*Mysrary*/
		Maxitomate = new Maxitomate(100, 100, true);
		
		GameRegistry.registerItem(Maxitomate, "Maxitomate");
		/* Rubis Tool */
		PickaxeRubis = new ToolPickaxe(RubisTool).setUnlocalizedName("RubisPickaxe")
				.setTextureName(enderdeath.MODID + ":RubisPickaxe").setCreativeTab(CreativeTabs.tabTools);

		AxeRubis = new ToolAxe(RubisTool).setUnlocalizedName("RubisAxe").setTextureName(enderdeath.MODID + ":RubisAxe")
				.setCreativeTab(CreativeTabs.tabTools);

		ShovelRubis = new ToolShovel(RubisTool).setUnlocalizedName("RubisShovel")
				.setTextureName(enderdeath.MODID + ":RubisShovel").setCreativeTab(CreativeTabs.tabTools);

		HoeRubis = new ToolHoe(RubisTool).setUnlocalizedName("RubisHoe").setTextureName(enderdeath.MODID + ":RubisHoe")
				.setCreativeTab(CreativeTabs.tabTools);

		RubisSword = new ToolSword(RubisTool).setUnlocalizedName("RubisSword")
				.setTextureName(enderdeath.MODID + ":RubisSword").setCreativeTab(CreativeTabs.tabCombat);
		RubisSwordA = new SwordSkin(RubisTool).setUnlocalizedName("RubisSword")
				.setTextureName(enderdeath.MODID + ":RubisSwordA").setCreativeTab(CreativeTabs.tabCombat)
				.setMaxDamage(4000);

		RoyaliteSwordA = new SwordSkin(RoyaliteTool).setUnlocalizedName("SwordRoyalite")
				.setTextureName(enderdeath.MODID + ":ARoyaliteSword").setCreativeTab(CreativeTabs.tabCombat)
				.setMaxDamage(5000);
		DarkaniteSwordA = new SwordSkin(DarkaniteTool).setUnlocalizedName("SwordDarkanite")
				.setTextureName(enderdeath.MODID + ":ADarkaniteSword").setCreativeTab(CreativeTabs.tabCombat)
				.setMaxDamage(5000);

		EnderiteSwordA = new SwordSkin(EnderiteTool).setUnlocalizedName("SwordEnderite")
				.setTextureName(enderdeath.MODID + ":ASwordEnderite").setCreativeTab(CreativeTabs.tabCombat)
				.setMaxDamage(5000);

		GameRegistry.registerItem(DarkaniteSwordA, "Volcanite_Sword_Skin");

		GameRegistry.registerItem(EnderiteSwordA, "Enderite_Sword_Skin");

		GameRegistry.registerItem(RubisSwordA, "Rubis_Sword_Skin");

		GameRegistry.registerItem(RoyaliteSwordA, "Amethyse_Sword_Skin");

		GameRegistry.registerItem(PickaxeRubis, "Pickaxe_Rubis");

		GameRegistry.registerItem(AxeRubis, "Axe_Rubis");

		GameRegistry.registerItem(ShovelRubis, "Shovel_Rubis");

		GameRegistry.registerItem(HoeRubis, "Hoe_Rubis");

		GameRegistry.registerItem(RubisSword, "Sword_Rubis");

		GameRegistry.addRecipe(new ItemStack(enderdeath.PickaxeRubis, 1),
				new Object[] { "RRR", " S ", " S ", 'R', enderdeath.Rubis, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.AxeRubis, 1),
				new Object[] { " RR", " SR", " S ", 'R', enderdeath.Rubis, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.AxeRubis, 1),
				new Object[] { "RR ", "RS ", " S ", 'R', enderdeath.Rubis, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelRubis, 1),
				new Object[] { " R ", " S ", " S ", 'R', enderdeath.Rubis, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelRubis, 1),
				new Object[] { "R  ", "S  ", "S  ", 'R', enderdeath.Rubis, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelRubis, 1),
				new Object[] { "  R", "  S", "  S", 'R', enderdeath.Rubis, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.HoeRubis, 1),
				new Object[] { " RR", " S ", " S ", 'R', enderdeath.Rubis, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(enderdeath.HoeRubis, 1),
				new Object[] { "RR ", " S ", " S ", 'R', enderdeath.Rubis, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(enderdeath.RubisSword, 1),
				new Object[] { " R ", " R ", " S ", 'R', enderdeath.Rubis, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.RubisSword, 1),
				new Object[] { "R  ", "R  ", "S  ", 'R', enderdeath.Rubis, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.RubisSword, 1),
				new Object[] { "  R", "  R", "  S", 'R', enderdeath.Rubis, 'S', Items.stick });
		/* ArmorRubis */
		RubisHelmet = new RubisArmor(RubisArmor, 0).setUnlocalizedName("RubisHelmet").setUnlocalizedName("RubisHelmet")
				.setTextureName(enderdeath.MODID + ":RubisHelmet").setCreativeTab(CreativeTabs.tabCombat);

		RubisChestplate = new RubisArmor(RubisArmor, 1).setUnlocalizedName("RubisChestplate")
				.setUnlocalizedName("RubisChestplate").setTextureName(enderdeath.MODID + ":RubisChestplate")
				.setCreativeTab(CreativeTabs.tabCombat);

		RubisLeggings = new RubisArmor(RubisArmor, 2).setUnlocalizedName("RubisLeggings")
				.setUnlocalizedName("RubisLeggings").setTextureName(enderdeath.MODID + ":RubisLeggings")
				.setCreativeTab(CreativeTabs.tabCombat);

		RubisBoot = new RubisArmor(RubisArmor, 3).setUnlocalizedName("RubisBoot").setUnlocalizedName("RubisBoot")
				.setTextureName(enderdeath.MODID + ":RubisBoot").setCreativeTab(CreativeTabs.tabCombat);

		GameRegistry.registerItem(RubisHelmet, "Rubis_Helmet");

		GameRegistry.registerItem(RubisChestplate, "Rubis_Chestplate");

		GameRegistry.registerItem(RubisLeggings, "Rubis_Leggings");

		GameRegistry.registerItem(RubisBoot, "Rubis_Boot");

		GameRegistry.addRecipe(new ItemStack(enderdeath.RubisHelmet, 1),
				new Object[] { "RRR", "R R", "   ", 'R', enderdeath.Rubis });
		GameRegistry.addRecipe(new ItemStack(enderdeath.RubisHelmet, 1),
				new Object[] { "   ", "RRR", "R R", 'R', enderdeath.Rubis });

		GameRegistry.addRecipe(new ItemStack(enderdeath.RubisChestplate, 1),
				new Object[] { "R R", "RRR", "RRR", 'R', enderdeath.Rubis });

		GameRegistry.addRecipe(new ItemStack(enderdeath.RubisLeggings, 1),
				new Object[] { "RRR", "R R", "R R", 'R', enderdeath.Rubis });

		GameRegistry.addRecipe(new ItemStack(enderdeath.RubisBoot, 1),
				new Object[] { "   ", "R R", "R R", 'R', enderdeath.Rubis });
		GameRegistry.addRecipe(new ItemStack(enderdeath.RubisBoot, 1),
				new Object[] { "R R", "R R", "   ", 'R', enderdeath.Rubis });

		/* Tool Obsi */

		;
		/* Material Boss */
		BoneSacred = new RareItem().setUnlocalizedName("BoneSacred").setTextureName(enderdeath.MODID + ":BoneSacred")
				.setCreativeTab(CreativeTabs.tabMaterials);

		GameRegistry.registerItem(BoneSacred, "Bone_Sacred");
		/* Tool Saphir */
		PickaxeSaphir = new ToolPickaxe(SaphirTool).setUnlocalizedName("PickaxeSaphir")
				.setTextureName(enderdeath.MODID + ":PickaxeSaphir").setCreativeTab(CreativeTabs.tabTools);

		AxeSaphir = new ToolAxe(SaphirTool).setUnlocalizedName("AxeSaphir")
				.setTextureName(enderdeath.MODID + ":AxeSaphir").setCreativeTab(CreativeTabs.tabTools);

		ShovelSaphir = new ToolShovel(SaphirTool).setUnlocalizedName("ShovelSaphir")
				.setTextureName(enderdeath.MODID + ":ShovelSaphir").setCreativeTab(CreativeTabs.tabTools);

		HoeSaphir = new ToolHoe(SaphirTool).setUnlocalizedName("HoeSaphir")
				.setTextureName(enderdeath.MODID + ":HoeSaphir").setCreativeTab(CreativeTabs.tabTools);

		SwordSaphir = new ToolSword(SaphirTool).setUnlocalizedName("SwordSaphir")
				.setTextureName(enderdeath.MODID + ":SwordSaphir").setCreativeTab(CreativeTabs.tabCombat);
		SaphirSwordA = new SwordSkin(SaphirTool).setUnlocalizedName("SwordSaphir")
				.setTextureName(enderdeath.MODID + ":ASwordSaphir").setCreativeTab(CreativeTabs.tabCombat)
				.setMaxDamage(4500);
		;

		GameRegistry.registerItem(SaphirSwordA, "Sword_Saphir_Skin");

		GameRegistry.registerItem(PickaxeSaphir, "Pickaxe_Saphir");

		GameRegistry.registerItem(AxeSaphir, "Axe_Saphir");

		GameRegistry.registerItem(ShovelSaphir, "Shovel_Saphir");

		GameRegistry.registerItem(HoeSaphir, "Hoe_Saphir");

		GameRegistry.registerItem(SwordSaphir, "Sword_Saphir");
		GameRegistry.addRecipe(new ItemStack(enderdeath.PickaxeSaphir, 1),
				new Object[] { "RRR", " S ", " S ", 'R', enderdeath.Saphir, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.AxeSaphir, 1),
				new Object[] { " RR", " SR", " S ", 'R', enderdeath.Saphir, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.AxeSaphir, 1),
				new Object[] { "RR ", "RS ", " S ", 'R', enderdeath.Saphir, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelSaphir, 1),
				new Object[] { " R ", " S ", " S ", 'R', enderdeath.Saphir, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelSaphir, 1),
				new Object[] { "R  ", "S  ", "S  ", 'R', enderdeath.Saphir, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelSaphir, 1),
				new Object[] { "  R", "  S", "  S", 'R', enderdeath.Saphir, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.HoeSaphir, 1),
				new Object[] { " RR", " S ", " S ", 'R', enderdeath.Saphir, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(enderdeath.HoeSaphir, 1),
				new Object[] { "RR ", " S ", " S ", 'R', enderdeath.Saphir, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordSaphir, 1),
				new Object[] { " R ", " R ", " S ", 'R', enderdeath.Saphir, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordSaphir, 1),
				new Object[] { "R  ", "R  ", "S  ", 'R', enderdeath.Saphir, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordSaphir, 1),
				new Object[] { "  R", "  R", "  S", 'R', enderdeath.Saphir, 'S', Items.stick });
		/* Armor Saphir */
		SaphirHelmet = new SaphirArmor(SaphirArmor, 0).setUnlocalizedName("SaphirHelmet")
				.setTextureName(enderdeath.MODID + ":SaphirHelmet").setCreativeTab(CreativeTabs.tabCombat);

		SaphirChestplate = new SaphirArmor(SaphirArmor, 1).setUnlocalizedName("SaphirChestplate")
				.setTextureName(enderdeath.MODID + ":SaphirChestplate").setCreativeTab(CreativeTabs.tabCombat);

		SaphirLeggings = new SaphirArmor(SaphirArmor, 2).setUnlocalizedName("SaphirLeggings")
				.setTextureName(enderdeath.MODID + ":SaphirLeggings").setCreativeTab(CreativeTabs.tabCombat);

		SaphirBoot = new SaphirArmor(SaphirArmor, 3).setUnlocalizedName("SaphirBoots")
				.setTextureName(enderdeath.MODID + ":SaphirBoots").setCreativeTab(CreativeTabs.tabCombat);

		GameRegistry.registerItem(SaphirHelmet, "Saphir_Helmet");

		GameRegistry.registerItem(SaphirChestplate, "Saphir_Chestplate");

		GameRegistry.registerItem(SaphirLeggings, "Saphir_Leggings");

		GameRegistry.registerItem(SaphirBoot, "Saphir_Boots");
		/* SaphirArmor */
		GameRegistry.addRecipe(new ItemStack(enderdeath.SaphirHelmet, 1),
				new Object[] { "RRR", "R R", "   ", 'R', enderdeath.Saphir });
		GameRegistry.addRecipe(new ItemStack(enderdeath.SaphirHelmet, 1),
				new Object[] { "   ", "RRR", "R R", 'R', enderdeath.Saphir });

		GameRegistry.addRecipe(new ItemStack(enderdeath.SaphirChestplate, 1),
				new Object[] { "R R", "RRR", "RRR", 'R', enderdeath.Saphir });

		GameRegistry.addRecipe(new ItemStack(enderdeath.SaphirLeggings, 1),
				new Object[] { "RRR", "R R", "R R", 'R', enderdeath.Saphir });

		GameRegistry.addRecipe(new ItemStack(enderdeath.SaphirBoot, 1),
				new Object[] { "   ", "R R", "R R", 'R', enderdeath.Saphir });
		GameRegistry.addRecipe(new ItemStack(enderdeath.SaphirBoot, 1),
				new Object[] { "R R", "R R", "   ", 'R', enderdeath.Saphir });
		/*Official*/
		Axe = new Axe(EnderiteTool);
		
		GameRegistry.registerItem(Axe, "Wood_Axe");
		/* Royalite */
		PickaxeRoyalite = new ToolPickaxe(RoyaliteTool).setUnlocalizedName("PickaxeRoyalite")
				.setTextureName(enderdeath.MODID + ":RoyalitePickaxe").setCreativeTab(CreativeTabs.tabTools);

		AxeRoyalite = new ToolAxe(RoyaliteTool).setUnlocalizedName("AxeRoyalite")
				.setTextureName(enderdeath.MODID + ":RoyaliteAxe").setCreativeTab(CreativeTabs.tabTools);

		ShovelRoyalite = new ToolShovel(RoyaliteTool).setUnlocalizedName("ShovelRoyalite")
				.setTextureName(enderdeath.MODID + ":RoyaliteShovel").setCreativeTab(CreativeTabs.tabTools);

		HoeRoyalite = new ToolHoe(RoyaliteTool).setUnlocalizedName("HoeRoyalite")
				.setTextureName(enderdeath.MODID + ":RoyaliteHoe").setCreativeTab(CreativeTabs.tabTools);

		SwordRoyalite = new ToolSword(RoyaliteTool).setUnlocalizedName("SwordRoyalite")
				.setTextureName(enderdeath.MODID + ":RoyaliteSword").setCreativeTab(CreativeTabs.tabCombat);

		GameRegistry.registerItem(PickaxeRoyalite, "Royalite_Pickaxe");

		GameRegistry.registerItem(AxeRoyalite, "Royalite_Axe");

		GameRegistry.registerItem(ShovelRoyalite, "Royalite_Shovel");

		GameRegistry.registerItem(HoeRoyalite, "Royalite_Hoe");

		GameRegistry.registerItem(SwordRoyalite, "Royalite_Sword");

		GameRegistry.addRecipe(new ItemStack(enderdeath.PickaxeRoyalite, 1),
				new Object[] { "RRR", " S ", " S ", 'R', enderdeath.Royalite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.AxeRoyalite, 1),
				new Object[] { " RR", " SR", " S ", 'R', enderdeath.Royalite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.AxeRoyalite, 1),
				new Object[] { "RR ", "RS ", " S ", 'R', enderdeath.Royalite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelRoyalite, 1),
				new Object[] { " R ", " S ", " S ", 'R', enderdeath.Royalite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelRoyalite, 1),
				new Object[] { "R  ", "S  ", "S  ", 'R', enderdeath.Royalite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelRoyalite, 1),
				new Object[] { "  R", "  S", "  S", 'R', enderdeath.Royalite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.HoeRoyalite, 1),
				new Object[] { " RR", " S ", " S ", 'R', enderdeath.Royalite, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(enderdeath.HoeRoyalite, 1),
				new Object[] { "RR ", " S ", " S ", 'R', enderdeath.Royalite, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordRoyalite, 1),
				new Object[] { " R ", " R ", " S ", 'R', enderdeath.Royalite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordRoyalite, 1),
				new Object[] { "R  ", "R  ", "S  ", 'R', enderdeath.Royalite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordRoyalite, 1),
				new Object[] { "  R", "  R", "  S", 'R', enderdeath.Royalite, 'S', Items.stick });
		AntiPiston = new AntiPiston(null);

		GameRegistry.registerBlock(AntiPiston, "AntiPiston");
		/* RoyaliteArmor */
		RoyaliteHelmet = new RoyaliteArmor(RoyaliteArmor, 0).setUnlocalizedName("RoyaliteHelmet")
				.setTextureName(enderdeath.MODID + ":RoyaliteHelmet").setCreativeTab(CreativeTabs.tabCombat);

		RoyaliteChestplate = new RoyaliteArmor(RoyaliteArmor, 1).setUnlocalizedName("RoyaliteChestplate")
				.setTextureName(enderdeath.MODID + ":RoyaliteChestplate").setCreativeTab(CreativeTabs.tabCombat);

		RoyaliteLeggings = new RoyaliteArmor(RoyaliteArmor, 2).setUnlocalizedName("RoyaliteLeggings")
				.setTextureName(enderdeath.MODID + ":RoyaliteLeggings").setCreativeTab(CreativeTabs.tabCombat);

		RoyaliteBoots = new RoyaliteArmor(RoyaliteArmor, 3).setUnlocalizedName("RoyaliteBoots")
				.setTextureName(enderdeath.MODID + ":RoyaliteBoots").setCreativeTab(CreativeTabs.tabCombat);

		GameRegistry.registerItem(RoyaliteHelmet, "Royalite_Helmet");

		GameRegistry.registerItem(RoyaliteChestplate, "Royalite_Chestplate");

		GameRegistry.registerItem(RoyaliteLeggings, "Royalite_Leggings");

		GameRegistry.registerItem(RoyaliteBoots, "Royalite_Boots");
		GameRegistry.addRecipe(new ItemStack(enderdeath.RoyaliteHelmet, 1),
				new Object[] { "RRR", "R R", "   ", 'R', enderdeath.Royalite });
		GameRegistry.addRecipe(new ItemStack(enderdeath.RoyaliteHelmet, 1),
				new Object[] { "   ", "RRR", "R R", 'R', enderdeath.Royalite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.RoyaliteChestplate, 1),
				new Object[] { "R R", "RRR", "RRR", 'R', enderdeath.Royalite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.RoyaliteLeggings, 1),
				new Object[] { "RRR", "R R", "R R", 'R', enderdeath.Royalite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.RoyaliteBoots, 1),
				new Object[] { "   ", "R R", "R R", 'R', enderdeath.Royalite });
		GameRegistry.addRecipe(new ItemStack(enderdeath.RoyaliteBoots, 1),
				new Object[] { "R R", "R R", "   ", 'R', enderdeath.Royalite });
	

		/* Enderite */
		Enderite = new RareItem().setUnlocalizedName("Enderite").setTextureName(enderdeath.MODID + ":Enderite")
				.setCreativeTab(CreativeTabs.tabMaterials);
		NuggetEnderite = new RareItem().setUnlocalizedName("NuggetEnderite")
				.setTextureName(enderdeath.MODID + ":NuggetEnderite").setCreativeTab(CreativeTabs.tabMaterials);
		GreatNuggetEnderite = new RareItem().setUnlocalizedName("GreatNuggetEnderite")
				.setTextureName(enderdeath.MODID + ":GreatNuggetEnderite").setCreativeTab(CreativeTabs.tabMaterials);
		EnderiteOre = new EnderiteOre();
		EnderiteBlock = new BlockOre().setBlockName("EnderiteBlock")
				.setBlockTextureName(enderdeath.MODID + ":EnderiteBlock");

		GameRegistry.registerBlock(EnderiteBlock, "Enderite_Block");
		GameRegistry.registerBlock(EnderiteOre, "Enderite_Ore");
		GameRegistry.registerItem(NuggetEnderite, "Nugget_Enderite");

		GameRegistry.registerItem(GreatNuggetEnderite, "GreatNuggetEnderite");
		GameRegistry.registerItem(Enderite, "Enderite");

		GameRegistry.addRecipe(new ItemStack(enderdeath.Enderite, 1),
				new Object[] { "RRR", "RRR", "RRR", 'R', enderdeath.GreatNuggetEnderite });
		GameRegistry.addRecipe(new ItemStack(enderdeath.GreatNuggetEnderite, 1),
				new Object[] { "ABC", "RHR", "FJN", 'R', enderdeath.NuggetEnderite, 'F', enderdeath.Darkanite, 'A',
						enderdeath.Rubis, 'B', enderdeath.Saphir, 'C', enderdeath.Royalite, 'H', enderdeath.hulmini,
						'J', Items.diamond, 'N', Items.iron_ingot });

		GameRegistry.addRecipe(new ItemStack(enderdeath.EnderiteBlock, 1),
				new Object[] { "RRR", "RRR", "RRR", 'R', enderdeath.Enderite });

		PickaxeEnderite = new ToolPickaxe(EnderiteTool).setUnlocalizedName("PickaxeEnderite")
				.setTextureName(enderdeath.MODID + ":PickaxeEnderite").setCreativeTab(CreativeTabs.tabTools);

		AxeEnderite = new ToolAxe(EnderiteTool).setUnlocalizedName("AxeEnderite")
				.setTextureName(enderdeath.MODID + ":AxeEnderite").setCreativeTab(CreativeTabs.tabTools);

		ShovelEnderite = new ToolShovel(EnderiteTool).setUnlocalizedName("ShovelEnderite")
				.setTextureName(enderdeath.MODID + ":ShovelEnderite").setCreativeTab(CreativeTabs.tabTools);

		HoeEnderite = new ToolHoe(EnderiteTool).setUnlocalizedName("HoeEnderite")
				.setTextureName(enderdeath.MODID + ":HoeEnderite").setCreativeTab(CreativeTabs.tabTools);

		SwordEnderite = new ToolSword(EnderiteTool).setUnlocalizedName("SwordEnderite")
				.setTextureName(enderdeath.MODID + ":SwordEnderite").setCreativeTab(CreativeTabs.tabCombat);
		;

		GameRegistry.registerItem(PickaxeEnderite, "Enderite_Pickaxe");

		GameRegistry.registerItem(AxeEnderite, "Enderite_Axe");

		GameRegistry.registerItem(ShovelEnderite, "Enderite_Shovel");

		GameRegistry.registerItem(HoeEnderite, "Enderite_Hoe");

		GameRegistry.registerItem(SwordEnderite, "Enderite_Sword");
		/* Defense1.0.6 */
		RenforcedSandandgravel = new ed.enderdeath.mod.Block.RenforcedSandandgravel()
				.setBlockTextureName(enderdeath.MODID + ":falling").setBlockName("falling")
				.setCreativeTab(CreativeTabs.tabBlock).setResistance(25.0F);

		GameRegistry.registerBlock(RenforcedSandandgravel, "falling");
		GameRegistry.addRecipe(new ItemStack(enderdeath.RenforcedSandandgravel, 1),
				new Object[] { "SSS", "SRS", "SSS", 'R', Blocks.gravel, 'S', Blocks.sand });

		/* ArmorEnderite */
		EnderiteHelmet = new EnderiteArmor(EnderiteArmor, 0).setUnlocalizedName("EnderiteHelmet")
				.setTextureName(enderdeath.MODID + ":EnderiteHelmet").setCreativeTab(CreativeTabs.tabCombat);

		EnderiteChestplate = new EnderiteArmor(EnderiteArmor, 1).setUnlocalizedName("EnderiteChestplate")
				.setTextureName(enderdeath.MODID + ":EnderiteChestplate").setCreativeTab(CreativeTabs.tabCombat);

		EnderiteLeggings = new EnderiteArmor(EnderiteArmor, 2).setUnlocalizedName("EnderiteLeggings")
				.setTextureName(enderdeath.MODID + ":EnderiteLeggings").setCreativeTab(CreativeTabs.tabCombat);

		EnderiteBoots = new EnderiteArmor(EnderiteArmor, 3).setUnlocalizedName("EnderiteBoots")
				.setTextureName(enderdeath.MODID + ":EnderiteBoots").setCreativeTab(CreativeTabs.tabCombat);

		GameRegistry.registerItem(EnderiteHelmet, "Enderite_Helmet");

		GameRegistry.registerItem(EnderiteChestplate, "Enderite_Chestplate");

		GameRegistry.registerItem(EnderiteLeggings, "Enderite_Leggings");

		GameRegistry.registerItem(EnderiteBoots, "Enderite_Boots");

		/* Gold */

		/* DarkaniteTool */

		PickaxeDarkanite = new ToolPickaxe(DarkaniteTool).setUnlocalizedName("PickaxeDarkanite")
				.setTextureName(enderdeath.MODID + ":PickaxeDarkanite").setCreativeTab(CreativeTabs.tabTools);

		AxeDarkanite = new ToolAxe(DarkaniteTool).setUnlocalizedName("AxeDarkanite")
				.setTextureName(enderdeath.MODID + ":AxeDarkanite").setCreativeTab(CreativeTabs.tabTools);

		ShovelDarkanite = new ToolShovel(DarkaniteTool).setUnlocalizedName("ShovelDarkanite")
				.setTextureName(enderdeath.MODID + ":ShovelDarkanite").setCreativeTab(CreativeTabs.tabTools);

		HoeDarkanite = new ToolHoe(DarkaniteTool).setUnlocalizedName("HoeDarkanite")
				.setTextureName(enderdeath.MODID + ":HoeDarkanite").setCreativeTab(CreativeTabs.tabTools);

		SwordDarkanite = new ToolSword(DarkaniteTool).setUnlocalizedName("SwordDarkanite")
				.setTextureName(enderdeath.MODID + ":SwordDarkanite").setCreativeTab(CreativeTabs.tabCombat);

		GameRegistry.registerItem(PickaxeDarkanite, "Darkanite_Pickaxe");

		GameRegistry.registerItem(AxeDarkanite, "Darkanite_Axe");

		GameRegistry.registerItem(ShovelDarkanite, "Darkanite_Shovel");

		GameRegistry.registerItem(HoeDarkanite, "Darkanite_Hoe");


		BlockAnvilDragon = new BlockAnvilDragon();
		GameRegistry.registerBlock(BlockAnvilDragon, "BlockAnvilDragon");
		
		GameRegistry.registerTileEntity(TileEntityAlloyer.class, "enderdeath:alloyer");
		GameRegistry.registerTileEntity(TileEntityMachineTuto.class, "enderdeath:baie");
		Mega = new MegaSpawner();

		GameRegistry.registerBlock(Mega, "MegaSpawner");
		GameRegistry.registerTileEntity(TileEntityMega.class, "enderdeath:mega");
		GameRegistry.registerItem(SwordDarkanite, "Darkanite_Sword");
		GameRegistry.addRecipe(new ItemStack(enderdeath.PickaxeDarkanite, 1),
				new Object[] { "RRR", " S ", " S ", 'R', enderdeath.Darkanite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.AxeDarkanite, 1),
				new Object[] { " RR", " SR", " S ", 'R', enderdeath.Darkanite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.AxeDarkanite, 1),
				new Object[] { "RR ", "RS ", " S ", 'R', enderdeath.Darkanite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelDarkanite, 1),
				new Object[] { " R ", " S ", " S ", 'R', enderdeath.Darkanite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelDarkanite, 1),
				new Object[] { "R  ", "S  ", "S  ", 'R', enderdeath.Darkanite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelDarkanite, 1),
				new Object[] { "  R", "  S", "  S", 'R', enderdeath.Darkanite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.HoeDarkanite, 1),
				new Object[] { " RR", " S ", " S ", 'R', enderdeath.Darkanite, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(enderdeath.HoeDarkanite, 1),
				new Object[] { "RR ", " S ", " S ", 'R', enderdeath.Darkanite, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordDarkanite, 1),
				new Object[] { " R ", " R ", " S ", 'R', enderdeath.Darkanite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordDarkanite, 1),
				new Object[] { "R  ", "R  ", "S  ", 'R', enderdeath.Darkanite, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordDarkanite, 1),
				new Object[] { "  R", "  R", "  S", 'R', enderdeath.Darkanite, 'S', Items.stick });
		DamageBlock = new DamageBlock();

		GameRegistry.registerBlock(DamageBlock, "DamageBlock");
		/* NetherStarsIngot */

		/* DarkaniteArmor */
		DarkaniteHelmet = new DarkaniteArmor(DarkaniteArmor, 0).setUnlocalizedName("DarkaniteHelmet")
				.setTextureName(enderdeath.MODID + ":DarkaniteHelmet").setCreativeTab(CreativeTabs.tabCombat);

		DarkaniteChestplate = new DarkaniteArmor(DarkaniteArmor, 1).setUnlocalizedName("DarkaniteChestplate")
				.setTextureName(enderdeath.MODID + ":DarkaniteChestplate").setCreativeTab(CreativeTabs.tabCombat);

		DarkaniteLeggings = new DarkaniteArmor(DarkaniteArmor, 2).setUnlocalizedName("DarkaniteLeggings")
				.setTextureName(enderdeath.MODID + ":DarkaniteLeggings").setCreativeTab(CreativeTabs.tabCombat);

		DarkaniteBoots = new DarkaniteArmor(DarkaniteArmor, 3).setUnlocalizedName("DarkaniteBoots")
				.setTextureName(enderdeath.MODID + ":DarkaniteBoots").setCreativeTab(CreativeTabs.tabCombat);

		GameRegistry.registerItem(DarkaniteHelmet, "Darkanite_Helmet");

		GameRegistry.registerItem(DarkaniteChestplate, "Darkanite_Chestplate");

		GameRegistry.registerItem(DarkaniteLeggings, "Darkanite_Leggings");

		GameRegistry.registerItem(DarkaniteBoots, "Darkanite_Boots");

		GameRegistry.addRecipe(new ItemStack(enderdeath.DarkaniteHelmet, 1),
				new Object[] { "RRR", "R R", "   ", 'R', enderdeath.Darkanite });
		GameRegistry.addRecipe(new ItemStack(enderdeath.DarkaniteHelmet, 1),
				new Object[] { "   ", "RRR", "R R", 'R', enderdeath.Darkanite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.DarkaniteChestplate, 1),
				new Object[] { "R R", "RRR", "RRR", 'R', enderdeath.Darkanite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.DarkaniteLeggings, 1),
				new Object[] { "RRR", "R R", "R R", 'R', enderdeath.Darkanite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.DarkaniteBoots, 1),
				new Object[] { "   ", "R R", "R R", 'R', enderdeath.Darkanite });
		GameRegistry.addRecipe(new ItemStack(enderdeath.DarkaniteBoots, 1),
				new Object[] { "R R", "R R", "   ", 'R', enderdeath.Darkanite });

		/* Robber */

		/* Box */
		DeathBox = new BoxKey();
		DeathKey = new ItemClass().setUnlocalizedName("DeathKey").setFull3D()
				.setTextureName(enderdeath.MODID + ":DeathKey").setCreativeTab(CreativeTabs.tabMisc);

		UltimeBox = new UltimeBox();
		UltimeKey = new RareItem().setUnlocalizedName("UltimeKey").setFull3D()
				.setTextureName(enderdeath.MODID + ":UltimeKey").setCreativeTab(CreativeTabs.tabMisc);

		NaturalBox = new NaturalBox();
		NaturalKey = new ItemClass().setUnlocalizedName("NaturalKey").setFull3D()
				.setTextureName(enderdeath.MODID + ":NaturalKey").setCreativeTab(CreativeTabs.tabMisc);

		GameRegistry.registerItem(UltimeKey, "UltimeKey");
		GameRegistry.registerBlock(UltimeBox, "UltimeBox");

		GameRegistry.registerItem(NaturalKey, "NaturalKey");
		GameRegistry.registerBlock(NaturalBox, "NaturalBox");

		GameRegistry.registerItem(DeathKey, "Ender_Key");
		GameRegistry.registerBlock(DeathBox, "Ender_Box");
		/* Ore */
		RubisOre = new RubisOre(Material.rock, 176);
		SaphirOre = new SaphirOre(null, 177);
		HulminiOre = new HulminiOre(null);
		RoyaliteOre = new RoyaliteOre(null);

		DarkaniteNetherack = new DarkaniteNetherack();
		GameRegistry.registerBlock(RoyaliteOre, "Royalite_Ore");
		GameRegistry.registerBlock(RubisOre, "Rubis_Ore");
		GameRegistry.registerBlock(SaphirOre, "Saphir_Ore");
		GameRegistry.registerBlock(HulminiOre, "Hulmini_Ore");

		GameRegistry.registerBlock(DarkaniteNetherack, "Darkanite_Netherack");

		GameRegistry.addSmelting(RubisOre, new ItemStack(Rubis), 1.0F);

		GameRegistry.addSmelting(SaphirOre, new ItemStack(Saphir), 1.0F);

		GameRegistry.addSmelting(HulminiOre, new ItemStack(hulmini), 1.0F);

		GameRegistry.addSmelting(DarkaniteNetherack, new ItemStack(NuggetDarkanite), 1.0F);

		GameRegistry.addSmelting(RoyaliteOre, new ItemStack(Royalite), 1.0F);

		/* Block Ore */
		IronHammer = new IronHammer(Hammer).setUnlocalizedName("IronHammer")
				.setTextureName(enderdeath.MODID + ":IronHammer").setCreativeTab(CreativeTabs.tabTools);

		GameRegistry.registerItem(IronHammer, "Hammer_Iron");
		/* Block Admin */
		BlockInvisible = new BlockInvisible(null, true);

		InvisibleBlock = new ItemReed(BlockInvisible).setTextureName(enderdeath.MODID + ":InvisibleBlock")
				.setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("InvisibleBlock");

		GameRegistry.registerItem(InvisibleBlock, "Invisible_Block");
		GameRegistry.registerBlock(BlockInvisible, "Block_Invisible");
		/* OreElemental */

		/* Block F/M */
		SpeedBlock = new SpeedBlock(null);

		SlowBlock = new SlowBlock();
		
		JumpBlock = new JumpBlock();

		IronFence = new IronFence(Material.iron);

		GameRegistry.registerBlock(IronFence, "Saphir_Ladder");

		GameRegistry.registerBlock(SpeedBlock, "Speed_Block");

		GameRegistry.registerBlock(JumpBlock, "Jump_Block");

		GameRegistry.registerBlock(SlowBlock, "SlowBlock");
		
		/* Legendary */

		Pickaxe = new Pickaxe(pickaxe).setUnlocalizedName("Pickaxe").setTextureName(enderdeath.MODID + ":Pickaxe")
				.setCreativeTab(CreativeTabs.tabTools);

		GameRegistry.registerItem(Pickaxe, "Pickaxe_Of_Doyo");

		/* Craft Block F/M */
		GameRegistry.addRecipe(new ItemStack(enderdeath.JumpBlock, 1),
				new Object[] { "RRR", "GGG", "RRR", 'R', enderdeath.Rubis, 'G', Blocks.wool });
		GameRegistry.addRecipe(new ItemStack(enderdeath.SpeedBlock, 1),
				new Object[] { "RRR", "GGG", "RRR", 'R', enderdeath.hulmini, 'G', enderdeath.Saphir });

		/* Vanilla */
		/* Bottle */
		BottleHaste = new BotleHaste(0, 0, false);

		GameRegistry.registerItem(BottleHaste, "Bottle_Haste");
		/* Food */

		/* Familiar */
		GoldenCroquette = new Croquette(enderdeath.GoldenCroquette).setCreativeTab(CreativeTabs.tabFood)
				.setTextureName(enderdeath.MODID + ":GoldenCroquette").setUnlocalizedName("GoldenCroquette");

		RubisCroquette = new Croquette(enderdeath.RubisCroquette).setCreativeTab(CreativeTabs.tabFood)
				.setTextureName(enderdeath.MODID + ":RubisCroquette").setUnlocalizedName("RubisCroquette");

		SaphirCroquette = new Croquette(enderdeath.SaphirCroquette).setCreativeTab(CreativeTabs.tabFood)
				.setTextureName(enderdeath.MODID + ":SaphirCroquette").setUnlocalizedName("SaphirCroquette");

		

		SkinFire = new Croquette(SkinFire).setTextureName(enderdeath.MODID + ":SkinFire").setCreativeTab(CreativeTabs.tabMisc)
				.setUnlocalizedName("SkinFire");

		SkinBlue = new Croquette(SkinBlue).setTextureName(enderdeath.MODID + ":SkinBlue").setCreativeTab(CreativeTabs.tabMisc)
				.setUnlocalizedName("SkinBlue");

		SkinDirt = new Croquette(SkinDirt).setTextureName(enderdeath.MODID + ":SkinDirt").setCreativeTab(CreativeTabs.tabMisc)
				.setUnlocalizedName("SkinDirt");

		SkinEnder = new Croquette(SkinEnder).setTextureName(enderdeath.MODID + ":SkinEnder").setCreativeTab(CreativeTabs.tabMisc)
				.setUnlocalizedName("SkinEnder");

		GameRegistry.registerItem(SkinFire, "SkinFire");

		GameRegistry.registerItem(SkinBlue, "SkinBlue");

		GameRegistry.registerItem(SkinDirt, "SkinDirt");

		GameRegistry.registerItem(SkinEnder, "SkinEnder");

		GameRegistry.registerItem(GoldenCroquette, "Golden_Croquette");

		GameRegistry.registerItem(RubisCroquette, "Rubis_Croquette");

		GameRegistry.registerItem(SaphirCroquette, "Saphir_Croquette");

	
		
		

		GameRegistry.addRecipe(new ItemStack(enderdeath.SkinBlue, 1),
				new Object[] { "RRR", "RAR", "RRR", 'R', enderdeath.Saphir, 'A', enderdeath.hulmini });

		/* Craft et cuison de minerais */

		GameRegistry.addRecipe(new ItemStack(enderdeath.Darkanite, 1),
				new Object[] { "RRR", "RRR", "RRR", 'R', enderdeath.NuggetDarkanite });

		/* Vanilla ajout de craft */
		GameRegistry.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 1),
				new Object[] { " S ", "SRS", " S ", 'R', Blocks.cobblestone, 'S', Blocks.vine });

		/* Effect de Potion */

		/* Block Ore */
		DragonCrystalOre = new DragonCrystalOre(null);

		GameRegistry.registerBlock(DragonCrystalOre, "Dragon_Crystal_Ore");
		/* Rubis */
		GameRegistry.addRecipe(new ItemStack(enderdeath.RubisBlock, 1),
				new Object[] { "RRR", "RRR", "RRR", 'R', enderdeath.Rubis });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Rubis, 9),
				new Object[] { "R  ", "   ", "   ", 'R', enderdeath.RubisBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Rubis, 9),
				new Object[] { " R ", "   ", "   ", 'R', enderdeath.RubisBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Rubis, 9),
				new Object[] { "  R", "   ", "   ", 'R', enderdeath.RubisBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Rubis, 9),
				new Object[] { "   ", "R   ", "   ", 'R', enderdeath.RubisBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Rubis, 9),
				new Object[] { "   ", " R ", "   ", 'R', enderdeath.RubisBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Rubis, 9),
				new Object[] { "   ", "  R", "   ", 'R', enderdeath.RubisBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Rubis, 9),
				new Object[] { "   ", "   ", "R  ", 'R', enderdeath.RubisBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Rubis, 9),
				new Object[] { "   ", "   ", " R ", 'R', enderdeath.RubisBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Rubis, 9),
				new Object[] { "   ", "   ", "  R", 'R', enderdeath.RubisBlock });
		
		/* Saphir */
		GameRegistry.addRecipe(new ItemStack(enderdeath.SaphirBlock, 1),
				new Object[] { "RRR", "RRR", "RRR", 'R', enderdeath.Saphir });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Saphir, 9),
				new Object[] { "R  ", "   ", "   ", 'R', enderdeath.SaphirBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Saphir, 9),
				new Object[] { " R ", "   ", "   ", 'R', enderdeath.SaphirBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Saphir, 9),
				new Object[] { "  R", "   ", "   ", 'R', enderdeath.SaphirBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Saphir, 9),
				new Object[] { "   ", "R   ", "   ", 'R', enderdeath.SaphirBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Saphir, 9),
				new Object[] { "   ", " R ", "   ", 'R', enderdeath.SaphirBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Saphir, 9),
				new Object[] { "   ", "  R", "   ", 'R', enderdeath.SaphirBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Saphir, 9),
				new Object[] { "   ", "   ", "R  ", 'R', enderdeath.SaphirBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Saphir, 9),
				new Object[] { "   ", "   ", " R ", 'R', enderdeath.SaphirBlock });
				/* EnderiteRenforce */

		/* Royalite */
		GameRegistry.addRecipe(new ItemStack(enderdeath.RoyaliteBlock, 1),
				new Object[] { "RRR", "RRR", "RRR", 'R', enderdeath.Royalite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Royalite, 9),
				new Object[] { "R  ", "   ", "   ", 'R', enderdeath.RoyaliteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Royalite, 9),
				new Object[] { " R ", "   ", "   ", 'R', enderdeath.RoyaliteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Royalite, 9),
				new Object[] { "  R", "   ", "   ", 'R', enderdeath.RoyaliteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Royalite, 9),
				new Object[] { "   ", "R   ", "   ", 'R', enderdeath.RoyaliteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Royalite, 9),
				new Object[] { "   ", " R ", "   ", 'R', enderdeath.RoyaliteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Royalite, 9),
				new Object[] { "   ", "  R", "   ", 'R', enderdeath.RoyaliteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Royalite, 9),
				new Object[] { "   ", "   ", "R  ", 'R', enderdeath.RoyaliteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Royalite, 9),
				new Object[] { "   ", "   ", " R ", 'R', enderdeath.RoyaliteBlock });
		/* Darkanite */
		GameRegistry.addRecipe(new ItemStack(enderdeath.DarkaniteBlock, 1),
				new Object[] { "RRR", "RRR", "RRR", 'R', enderdeath.Darkanite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Darkanite, 9),
				new Object[] { "R  ", "   ", "   ", 'R', enderdeath.DarkaniteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Darkanite, 9),
				new Object[] { " R ", "   ", "   ", 'R', enderdeath.DarkaniteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Darkanite, 9),
				new Object[] { "  R", "   ", "   ", 'R', enderdeath.DarkaniteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Darkanite, 9),
				new Object[] { "   ", "R   ", "   ", 'R', enderdeath.DarkaniteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Darkanite, 9),
				new Object[] { "   ", " R ", "   ", 'R', enderdeath.DarkaniteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Darkanite, 9),
				new Object[] { "   ", "  R", "   ", 'R', enderdeath.DarkaniteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Darkanite, 9),
				new Object[] { "   ", "   ", "R  ", 'R', enderdeath.DarkaniteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Darkanite, 9),
				new Object[] { "   ", "   ", " R ", 'R', enderdeath.DarkaniteBlock });

		/* Fac */
		GameRegistry.addRecipe(new ItemStack(enderdeath.ObsiRenforced, 1),
				new Object[] { "RRR", "RRR", "RRR", 'R', Blocks.obsidian });
		GameRegistry.addRecipe(new ItemStack(enderdeath.BlockMiner, 1),
				new Object[] { "SRS", "RSR", "SRS", 'R', enderdeath.Rubis, 'S', enderdeath.hulmini });

		/* Enderite */
		GameRegistry.addRecipe(new ItemStack(enderdeath.EnderiteBlock, 1),
				new Object[] { "RRR", "RRR", "RRR", 'R', enderdeath.Enderite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Enderite, 9),
				new Object[] { "R  ", "   ", "   ", 'R', enderdeath.EnderiteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Enderite, 9),
				new Object[] { " R ", "   ", "   ", 'R', enderdeath.EnderiteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Enderite, 9),
				new Object[] { "  R", "   ", "   ", 'R', enderdeath.EnderiteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Enderite, 9),
				new Object[] { "   ", "R   ", "   ", 'R', enderdeath.EnderiteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Enderite, 9),
				new Object[] { "   ", " R ", "   ", 'R', enderdeath.EnderiteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Enderite, 9),
				new Object[] { "   ", "  R", "   ", 'R', enderdeath.EnderiteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Enderite, 9),
				new Object[] { "   ", "   ", "R  ", 'R', enderdeath.EnderiteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Enderite, 9),
				new Object[] { "   ", "   ", " R ", 'R', enderdeath.EnderiteBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.FeatherBoot, 1),
				new Object[] { "R R", "R R", "   ", 'R', enderdeath.hulmini });

		GameRegistry.addRecipe(new ItemStack(enderdeath.FeatherBoot, 1),
				new Object[] { "   ", "R R", "R R", 'R', enderdeath.hulmini });

		/* Baie */
		Baie = new Baie(2, 2, true);

		BaieResistance = new BaieResistance(2, 2, true);

		BaieRed = new BaieRed(2, 2, true);

		BaieBlue = new BaieBlue(2, 2, true);

		BaieGreen = new BaieGreen(2, 2, true);

		BaieYellow = new BaieYellow(2, 2, true);

		BaieOfChocolate = new BaieChocolate(2, 2, true);

		BaieOfRainbow = new BaieOfRainbow(2, 2, true);

		BaiePink = new BaiePink(2, 2, true).setMaxStackSize(1);

		BaieOrange = new BaieOrange(2, 2, true);

		BaieWhite = new BaieWhite(2, 2, true);

		BaieBlack = new BaieBlack(2, 2, true);

		BaieHeal = new BaieHeal(2, 2, true).setMaxStackSize(3);

		BaieSpeed = new BaieSpeed(2, 2, true);

		PieceBaieRainbow = new Baie(2, 2, true).setCreativeTab(CreativeTabs.tabFood)
				.setTextureName(enderdeath.MODID + ":PieceBaieRainbow").setUnlocalizedName("PieceBaieRainbow");

		BaieCake = new BaieCake();

		BaiePlant = new BaiePlant(enderdeath.Baie);

		BaiePlantWater = new BaiePlantWater(enderdeath.BaieBlue);

		BaiePlantFire = new BaiePlantFire(enderdeath.BaieRed);

		BaiePlantGreen = new BaiePlantGreen(enderdeath.BaieGreen);

		BaiePlantYellow = new BaiePlantYellow(enderdeath.BaieYellow);

		BaiePlantRainBow = new BaiePlantRainBow(enderdeath.BaieSeedRainbow);

		BaieSeedRainbow = new BaieSeedRainbow(enderdeath.BaiePlantRainBow);

		GameRegistry.registerItem(BaieHeal, "Baie_Heal+");

		GameRegistry.registerItem(BaieSpeed, "Baie_Speed+");
		GameRegistry.registerBlock(BaiePlantRainBow, "Baie_Plant_RainBow");
		GameRegistry.registerBlock(BaiePlantYellow, "Baie_Plant_Yellow");
		GameRegistry.registerBlock(BaiePlantGreen, "Baie_Plant_Green");
		GameRegistry.registerBlock(BaiePlantFire, "Baie_Plant_Fire");
		GameRegistry.registerBlock(BaiePlantWater, "Baie_Plant_Water");
		GameRegistry.registerBlock(BaiePlant, "Baie_Plant");
		GameRegistry.registerBlock(BaieCake, "Baie_Cake");
		GameRegistry.registerItem(BaieOfRainbow, "Baie_Of_Rainbow");
		GameRegistry.registerItem(BaieOfChocolate, "Baie_Of_Chocolate");
		GameRegistry.registerItem(BaiePink, "Baie_Pink");
		GameRegistry.registerItem(BaieOrange, "Baie_Orange");
		GameRegistry.registerItem(BaieWhite, "Baie_White");
		GameRegistry.registerItem(BaieYellow, "Baie_Yellow");
		GameRegistry.registerItem(BaieGreen, "Baie_Green");
		GameRegistry.registerItem(BaieResistance, "Baie_Black_and_White");
		GameRegistry.registerItem(BaieBlue, "Baie_Blue");
		GameRegistry.registerItem(BaieBlack, "Baie_Black");
		GameRegistry.registerItem(BaieRed, "Baie_Red");
		GameRegistry.registerItem(Baie, "Baie");
		GameRegistry.registerItem(PieceBaieRainbow, "Piece_Baie_Rainbow");
		GameRegistry.registerItem(BaieSeedRainbow, "Baie_Seed_Rainbow");

		/* BaiePlantItem */
		BaiePlantItem = new ItemReed(enderdeath.BaiePlant).setTextureName(enderdeath.MODID + ":BaiePlantItem")
				.setUnlocalizedName("BaiePlantItem").setCreativeTab(CreativeTabs.tabMaterials);

		BaiePlantItemWater = new ItemReed(enderdeath.BaiePlantWater).setTextureName(enderdeath.MODID + ":BaieBlueItem")
				.setUnlocalizedName("BaieBlueItem").setCreativeTab(CreativeTabs.tabMaterials);

		BaiePlantFireItem = new ItemReed(enderdeath.BaiePlantFire).setTextureName(enderdeath.MODID + ":BaieRedItem")
				.setUnlocalizedName("BaieRedItem").setCreativeTab(CreativeTabs.tabMaterials);

		BaiePlantGreenItem = new ItemReed(enderdeath.BaiePlantGreen)
				.setTextureName(enderdeath.MODID + ":BaiePlantGreenItem").setUnlocalizedName("BaiePlantGreenItem")
				.setCreativeTab(CreativeTabs.tabMaterials);

		BaiePlantYellowItem = new ItemReed(BaiePlantYellow).setTextureName(enderdeath.MODID + ":BaiePlantYellowItem")
				.setUnlocalizedName("BaiePlantYellowItem").setCreativeTab(CreativeTabs.tabMaterials);

		MegaEnder = new MegaEnder();

		GameRegistry.registerItem(MegaEnder, "Enderrer");

		GameRegistry.registerItem(BaiePlantYellowItem, "Baie_Yellow_Seeds");

		GameRegistry.registerItem(BaiePlantFireItem, "Baie_Red_Seeds");

		GameRegistry.registerItem(BaiePlantItem, "Baie_Seeds");

		GameRegistry.registerItem(BaiePlantItemWater, "Baie_Blue_Seeds");

		GameRegistry.registerItem(BaiePlantGreenItem, "Baie_Green_Seeds");

		/* testBlock */
		testBlock = new testBlock();

		GameRegistry.registerBlock(testBlock, "Legendary");
		/* Obsi */
		/* Autres */
		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);

		/*Ugrade*/
		
	
		/* Enchant */

		StarsPower = new StarsPower().setName("StarsPower");

		/* DragonRed */
		DragonEggRed = new EggDragonRed(null);

		GameRegistry.registerBlock(DragonEggRed, "DragonEggRed");
		/* SwordStars */
		SwordOfStars = new SwordStars(ASwordStars).setUnlocalizedName("SwordStars")
				.setTextureName(enderdeath.MODID + ":SwordStars").setCreativeTab(CreativeTabs.tabCombat);

		Fight = new EnchantFight().setName("FightPower");

		SwordStars = new UltimateSword(BSwordStars).setUnlocalizedName("SwordOfStars")
				.setTextureName(enderdeath.MODID + ":SwordOfStars").setCreativeTab(CreativeTabs.tabCombat);
		;

		GameRegistry.registerItem(SwordStars, "SwordStars");

		GameRegistry.registerItem(SwordOfStars, "Sword_Of_Stars");
		GameRegistry.addRecipe(new ItemStack(enderdeath.testBlock, 1),
				new Object[] { "RRR", "RRR", "RRR", 'R', enderdeath.hulmini });

		GameRegistry.addRecipe(new ItemStack(enderdeath.hulmini, 9),
				new Object[] { "R  ", "   ", "   ", 'R', enderdeath.testBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.hulmini, 9),
				new Object[] { " R ", "   ", "   ", 'R', enderdeath.testBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.hulmini, 9),
				new Object[] { "  R", "   ", "   ", 'R', enderdeath.testBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.hulmini, 9),
				new Object[] { "   ", "R   ", "   ", 'R', enderdeath.testBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.hulmini, 9),
				new Object[] { "   ", " R ", "   ", 'R', enderdeath.testBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.hulmini, 9),
				new Object[] { "   ", "  R", "   ", 'R', enderdeath.testBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.hulmini, 9),
				new Object[] { "   ", "   ", "R  ", 'R', enderdeath.testBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.hulmini, 9),
				new Object[] { "   ", "   ", " R ", 'R', enderdeath.testBlock });

		GameRegistry.addRecipe(new ItemStack(enderdeath.hulmini, 9),
				new Object[] { "   ", "   ", "  R", 'R', enderdeath.testBlock });
		/* Magic */
		SitckJolo = new StickJolo();
		FattingXp = new FattingXp();
		StickHeal = new StickHeal();
		StickSpeed = new StickSpeed();
		StickJump = new StickJump();
		XpOre = new XpOre();
		OrbRed = new OrbRed();
		OrbBlue = new OrbBlue();
		OrbGreen = new OrbGreen();
		OrbYellow = new OrbYellow();
		
		Bomber = new Bomber().setMaxStackSize(1);

		GameRegistry.registerItem(OrbGreen, "OrbGreen");
		GameRegistry.registerItem(StickJump, "StickJump");
		GameRegistry.registerItem(OrbYellow, "OrbYellow");
		GameRegistry.registerItem(Bomber, "Bomber");
		GameRegistry.registerItem(OrbBlue, "Orb_Blue");
		GameRegistry.registerItem(OrbRed, "Orb_Red");

		GameRegistry.registerItem(StickSpeed, "Stick_Speed");
		GameRegistry.registerItem(StickHeal, "Stick_Healing");
		GameRegistry.registerItem(SitckJolo, "Stick_Clear");
		GameRegistry.registerBlock(XpOre, "Xp_Ore");
		GameRegistry.registerItem(FattingXp, "Fatting_Xp");

		DragoniteHelmet = new DragoniteArmor(DragoniteArmor, 0).setUnlocalizedName("DragoniteHelmet")
				.setTextureName(enderdeath.MODID + ":DragoniteHelmet");
		GameRegistry.registerItem(DragoniteHelmet, "Dragonite_Helmet");
		/* Modification du diamant */
		ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.diamond_helmet, 2, "damageReduceAmount",
				"field_77879_b");
		ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.diamond_chestplate, 7, "damageReduceAmount",
				"field_77879_b");
		ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.diamond_leggings, 5, "damageReduceAmount",
				"field_77879_b");
		ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.diamond_boots, 2, "damageReduceAmount",
				"field_77879_b");

		/* Arica */
		BrickStonarck = new BrickStonarck();

		BowGreetWood = new BowGreetWood();

		
		WitherBow = new WitherBow();
	
		GameRegistry.registerItem(WitherBow, "WitherBow");
		
		GameRegistry.registerItem(BowGreetWood, "Bow_Greet_Wood");

		GameRegistry.registerBlock(BrickStonarck, "BrickS_Stonarck");

		/* NuggetAll */

		/* Bloc d�cioratif */
		GameRegistry.addRecipe(new ItemStack(enderdeath.BrickStonarck, 3),
				new Object[] { "   ", " R ", "   ", 'R', enderdeath.hulmini });
		/* Saphir */
		DeathArrow = new ItemClass().setCreativeTab(CreativeTabs.tabCombat).setFull3D()
				.setTextureName(enderdeath.MODID + ":DeathArrow").setUnlocalizedName("DeathArrow");

		GameRegistry.registerItem(DeathArrow, "Death_Arrow");

		GameRegistry.addRecipe(new ItemStack(enderdeath.NuggetDarkanite, 9),
				new Object[] { "R  ", "   ", "   ", 'R', enderdeath.Darkanite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.NuggetDarkanite, 9),
				new Object[] { " R ", "   ", "   ", 'R', enderdeath.Darkanite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.NuggetDarkanite, 9),
				new Object[] { "  R", "   ", "   ", 'R', enderdeath.Darkanite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.NuggetDarkanite, 9),
				new Object[] { "   ", "R   ", "   ", 'R', enderdeath.Darkanite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.NuggetDarkanite, 9),
				new Object[] { "   ", " R ", "   ", 'R', enderdeath.Darkanite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.NuggetDarkanite, 9),
				new Object[] { "   ", "  R", "   ", 'R', enderdeath.Darkanite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.NuggetDarkanite, 9),
				new Object[] { "   ", "   ", "R  ", 'R', enderdeath.Darkanite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.NuggetDarkanite, 9),
				new Object[] { "   ", "   ", " R ", 'R', enderdeath.Darkanite });

		/* BaieCraft */
		GameRegistry.addRecipe(new ItemStack(enderdeath.BaiePlantItemWater, 2),
				new Object[] { "RRR", "RSR", "RRR", 'R', enderdeath.Baie, 'S', Items.water_bucket });
		GameRegistry.addRecipe(new ItemStack(enderdeath.BaieCake, 1),
				new Object[] { "BHB", "ASG", "BZB", 'R', enderdeath.Baie, 'A', enderdeath.BaieGreen, 'B', Items.wheat,
						'G', enderdeath.BaieBlue, 'H', enderdeath.BaieYellow, 'S', enderdeath.Baie, 'Z',
						enderdeath.BaieRed });
		GameRegistry.addRecipe(new ItemStack(enderdeath.BaiePlantFireItem, 2),
				new Object[] { "RRR", "RSR", "RRR", 'R', enderdeath.Baie, 'S', Items.fire_charge });
		GameRegistry.addRecipe(new ItemStack(enderdeath.BaiePlantGreenItem, 2),
				new Object[] { "RRR", "RSR", "RRR", 'R', enderdeath.Baie, 'S', Blocks.sapling });
		GameRegistry.addRecipe(new ItemStack(enderdeath.BaiePlantYellowItem, 2),
				new Object[] { "RRR", "RSR", "RRR", 'R', enderdeath.Baie, 'S', Items.glowstone_dust });
		

		GameRegistry.addRecipe(new ItemStack(enderdeath.PotionFly, 1),
				new Object[] { "RRR", "RSR", "RRR", 'S', enderdeath.BottleHaste, 'R', Items.feather });
		GameRegistry.addRecipe(new ItemStack(enderdeath.PotionFall, 1),
				new Object[] { "RRR", "RSR", "RRR", 'S', Items.glass_bottle, 'R', enderdeath.hulmini });

		/* Craft Sword Ultimate */

		/* RubisRenforced */

		GameRegistry.addRecipe(new ItemStack(enderdeath.BaieOfRainbow, 1),
				new Object[] { "RRR", "RRR", "RRR", 'R', enderdeath.PieceBaieRainbow, });

		GameRegistry.addRecipe(new ItemStack(enderdeath.BaieSeedRainbow, 1),
				new Object[] { "RAR", "ARA", "RAR", 'R', enderdeath.Enderite, 'A', enderdeath.BaieOfRainbow });
		/* Haste */
		GameRegistry.addRecipe(new ItemStack(enderdeath.BottleHaste, 1), new Object[] { "BIB", "ISI", "BIB", 'B',
				Items.gold_ingot, 'S', Items.glass_bottle, 'I', Items.golden_pickaxe });
		Blocks.obsidian.setResistance(1.0F);
		Blocks.dragon_egg.setCreativeTab(CreativeTabs.tabBlock);
		Blocks.command_block.setCreativeTab(CreativeTabs.tabRedstone);
		Blocks.enchanting_table.setResistance(1.0F);
		Blocks.anvil.setResistance(1.0F);
		DragonCrystal = new RareItem().setUnlocalizedName("DragonCrystal")
				.setTextureName(enderdeath.MODID + ":DragonCrystal");

		GameRegistry.registerItem(DragonCrystal, "Dragon_Crystal");

		GameRegistry.addRecipe(new ItemStack(enderdeath.BowGreetWood, 1), new Object[] { " AG", "ARG", " AG", 'R',
				enderdeath.DarkaniteBlock, 'A', enderdeath.Enderite, 'G', Items.string });

		GameRegistry.addRecipe(new ItemStack(enderdeath.OrbBlue, 1),
				new Object[] { "AGA", "GAG", "AGA", 'A', enderdeath.Saphir, 'G', enderdeath.hulmini });

		GameRegistry.addRecipe(new ItemStack(enderdeath.IronFence, 1),
				new Object[] { "A A", "AAA", "A A", 'A', enderdeath.Saphir });
		/* Extractor */
		alloyer = new Alloyer(Material.iron);
		speedUpgrade = new SpeedUpgrade("speedUpgrade", 125);

		machineBaie = new MachineBaie();
		
		GameRegistry.registerItem(speedUpgrade, "speedUpgrade");
		GameRegistry.registerBlock(alloyer, "Extractor");
		GameRegistry.registerBlock(machineBaie, "machineBaie");
		StickIron = new ItemClass().setUnlocalizedName("StickIron").setTextureName(enderdeath.MODID + ":StickIron")
				.setCreativeTab(CreativeTabs.tabMaterials);

		GameRegistry.registerItem(StickIron, "Stick_Iron");

		GameRegistry.addRecipe(new ItemStack(enderdeath.StickIron, 1),
				new Object[] { " R ", " R ", " R ", 'R', Blocks.iron_block });
		GameRegistry.addRecipe(new ItemStack(enderdeath.StickIron, 1),
				new Object[] { "R  ", "R  ", "R  ", 'R', Blocks.iron_block });
		GameRegistry.addRecipe(new ItemStack(enderdeath.StickIron, 1),
				new Object[] { "  R", "  R", "  R", 'R', Blocks.iron_block });
		GameRegistry.addRecipe(new ItemStack(enderdeath.PickaxeEnderite, 1),
				new Object[] { "RRR", " S ", " S ", 'R', enderdeath.Enderite, 'S', enderdeath.StickIron });

		GameRegistry.addRecipe(new ItemStack(enderdeath.AxeEnderite, 1),
				new Object[] { " RR", " SR", " S ", 'R', enderdeath.Enderite, 'S', enderdeath.StickIron });

		GameRegistry.addRecipe(new ItemStack(enderdeath.AxeEnderite, 1),
				new Object[] { "RR ", "RS ", " S ", 'R', enderdeath.Enderite, 'S', enderdeath.StickIron });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelEnderite, 1),
				new Object[] { " R ", " S ", " S ", 'R', enderdeath.Enderite, 'S', enderdeath.StickIron });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelEnderite, 1),
				new Object[] { "R  ", "S  ", "S  ", 'R', enderdeath.Enderite, 'S', enderdeath.StickIron });

		GameRegistry.addRecipe(new ItemStack(enderdeath.ShovelEnderite, 1),
				new Object[] { "  R", "  S", "  S", 'R', enderdeath.Enderite, 'S', enderdeath.StickIron });

		GameRegistry.addRecipe(new ItemStack(enderdeath.HoeEnderite, 1),
				new Object[] { " RR", " S ", " S ", 'R', enderdeath.Enderite, 'S', enderdeath.StickIron });
		GameRegistry.addRecipe(new ItemStack(enderdeath.HoeEnderite, 1),
				new Object[] { "RR ", " S ", " S ", 'R', enderdeath.Enderite, 'S', enderdeath.StickIron });
		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordEnderite, 1),
				new Object[] { " R ", " R ", " S ", 'R', enderdeath.Enderite, 'S', enderdeath.StickIron });

		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordEnderite, 1),
				new Object[] { "R  ", "R  ", "S  ", 'R', enderdeath.Enderite, 'S', enderdeath.StickIron });

		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordEnderite, 1),
				new Object[] { "  R", "  R", "  S", 'R', enderdeath.Enderite, 'S', enderdeath.StickIron });

		GameRegistry
				.addRecipe(new ItemStack(enderdeath.SwordStars, 1),
						new Object[] { " V ", "IRI", "SBS", 'R', enderdeath.EnderHeart, 'B', enderdeath.StickIron, 'S',
								enderdeath.DarkaniteBlock, 'I', enderdeath.EnderiteBlock, 'V',
								enderdeath.DragonCrystal });

		GameRegistry.addRecipe(new ItemStack(enderdeath.EnderiteHelmet, 1),
				new Object[] { "RRR", "R R", "   ", 'R', enderdeath.Enderite });
		GameRegistry.addRecipe(new ItemStack(enderdeath.EnderiteHelmet, 1),
				new Object[] { "   ", "RRR", "R R", 'R', enderdeath.Enderite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.EnderiteChestplate, 1),
				new Object[] { "R R", "RRR", "RRR", 'R', enderdeath.Enderite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.EnderiteLeggings, 1),
				new Object[] { "RRR", "R R", "R R", 'R', enderdeath.Enderite });

		GameRegistry.addRecipe(new ItemStack(enderdeath.EnderiteBoots, 1),
				new Object[] { "   ", "R R", "R R", 'R', enderdeath.Enderite });
		GameRegistry.addRecipe(new ItemStack(enderdeath.EnderiteBoots, 1),
				new Object[] { "R R", "R R", "   ", 'R', enderdeath.Enderite });
		GameRegistry.addRecipe(new ItemStack(enderdeath.speedUpgrade, 1),
				new Object[] { " R ", "RAR", "RAR", 'R', Blocks.iron_block, 'A', Blocks.diamond_block });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Bomber, 1), new Object[] { " S ", "RAR", "RMR", 'A',
				enderdeath.Rubis, 'R', Items.iron_ingot, 'S', Items.string, 'M', enderdeath.Saphir });

		GameRegistry.addRecipe(new ItemStack(enderdeath.DamageBlock, 1),
				new Object[] { "RRR", "RAR", "RRR", 'R', Blocks.netherrack, 'A', enderdeath.Darkanite });

		Cobalt = new ItemClass().setUnlocalizedName("Cobalt").setTextureName(enderdeath.MODID + ":Cobalt")
				.setCreativeTab(CreativeTabs.tabMaterials);

		GameRegistry.registerItem(Cobalt, "Cobalt");

		GameRegistry.addRecipe(new ItemStack(enderdeath.SwordOfStars, 1),
				new Object[] { "RQR", "ASA", " S ", 'R', enderdeath.DarkaniteBlock, 'A', enderdeath.DarkaniteBlock, 'S',
						enderdeath.StickIron, 'Q', enderdeath.EnderHeart });
		GameRegistry.addRecipe(new ItemStack(enderdeath.AntiPiston, 1),
				new Object[] { "R R", " R ", "R R", 'R', Blocks.cobblestone });

		GameRegistry.addRecipe(new ItemStack(enderdeath.alloyer, 1),
				new Object[] { "BIB", "RAR", "BSB", 'R', Blocks.quartz_block, 'B', enderdeath.Enderite, 'S',
						Blocks.redstone_block, 'I', enderdeath.RubisBlock, 'A', enderdeath.DarkaniteBlock });
		GameRegistry.addRecipe(new ItemStack(enderdeath.Pickaxe3x3, 1), new Object[] { "RAR", "RSR", "RSR", 'R',
				Blocks.diamond_block, 'A', enderdeath.RubisBlock, 'S', enderdeath.StickIron });

		GameRegistry.addRecipe(new ItemStack(enderdeath.Cobalt, 1), new Object[] { "RAR", "ASA", "RAR", 'R',
				Blocks.diamond_block, 'A', enderdeath.Saphir, 'S', Blocks.diamond_block });
		Wand = new Wand().setUnlocalizedName("Wand");

		Items.potionitem.setMaxStackSize(6);

		GameRegistry.registerItem(Wand, "Ender_Specter");

		GameRegistry.addRecipe(new ItemStack(enderdeath.DragoniteHelmet, 1),
				new Object[] { "RAR", "R R", "   ", 'R', enderdeath.DragonCrystal,'A',enderdeath.EnderHeart });
		GameRegistry.addRecipe(new ItemStack(enderdeath.DragoniteHelmet, 1),
				new Object[] { "   ", "RAR", "R R", 'R', enderdeath.DragonCrystal,'A',enderdeath.EnderHeart });
	
		GameRegistry.addRecipe(new ItemStack(enderdeath.IronHammer, 1),
				new Object[] { "RFR", "RSR", " S ", 'R', Blocks.iron_block, 'S', Items.stick, 'F', Items.iron_ingot });

		GameRegistry.addRecipe(new ItemStack(enderdeath.DeathArrow, 9),
				new Object[] { "  S", " R ", "R  ", 'R', Items.stick, 'S', enderdeath.BaieBlack });
	

	
				/* Achivement */
				/* Rubis */

		/* Autre */
		GameRegistry.addRecipe(new ItemStack(enderdeath.BaiePlantRainBowItem, 2),
				new Object[] { "RRR", "RSR", "RRR", 'R', enderdeath.Baie, 'S', enderdeath.DragonCrystal });
				/* Saphir */

		/* Lumieterite */
		GameRegistry.addRecipe(new ItemStack(enderdeath.Pickaxe, 1), new Object[] { "RAR", "RSR", "RSR", 'R',
				enderdeath.RubisBlock, 'S', Items.stick, 'A', enderdeath.DarkaniteBlock });
		/* achievement */

		FlyPotion.customEffectID = 30;
		FlyPotion.falleffect = 27;

		PickaxeSpawner = new ToolPickaxe(SpawnerPickaxe).setUnlocalizedName("PickaxeSpawner")
				.setTextureName(enderdeath.MODID + ":PickaxeSpawner").setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.addRecipe(new ItemStack(enderdeath.PickaxeSpawner, 1), new Object[] { "RAR", "RSR", "RSR", 'R',
				enderdeath.Cobalt, 'S', enderdeath.StickIron, 'A', enderdeath.NuggetEnderite });
		GameRegistry.registerItem(PickaxeSpawner, "Pickaxe_Spawner");
		GameRegistry.addRecipe(new ItemStack(enderdeath.machineBaie, 1),
				new Object[] { "ARA", "QSQ", "ARA", 'R', enderdeath.Baie, 'S', enderdeath.StickIron,'Q',Blocks.redstone_block,'A',enderdeath.hulmini });
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
	
		proxy.registerRender();
		System.out.println("init");
		MinecraftForge.EVENT_BUS.register(new EnchantForge());

		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

		if (event.getSide().isClient()) {

			FMLCommonHandler.instance().bus().register(this);
			Minecraft mc = Minecraft.getMinecraft();
			FMLCommonHandler.instance().bus().register(new TickHandler(mc));

		}

		FlyPotion.loadEffects();
		FlyPotion.register();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		EntityRegistry.registerGlobalEntityID(Familiar.class, "Familiar", EntityRegistry.findGlobalUniqueEntityId(),
				new Color(45, 6, 130).getRGB(), new Color(100, 102, 12).getRGB());
		EntityRegistry.registerModEntity(Familiar.class, "Familiar", 450, this.instance, 68, 2, true);

		EntityRegistry.registerGlobalEntityID(DragonRed.class, "DragonRed", EntityRegistry.findGlobalUniqueEntityId(),
				new Color(99, 153, 99).getRGB(), new Color(50, 50, 50).getRGB());
		EntityRegistry.registerModEntity(DragonRed.class, "DragonRed", 440, this.instance, 69, 2, true);
		
	
		
		EntityRegistry.registerModEntity(EntityBoatTnT.class, "EntityBoatTnT", 467, this.instance, 72, 2, false);
		
		EntityRegistry.registerModEntity(BomberEntity.class, "BomberEntity", 428, this.instance, 48, 2, true);

		EntityRegistry.registerModEntity(EntityArrowDeath.class, "EntityArrowDeath", 440, this.instance, 49, 2, true);

		EntityRegistry.registerGlobalEntityID(Goblin.class, "Goblin", EntityRegistry.findGlobalUniqueEntityId(),
				new Color(99, 153, 99).getRGB(), new Color(50, 50, 50).getRGB());
		EntityRegistry.registerModEntity(Goblin.class, "Goblin", 424, this.instance, 40, 2, true);

		EntityRegistry.registerGlobalEntityID(GoblinKing.class, "GoblinKing", EntityRegistry.findGlobalUniqueEntityId(),
				new Color(99, 153, 99).getRGB(), new Color(104, 75, 12).getRGB());
		EntityRegistry.registerModEntity(GoblinKing.class, "GoblinKing", 425, this.instance, 44, 2, true);

		EntityRegistry.registerGlobalEntityID(WolfNether.class, "WolfNether", EntityRegistry.findGlobalUniqueEntityId(),
				new Color(46, 102, 1).getRGB(), new Color(46, 2, 106).getRGB());
		EntityRegistry.registerModEntity(WolfNether.class, "WolfNether", 426, this.instance, 46, 2, true);

		EntityRegistry.registerGlobalEntityID(KCreeper.class, "KCreeper", EntityRegistry.findGlobalUniqueEntityId(),
				new Color(164, 122, 121).getRGB(), new Color(6, 17, 22).getRGB());
		EntityRegistry.registerModEntity(KCreeper.class, "KCreeper", 429, this.instance, 50, 2, true);

		EntityRegistry.registerGlobalEntityID(EntityCreeperBoss.class, "EntityCreeperBoss",
				EntityRegistry.findGlobalUniqueEntityId(), new Color(164, 122, 121).getRGB(),
				new Color(6, 17, 22).getRGB());
		EntityRegistry.registerModEntity(EntityCreeperBoss.class, "EntityCreeperBoss", 433, this.instance, 51, 2, true);

		EntityRegistry.registerGlobalEntityID(KingHeal.class, "KingHeal", EntityRegistry.findGlobalUniqueEntityId(),
				new Color(151, 123, 12).getRGB(), new Color(12, 45, 78).getRGB());
		EntityRegistry.registerModEntity(KingHeal.class, "KingHeal", 422, this.instance, 45, 2, true);

		EntityRegistry.addSpawn(Goblin.class, 80, 2, 10, EnumCreatureType.monster, biomes);
		EntityRegistry.addSpawn(EntityGiantZombie.class, 53, 2, 100, EnumCreatureType.monster, biomes);
		MinecraftForge.addGrassSeed(new ItemStack(enderdeath.BaiePlantItem), 10);
		MinecraftForge.addGrassSeed(new ItemStack(enderdeath.BaiePlantFireItem), 10);
		MinecraftForge.addGrassSeed(new ItemStack(enderdeath.BaiePlantGreenItem), 10);
		MinecraftForge.addGrassSeed(new ItemStack(enderdeath.BaiePlantItemWater), 10);
		MinecraftForge.addGrassSeed(new ItemStack(enderdeath.BaiePlantYellowItem), 10);
		

	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onTickClient(TickEvent.ClientTickEvent event) {
		if (event.phase == Phase.START) {
			Minecraft mc = Minecraft.getMinecraft();
			GuiScreen currentScreen = mc.currentScreen;
			GuiCustomMenu customMenu = new GuiCustomMenu();

			if (currentScreen instanceof GuiMainMenu && !currentScreen.equals(customMenu)) {
				mc.displayGuiScreen(customMenu);
			}

		}
	}


}
