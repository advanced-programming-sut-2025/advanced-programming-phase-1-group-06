package models.ItemFaces;

import models.Crafting.RecipeInfo;
import models.PlantsAndForaging.Info.*;

/**
 * Last updated by: hassanp30
 * Last updated at: 2025-05-13 12:59:24 UTC
 *
 * MAKE SURE YOU SET THE VALUES TO 1 WHEN CREATING NEW OBJECTS
 */
public enum ItemFinder {
    // Spring Crops (1-13)
    BLUE_JAZZ(1, CropInfo.BLUE_JAZZ.create()),
    CARROT(2, CropInfo.CARROT.create()),
    CAULIFLOWER(3, CropInfo.CAULIFLOWER.create()),
    COFFEE_BEAN(4, CropInfo.COFFEE_BEAN.create()),
    GARLIC(5, CropInfo.GARLIC.create()),
    GREEN_BEAN(6, CropInfo.GREEN_BEAN.create()),
    KALE(7, CropInfo.KALE.create()),
    PARSNIP(8, CropInfo.PARSNIP.create()),
    POTATO(9, CropInfo.POTATO.create()),
    RHUBARB(10, CropInfo.RHUBARB.create()),
    STRAWBERRY(11, CropInfo.STRAWBERRY.create()),
    TULIP(12, CropInfo.TULIP.create()),
    UNMILLED_RICE(13, CropInfo.UNMILLED_RICE.create()),

    // Summer Crops (14-28)
    BLUEBERRY(14, CropInfo.BLUEBERRY.create()),
    CORN(15, CropInfo.CORN.create()),
    HOPS(16, CropInfo.HOPS.create()),
    HOT_PEPPER(17, CropInfo.HOT_PEPPER.create()),
    MELON(18, CropInfo.MELON.create()),
    POPPY(19, CropInfo.POPPY.create()),
    RADISH(20, CropInfo.RADISH.create()),
    RED_CABBAGE(21, CropInfo.RED_CABBAGE.create()),
    STARFRUIT(22, CropInfo.STARFRUIT.create()),
    SUMMER_SPANGLE(23, CropInfo.SUMMER_SPANGLE.create()),
    SUMMER_SQUASH(24, CropInfo.SUMMER_SQUASH.create()),
    SUNFLOWER(25, CropInfo.SUNFLOWER.create()),
    TOMATO(26, CropInfo.TOMATO.create()),
    WHEAT(27, CropInfo.WHEAT.create()),

    // Fall Crops (29-43)
    AMARANTH(29, CropInfo.AMARANTH.create()),
    ARTICHOKE(30, CropInfo.ARTICHOKE.create()),
    BEET(31, CropInfo.BEET.create()),
    BOK_CHOY(32, CropInfo.BOK_CHOY.create()),
    BROCCOLI(33, CropInfo.BROCCOLI.create()),
    CRANBERRIES(34, CropInfo.CRANBERRIES.create()),
    EGGPLANT(35, CropInfo.EGGPLANT.create()),
    FAIRY_ROSE(36, CropInfo.FAIRY_ROSE.create()),
    GRAPE(37, CropInfo.GRAPE.create()),
    PUMPKIN(38, CropInfo.PUMPKIN.create()),
    YAM(39, CropInfo.YAM.create()),
    SWEET_GEM_BERRY(40, CropInfo.SWEET_GEM_BERRY.create()),
    POWDER_MELON(41, CropInfo.POWDERMELON.create()),
    ANCIENT_FRUIT(42, CropInfo.ANCIENT_FRUIT.create()),

    // Tree Saplings (43-60)
    // Spring Trees
    APRICOT_SAPLING(43, TreeSeedInfo.APRICOT_SAPLING.create()),
    CHERRY_SAPLING(44, TreeSeedInfo.CHERRY_SAPLING.create()),

    // Summer Trees
    BANANA_SAPLING(45, TreeSeedInfo.BANANA_SAPLING.create()),
    MANGO_SAPLING(46, TreeSeedInfo.MANGO_SAPLING.create()),
    ORANGE_SAPLING(47, TreeSeedInfo.ORANGE_SAPLING.create()),
    PEACH_SAPLING(48, TreeSeedInfo.PEACH_SAPLING.create()),

    // Fall Trees
    APPLE_SAPLING(49, TreeSeedInfo.APPLE_SAPLING.create()),
    POMEGRANATE_SAPLING(50, TreeSeedInfo.POMEGRANATE_SAPLING.create()),

    // Special Trees
    ACORNS(51, TreeSeedInfo.ACORNS.create()),
    MAPLE_SEEDS(52, TreeSeedInfo.MAPLE_SEEDS.create()),
    PINE_CONES(53, TreeSeedInfo.PINE_CONES.create()),
    MAHOGANY_SEEDS(54, TreeSeedInfo.MAHOGANY_SEEDS.create()),
    MUSHROOM_TREE_SEEDS(55, TreeSeedInfo.MUSHROOM_TREE_SEEDS.create()),
    MYSTIC_TREE_SEEDS(56, TreeSeedInfo.MYSTIC_TREE_SEEDS.create()),

    // Seeds (61-90)
    // Summer Seeds
    BLUEBERRY_SEEDS(61, SeedInfo.BLUEBERRY_SEEDS.create()),
    CORN_SEEDS(62, SeedInfo.CORN_SEEDS.create()),
    HOPS_STARTER(63, SeedInfo.HOPS_STARTER.create()),
    PEPPER_SEEDS(64, SeedInfo.PEPPER_SEEDS.create()),
    MELON_SEEDS(65, SeedInfo.MELON_SEEDS.create()),
    POPPY_SEEDS(66, SeedInfo.POPPY_SEEDS.create()),
    RADISH_SEEDS(67, SeedInfo.RADISH_SEEDS.create()),
    RED_CABBAGE_SEEDS(68, SeedInfo.RED_CABBAGE_SEEDS.create()),
    STARFRUIT_SEEDS(69, SeedInfo.STARFRUIT_SEEDS.create()),
    SPANGLE_SEEDS(70, SeedInfo.SPANGLE_SEEDS.create()),
    SUMMER_SQUASH_SEEDS(71, SeedInfo.SUMMER_SQUASH_SEEDS.create()),
    SUNFLOWER_SEEDS(72, SeedInfo.SUNFLOWER_SEEDS.create()),
    TOMATO_SEEDS(73, SeedInfo.TOMATO_SEEDS.create()),
    WHEAT_SEEDS(74, SeedInfo.WHEAT_SEEDS.create()),

    // Fall Seeds
    AMARANTH_SEEDS(75, SeedInfo.AMARANTH_SEEDS.create()),
    ARTICHOKE_SEEDS(76, SeedInfo.ARTICHOKE_SEEDS.create()),
    BEET_SEEDS(77, SeedInfo.BEET_SEEDS.create()),
    BOK_CHOY_SEEDS(78, SeedInfo.BOK_CHOY_SEEDS.create()),
    BROCCOLI_SEEDS(79, SeedInfo.BROCCOLI_SEEDS.create()),
    CRANBERRY_SEEDS(80, SeedInfo.CRANBERRY_SEEDS.create()),
    EGGPLANT_SEEDS(81, SeedInfo.EGGPLANT_SEEDS.create()),
    FAIRY_SEEDS(82, SeedInfo.FAIRY_SEEDS.create()),
    GRAPE_STARTER(83, SeedInfo.GRAPE_STARTER.create()),
    PUMPKIN_SEEDS(84, SeedInfo.PUMPKIN_SEEDS.create()),
    YAM_SEEDS(85, SeedInfo.YAM_SEEDS.create()),
    RARE_SEED(86, SeedInfo.RARE_SEED.create()),

    // Winter Seeds
    POWDERMELON_SEEDS(87, SeedInfo.POWDERMELON_SEEDS.create()),

    // Special Seeds
    ANCIENT_SEEDS(88, SeedInfo.ANCIENT_SEEDS.create()),

    // Foraged Items (91-111)
    COMMON_MUSHROOM(91, ForagingCropInfo.COMMON_MUSHROOM.create()),
    DAFFODIL(92, ForagingCropInfo.DAFFODIL.create()),
    DANDELION(93, ForagingCropInfo.DANDELION.create()),
    LEEK(94, ForagingCropInfo.LEEK.create()),
    MOREL(95, ForagingCropInfo.MOREL.create()),
    SALMONBERRY(96, ForagingCropInfo.SALMONBERRY.create()),
    SPRING_ONION(97, ForagingCropInfo.SPRING_ONION.create()),
    WILD_HORSERADISH(98, ForagingCropInfo.WILD_HORSERADISH.create()),
    FIDDLEHEAD_FERN(99, ForagingCropInfo.FIDDLEHEAD_FERN.create()),
    FORAGED_GRAPE(100, ForagingCropInfo.FORAGED_GRAPE.create()),
    RED_MUSHROOM(101, ForagingCropInfo.RED_MUSHROOM.create()),
    SPICE_BERRY(102, ForagingCropInfo.SPICE_BERRY.create()),
    SWEET_PEA(103, ForagingCropInfo.SWEET_PEA.create()),
    BLACKBERRY(104, ForagingCropInfo.BLACKBERRY.create()),
    CHANTERELLE(105, ForagingCropInfo.CHANTERELLE.create()),
    HAZELNUT(106, ForagingCropInfo.HAZELNUT.create()),
    PURPLE_MUSHROOM(107, ForagingCropInfo.PURPLE_MUSHROOM.create()),
    WILD_PLUM(108, ForagingCropInfo.WILD_PLUM.create()),
    CROCUS(109, ForagingCropInfo.CROCUS.create()),
    CRYSTAL_FRUIT(110, ForagingCropInfo.CRYSTAL_FRUIT.create()),
    HOLLY(111, ForagingCropInfo.HOLLY.create()),

    // Minerals (112-128)
    QUARTZ(112, MineralsInfo.QUARTZ.create()),
    EARTH_CRYSTAL(113, MineralsInfo.EARTH_CRYSTAL.create()),
    FROZEN_TEAR(114, MineralsInfo.FROZEN_TEAR.create()),
    FIRE_QUARTZ(115, MineralsInfo.FIRE_QUARTZ.create()),
    EMERALD(116, MineralsInfo.EMERALD.create()),
    AQUAMARINE(117, MineralsInfo.AQUAMARINE.create()),
    RUBY(118, MineralsInfo.RUBY.create()),
    AMETHYST(119, MineralsInfo.AMETHYST.create()),
    TOPAZ(120, MineralsInfo.TOPAZ.create()),
    JADE(121, MineralsInfo.JADE.create()),
    DIAMOND(122, MineralsInfo.DIAMOND.create()),
    PRISMATIC_SHARD(123, MineralsInfo.PRISMATIC_SHARD.create()),
    COPPER(124, MineralsInfo.COPPER.create()),
    IRON(125, MineralsInfo.IRON.create()),
    GOLD(126, MineralsInfo.GOLD.create()),
    IRIDIUM(127, MineralsInfo.IRIDIUM.create()),
    COAL(128, MineralsInfo.COAL.create()),

//    crafted stuff
//    Honey
    HONEY(129, RecipeInfo.HONEY.getResult()),

    // Dairy Products
    CHEESE(130, RecipeInfo.CHEESE.getResult()),
    LARGE_MILK_CHEESE(131, RecipeInfo.LARGE_MILK_CHEESE.getResult()),
    GOAT_CHEESE(132, RecipeInfo.GOAT_CHEESE.getResult()),
    LARGE_GOAT_CHEESE(133, RecipeInfo.LARGE_GOAT_CHEESE.getResult()),

    // Egg Products
    MAYONNAISE(134, RecipeInfo.MAYONNAISE.getResult()),
    LARGE_MAYONNAISE(135, RecipeInfo.LARGE_MAYONNAISE.getResult()),
    DUCK_MAYONNAISE(136, RecipeInfo.DUCK_MAYONNAISE.getResult()),
    DINOSAUR_MAYONNAISE(137, RecipeInfo.DINOSAUR_MAYONNAISE.getResult()),

    // Alcoholic Beverages
    BEER(138, RecipeInfo.BEER.getResult()),
    PALE_ALE(139, RecipeInfo.PALE_ALE.getResult()),
    MEAD(140, RecipeInfo.MEAD.getResult()),

    // Other Beverages
    COFFEE(141, RecipeInfo.COFFEE.getResult()),

    // Condiments and Oils
    VINEGAR(142, RecipeInfo.VINEGAR.getResult()),
    TRUFFLE_OIL(143, RecipeInfo.TRUFFLE_OIL.getResult()),
    CORN_OIL(144, RecipeInfo.CORN_OIL.getResult()),
    SUNFLOWER_OIL(145, RecipeInfo.SUNFLOWER_OIL.getResult()),

    // Spring Fruit Wines
    APRICOT_WINE(146, RecipeInfo.APRICOT_WINE.getResult()),
    CHERRY_WINE(147, RecipeInfo.CHERRY_WINE.getResult()),
    STRAWBERRY_WINE(148, RecipeInfo.STRAWBERRY_WINE.getResult()),

    // Summer Fruit Wines
    BANANA_WINE(149, RecipeInfo.BANANA_WINE.getResult()),
    BLUEBERRY_WINE(150, RecipeInfo.BLUEBERRY_WINE.getResult()),
    MANGO_WINE(151, RecipeInfo.MANGO_WINE.getResult()),
    MELON_WINE(152, RecipeInfo.MELON_WINE.getResult()),
    ORANGE_WINE(153, RecipeInfo.ORANGE_WINE.getResult()),
    PEACH_WINE(154, RecipeInfo.PEACH_WINE.getResult()),

    // Fall Fruit Wines
    APPLE_WINE(155, RecipeInfo.APPLE_WINE.getResult()),
    CRANBERRY_WINE(156, RecipeInfo.CRANBERRY_WINE.getResult()),
    GRAPE_WINE(157, RecipeInfo.GRAPE_WINE.getResult()),
    POMEGRANATE_WINE(158, RecipeInfo.POMEGRANATE_WINE.getResult()),

    // Special Wines
    ANCIENT_FRUIT_WINE(159, RecipeInfo.ANCIENT_FRUIT_WINE.getResult()),

    // Spring Fruit Juices
    APRICOT_JUICE(160, RecipeInfo.APRICOT_JUICE.getResult()),
    CHERRY_JUICE(161, RecipeInfo.CHERRY_JUICE.getResult()),
    STRAWBERRY_JUICE(162, RecipeInfo.STRAWBERRY_JUICE.getResult()),

    // Summer Fruit Juices
    BANANA_JUICE(163, RecipeInfo.BANANA_JUICE.getResult()),
    BLUEBERRY_JUICE(164, RecipeInfo.BLUEBERRY_JUICE.getResult()),
    MANGO_JUICE(165, RecipeInfo.MANGO_JUICE.getResult()),
    MELON_JUICE(166, RecipeInfo.MELON_JUICE.getResult()),
    ORANGE_JUICE(167, RecipeInfo.ORANGE_JUICE.getResult()),
    PEACH_JUICE(168, RecipeInfo.PEACH_JUICE.getResult()),

    // Fall Fruit Juices
    APPLE_JUICE(169, RecipeInfo.APPLE_JUICE.getResult()),
    CRANBERRY_JUICE(170, RecipeInfo.CRANBERRY_JUICE.getResult()),
    GRAPE_JUICE(171, RecipeInfo.GRAPE_JUICE.getResult()),
    POMEGRANATE_JUICE(172, RecipeInfo.POMEGRANATE_JUICE.getResult()),

    // Pickled Vegetables
    PICKLED_ARTICHOKE(173, RecipeInfo.PICKLED_ARTICHOKE.getResult()),
    PICKLED_BEET(174, RecipeInfo.PICKLED_BEET.getResult()),
    PICKLED_BOK_CHOY(175, RecipeInfo.PICKLED_BOK_CHOY.getResult()),
    PICKLED_BROCCOLI(176, RecipeInfo.PICKLED_BROCCOLI.getResult()),
    PICKLED_CAULIFLOWER(177, RecipeInfo.PICKLED_CAULIFLOWER.getResult()),
    PICKLED_CORN(178, RecipeInfo.PICKLED_CORN.getResult()),
    PICKLED_EGGPLANT(179, RecipeInfo.PICKLED_EGGPLANT.getResult()),
    PICKLED_GARLIC(180, RecipeInfo.PICKLED_GARLIC.getResult()),
    PICKLED_GREEN_BEAN(181, RecipeInfo.PICKLED_GREEN_BEAN.getResult()),
    PICKLED_HOT_PEPPER(182, RecipeInfo.PICKLED_HOT_PEPPER.getResult()),
    PICKLED_KALE(183, RecipeInfo.PICKLED_KALE.getResult()),
    PICKLED_PARSNIP(184, RecipeInfo.PICKLED_PARSNIP.getResult()),
    PICKLED_POTATO(185, RecipeInfo.PICKLED_POTATO.getResult()),
    PICKLED_PUMPKIN(186, RecipeInfo.PICKLED_PUMPKIN.getResult()),
    PICKLED_RADISH(187, RecipeInfo.PICKLED_RADISH.getResult()),
    PICKLED_RED_CABBAGE(188, RecipeInfo.PICKLED_RED_CABBAGE.getResult()),
    PICKLED_TOMATO(189, RecipeInfo.PICKLED_TOMATO.getResult()),
    PICKLED_YAM(190, RecipeInfo.PICKLED_YAM.getResult()),

    APRICOT_JELLY(191, RecipeInfo.APRICOT_JELLY.getResult()),
    CHERRY_JELLY(192, RecipeInfo.CHERRY_JELLY.getResult()),
    STRAWBERRY_JELLY(193, RecipeInfo.STRAWBERRY_JELLY.getResult()),

    // Summer Fruit Jellies
    BANANA_JELLY(194, RecipeInfo.BANANA_JELLY.getResult()),
    BLUEBERRY_JELLY(195, RecipeInfo.BLUEBERRY_JELLY.getResult()),
    MANGO_JELLY(196, RecipeInfo.MANGO_JELLY.getResult()),
    MELON_JELLY(197, RecipeInfo.MELON_JELLY.getResult()),
    ORANGE_JELLY(198, RecipeInfo.ORANGE_JELLY.getResult()),
    PEACH_JELLY(199, RecipeInfo.PEACH_JELLY.getResult()),

    // Fall Fruit Jellies
    APPLE_JELLY(200, RecipeInfo.APPLE_JELLY.getResult()),
    CRANBERRY_JELLY(201, RecipeInfo.CRANBERRY_JELLY.getResult()),
    GRAPE_JELLY(202, RecipeInfo.GRAPE_JELLY.getResult()),
    POMEGRANATE_JELLY(203, RecipeInfo.POMEGRANATE_JELLY.getResult()),

    // Special Fruit Jellies
    ANCIENT_FRUIT_JELLY(204, RecipeInfo.ANCIENT_FRUIT_JELLY.getResult()),
    SWEET_GEM_BERRY_JELLY(205, RecipeInfo.SWEET_GEM_BERRY_JELLY.getResult()),
    POWDERMELON_JELLY(206, RecipeInfo.POWDERMELON_JELLY.getResult()),

    // Dried Products
    DRIED_MOREL(207, RecipeInfo.DRIED_MOREL.getResult()),
    DRIED_CHANTERELLE(208, RecipeInfo.DRIED_CHANTERELLE.getResult()),
    DRIED_APPLE(209, RecipeInfo.DRIED_APPLE.getResult()),
    RAISINS(210, RecipeInfo.RAISINS.getResult()),

    // Regular Smoked Fish
    SMOKED_FLOUNDER(211, RecipeInfo.SMOKED_FLOUNDER.getResult()),
    SMOKED_LIONFISH(212, RecipeInfo.SMOKED_LIONFISH.getResult()),
    SMOKED_HERRING(213, RecipeInfo.SMOKED_HERRING.getResult()),
    SMOKED_GHOSTFISH(214, RecipeInfo.SMOKED_GHOSTFISH.getResult()),
    SMOKED_TILAPIA(215, RecipeInfo.SMOKED_TILAPIA.getResult()),
    SMOKED_DORADO(216, RecipeInfo.SMOKED_DORADO.getResult()),
    SMOKED_SUNFISH(217, RecipeInfo.SMOKED_SUNFISH.getResult()),
    SMOKED_RAINBOW_TROUT(218, RecipeInfo.SMOKED_RAINBOW_TROUT.getResult()),
    SMOKED_SALMON(219, RecipeInfo.SMOKED_SALMON.getResult()),
    SMOKED_SARDINE(220, RecipeInfo.SMOKED_SARDINE.getResult()),
    SMOKED_SHAD(221, RecipeInfo.SMOKED_SHAD.getResult()),
    SMOKED_BLUE_DISCUS(222, RecipeInfo.SMOKED_BLUE_DISCUS.getResult()),
    SMOKED_MIDNIGHT_CARP(223, RecipeInfo.SMOKED_MIDNIGHT_CARP.getResult()),
    SMOKED_SQUID(224, RecipeInfo.SMOKED_SQUID.getResult()),
    SMOKED_TUNA(225, RecipeInfo.SMOKED_TUNA.getResult()),
    SMOKED_PERCH(226, RecipeInfo.SMOKED_PERCH.getResult()),

    // Legendary Smoked Fish
    SMOKED_LEGEND(227, RecipeInfo.SMOKED_LEGEND.getResult()),
    SMOKED_GLACIERFISH(228, RecipeInfo.SMOKED_GLACIERFISH.getResult()),
    SMOKED_ANGLER(229, RecipeInfo.SMOKED_ANGLER.getResult()),
    SMOKED_CRIMSONFISH(230, RecipeInfo.SMOKED_CRIMSONFISH.getResult()),

    // Artisan Goods (Inedible)
    CLOTH(231, RecipeInfo.CLOTH.getResult()),
    //    COAL(128, RecipeInfo.COAL.getResult()),  line 160
    COPPER_BAR(232, RecipeInfo.COPPER_BAR.getResult()),
    IRON_BAR(233, RecipeInfo.IRON_BAR.getResult()),
    GOLD_BAR(234, RecipeInfo.GOLD_BAR.getResult()),
    IRIDIUM_BAR(235, RecipeInfo.IRIDIUM_BAR.getResult());
    ;
    private final int id;
    private final InventoryItem inventoryItem;
    private final Item item;

    ItemFinder(int id, InventoryItem item) {
        this.id = id;
        this.inventoryItem = item;
        this.item = null;
    }

    ItemFinder(int id, Item item) {
        this.id = id;
        this.item = item;
        this.inventoryItem = null;
    }

    public int getId() {
        return id;
    }

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public Item getItem() {
        return item;
    }

    public static ItemFinder getById(int id) {
        for (ItemFinder item : values()) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
