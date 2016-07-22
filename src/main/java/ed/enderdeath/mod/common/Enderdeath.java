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
import ed.enderdeath.mod.anvildragon.BlockAnvilDragon;
import ed.enderdeath.mod.armor.DarkaniteArmor;
import ed.enderdeath.mod.armor.DragoniteArmor;
import ed.enderdeath.mod.armor.EnderiteArmor;
import ed.enderdeath.mod.armor.RoyaliteArmor;
import ed.enderdeath.mod.armor.RubisArmor;
import ed.enderdeath.mod.armor.SaphirArmor;
import ed.enderdeath.mod.baiemachine.MachineBaie;
import ed.enderdeath.mod.baiemachine.TileEntityMachineTuto;
import ed.enderdeath.mod.block.AntiPiston;
import ed.enderdeath.mod.block.BaieCake;
import ed.enderdeath.mod.block.BaiePlant;
import ed.enderdeath.mod.block.BaiePlantFire;
import ed.enderdeath.mod.block.BaiePlantGreen;
import ed.enderdeath.mod.block.BaiePlantRainBow;
import ed.enderdeath.mod.block.BaiePlantWater;
import ed.enderdeath.mod.block.BaiePlantYellow;
import ed.enderdeath.mod.block.BlockInvisible;
import ed.enderdeath.mod.block.BlockOre;
import ed.enderdeath.mod.block.BlockerMiner;
import ed.enderdeath.mod.block.Box;
import ed.enderdeath.mod.block.BoxKey;
import ed.enderdeath.mod.block.BrickStonarck;
import ed.enderdeath.mod.block.DamageBlock;
import ed.enderdeath.mod.block.DarkaniteNetherack;
import ed.enderdeath.mod.block.DragonCrystalOre;
import ed.enderdeath.mod.block.Dragoneyes;
import ed.enderdeath.mod.block.EggDragonRed;
import ed.enderdeath.mod.block.EnderiteOre;
import ed.enderdeath.mod.block.HulminiOre;
import ed.enderdeath.mod.block.IronFence;
import ed.enderdeath.mod.block.JumpBlock;
import ed.enderdeath.mod.block.MegaSpawner;
import ed.enderdeath.mod.block.NaturalBox;
import ed.enderdeath.mod.block.ObsiRenforced;
import ed.enderdeath.mod.block.RoyaliteOre;
import ed.enderdeath.mod.block.RubisOre;
import ed.enderdeath.mod.block.SaphirOre;
import ed.enderdeath.mod.block.SlowBlock;
import ed.enderdeath.mod.block.SpeedBlock;
import ed.enderdeath.mod.block.TileEntityMega;
import ed.enderdeath.mod.block.UltimeBox;
import ed.enderdeath.mod.block.XpOre;
import ed.enderdeath.mod.block.testBlock;
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
import ed.enderdeath.mod.event.EnchantForge;
import ed.enderdeath.mod.event.TickHandler;
import ed.enderdeath.mod.extractor.Alloyer;
import ed.enderdeath.mod.extractor.TileEntityAlloyer;
import ed.enderdeath.mod.food.Baie;
import ed.enderdeath.mod.food.BaieBlack;
import ed.enderdeath.mod.food.BaieBlue;
import ed.enderdeath.mod.food.BaieChocolate;
import ed.enderdeath.mod.food.BaieGreen;
import ed.enderdeath.mod.food.BaieHeal;
import ed.enderdeath.mod.food.BaieOfRainbow;
import ed.enderdeath.mod.food.BaieOrange;
import ed.enderdeath.mod.food.BaiePink;
import ed.enderdeath.mod.food.BaieRed;
import ed.enderdeath.mod.food.BaieResistance;
import ed.enderdeath.mod.food.BaieSpeed;
import ed.enderdeath.mod.food.BaieWhite;
import ed.enderdeath.mod.food.BaieYellow;
import ed.enderdeath.mod.food.BotleHaste;
import ed.enderdeath.mod.food.PotionFly;
import ed.enderdeath.mod.item.BaieSeedRainbow;
import ed.enderdeath.mod.item.BoatTnt;
import ed.enderdeath.mod.item.Bomber;
import ed.enderdeath.mod.item.Croquette;
import ed.enderdeath.mod.item.FattingXp;
import ed.enderdeath.mod.item.FlyPotion;
import ed.enderdeath.mod.item.ItemClass;
import ed.enderdeath.mod.item.ItemEnchantmentTest;
import ed.enderdeath.mod.item.MegaEnder;
import ed.enderdeath.mod.item.OrbBlue;
import ed.enderdeath.mod.item.OrbGreen;
import ed.enderdeath.mod.item.OrbRed;
import ed.enderdeath.mod.item.OrbYellow;
import ed.enderdeath.mod.item.PotionFall;
import ed.enderdeath.mod.item.RareItem;
import ed.enderdeath.mod.item.SpeedUpgrade;
import ed.enderdeath.mod.item.StickHeal;
import ed.enderdeath.mod.item.StickJolo;
import ed.enderdeath.mod.item.StickJump;
import ed.enderdeath.mod.item.StickSpeed;
import ed.enderdeath.mod.item.Wand;
import ed.enderdeath.mod.item.WitherBow;
import ed.enderdeath.mod.proxy.CommonProxy;
import ed.enderdeath.mod.secret.Maxitomate;
import ed.enderdeath.mod.tool.Axe;
import ed.enderdeath.mod.tool.BowGreetWood;
import ed.enderdeath.mod.tool.IronHammer;
import ed.enderdeath.mod.tool.Pickaxe;
import ed.enderdeath.mod.tool.Pickaxe3x3;
import ed.enderdeath.mod.tool.SwordSkin;
import ed.enderdeath.mod.tool.SwordStars;
import ed.enderdeath.mod.tool.UltimateSword;
import ed.enderdeath.mod.tool.toolBase.ToolAxe;
import ed.enderdeath.mod.tool.toolBase.ToolHoe;
import ed.enderdeath.mod.tool.toolBase.ToolPickaxe;
import ed.enderdeath.mod.tool.toolBase.ToolShovel;
import ed.enderdeath.mod.tool.toolBase.ToolSword;
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
public class Enderdeath
{

    @Instance("enderdeath")
    public static Enderdeath instance;

    public static final String MODID = "enderdeath";
    public static final String version = "1.0.6";
    @SidedProxy(clientSide = "ed.enderdeath.mod.proxy.ClientProxy", serverSide = "ed.enderdeath.mod.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static final String TEXTURE_NAME = MODID + ":";

    public static Item witherBow;

    /* Material armure */

    public static ToolMaterial rubisTool = EnumHelper.addToolMaterial("RubisTool", 4, 1650, 11.5F, 4, 8);
    public static ToolMaterial saphirTool = EnumHelper.addToolMaterial("SaphirTool", 5, 1750, 13.5F, (float)4.5, 7);
    public static ToolMaterial obsidienTool = EnumHelper.addToolMaterial("ObsidienTool", 3, 3000, 10F, (float)3.5, 15);
    public static ToolMaterial royaliteTool = EnumHelper.addToolMaterial("RoyaliteTool", 6, 1850, 15.5F, 5, 6);
    public static ToolMaterial darkaniteTool = EnumHelper.addToolMaterial("DarkaniteTool", 6, 1950, 19.5F, (float)5.5, 5);

    public static ToolMaterial spawnerPickaxe = EnumHelper.addToolMaterial("SpawnerPickaxe", 1, 1, 15.5F, 6, 15);

    public static ToolMaterial enderiteTool = EnumHelper.addToolMaterial("EnderiteTool", 6, 2500, 25.5F, 6, 4);
    public static ArmorMaterial rubisArmor = EnumHelper.addArmorMaterial("RubisArmor", 45, new int[] {3, 7, 6, 3}, 9);
    public static ArmorMaterial saphirArmor = EnumHelper.addArmorMaterial("SaphirArmor", 50, new int[] {4, 8, 7, 4}, 25);

    public static ToolMaterial hammer = EnumHelper.addToolMaterial("Hammer", 4, 1650, 11.5F, 1, 8);
    public static ArmorMaterial royaliteArmor = EnumHelper.addArmorMaterial("RoyaliteArmor", 55, new int[] {4, 8, 7, 5}, 10);
    public static ArmorMaterial darkaniteArmor = EnumHelper.addArmorMaterial("DarkaniteArmor", 65, new int[] {4, 9, 7, 5}, 35);

    public static ArmorMaterial enderiteArmor = EnumHelper.addArmorMaterial("EnderiteArmor", 85, new int[] {4, 10, 7, 6}, 100);
    public static ArmorMaterial dragoniteArmor = EnumHelper.addArmorMaterial("DragoniteArmor", -2, new int[] {12, 1, 1, 1}, 500);

    public static ToolMaterial pickaxe = EnumHelper.addToolMaterial("pickaxe", 7, (int)0.2500, 1000F, 1, 7);
    public static ToolMaterial aSwordStars = EnumHelper.addToolMaterial("ASwordStars", 7, (int)0.2500, 825F, 7, 7);
    public static ToolMaterial bSwordStars = EnumHelper.addToolMaterial("BSwordStars", 7, (int)0.2500, 825F, 8, 7);

    public static Item dragoniteHelmet;

    /* Material */
    public static Item stickIron;
    public static Item rubis;
    public static Item saphir;
    public static Item hulmini;
    public static Item royalite;
    public static Item darkanite;

    public static Item nuggetDarkanite;
    public static Item enderite;

    public static Item nuggetEnderite;

    public static Block blockMiner;
    public static Item enderHeart;
    public static Item pickaxeSpawner;
    public static Block dragonCrystalOre;
    public static Item pickaxe3x3Item;
    /* Ugrade */
    public static Item ugradeSpeed;
    public static Item ugradeDamage;
    public static Item ugradeFire;
    public static Item ugradeFortune;
    public static Item ugradeSmelt;
    public static Item ugradedoubledamage;
    /* Rubis Tool */
    public static Item pickaxeRubis;
    public static Item axeRubis;
    public static Item shovelRubis;
    public static Item hoeRubis;
    public static Item rubisSword;
    public static Item ironHammer;
    /* Pckaxe3x3 */
    public static Item pickaxe3x3;
    /* SaphirTool */
    public static Item pickaxeSaphir;
    public static Item axeSaphir;
    public static Item shovelSaphir;
    public static Item hoeSaphir;
    public static Item swordSaphir;
    /* Secret Saison */
    public static Item maxitomate;
    /* Royalite */
    public static Item pickaxeRoyalite;
    public static Item axeRoyalite;
    public static Item shovelRoyalite;
    public static Item hoeRoyalite;
    public static Item swordRoyalite;
    /* RoyaliteArmor */
    public static Item royaliteHelmet;
    public static Item royaliteChestplate;
    public static Item royaliteLeggings;
    public static Item royaliteBoots;

    /* DefenseBlock */
    public static Block renforcedSandAndGravel;
    public static Block deadAirBlock;

    /* darkanite */
    public static Item pickaxeDarkanite;
    public static Item axeDarkanite;
    public static Item shovelDarkanite;
    public static Item hoeDarkanite;
    public static Item swordDarkanite;
    /* DarkaniteArmor */
    public static Item darkaniteHelmet;
    public static Item darkaniteChestplate;
    public static Item darkaniteLeggings;
    public static Item darkaniteBoots;
    public static Item megaEnder;
    /* EnderiteTool */
    public static Item pickaxeEnderite;
    public static Item axeEnderite;
    public static Item shovelEnderite;
    public static Item hoeEnderite;
    public static Item swordEnderite;
    /* RubisArmor */
    public static Item rubisHelmet;
    public static Item rubisChestplate;
    public static Item rubisLeggings;
    public static Item rubisBoot;
    /* SaphirArmor */
    public static Item saphirHelmet;
    public static Item saphirChestplate;
    public static Item saphirLeggings;
    public static Item saphirBoot;
    public static Block dragoneyes;

    /**/
    /* Test */
    public static Item itemEnchantmentTest;

    public static Block damageBlock;
    public static Item dragonCrystal;
    /* EnderiteArmor */
    public static Item enderiteHelmet;
    public static Item enderiteChestplate;
    public static Item enderiteLeggings;
    public static Item enderiteBoots;
    public static Block mega;
    /* IngotNetherStars */

    /* Block */
    /* Personnilation sword */
    public static Item rubisSwordA;
    public static Item saphirSwordA;
    public static Item royaliteSwordA;
    public static Item darkaniteSwordA;
    public static Item enderiteSwordA;
    /* Ore */
    public static Block rubisOre;
    public static Block saphirOre;
    public static Block hulminiOre;
    public static Block royaliteOre;
    public static Block darkaniteNetherack;
    public static Block enderiteOre;
    /* Chateau block */
    public static Block box;
    /* Block ore */
    public static Block rubisBlock;
    public static Block saphirBlock;
    public static Block royaliteBlock;
    public static Block darkaniteBlock;
    public static Block obsiRenforced;
    public static Block enderiteBlock;
    /* Box */
    public static Block deathBox;
    public static Item deathKey;
    public static Item naturalKey;
    public static Block naturalBox;
    public static Item ultimeKey;
    public static Block ultimeBox;
    /* Extractor */
    public static Block alloyer;
    public static Item speedUpgrade;
    /* Food */
    public static Item banana;
    /* Achievement */

    /* Block admin */
    public static Block blockInvisible;
    public static Item invisibleBlock;
    /* Block F/M */
    public static Block speedBlock;
    public static Block jumpBlock;
    public static Block speedAdmin;
    public static Block jumpAdmin;

    public static Block antiPiston;
    public static Block ironFence;
    /* Legendary */

    public static Item swordF;
    public static Item swordFire;
    public static Item featherHelmet;

    public static Item featherLeggings;
    public static Item featherBoot;
    public static Item boneSacred;
    public static Item spectral;
    public static Block testBlock;
    public static Item axePlant;

    public static Item dirtShovel;
    public static Item pickaxeItem;
    public static Item swordOfStars;
    public static Item swordStars;
    public static Item swordStarsA;
    public static Item swordStarsB;
    public static Item wand;

    /* Vanilla */
    public static Block obsidienBlock;
    /* Autre */
    public static Block tnTMeeb;
    /* Enchant */
    public static Enchantment enchantTest;
    public static Enchantment slowness;
    public static Enchantment starsPower;
    public static Enchantment fight;
    /* Official */
    public static Item axe;
    /* Faction */
    public static Item cobalt;
    public static Block megaSpawner;
    /* Vanilla */
    /* Bottle */
    public static ItemFood bottleHaste;

    /* Robber */

    /* Arica */
    public static Block brickStonarck;
    public static Item bowGreetWood;
    public static Item deathArrow;
    /* Autre */

    /* Familiar */
    public static Item goldenCroquette;
    public static Item rubisCroquette;
    public static Item saphirCroquette;

    public static Item rainbownCroquette;
    public static Item skinFire;
    public static Item skinBlue;
    public static Item skinDirt;
    public static Item skinEnder;
    /* MystaryDoor */

    /* Baie */
    public static Item baie;
    public static Item baieRed;
    public static Item baieGreen;
    public static Item baieBlue;
    public static Item baieYellow;
    public static Item baieOfChocolate;
    public static Item baieOfRainbow;
    public static Block baieCake;
    public static Item pieceBaieRainbow;
    public static Item baiePink;
    public static Item baieOrange;
    public static Item baieWhite;
    public static Item baieBlack;
    public static Item baieHeal;
    public static Item baieSpeed;
    public static Item baieResistance;
    public static Item potionFly;
    public static Item potionFall;
    public static BiomeGenBase[] biomes = new BiomeGenBase[] {BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.beach, BiomeGenBase.desert,

            BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.icePlains, BiomeGenBase.iceMountains, BiomeGenBase.river, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.deepOcean, BiomeGenBase.extremeHillsPlus, BiomeGenBase.jungleEdge, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach};
    /* PlantBaie */
    public static Block baiePlant;
    public static Block baiePlantWater;
    public static Block baiePlantFire;
    public static Block baiePlantGreen;
    public static Block baiePlantYellow;
    public static Block baiePlantRainBow;
    public static Block baiePlantXp;
    /* BaiePlant Item */
    public static Item baiePlantItem;
    public static Item baiePlantItemWater;
    public static Item baiePlantFireItem;
    public static Item baiePlantGreenItem;
    public static Item baiePlantYellowItem;
    public static Item baiePlantRainBowItem;
    public static Item baieSeedRainbow;
    /* DragonRed */
    public static Block dragonEggRed;
    public static Item boatTnt;
    /* autre */
    public static Item featherChestplate;
    /* Magic */
    public static Item sitckJolo;
    public static Item stickHeal;
    public static Item stickSpeed;
    public static Item stickJump;
    public static Item orbRed;
    public static Item orbBlue;
    public static Item orbYellow;

    public static Item stickStrenght;
    public static Item bomber;
    public static Block machineBaie;
    /* Xp */
    public static Item fattingXp;
    public static Block xpOre;
    /* Shield */
    public static Block slowBlock;
    public static AchievementPage enderAchivement;

    private static Item greatNuggetEnderite;

    public static OrbGreen orbGreen;

    public static BlockAnvilDragon blockAnvilDragon;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println("preInit");
        /* Hub */

        enderHeart = new RareItem().setUnlocalizedName("EnderHeart").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Enderdeath.MODID + ":EnderHeart");

        GameRegistry.registerItem(enderHeart, "Ender_Titan_Heart");

        /* Material */

        rubis = new ItemClass().setUnlocalizedName("Rubis").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Enderdeath.MODID + ":Rubis");

        saphir = new ItemClass().setUnlocalizedName("Saphir").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Enderdeath.MODID + ":Saphir");

        hulmini = new ItemClass().setUnlocalizedName("hulmini").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Enderdeath.MODID + ":testItem");

        royalite = new ItemClass().setUnlocalizedName("Royalite").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Enderdeath.MODID + ":Royalite");

        potionFly = new PotionFly(0, 0, false).setMaxStackSize(1);

        potionFall = new PotionFall(0, 0, false).setMaxStackSize(1);

        GameRegistry.registerItem(potionFly, "PotionFly");

        GameRegistry.registerItem(potionFall, "PotionFall");

        darkanite = new ItemClass().setUnlocalizedName("Darkanite").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Enderdeath.MODID + ":Darkanite");

        nuggetDarkanite = new ItemClass().setUnlocalizedName("NuggetDarkanite").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Enderdeath.MODID + ":NuggetDarkanite");

        GameRegistry.registerItem(darkanite, "Darkanite");

        GameRegistry.registerItem(rubis, "Rubis");

        GameRegistry.registerItem(saphir, "Saphir");

        GameRegistry.registerItem(hulmini, "hulmini");

        GameRegistry.registerItem(royalite, "Royalite");

        GameRegistry.registerItem(nuggetDarkanite, "Nugget_Darkanite");

        /* Test */
        itemEnchantmentTest = new ItemEnchantmentTest();

        GameRegistry.registerItem(itemEnchantmentTest, "logo");

        box = new Box();

        dragoneyes = new Dragoneyes(Material.rock);

        GameRegistry.registerBlock(dragoneyes, "Dragoneyes");
        GameRegistry.registerBlock(box, "Box");
        Items.boat.setMaxStackSize(16);
        Items.iron_door.setMaxStackSize(16);
        Items.wooden_door.setMaxStackSize(16);

        Items.minecart.setMaxStackSize(16);
        Items.tnt_minecart.setMaxStackSize(12);
        Items.golden_apple.setMaxStackSize(16);

        /* Pickaxe3 */
        pickaxe3x3 = new Pickaxe3x3(enderiteTool, 100.0F).setUnlocalizedName("Pickaxe3x3").setTextureName(Enderdeath.MODID + ":Pickaxe3x3");

        GameRegistry.registerItem(pickaxe3x3, "Pickaxe3x3");

        /* Block */
        rubisBlock = new BlockOre().setBlockName("RubisBlock").setBlockTextureName(Enderdeath.MODID + ":RubisBlock");
        saphirBlock = new BlockOre().setBlockName("SaphirBlock").setBlockTextureName(Enderdeath.MODID + ":SaphirBlock");
        royaliteBlock = new BlockOre().setBlockName("RoyaliteBlock").setBlockTextureName(Enderdeath.MODID + ":RoyaliteBlock");
        darkaniteBlock = new BlockOre().setBlockName("DarkaniteBlock").setBlockTextureName(Enderdeath.MODID + ":DarkaniteBlock");

        obsiRenforced = new ObsiRenforced();
        blockMiner = new BlockerMiner();

        boatTnt = new BoatTnt();

        GameRegistry.registerItem(boatTnt, "BoatTnt");
        GameRegistry.registerBlock(blockMiner, "Block_Miner");
        GameRegistry.registerBlock(obsiRenforced, "Obsidien_Renforced");
        GameRegistry.registerBlock(darkaniteBlock, "Darkanite_Block");
        GameRegistry.registerBlock(royaliteBlock, "Royalite_Block");
        GameRegistry.registerBlock(rubisBlock, "Rubis_Block");
        GameRegistry.registerBlock(saphirBlock, "Saphir_Block");
        /* Mysrary */
        maxitomate = new Maxitomate(100, 100, true);

        GameRegistry.registerItem(maxitomate, "Maxitomate");
        /* Rubis Tool */
        pickaxeRubis = new ToolPickaxe(rubisTool).setUnlocalizedName("RubisPickaxe").setTextureName(Enderdeath.MODID + ":RubisPickaxe").setCreativeTab(CreativeTabs.tabTools);

        axeRubis = new ToolAxe(rubisTool).setUnlocalizedName("RubisAxe").setTextureName(Enderdeath.MODID + ":RubisAxe").setCreativeTab(CreativeTabs.tabTools);

        shovelRubis = new ToolShovel(rubisTool).setUnlocalizedName("RubisShovel").setTextureName(Enderdeath.MODID + ":RubisShovel").setCreativeTab(CreativeTabs.tabTools);

        hoeRubis = new ToolHoe(rubisTool).setUnlocalizedName("RubisHoe").setTextureName(Enderdeath.MODID + ":RubisHoe").setCreativeTab(CreativeTabs.tabTools);

        rubisSword = new ToolSword(rubisTool).setUnlocalizedName("RubisSword").setTextureName(Enderdeath.MODID + ":RubisSword").setCreativeTab(CreativeTabs.tabCombat);
        rubisSwordA = new SwordSkin(rubisTool).setUnlocalizedName("RubisSword").setTextureName(Enderdeath.MODID + ":RubisSwordA").setCreativeTab(CreativeTabs.tabCombat).setMaxDamage(4000);

        royaliteSwordA = new SwordSkin(royaliteTool).setUnlocalizedName("SwordRoyalite").setTextureName(Enderdeath.MODID + ":ARoyaliteSword").setCreativeTab(CreativeTabs.tabCombat).setMaxDamage(5000);
        darkaniteSwordA = new SwordSkin(darkaniteTool).setUnlocalizedName("SwordDarkanite").setTextureName(Enderdeath.MODID + ":ADarkaniteSword").setCreativeTab(CreativeTabs.tabCombat).setMaxDamage(5000);

        enderiteSwordA = new SwordSkin(enderiteTool).setUnlocalizedName("SwordEnderite").setTextureName(Enderdeath.MODID + ":ASwordEnderite").setCreativeTab(CreativeTabs.tabCombat).setMaxDamage(5000);

        GameRegistry.registerItem(darkaniteSwordA, "Volcanite_Sword_Skin");

        GameRegistry.registerItem(enderiteSwordA, "Enderite_Sword_Skin");

        GameRegistry.registerItem(rubisSwordA, "Rubis_Sword_Skin");

        GameRegistry.registerItem(royaliteSwordA, "Amethyse_Sword_Skin");

        GameRegistry.registerItem(pickaxeRubis, "Pickaxe_Rubis");

        GameRegistry.registerItem(axeRubis, "Axe_Rubis");

        GameRegistry.registerItem(shovelRubis, "Shovel_Rubis");

        GameRegistry.registerItem(hoeRubis, "Hoe_Rubis");

        GameRegistry.registerItem(rubisSword, "Sword_Rubis");

        GameRegistry.addRecipe(new ItemStack(Enderdeath.pickaxeRubis, 1), new Object[] {"RRR", " S ", " S ", 'R', Enderdeath.rubis, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.axeRubis, 1), new Object[] {" RR", " SR", " S ", 'R', Enderdeath.rubis, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.axeRubis, 1), new Object[] {"RR ", "RS ", " S ", 'R', Enderdeath.rubis, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelRubis, 1), new Object[] {" R ", " S ", " S ", 'R', Enderdeath.rubis, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelRubis, 1), new Object[] {"R  ", "S  ", "S  ", 'R', Enderdeath.rubis, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelRubis, 1), new Object[] {"  R", "  S", "  S", 'R', Enderdeath.rubis, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hoeRubis, 1), new Object[] {" RR", " S ", " S ", 'R', Enderdeath.rubis, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.hoeRubis, 1), new Object[] {"RR ", " S ", " S ", 'R', Enderdeath.rubis, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubisSword, 1), new Object[] {" R ", " R ", " S ", 'R', Enderdeath.rubis, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubisSword, 1), new Object[] {"R  ", "R  ", "S  ", 'R', Enderdeath.rubis, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubisSword, 1), new Object[] {"  R", "  R", "  S", 'R', Enderdeath.rubis, 'S', Items.stick});
        /* ArmorRubis */
        rubisHelmet = new RubisArmor(rubisArmor, 0).setUnlocalizedName("RubisHelmet").setUnlocalizedName("RubisHelmet").setTextureName(Enderdeath.MODID + ":RubisHelmet").setCreativeTab(CreativeTabs.tabCombat);

        rubisChestplate = new RubisArmor(rubisArmor, 1).setUnlocalizedName("RubisChestplate").setUnlocalizedName("RubisChestplate").setTextureName(Enderdeath.MODID + ":RubisChestplate").setCreativeTab(CreativeTabs.tabCombat);

        rubisLeggings = new RubisArmor(rubisArmor, 2).setUnlocalizedName("RubisLeggings").setUnlocalizedName("RubisLeggings").setTextureName(Enderdeath.MODID + ":RubisLeggings").setCreativeTab(CreativeTabs.tabCombat);

        rubisBoot = new RubisArmor(rubisArmor, 3).setUnlocalizedName("RubisBoot").setUnlocalizedName("RubisBoot").setTextureName(Enderdeath.MODID + ":RubisBoot").setCreativeTab(CreativeTabs.tabCombat);

        GameRegistry.registerItem(rubisHelmet, "Rubis_Helmet");

        GameRegistry.registerItem(rubisChestplate, "Rubis_Chestplate");

        GameRegistry.registerItem(rubisLeggings, "Rubis_Leggings");

        GameRegistry.registerItem(rubisBoot, "Rubis_Boot");

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubisHelmet, 1), new Object[] {"RRR", "R R", "   ", 'R', Enderdeath.rubis});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubisHelmet, 1), new Object[] {"   ", "RRR", "R R", 'R', Enderdeath.rubis});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubisChestplate, 1), new Object[] {"R R", "RRR", "RRR", 'R', Enderdeath.rubis});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubisLeggings, 1), new Object[] {"RRR", "R R", "R R", 'R', Enderdeath.rubis});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubisBoot, 1), new Object[] {"   ", "R R", "R R", 'R', Enderdeath.rubis});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubisBoot, 1), new Object[] {"R R", "R R", "   ", 'R', Enderdeath.rubis});

        /* Tool Obsi */

        ;
        /* Material Boss */
        boneSacred = new RareItem().setUnlocalizedName("BoneSacred").setTextureName(Enderdeath.MODID + ":BoneSacred").setCreativeTab(CreativeTabs.tabMaterials);

        GameRegistry.registerItem(boneSacred, "Bone_Sacred");
        /* Tool Saphir */
        pickaxeSaphir = new ToolPickaxe(saphirTool).setUnlocalizedName("PickaxeSaphir").setTextureName(Enderdeath.MODID + ":PickaxeSaphir").setCreativeTab(CreativeTabs.tabTools);

        axeSaphir = new ToolAxe(saphirTool).setUnlocalizedName("AxeSaphir").setTextureName(Enderdeath.MODID + ":AxeSaphir").setCreativeTab(CreativeTabs.tabTools);

        shovelSaphir = new ToolShovel(saphirTool).setUnlocalizedName("ShovelSaphir").setTextureName(Enderdeath.MODID + ":ShovelSaphir").setCreativeTab(CreativeTabs.tabTools);

        hoeSaphir = new ToolHoe(saphirTool).setUnlocalizedName("HoeSaphir").setTextureName(Enderdeath.MODID + ":HoeSaphir").setCreativeTab(CreativeTabs.tabTools);

        swordSaphir = new ToolSword(saphirTool).setUnlocalizedName("SwordSaphir").setTextureName(Enderdeath.MODID + ":SwordSaphir").setCreativeTab(CreativeTabs.tabCombat);
        saphirSwordA = new SwordSkin(saphirTool).setUnlocalizedName("SwordSaphir").setTextureName(Enderdeath.MODID + ":ASwordSaphir").setCreativeTab(CreativeTabs.tabCombat).setMaxDamage(4500);;

        GameRegistry.registerItem(saphirSwordA, "Sword_Saphir_Skin");

        GameRegistry.registerItem(pickaxeSaphir, "Pickaxe_Saphir");

        GameRegistry.registerItem(axeSaphir, "Axe_Saphir");

        GameRegistry.registerItem(shovelSaphir, "Shovel_Saphir");

        GameRegistry.registerItem(hoeSaphir, "Hoe_Saphir");

        GameRegistry.registerItem(swordSaphir, "Sword_Saphir");
        GameRegistry.addRecipe(new ItemStack(Enderdeath.pickaxeSaphir, 1), new Object[] {"RRR", " S ", " S ", 'R', Enderdeath.saphir, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.axeSaphir, 1), new Object[] {" RR", " SR", " S ", 'R', Enderdeath.saphir, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.axeSaphir, 1), new Object[] {"RR ", "RS ", " S ", 'R', Enderdeath.saphir, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelSaphir, 1), new Object[] {" R ", " S ", " S ", 'R', Enderdeath.saphir, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelSaphir, 1), new Object[] {"R  ", "S  ", "S  ", 'R', Enderdeath.saphir, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelSaphir, 1), new Object[] {"  R", "  S", "  S", 'R', Enderdeath.saphir, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hoeSaphir, 1), new Object[] {" RR", " S ", " S ", 'R', Enderdeath.saphir, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.hoeSaphir, 1), new Object[] {"RR ", " S ", " S ", 'R', Enderdeath.saphir, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordSaphir, 1), new Object[] {" R ", " R ", " S ", 'R', Enderdeath.saphir, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordSaphir, 1), new Object[] {"R  ", "R  ", "S  ", 'R', Enderdeath.saphir, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordSaphir, 1), new Object[] {"  R", "  R", "  S", 'R', Enderdeath.saphir, 'S', Items.stick});
        /* Armor Saphir */
        saphirHelmet = new SaphirArmor(saphirArmor, 0).setUnlocalizedName("SaphirHelmet").setTextureName(Enderdeath.MODID + ":SaphirHelmet").setCreativeTab(CreativeTabs.tabCombat);

        saphirChestplate = new SaphirArmor(saphirArmor, 1).setUnlocalizedName("SaphirChestplate").setTextureName(Enderdeath.MODID + ":SaphirChestplate").setCreativeTab(CreativeTabs.tabCombat);

        saphirLeggings = new SaphirArmor(saphirArmor, 2).setUnlocalizedName("SaphirLeggings").setTextureName(Enderdeath.MODID + ":SaphirLeggings").setCreativeTab(CreativeTabs.tabCombat);

        saphirBoot = new SaphirArmor(saphirArmor, 3).setUnlocalizedName("SaphirBoots").setTextureName(Enderdeath.MODID + ":SaphirBoots").setCreativeTab(CreativeTabs.tabCombat);

        GameRegistry.registerItem(saphirHelmet, "Saphir_Helmet");

        GameRegistry.registerItem(saphirChestplate, "Saphir_Chestplate");

        GameRegistry.registerItem(saphirLeggings, "Saphir_Leggings");

        GameRegistry.registerItem(saphirBoot, "Saphir_Boots");
        /* SaphirArmor */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphirHelmet, 1), new Object[] {"RRR", "R R", "   ", 'R', Enderdeath.saphir});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphirHelmet, 1), new Object[] {"   ", "RRR", "R R", 'R', Enderdeath.saphir});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphirChestplate, 1), new Object[] {"R R", "RRR", "RRR", 'R', Enderdeath.saphir});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphirLeggings, 1), new Object[] {"RRR", "R R", "R R", 'R', Enderdeath.saphir});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphirBoot, 1), new Object[] {"   ", "R R", "R R", 'R', Enderdeath.saphir});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphirBoot, 1), new Object[] {"R R", "R R", "   ", 'R', Enderdeath.saphir});
        /* Official */
        axe = new Axe(enderiteTool);

        GameRegistry.registerItem(axe, "Wood_Axe");
        /* Royalite */
        pickaxeRoyalite = new ToolPickaxe(royaliteTool).setUnlocalizedName("PickaxeRoyalite").setTextureName(Enderdeath.MODID + ":RoyalitePickaxe").setCreativeTab(CreativeTabs.tabTools);

        axeRoyalite = new ToolAxe(royaliteTool).setUnlocalizedName("AxeRoyalite").setTextureName(Enderdeath.MODID + ":RoyaliteAxe").setCreativeTab(CreativeTabs.tabTools);

        shovelRoyalite = new ToolShovel(royaliteTool).setUnlocalizedName("ShovelRoyalite").setTextureName(Enderdeath.MODID + ":RoyaliteShovel").setCreativeTab(CreativeTabs.tabTools);

        hoeRoyalite = new ToolHoe(royaliteTool).setUnlocalizedName("HoeRoyalite").setTextureName(Enderdeath.MODID + ":RoyaliteHoe").setCreativeTab(CreativeTabs.tabTools);

        swordRoyalite = new ToolSword(royaliteTool).setUnlocalizedName("SwordRoyalite").setTextureName(Enderdeath.MODID + ":RoyaliteSword").setCreativeTab(CreativeTabs.tabCombat);

        GameRegistry.registerItem(pickaxeRoyalite, "Royalite_Pickaxe");

        GameRegistry.registerItem(axeRoyalite, "Royalite_Axe");

        GameRegistry.registerItem(shovelRoyalite, "Royalite_Shovel");

        GameRegistry.registerItem(hoeRoyalite, "Royalite_Hoe");

        GameRegistry.registerItem(swordRoyalite, "Royalite_Sword");

        GameRegistry.addRecipe(new ItemStack(Enderdeath.pickaxeRoyalite, 1), new Object[] {"RRR", " S ", " S ", 'R', Enderdeath.royalite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.axeRoyalite, 1), new Object[] {" RR", " SR", " S ", 'R', Enderdeath.royalite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.axeRoyalite, 1), new Object[] {"RR ", "RS ", " S ", 'R', Enderdeath.royalite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelRoyalite, 1), new Object[] {" R ", " S ", " S ", 'R', Enderdeath.royalite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelRoyalite, 1), new Object[] {"R  ", "S  ", "S  ", 'R', Enderdeath.royalite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelRoyalite, 1), new Object[] {"  R", "  S", "  S", 'R', Enderdeath.royalite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hoeRoyalite, 1), new Object[] {" RR", " S ", " S ", 'R', Enderdeath.royalite, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.hoeRoyalite, 1), new Object[] {"RR ", " S ", " S ", 'R', Enderdeath.royalite, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordRoyalite, 1), new Object[] {" R ", " R ", " S ", 'R', Enderdeath.royalite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordRoyalite, 1), new Object[] {"R  ", "R  ", "S  ", 'R', Enderdeath.royalite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordRoyalite, 1), new Object[] {"  R", "  R", "  S", 'R', Enderdeath.royalite, 'S', Items.stick});
        antiPiston = new AntiPiston(null);

        GameRegistry.registerBlock(antiPiston, "AntiPiston");
        /* RoyaliteArmor */
        royaliteHelmet = new RoyaliteArmor(royaliteArmor, 0).setUnlocalizedName("RoyaliteHelmet").setTextureName(Enderdeath.MODID + ":RoyaliteHelmet").setCreativeTab(CreativeTabs.tabCombat);

        royaliteChestplate = new RoyaliteArmor(royaliteArmor, 1).setUnlocalizedName("RoyaliteChestplate").setTextureName(Enderdeath.MODID + ":RoyaliteChestplate").setCreativeTab(CreativeTabs.tabCombat);

        royaliteLeggings = new RoyaliteArmor(royaliteArmor, 2).setUnlocalizedName("RoyaliteLeggings").setTextureName(Enderdeath.MODID + ":RoyaliteLeggings").setCreativeTab(CreativeTabs.tabCombat);

        royaliteBoots = new RoyaliteArmor(royaliteArmor, 3).setUnlocalizedName("RoyaliteBoots").setTextureName(Enderdeath.MODID + ":RoyaliteBoots").setCreativeTab(CreativeTabs.tabCombat);

        GameRegistry.registerItem(royaliteHelmet, "Royalite_Helmet");

        GameRegistry.registerItem(royaliteChestplate, "Royalite_Chestplate");

        GameRegistry.registerItem(royaliteLeggings, "Royalite_Leggings");

        GameRegistry.registerItem(royaliteBoots, "Royalite_Boots");
        GameRegistry.addRecipe(new ItemStack(Enderdeath.royaliteHelmet, 1), new Object[] {"RRR", "R R", "   ", 'R', Enderdeath.royalite});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.royaliteHelmet, 1), new Object[] {"   ", "RRR", "R R", 'R', Enderdeath.royalite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.royaliteChestplate, 1), new Object[] {"R R", "RRR", "RRR", 'R', Enderdeath.royalite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.royaliteLeggings, 1), new Object[] {"RRR", "R R", "R R", 'R', Enderdeath.royalite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.royaliteBoots, 1), new Object[] {"   ", "R R", "R R", 'R', Enderdeath.royalite});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.royaliteBoots, 1), new Object[] {"R R", "R R", "   ", 'R', Enderdeath.royalite});

        /* Enderite */
        enderite = new RareItem().setUnlocalizedName("Enderite").setTextureName(Enderdeath.MODID + ":Enderite").setCreativeTab(CreativeTabs.tabMaterials);
        nuggetEnderite = new RareItem().setUnlocalizedName("NuggetEnderite").setTextureName(Enderdeath.MODID + ":NuggetEnderite").setCreativeTab(CreativeTabs.tabMaterials);
        greatNuggetEnderite = new RareItem().setUnlocalizedName("GreatNuggetEnderite").setTextureName(Enderdeath.MODID + ":GreatNuggetEnderite").setCreativeTab(CreativeTabs.tabMaterials);
        enderiteOre = new EnderiteOre();
        enderiteBlock = new BlockOre().setBlockName("EnderiteBlock").setBlockTextureName(Enderdeath.MODID + ":EnderiteBlock");

        GameRegistry.registerBlock(enderiteBlock, "Enderite_Block");
        GameRegistry.registerBlock(enderiteOre, "Enderite_Ore");
        GameRegistry.registerItem(nuggetEnderite, "Nugget_Enderite");

        GameRegistry.registerItem(greatNuggetEnderite, "GreatNuggetEnderite");
        GameRegistry.registerItem(enderite, "Enderite");

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderite, 1), new Object[] {"RRR", "RRR", "RRR", 'R', Enderdeath.greatNuggetEnderite});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.greatNuggetEnderite, 1), new Object[] {"ABC", "RHR", "FJN", 'R', Enderdeath.nuggetEnderite, 'F', Enderdeath.darkanite, 'A', Enderdeath.rubis, 'B', Enderdeath.saphir, 'C', Enderdeath.royalite, 'H', Enderdeath.hulmini, 'J', Items.diamond, 'N', Items.iron_ingot});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderiteBlock, 1), new Object[] {"RRR", "RRR", "RRR", 'R', Enderdeath.enderite});

        pickaxeEnderite = new ToolPickaxe(enderiteTool).setUnlocalizedName("PickaxeEnderite").setTextureName(Enderdeath.MODID + ":PickaxeEnderite").setCreativeTab(CreativeTabs.tabTools);

        axeEnderite = new ToolAxe(enderiteTool).setUnlocalizedName("AxeEnderite").setTextureName(Enderdeath.MODID + ":AxeEnderite").setCreativeTab(CreativeTabs.tabTools);

        shovelEnderite = new ToolShovel(enderiteTool).setUnlocalizedName("ShovelEnderite").setTextureName(Enderdeath.MODID + ":ShovelEnderite").setCreativeTab(CreativeTabs.tabTools);

        hoeEnderite = new ToolHoe(enderiteTool).setUnlocalizedName("HoeEnderite").setTextureName(Enderdeath.MODID + ":HoeEnderite").setCreativeTab(CreativeTabs.tabTools);

        swordEnderite = new ToolSword(enderiteTool).setUnlocalizedName("SwordEnderite").setTextureName(Enderdeath.MODID + ":SwordEnderite").setCreativeTab(CreativeTabs.tabCombat);;

        GameRegistry.registerItem(pickaxeEnderite, "Enderite_Pickaxe");

        GameRegistry.registerItem(axeEnderite, "Enderite_Axe");

        GameRegistry.registerItem(shovelEnderite, "Enderite_Shovel");

        GameRegistry.registerItem(hoeEnderite, "Enderite_Hoe");

        GameRegistry.registerItem(swordEnderite, "Enderite_Sword");
        /* Defense1.0.6 */
        renforcedSandAndGravel = new ed.enderdeath.mod.block.RenforcedSandandgravel().setBlockTextureName(Enderdeath.MODID + ":falling").setBlockName("falling").setCreativeTab(CreativeTabs.tabBlock).setResistance(25.0F);

        GameRegistry.registerBlock(renforcedSandAndGravel, "falling");
        GameRegistry.addRecipe(new ItemStack(Enderdeath.renforcedSandAndGravel, 1), new Object[] {"SSS", "SRS", "SSS", 'R', Blocks.gravel, 'S', Blocks.sand});

        /* ArmorEnderite */
        enderiteHelmet = new EnderiteArmor(enderiteArmor, 0).setUnlocalizedName("EnderiteHelmet").setTextureName(Enderdeath.MODID + ":EnderiteHelmet").setCreativeTab(CreativeTabs.tabCombat);

        enderiteChestplate = new EnderiteArmor(enderiteArmor, 1).setUnlocalizedName("EnderiteChestplate").setTextureName(Enderdeath.MODID + ":EnderiteChestplate").setCreativeTab(CreativeTabs.tabCombat);

        enderiteLeggings = new EnderiteArmor(enderiteArmor, 2).setUnlocalizedName("EnderiteLeggings").setTextureName(Enderdeath.MODID + ":EnderiteLeggings").setCreativeTab(CreativeTabs.tabCombat);

        enderiteBoots = new EnderiteArmor(enderiteArmor, 3).setUnlocalizedName("EnderiteBoots").setTextureName(Enderdeath.MODID + ":EnderiteBoots").setCreativeTab(CreativeTabs.tabCombat);

        GameRegistry.registerItem(enderiteHelmet, "Enderite_Helmet");

        GameRegistry.registerItem(enderiteChestplate, "Enderite_Chestplate");

        GameRegistry.registerItem(enderiteLeggings, "Enderite_Leggings");

        GameRegistry.registerItem(enderiteBoots, "Enderite_Boots");

        /* Gold */

        /* DarkaniteTool */

        pickaxeDarkanite = new ToolPickaxe(darkaniteTool).setUnlocalizedName("PickaxeDarkanite").setTextureName(Enderdeath.MODID + ":PickaxeDarkanite").setCreativeTab(CreativeTabs.tabTools);

        axeDarkanite = new ToolAxe(darkaniteTool).setUnlocalizedName("AxeDarkanite").setTextureName(Enderdeath.MODID + ":AxeDarkanite").setCreativeTab(CreativeTabs.tabTools);

        shovelDarkanite = new ToolShovel(darkaniteTool).setUnlocalizedName("ShovelDarkanite").setTextureName(Enderdeath.MODID + ":ShovelDarkanite").setCreativeTab(CreativeTabs.tabTools);

        hoeDarkanite = new ToolHoe(darkaniteTool).setUnlocalizedName("HoeDarkanite").setTextureName(Enderdeath.MODID + ":HoeDarkanite").setCreativeTab(CreativeTabs.tabTools);

        swordDarkanite = new ToolSword(darkaniteTool).setUnlocalizedName("SwordDarkanite").setTextureName(Enderdeath.MODID + ":SwordDarkanite").setCreativeTab(CreativeTabs.tabCombat);

        GameRegistry.registerItem(pickaxeDarkanite, "Darkanite_Pickaxe");

        GameRegistry.registerItem(axeDarkanite, "Darkanite_Axe");

        GameRegistry.registerItem(shovelDarkanite, "Darkanite_Shovel");

        GameRegistry.registerItem(hoeDarkanite, "Darkanite_Hoe");

        blockAnvilDragon = new BlockAnvilDragon();
        GameRegistry.registerBlock(blockAnvilDragon, "BlockAnvilDragon");

        GameRegistry.registerTileEntity(TileEntityAlloyer.class, "enderdeath:alloyer");
        GameRegistry.registerTileEntity(TileEntityMachineTuto.class, "enderdeath:baie");
        mega = new MegaSpawner();

        GameRegistry.registerBlock(mega, "MegaSpawner");
        GameRegistry.registerTileEntity(TileEntityMega.class, "enderdeath:mega");
        GameRegistry.registerItem(swordDarkanite, "Darkanite_Sword");
        GameRegistry.addRecipe(new ItemStack(Enderdeath.pickaxeDarkanite, 1), new Object[] {"RRR", " S ", " S ", 'R', Enderdeath.darkanite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.axeDarkanite, 1), new Object[] {" RR", " SR", " S ", 'R', Enderdeath.darkanite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.axeDarkanite, 1), new Object[] {"RR ", "RS ", " S ", 'R', Enderdeath.darkanite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelDarkanite, 1), new Object[] {" R ", " S ", " S ", 'R', Enderdeath.darkanite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelDarkanite, 1), new Object[] {"R  ", "S  ", "S  ", 'R', Enderdeath.darkanite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelDarkanite, 1), new Object[] {"  R", "  S", "  S", 'R', Enderdeath.darkanite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hoeDarkanite, 1), new Object[] {" RR", " S ", " S ", 'R', Enderdeath.darkanite, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.hoeDarkanite, 1), new Object[] {"RR ", " S ", " S ", 'R', Enderdeath.darkanite, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordDarkanite, 1), new Object[] {" R ", " R ", " S ", 'R', Enderdeath.darkanite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordDarkanite, 1), new Object[] {"R  ", "R  ", "S  ", 'R', Enderdeath.darkanite, 'S', Items.stick});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordDarkanite, 1), new Object[] {"  R", "  R", "  S", 'R', Enderdeath.darkanite, 'S', Items.stick});
        damageBlock = new DamageBlock();

        GameRegistry.registerBlock(damageBlock, "DamageBlock");
        /* NetherStarsIngot */

        /* DarkaniteArmor */
        darkaniteHelmet = new DarkaniteArmor(darkaniteArmor, 0).setUnlocalizedName("DarkaniteHelmet").setTextureName(Enderdeath.MODID + ":DarkaniteHelmet").setCreativeTab(CreativeTabs.tabCombat);

        darkaniteChestplate = new DarkaniteArmor(darkaniteArmor, 1).setUnlocalizedName("DarkaniteChestplate").setTextureName(Enderdeath.MODID + ":DarkaniteChestplate").setCreativeTab(CreativeTabs.tabCombat);

        darkaniteLeggings = new DarkaniteArmor(darkaniteArmor, 2).setUnlocalizedName("DarkaniteLeggings").setTextureName(Enderdeath.MODID + ":DarkaniteLeggings").setCreativeTab(CreativeTabs.tabCombat);

        darkaniteBoots = new DarkaniteArmor(darkaniteArmor, 3).setUnlocalizedName("DarkaniteBoots").setTextureName(Enderdeath.MODID + ":DarkaniteBoots").setCreativeTab(CreativeTabs.tabCombat);

        GameRegistry.registerItem(darkaniteHelmet, "Darkanite_Helmet");

        GameRegistry.registerItem(darkaniteChestplate, "Darkanite_Chestplate");

        GameRegistry.registerItem(darkaniteLeggings, "Darkanite_Leggings");

        GameRegistry.registerItem(darkaniteBoots, "Darkanite_Boots");

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkaniteHelmet, 1), new Object[] {"RRR", "R R", "   ", 'R', Enderdeath.darkanite});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkaniteHelmet, 1), new Object[] {"   ", "RRR", "R R", 'R', Enderdeath.darkanite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkaniteChestplate, 1), new Object[] {"R R", "RRR", "RRR", 'R', Enderdeath.darkanite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkaniteLeggings, 1), new Object[] {"RRR", "R R", "R R", 'R', Enderdeath.darkanite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkaniteBoots, 1), new Object[] {"   ", "R R", "R R", 'R', Enderdeath.darkanite});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkaniteBoots, 1), new Object[] {"R R", "R R", "   ", 'R', Enderdeath.darkanite});

        /* Robber */

        /* Box */
        deathBox = new BoxKey();
        deathKey = new ItemClass().setUnlocalizedName("DeathKey").setFull3D().setTextureName(Enderdeath.MODID + ":DeathKey").setCreativeTab(CreativeTabs.tabMisc);

        ultimeBox = new UltimeBox();
        ultimeKey = new RareItem().setUnlocalizedName("UltimeKey").setFull3D().setTextureName(Enderdeath.MODID + ":UltimeKey").setCreativeTab(CreativeTabs.tabMisc);

        naturalBox = new NaturalBox();
        naturalKey = new ItemClass().setUnlocalizedName("NaturalKey").setFull3D().setTextureName(Enderdeath.MODID + ":NaturalKey").setCreativeTab(CreativeTabs.tabMisc);

        GameRegistry.registerItem(ultimeKey, "UltimeKey");
        GameRegistry.registerBlock(ultimeBox, "UltimeBox");

        GameRegistry.registerItem(naturalKey, "NaturalKey");
        GameRegistry.registerBlock(naturalBox, "NaturalBox");

        GameRegistry.registerItem(deathKey, "Ender_Key");
        GameRegistry.registerBlock(deathBox, "Ender_Box");
        /* Ore */
        rubisOre = new RubisOre(Material.rock, 176);
        saphirOre = new SaphirOre(null, 177);
        hulminiOre = new HulminiOre(null);
        royaliteOre = new RoyaliteOre(null);

        darkaniteNetherack = new DarkaniteNetherack();
        GameRegistry.registerBlock(royaliteOre, "Royalite_Ore");
        GameRegistry.registerBlock(rubisOre, "Rubis_Ore");
        GameRegistry.registerBlock(saphirOre, "Saphir_Ore");
        GameRegistry.registerBlock(hulminiOre, "Hulmini_Ore");

        GameRegistry.registerBlock(darkaniteNetherack, "Darkanite_Netherack");

        GameRegistry.addSmelting(rubisOre, new ItemStack(rubis), 1.0F);

        GameRegistry.addSmelting(saphirOre, new ItemStack(saphir), 1.0F);

        GameRegistry.addSmelting(hulminiOre, new ItemStack(hulmini), 1.0F);

        GameRegistry.addSmelting(darkaniteNetherack, new ItemStack(nuggetDarkanite), 1.0F);

        GameRegistry.addSmelting(royaliteOre, new ItemStack(royalite), 1.0F);

        /* Block Ore */
        ironHammer = new IronHammer(hammer).setUnlocalizedName("IronHammer").setTextureName(Enderdeath.MODID + ":IronHammer").setCreativeTab(CreativeTabs.tabTools);

        GameRegistry.registerItem(ironHammer, "Hammer_Iron");
        /* Block Admin */
        blockInvisible = new BlockInvisible(null, true);

        invisibleBlock = new ItemReed(blockInvisible).setTextureName(Enderdeath.MODID + ":InvisibleBlock").setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("InvisibleBlock");

        GameRegistry.registerItem(invisibleBlock, "Invisible_Block");
        GameRegistry.registerBlock(blockInvisible, "Block_Invisible");
        /* OreElemental */

        /* Block F/M */
        speedBlock = new SpeedBlock(null);

        slowBlock = new SlowBlock();

        jumpBlock = new JumpBlock();

        ironFence = new IronFence(Material.iron);

        GameRegistry.registerBlock(ironFence, "Saphir_Ladder");

        GameRegistry.registerBlock(speedBlock, "Speed_Block");

        GameRegistry.registerBlock(jumpBlock, "Jump_Block");

        GameRegistry.registerBlock(slowBlock, "SlowBlock");

        /* Legendary */

        pickaxeItem = new Pickaxe(pickaxe).setUnlocalizedName("Pickaxe").setTextureName(Enderdeath.MODID + ":Pickaxe").setCreativeTab(CreativeTabs.tabTools);

        GameRegistry.registerItem(pickaxeItem, "Pickaxe_Of_Doyo");

        /* Craft Block F/M */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.jumpBlock, 1), new Object[] {"RRR", "GGG", "RRR", 'R', Enderdeath.rubis, 'G', Blocks.wool});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.speedBlock, 1), new Object[] {"RRR", "GGG", "RRR", 'R', Enderdeath.hulmini, 'G', Enderdeath.saphir});

        /* Vanilla */
        /* Bottle */
        bottleHaste = new BotleHaste(0, 0, false);

        GameRegistry.registerItem(bottleHaste, "Bottle_Haste");
        /* Food */

        /* Familiar */
        goldenCroquette = new Croquette(Enderdeath.goldenCroquette).setCreativeTab(CreativeTabs.tabFood).setTextureName(Enderdeath.MODID + ":GoldenCroquette").setUnlocalizedName("GoldenCroquette");

        rubisCroquette = new Croquette(Enderdeath.rubisCroquette).setCreativeTab(CreativeTabs.tabFood).setTextureName(Enderdeath.MODID + ":RubisCroquette").setUnlocalizedName("RubisCroquette");

        saphirCroquette = new Croquette(Enderdeath.saphirCroquette).setCreativeTab(CreativeTabs.tabFood).setTextureName(Enderdeath.MODID + ":SaphirCroquette").setUnlocalizedName("SaphirCroquette");

        skinFire = new Croquette(skinFire).setTextureName(Enderdeath.MODID + ":SkinFire").setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("SkinFire");

        skinBlue = new Croquette(skinBlue).setTextureName(Enderdeath.MODID + ":SkinBlue").setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("SkinBlue");

        skinDirt = new Croquette(skinDirt).setTextureName(Enderdeath.MODID + ":SkinDirt").setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("SkinDirt");

        skinEnder = new Croquette(skinEnder).setTextureName(Enderdeath.MODID + ":SkinEnder").setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("SkinEnder");

        GameRegistry.registerItem(skinFire, "SkinFire");

        GameRegistry.registerItem(skinBlue, "SkinBlue");

        GameRegistry.registerItem(skinDirt, "SkinDirt");

        GameRegistry.registerItem(skinEnder, "SkinEnder");

        GameRegistry.registerItem(goldenCroquette, "Golden_Croquette");

        GameRegistry.registerItem(rubisCroquette, "Rubis_Croquette");

        GameRegistry.registerItem(saphirCroquette, "Saphir_Croquette");

        GameRegistry.addRecipe(new ItemStack(Enderdeath.skinBlue, 1), new Object[] {"RRR", "RAR", "RRR", 'R', Enderdeath.saphir, 'A', Enderdeath.hulmini});

        /* Craft et cuison de minerais */

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkanite, 1), new Object[] {"RRR", "RRR", "RRR", 'R', Enderdeath.nuggetDarkanite});

        /* Vanilla ajout de craft */
        GameRegistry.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 1), new Object[] {" S ", "SRS", " S ", 'R', Blocks.cobblestone, 'S', Blocks.vine});

        /* Effect de Potion */

        /* Block Ore */
        dragonCrystalOre = new DragonCrystalOre(null);

        GameRegistry.registerBlock(dragonCrystalOre, "Dragon_Crystal_Ore");
        /* Rubis */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubisBlock, 1), new Object[] {"RRR", "RRR", "RRR", 'R', Enderdeath.rubis});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubis, 9), new Object[] {"R  ", "   ", "   ", 'R', Enderdeath.rubisBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubis, 9), new Object[] {" R ", "   ", "   ", 'R', Enderdeath.rubisBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubis, 9), new Object[] {"  R", "   ", "   ", 'R', Enderdeath.rubisBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubis, 9), new Object[] {"   ", "R   ", "   ", 'R', Enderdeath.rubisBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubis, 9), new Object[] {"   ", " R ", "   ", 'R', Enderdeath.rubisBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubis, 9), new Object[] {"   ", "  R", "   ", 'R', Enderdeath.rubisBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubis, 9), new Object[] {"   ", "   ", "R  ", 'R', Enderdeath.rubisBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubis, 9), new Object[] {"   ", "   ", " R ", 'R', Enderdeath.rubisBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.rubis, 9), new Object[] {"   ", "   ", "  R", 'R', Enderdeath.rubisBlock});

        /* Saphir */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphirBlock, 1), new Object[] {"RRR", "RRR", "RRR", 'R', Enderdeath.saphir});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphir, 9), new Object[] {"R  ", "   ", "   ", 'R', Enderdeath.saphirBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphir, 9), new Object[] {" R ", "   ", "   ", 'R', Enderdeath.saphirBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphir, 9), new Object[] {"  R", "   ", "   ", 'R', Enderdeath.saphirBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphir, 9), new Object[] {"   ", "R   ", "   ", 'R', Enderdeath.saphirBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphir, 9), new Object[] {"   ", " R ", "   ", 'R', Enderdeath.saphirBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphir, 9), new Object[] {"   ", "  R", "   ", 'R', Enderdeath.saphirBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphir, 9), new Object[] {"   ", "   ", "R  ", 'R', Enderdeath.saphirBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.saphir, 9), new Object[] {"   ", "   ", " R ", 'R', Enderdeath.saphirBlock});
        /* EnderiteRenforce */

        /* Royalite */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.royaliteBlock, 1), new Object[] {"RRR", "RRR", "RRR", 'R', Enderdeath.royalite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.royalite, 9), new Object[] {"R  ", "   ", "   ", 'R', Enderdeath.royaliteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.royalite, 9), new Object[] {" R ", "   ", "   ", 'R', Enderdeath.royaliteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.royalite, 9), new Object[] {"  R", "   ", "   ", 'R', Enderdeath.royaliteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.royalite, 9), new Object[] {"   ", "R   ", "   ", 'R', Enderdeath.royaliteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.royalite, 9), new Object[] {"   ", " R ", "   ", 'R', Enderdeath.royaliteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.royalite, 9), new Object[] {"   ", "  R", "   ", 'R', Enderdeath.royaliteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.royalite, 9), new Object[] {"   ", "   ", "R  ", 'R', Enderdeath.royaliteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.royalite, 9), new Object[] {"   ", "   ", " R ", 'R', Enderdeath.royaliteBlock});
        /* Darkanite */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkaniteBlock, 1), new Object[] {"RRR", "RRR", "RRR", 'R', Enderdeath.darkanite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkanite, 9), new Object[] {"R  ", "   ", "   ", 'R', Enderdeath.darkaniteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkanite, 9), new Object[] {" R ", "   ", "   ", 'R', Enderdeath.darkaniteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkanite, 9), new Object[] {"  R", "   ", "   ", 'R', Enderdeath.darkaniteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkanite, 9), new Object[] {"   ", "R   ", "   ", 'R', Enderdeath.darkaniteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkanite, 9), new Object[] {"   ", " R ", "   ", 'R', Enderdeath.darkaniteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkanite, 9), new Object[] {"   ", "  R", "   ", 'R', Enderdeath.darkaniteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkanite, 9), new Object[] {"   ", "   ", "R  ", 'R', Enderdeath.darkaniteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.darkanite, 9), new Object[] {"   ", "   ", " R ", 'R', Enderdeath.darkaniteBlock});

        /* Fac */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.obsiRenforced, 1), new Object[] {"RRR", "RRR", "RRR", 'R', Blocks.obsidian});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.blockMiner, 1), new Object[] {"SRS", "RSR", "SRS", 'R', Enderdeath.rubis, 'S', Enderdeath.hulmini});

        /* Enderite */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderiteBlock, 1), new Object[] {"RRR", "RRR", "RRR", 'R', Enderdeath.enderite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderite, 9), new Object[] {"R  ", "   ", "   ", 'R', Enderdeath.enderiteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderite, 9), new Object[] {" R ", "   ", "   ", 'R', Enderdeath.enderiteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderite, 9), new Object[] {"  R", "   ", "   ", 'R', Enderdeath.enderiteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderite, 9), new Object[] {"   ", "R   ", "   ", 'R', Enderdeath.enderiteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderite, 9), new Object[] {"   ", " R ", "   ", 'R', Enderdeath.enderiteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderite, 9), new Object[] {"   ", "  R", "   ", 'R', Enderdeath.enderiteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderite, 9), new Object[] {"   ", "   ", "R  ", 'R', Enderdeath.enderiteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderite, 9), new Object[] {"   ", "   ", " R ", 'R', Enderdeath.enderiteBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.featherBoot, 1), new Object[] {"R R", "R R", "   ", 'R', Enderdeath.hulmini});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.featherBoot, 1), new Object[] {"   ", "R R", "R R", 'R', Enderdeath.hulmini});

        /* Baie */
        baie = new Baie(2, 2, true);

        baieResistance = new BaieResistance(2, 2, true);

        baieRed = new BaieRed(2, 2, true);

        baieBlue = new BaieBlue(2, 2, true);

        baieGreen = new BaieGreen(2, 2, true);

        baieYellow = new BaieYellow(2, 2, true);

        baieOfChocolate = new BaieChocolate(2, 2, true);

        baieOfRainbow = new BaieOfRainbow(2, 2, true);

        baiePink = new BaiePink(2, 2, true).setMaxStackSize(1);

        baieOrange = new BaieOrange(2, 2, true);

        baieWhite = new BaieWhite(2, 2, true);

        baieBlack = new BaieBlack(2, 2, true);

        baieHeal = new BaieHeal(2, 2, true).setMaxStackSize(3);

        baieSpeed = new BaieSpeed(2, 2, true);

        pieceBaieRainbow = new Baie(2, 2, true).setCreativeTab(CreativeTabs.tabFood).setTextureName(Enderdeath.MODID + ":PieceBaieRainbow").setUnlocalizedName("PieceBaieRainbow");

        baieCake = new BaieCake();

        baiePlant = new BaiePlant(Enderdeath.baie);

        baiePlantWater = new BaiePlantWater(Enderdeath.baieBlue);

        baiePlantFire = new BaiePlantFire(Enderdeath.baieRed);

        baiePlantGreen = new BaiePlantGreen(Enderdeath.baieGreen);

        baiePlantYellow = new BaiePlantYellow(Enderdeath.baieYellow);

        baiePlantRainBow = new BaiePlantRainBow(Enderdeath.baieSeedRainbow);

        baieSeedRainbow = new BaieSeedRainbow(Enderdeath.baiePlantRainBow);

        GameRegistry.registerItem(baieHeal, "Baie_Heal+");

        GameRegistry.registerItem(baieSpeed, "Baie_Speed+");
        GameRegistry.registerBlock(baiePlantRainBow, "Baie_Plant_RainBow");
        GameRegistry.registerBlock(baiePlantYellow, "Baie_Plant_Yellow");
        GameRegistry.registerBlock(baiePlantGreen, "Baie_Plant_Green");
        GameRegistry.registerBlock(baiePlantFire, "Baie_Plant_Fire");
        GameRegistry.registerBlock(baiePlantWater, "Baie_Plant_Water");
        GameRegistry.registerBlock(baiePlant, "Baie_Plant");
        GameRegistry.registerBlock(baieCake, "Baie_Cake");
        GameRegistry.registerItem(baieOfRainbow, "Baie_Of_Rainbow");
        GameRegistry.registerItem(baieOfChocolate, "Baie_Of_Chocolate");
        GameRegistry.registerItem(baiePink, "Baie_Pink");
        GameRegistry.registerItem(baieOrange, "Baie_Orange");
        GameRegistry.registerItem(baieWhite, "Baie_White");
        GameRegistry.registerItem(baieYellow, "Baie_Yellow");
        GameRegistry.registerItem(baieGreen, "Baie_Green");
        GameRegistry.registerItem(baieResistance, "Baie_Black_and_White");
        GameRegistry.registerItem(baieBlue, "Baie_Blue");
        GameRegistry.registerItem(baieBlack, "Baie_Black");
        GameRegistry.registerItem(baieRed, "Baie_Red");
        GameRegistry.registerItem(baie, "Baie");
        GameRegistry.registerItem(pieceBaieRainbow, "Piece_Baie_Rainbow");
        GameRegistry.registerItem(baieSeedRainbow, "Baie_Seed_Rainbow");

        /* BaiePlantItem */
        baiePlantItem = new ItemReed(Enderdeath.baiePlant).setTextureName(Enderdeath.MODID + ":BaiePlantItem").setUnlocalizedName("BaiePlantItem").setCreativeTab(CreativeTabs.tabMaterials);

        baiePlantItemWater = new ItemReed(Enderdeath.baiePlantWater).setTextureName(Enderdeath.MODID + ":BaieBlueItem").setUnlocalizedName("BaieBlueItem").setCreativeTab(CreativeTabs.tabMaterials);

        baiePlantFireItem = new ItemReed(Enderdeath.baiePlantFire).setTextureName(Enderdeath.MODID + ":BaieRedItem").setUnlocalizedName("BaieRedItem").setCreativeTab(CreativeTabs.tabMaterials);

        baiePlantGreenItem = new ItemReed(Enderdeath.baiePlantGreen).setTextureName(Enderdeath.MODID + ":BaiePlantGreenItem").setUnlocalizedName("BaiePlantGreenItem").setCreativeTab(CreativeTabs.tabMaterials);

        baiePlantYellowItem = new ItemReed(baiePlantYellow).setTextureName(Enderdeath.MODID + ":BaiePlantYellowItem").setUnlocalizedName("BaiePlantYellowItem").setCreativeTab(CreativeTabs.tabMaterials);

        megaEnder = new MegaEnder();

        GameRegistry.registerItem(megaEnder, "Enderrer");

        GameRegistry.registerItem(baiePlantYellowItem, "Baie_Yellow_Seeds");

        GameRegistry.registerItem(baiePlantFireItem, "Baie_Red_Seeds");

        GameRegistry.registerItem(baiePlantItem, "Baie_Seeds");

        GameRegistry.registerItem(baiePlantItemWater, "Baie_Blue_Seeds");

        GameRegistry.registerItem(baiePlantGreenItem, "Baie_Green_Seeds");

        /* testBlock */
        testBlock = new testBlock();

        GameRegistry.registerBlock(testBlock, "Legendary");
        /* Obsi */
        /* Autres */
        GameRegistry.registerWorldGenerator(new OreGenerator(), 0);

        /* Ugrade */

        /* Enchant */

        starsPower = new StarsPower().setName("StarsPower");

        /* DragonRed */
        dragonEggRed = new EggDragonRed(null);

        GameRegistry.registerBlock(dragonEggRed, "DragonEggRed");
        /* SwordStars */
        swordOfStars = new SwordStars(aSwordStars).setUnlocalizedName("SwordStars").setTextureName(Enderdeath.MODID + ":SwordStars").setCreativeTab(CreativeTabs.tabCombat);

        fight = new EnchantFight().setName("FightPower");

        swordStars = new UltimateSword(bSwordStars).setUnlocalizedName("SwordOfStars").setTextureName(Enderdeath.MODID + ":SwordOfStars").setCreativeTab(CreativeTabs.tabCombat);;

        GameRegistry.registerItem(swordStars, "SwordStars");

        GameRegistry.registerItem(swordOfStars, "Sword_Of_Stars");
        GameRegistry.addRecipe(new ItemStack(Enderdeath.testBlock, 1), new Object[] {"RRR", "RRR", "RRR", 'R', Enderdeath.hulmini});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hulmini, 9), new Object[] {"R  ", "   ", "   ", 'R', Enderdeath.testBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hulmini, 9), new Object[] {" R ", "   ", "   ", 'R', Enderdeath.testBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hulmini, 9), new Object[] {"  R", "   ", "   ", 'R', Enderdeath.testBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hulmini, 9), new Object[] {"   ", "R   ", "   ", 'R', Enderdeath.testBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hulmini, 9), new Object[] {"   ", " R ", "   ", 'R', Enderdeath.testBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hulmini, 9), new Object[] {"   ", "  R", "   ", 'R', Enderdeath.testBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hulmini, 9), new Object[] {"   ", "   ", "R  ", 'R', Enderdeath.testBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hulmini, 9), new Object[] {"   ", "   ", " R ", 'R', Enderdeath.testBlock});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hulmini, 9), new Object[] {"   ", "   ", "  R", 'R', Enderdeath.testBlock});
        /* Magic */
        sitckJolo = new StickJolo();
        fattingXp = new FattingXp();
        stickHeal = new StickHeal();
        stickSpeed = new StickSpeed();
        stickJump = new StickJump();
        xpOre = new XpOre();
        orbRed = new OrbRed();
        orbBlue = new OrbBlue();
        orbGreen = new OrbGreen();
        orbYellow = new OrbYellow();

        bomber = new Bomber().setMaxStackSize(1);

        GameRegistry.registerItem(orbGreen, "OrbGreen");
        GameRegistry.registerItem(stickJump, "StickJump");
        GameRegistry.registerItem(orbYellow, "OrbYellow");
        GameRegistry.registerItem(bomber, "Bomber");
        GameRegistry.registerItem(orbBlue, "Orb_Blue");
        GameRegistry.registerItem(orbRed, "Orb_Red");

        GameRegistry.registerItem(stickSpeed, "Stick_Speed");
        GameRegistry.registerItem(stickHeal, "Stick_Healing");
        GameRegistry.registerItem(sitckJolo, "Stick_Clear");
        GameRegistry.registerBlock(xpOre, "Xp_Ore");
        GameRegistry.registerItem(fattingXp, "Fatting_Xp");

        dragoniteHelmet = new DragoniteArmor(dragoniteArmor, 0).setUnlocalizedName("DragoniteHelmet").setTextureName(Enderdeath.MODID + ":DragoniteHelmet");
        GameRegistry.registerItem(dragoniteHelmet, "Dragonite_Helmet");
        /* Modification du diamant */
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.diamond_helmet, 2, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.diamond_chestplate, 7, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.diamond_leggings, 5, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.diamond_boots, 2, "damageReduceAmount", "field_77879_b");

        /* Arica */
        brickStonarck = new BrickStonarck();

        bowGreetWood = new BowGreetWood();

        witherBow = new WitherBow();

        GameRegistry.registerItem(witherBow, "WitherBow");

        GameRegistry.registerItem(bowGreetWood, "Bow_Greet_Wood");

        GameRegistry.registerBlock(brickStonarck, "BrickS_Stonarck");

        /* NuggetAll */

        /* Bloc d�cioratif */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.brickStonarck, 3), new Object[] {"   ", " R ", "   ", 'R', Enderdeath.hulmini});
        /* Saphir */
        deathArrow = new ItemClass().setCreativeTab(CreativeTabs.tabCombat).setFull3D().setTextureName(Enderdeath.MODID + ":DeathArrow").setUnlocalizedName("DeathArrow");

        GameRegistry.registerItem(deathArrow, "Death_Arrow");

        GameRegistry.addRecipe(new ItemStack(Enderdeath.nuggetDarkanite, 9), new Object[] {"R  ", "   ", "   ", 'R', Enderdeath.darkanite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.nuggetDarkanite, 9), new Object[] {" R ", "   ", "   ", 'R', Enderdeath.darkanite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.nuggetDarkanite, 9), new Object[] {"  R", "   ", "   ", 'R', Enderdeath.darkanite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.nuggetDarkanite, 9), new Object[] {"   ", "R   ", "   ", 'R', Enderdeath.darkanite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.nuggetDarkanite, 9), new Object[] {"   ", " R ", "   ", 'R', Enderdeath.darkanite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.nuggetDarkanite, 9), new Object[] {"   ", "  R", "   ", 'R', Enderdeath.darkanite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.nuggetDarkanite, 9), new Object[] {"   ", "   ", "R  ", 'R', Enderdeath.darkanite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.nuggetDarkanite, 9), new Object[] {"   ", "   ", " R ", 'R', Enderdeath.darkanite});

        /* BaieCraft */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.baiePlantItemWater, 2), new Object[] {"RRR", "RSR", "RRR", 'R', Enderdeath.baie, 'S', Items.water_bucket});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.baieCake, 1), new Object[] {"BHB", "ASG", "BZB", 'R', Enderdeath.baie, 'A', Enderdeath.baieGreen, 'B', Items.wheat, 'G', Enderdeath.baieBlue, 'H', Enderdeath.baieYellow, 'S', Enderdeath.baie, 'Z', Enderdeath.baieRed});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.baiePlantFireItem, 2), new Object[] {"RRR", "RSR", "RRR", 'R', Enderdeath.baie, 'S', Items.fire_charge});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.baiePlantGreenItem, 2), new Object[] {"RRR", "RSR", "RRR", 'R', Enderdeath.baie, 'S', Blocks.sapling});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.baiePlantYellowItem, 2), new Object[] {"RRR", "RSR", "RRR", 'R', Enderdeath.baie, 'S', Items.glowstone_dust});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.potionFly, 1), new Object[] {"RRR", "RSR", "RRR", 'S', Enderdeath.bottleHaste, 'R', Items.feather});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.potionFall, 1), new Object[] {"RRR", "RSR", "RRR", 'S', Items.glass_bottle, 'R', Enderdeath.hulmini});

        /* Craft Sword Ultimate */

        /* RubisRenforced */

        GameRegistry.addRecipe(new ItemStack(Enderdeath.baieOfRainbow, 1), new Object[] {"RRR", "RRR", "RRR", 'R', Enderdeath.pieceBaieRainbow,});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.baieSeedRainbow, 1), new Object[] {"RAR", "ARA", "RAR", 'R', Enderdeath.enderite, 'A', Enderdeath.baieOfRainbow});
        /* Haste */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.bottleHaste, 1), new Object[] {"BIB", "ISI", "BIB", 'B', Items.gold_ingot, 'S', Items.glass_bottle, 'I', Items.golden_pickaxe});
        Blocks.obsidian.setResistance(1.0F);
        Blocks.dragon_egg.setCreativeTab(CreativeTabs.tabBlock);
        Blocks.command_block.setCreativeTab(CreativeTabs.tabRedstone);
        Blocks.enchanting_table.setResistance(1.0F);
        Blocks.anvil.setResistance(1.0F);
        dragonCrystal = new RareItem().setUnlocalizedName("DragonCrystal").setTextureName(Enderdeath.MODID + ":DragonCrystal");

        GameRegistry.registerItem(dragonCrystal, "Dragon_Crystal");

        GameRegistry.addRecipe(new ItemStack(Enderdeath.bowGreetWood, 1), new Object[] {" AG", "ARG", " AG", 'R', Enderdeath.darkaniteBlock, 'A', Enderdeath.enderite, 'G', Items.string});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.orbBlue, 1), new Object[] {"AGA", "GAG", "AGA", 'A', Enderdeath.saphir, 'G', Enderdeath.hulmini});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.ironFence, 1), new Object[] {"A A", "AAA", "A A", 'A', Enderdeath.saphir});
        /* Extractor */
        alloyer = new Alloyer(Material.iron);
        speedUpgrade = new SpeedUpgrade("speedUpgrade", 125);

        machineBaie = new MachineBaie();

        GameRegistry.registerItem(speedUpgrade, "speedUpgrade");
        GameRegistry.registerBlock(alloyer, "Extractor");
        GameRegistry.registerBlock(machineBaie, "machineBaie");
        stickIron = new ItemClass().setUnlocalizedName("StickIron").setTextureName(Enderdeath.MODID + ":StickIron").setCreativeTab(CreativeTabs.tabMaterials);

        GameRegistry.registerItem(stickIron, "Stick_Iron");

        GameRegistry.addRecipe(new ItemStack(Enderdeath.stickIron, 1), new Object[] {" R ", " R ", " R ", 'R', Blocks.iron_block});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.stickIron, 1), new Object[] {"R  ", "R  ", "R  ", 'R', Blocks.iron_block});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.stickIron, 1), new Object[] {"  R", "  R", "  R", 'R', Blocks.iron_block});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.pickaxeEnderite, 1), new Object[] {"RRR", " S ", " S ", 'R', Enderdeath.enderite, 'S', Enderdeath.stickIron});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.axeEnderite, 1), new Object[] {" RR", " SR", " S ", 'R', Enderdeath.enderite, 'S', Enderdeath.stickIron});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.axeEnderite, 1), new Object[] {"RR ", "RS ", " S ", 'R', Enderdeath.enderite, 'S', Enderdeath.stickIron});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelEnderite, 1), new Object[] {" R ", " S ", " S ", 'R', Enderdeath.enderite, 'S', Enderdeath.stickIron});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelEnderite, 1), new Object[] {"R  ", "S  ", "S  ", 'R', Enderdeath.enderite, 'S', Enderdeath.stickIron});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.shovelEnderite, 1), new Object[] {"  R", "  S", "  S", 'R', Enderdeath.enderite, 'S', Enderdeath.stickIron});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.hoeEnderite, 1), new Object[] {" RR", " S ", " S ", 'R', Enderdeath.enderite, 'S', Enderdeath.stickIron});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.hoeEnderite, 1), new Object[] {"RR ", " S ", " S ", 'R', Enderdeath.enderite, 'S', Enderdeath.stickIron});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordEnderite, 1), new Object[] {" R ", " R ", " S ", 'R', Enderdeath.enderite, 'S', Enderdeath.stickIron});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordEnderite, 1), new Object[] {"R  ", "R  ", "S  ", 'R', Enderdeath.enderite, 'S', Enderdeath.stickIron});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordEnderite, 1), new Object[] {"  R", "  R", "  S", 'R', Enderdeath.enderite, 'S', Enderdeath.stickIron});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordStars, 1), new Object[] {" V ", "IRI", "SBS", 'R', Enderdeath.enderHeart, 'B', Enderdeath.stickIron, 'S', Enderdeath.darkaniteBlock, 'I', Enderdeath.enderiteBlock, 'V', Enderdeath.dragonCrystal});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderiteHelmet, 1), new Object[] {"RRR", "R R", "   ", 'R', Enderdeath.enderite});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderiteHelmet, 1), new Object[] {"   ", "RRR", "R R", 'R', Enderdeath.enderite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderiteChestplate, 1), new Object[] {"R R", "RRR", "RRR", 'R', Enderdeath.enderite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderiteLeggings, 1), new Object[] {"RRR", "R R", "R R", 'R', Enderdeath.enderite});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderiteBoots, 1), new Object[] {"   ", "R R", "R R", 'R', Enderdeath.enderite});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.enderiteBoots, 1), new Object[] {"R R", "R R", "   ", 'R', Enderdeath.enderite});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.speedUpgrade, 1), new Object[] {" R ", "RAR", "RAR", 'R', Blocks.iron_block, 'A', Blocks.diamond_block});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.bomber, 1), new Object[] {" S ", "RAR", "RMR", 'A', Enderdeath.rubis, 'R', Items.iron_ingot, 'S', Items.string, 'M', Enderdeath.saphir});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.damageBlock, 1), new Object[] {"RRR", "RAR", "RRR", 'R', Blocks.netherrack, 'A', Enderdeath.darkanite});

        cobalt = new ItemClass().setUnlocalizedName("Cobalt").setTextureName(Enderdeath.MODID + ":Cobalt").setCreativeTab(CreativeTabs.tabMaterials);

        GameRegistry.registerItem(cobalt, "Cobalt");

        GameRegistry.addRecipe(new ItemStack(Enderdeath.swordOfStars, 1), new Object[] {"RQR", "ASA", " S ", 'R', Enderdeath.darkaniteBlock, 'A', Enderdeath.darkaniteBlock, 'S', Enderdeath.stickIron, 'Q', Enderdeath.enderHeart});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.antiPiston, 1), new Object[] {"R R", " R ", "R R", 'R', Blocks.cobblestone});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.alloyer, 1), new Object[] {"BIB", "RAR", "BSB", 'R', Blocks.quartz_block, 'B', Enderdeath.enderite, 'S', Blocks.redstone_block, 'I', Enderdeath.rubisBlock, 'A', Enderdeath.darkaniteBlock});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.pickaxe3x3, 1), new Object[] {"RAR", "RSR", "RSR", 'R', Blocks.diamond_block, 'A', Enderdeath.rubisBlock, 'S', Enderdeath.stickIron});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.cobalt, 1), new Object[] {"RAR", "ASA", "RAR", 'R', Blocks.diamond_block, 'A', Enderdeath.saphir, 'S', Blocks.diamond_block});
        wand = new Wand().setUnlocalizedName("Wand");

        Items.potionitem.setMaxStackSize(6);

        GameRegistry.registerItem(wand, "Ender_Specter");

        GameRegistry.addRecipe(new ItemStack(Enderdeath.dragoniteHelmet, 1), new Object[] {"RAR", "R R", "   ", 'R', Enderdeath.dragonCrystal, 'A', Enderdeath.enderHeart});
        GameRegistry.addRecipe(new ItemStack(Enderdeath.dragoniteHelmet, 1), new Object[] {"   ", "RAR", "R R", 'R', Enderdeath.dragonCrystal, 'A', Enderdeath.enderHeart});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.ironHammer, 1), new Object[] {"RFR", "RSR", " S ", 'R', Blocks.iron_block, 'S', Items.stick, 'F', Items.iron_ingot});

        GameRegistry.addRecipe(new ItemStack(Enderdeath.deathArrow, 9), new Object[] {"  S", " R ", "R  ", 'R', Items.stick, 'S', Enderdeath.baieBlack});

        /* Achivement */
        /* Rubis */

        /* Autre */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.baiePlantRainBowItem, 2), new Object[] {"RRR", "RSR", "RRR", 'R', Enderdeath.baie, 'S', Enderdeath.dragonCrystal});
        /* Saphir */

        /* Lumieterite */
        GameRegistry.addRecipe(new ItemStack(Enderdeath.pickaxeItem, 1), new Object[] {"RAR", "RSR", "RSR", 'R', Enderdeath.rubisBlock, 'S', Items.stick, 'A', Enderdeath.darkaniteBlock});
        /* achievement */

        FlyPotion.customEffectID = 30;
        FlyPotion.falleffect = 27;

        pickaxeSpawner = new ToolPickaxe(spawnerPickaxe).setUnlocalizedName("PickaxeSpawner").setTextureName(Enderdeath.MODID + ":PickaxeSpawner").setCreativeTab(CreativeTabs.tabTools);
        GameRegistry.addRecipe(new ItemStack(Enderdeath.pickaxeSpawner, 1), new Object[] {"RAR", "RSR", "RSR", 'R', Enderdeath.cobalt, 'S', Enderdeath.stickIron, 'A', Enderdeath.nuggetEnderite});
        GameRegistry.registerItem(pickaxeSpawner, "Pickaxe_Spawner");
        GameRegistry.addRecipe(new ItemStack(Enderdeath.machineBaie, 1), new Object[] {"ARA", "QSQ", "ARA", 'R', Enderdeath.baie, 'S', Enderdeath.stickIron, 'Q', Blocks.redstone_block, 'A', Enderdeath.hulmini});
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerRender();
        System.out.println("init");
        MinecraftForge.EVENT_BUS.register(new EnchantForge());

        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

        if(event.getSide().isClient())
        {

            FMLCommonHandler.instance().bus().register(this);
            Minecraft mc = Minecraft.getMinecraft();
            FMLCommonHandler.instance().bus().register(new TickHandler(mc));

        }

        FlyPotion.loadEffects();
        FlyPotion.register();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

        EntityRegistry.registerGlobalEntityID(Familiar.class, "Familiar", EntityRegistry.findGlobalUniqueEntityId(), new Color(45, 6, 130).getRGB(), new Color(100, 102, 12).getRGB());
        EntityRegistry.registerModEntity(Familiar.class, "Familiar", 450, this.instance, 68, 2, true);

        EntityRegistry.registerGlobalEntityID(DragonRed.class, "DragonRed", EntityRegistry.findGlobalUniqueEntityId(), new Color(99, 153, 99).getRGB(), new Color(50, 50, 50).getRGB());
        EntityRegistry.registerModEntity(DragonRed.class, "DragonRed", 440, this.instance, 69, 2, true);

        EntityRegistry.registerModEntity(EntityBoatTnT.class, "EntityBoatTnT", 467, this.instance, 72, 2, false);

        EntityRegistry.registerModEntity(BomberEntity.class, "BomberEntity", 428, this.instance, 48, 2, true);

        EntityRegistry.registerModEntity(EntityArrowDeath.class, "EntityArrowDeath", 440, this.instance, 49, 2, true);

        EntityRegistry.registerGlobalEntityID(Goblin.class, "Goblin", EntityRegistry.findGlobalUniqueEntityId(), new Color(99, 153, 99).getRGB(), new Color(50, 50, 50).getRGB());
        EntityRegistry.registerModEntity(Goblin.class, "Goblin", 424, this.instance, 40, 2, true);

        EntityRegistry.registerGlobalEntityID(GoblinKing.class, "GoblinKing", EntityRegistry.findGlobalUniqueEntityId(), new Color(99, 153, 99).getRGB(), new Color(104, 75, 12).getRGB());
        EntityRegistry.registerModEntity(GoblinKing.class, "GoblinKing", 425, this.instance, 44, 2, true);

        EntityRegistry.registerGlobalEntityID(WolfNether.class, "WolfNether", EntityRegistry.findGlobalUniqueEntityId(), new Color(46, 102, 1).getRGB(), new Color(46, 2, 106).getRGB());
        EntityRegistry.registerModEntity(WolfNether.class, "WolfNether", 426, this.instance, 46, 2, true);

        EntityRegistry.registerGlobalEntityID(KCreeper.class, "KCreeper", EntityRegistry.findGlobalUniqueEntityId(), new Color(164, 122, 121).getRGB(), new Color(6, 17, 22).getRGB());
        EntityRegistry.registerModEntity(KCreeper.class, "KCreeper", 429, this.instance, 50, 2, true);

        EntityRegistry.registerGlobalEntityID(EntityCreeperBoss.class, "EntityCreeperBoss", EntityRegistry.findGlobalUniqueEntityId(), new Color(164, 122, 121).getRGB(), new Color(6, 17, 22).getRGB());
        EntityRegistry.registerModEntity(EntityCreeperBoss.class, "EntityCreeperBoss", 433, this.instance, 51, 2, true);

        EntityRegistry.registerGlobalEntityID(KingHeal.class, "KingHeal", EntityRegistry.findGlobalUniqueEntityId(), new Color(151, 123, 12).getRGB(), new Color(12, 45, 78).getRGB());
        EntityRegistry.registerModEntity(KingHeal.class, "KingHeal", 422, this.instance, 45, 2, true);

        EntityRegistry.addSpawn(Goblin.class, 80, 2, 10, EnumCreatureType.monster, biomes);
        EntityRegistry.addSpawn(EntityGiantZombie.class, 53, 2, 100, EnumCreatureType.monster, biomes);
        MinecraftForge.addGrassSeed(new ItemStack(Enderdeath.baiePlantItem), 10);
        MinecraftForge.addGrassSeed(new ItemStack(Enderdeath.baiePlantFireItem), 10);
        MinecraftForge.addGrassSeed(new ItemStack(Enderdeath.baiePlantGreenItem), 10);
        MinecraftForge.addGrassSeed(new ItemStack(Enderdeath.baiePlantItemWater), 10);
        MinecraftForge.addGrassSeed(new ItemStack(Enderdeath.baiePlantYellowItem), 10);

    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onTickClient(TickEvent.ClientTickEvent event)
    {
        if(event.phase == Phase.START)
        {
            Minecraft mc = Minecraft.getMinecraft();
            GuiScreen currentScreen = mc.currentScreen;
            GuiCustomMenu customMenu = new GuiCustomMenu();

            if(currentScreen instanceof GuiMainMenu && !currentScreen.equals(customMenu))
            {
                mc.displayGuiScreen(customMenu);
            }
        }
    }
}
