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
    // Spring Crops
    BLUE_JAZZ(CropInfo.BLUE_JAZZ.create()),
    CARROT(CropInfo.CARROT.create()),
    CAULIFLOWER(CropInfo.CAULIFLOWER.create()),
    COFFEE_BEAN(CropInfo.COFFEE_BEAN.create()),
    GARLIC(CropInfo.GARLIC.create()),
    GREEN_BEAN(CropInfo.GREEN_BEAN.create()),
    KALE(CropInfo.KALE.create()),
    PARSNIP(CropInfo.PARSNIP.create()),
    POTATO(CropInfo.POTATO.create()),
    RHUBARB(CropInfo.RHUBARB.create()),
    STRAWBERRY(CropInfo.STRAWBERRY.create()),
    TULIP(CropInfo.TULIP.create()),
    UNMILLED_RICE(CropInfo.UNMILLED_RICE.create()),

    // Summer Crops
    BLUEBERRY(CropInfo.BLUEBERRY.create()),
    CORN(CropInfo.CORN.create()),
    HOPS(CropInfo.HOPS.create()),
    HOT_PEPPER(CropInfo.HOT_PEPPER.create()),
    MELON(CropInfo.MELON.create()),
    POPPY(CropInfo.POPPY.create()),
    RADISH(CropInfo.RADISH.create()),
    RED_CABBAGE(CropInfo.RED_CABBAGE.create()),
    STARFRUIT(CropInfo.STARFRUIT.create()),
    SUMMER_SPANGLE(CropInfo.SUMMER_SPANGLE.create()),
    SUMMER_SQUASH(CropInfo.SUMMER_SQUASH.create()),
    SUNFLOWER(CropInfo.SUNFLOWER.create()),
    TOMATO(CropInfo.TOMATO.create()),
    WHEAT(CropInfo.WHEAT.create()),

    // Fall Crops
    AMARANTH(CropInfo.AMARANTH.create()),
    ARTICHOKE(CropInfo.ARTICHOKE.create()),
    BEET(CropInfo.BEET.create()),
    BOK_CHOY(CropInfo.BOK_CHOY.create()),
    BROCCOLI(CropInfo.BROCCOLI.create()),
    CRANBERRIES(CropInfo.CRANBERRIES.create()),
    EGGPLANT(CropInfo.EGGPLANT.create()),
    FAIRY_ROSE(CropInfo.FAIRY_ROSE.create()),
    GRAPE(CropInfo.GRAPE.create()),
    PUMPKIN(CropInfo.PUMPKIN.create()),
    YAM(CropInfo.YAM.create()),
    SWEET_GEM_BERRY(CropInfo.SWEET_GEM_BERRY.create()),
    POWDER_MELON(CropInfo.POWDERMELON.create()),
    ANCIENT_FRUIT(CropInfo.ANCIENT_FRUIT.create()),

    // Tree Saplings
    // Spring Trees
    APRICOT_SAPLING(TreeSeedInfo.APRICOT_SAPLING.create()),
    CHERRY_SAPLING(TreeSeedInfo.CHERRY_SAPLING.create()),

    // Summer Trees
    BANANA_SAPLING(TreeSeedInfo.BANANA_SAPLING.create()),
    MANGO_SAPLING(TreeSeedInfo.MANGO_SAPLING.create()),
    ORANGE_SAPLING(TreeSeedInfo.ORANGE_SAPLING.create()),
    PEACH_SAPLING(TreeSeedInfo.PEACH_SAPLING.create()),

    // Fall Trees
    APPLE_SAPLING(TreeSeedInfo.APPLE_SAPLING.create()),
    POMEGRANATE_SAPLING(TreeSeedInfo.POMEGRANATE_SAPLING.create()),

    // Special Trees
    ACORNS(TreeSeedInfo.ACORNS.create()),
    MAPLE_SEEDS(TreeSeedInfo.MAPLE_SEEDS.create()),
    PINE_CONES(TreeSeedInfo.PINE_CONES.create()),
    MAHOGANY_SEEDS(TreeSeedInfo.MAHOGANY_SEEDS.create()),
    MUSHROOM_TREE_SEEDS(TreeSeedInfo.MUSHROOM_TREE_SEEDS.create()),
    MYSTIC_TREE_SEEDS(TreeSeedInfo.MYSTIC_TREE_SEEDS.create()),

    // Seeds
    // Summer Seeds
    BLUEBERRY_SEEDS(SeedInfo.BLUEBERRY_SEEDS.create()),
    CORN_SEEDS(SeedInfo.CORN_SEEDS.create()),
    HOPS_STARTER(SeedInfo.HOPS_STARTER.create()),
    PEPPER_SEEDS(SeedInfo.PEPPER_SEEDS.create()),
    MELON_SEEDS(SeedInfo.MELON_SEEDS.create()),
    POPPY_SEEDS(SeedInfo.POPPY_SEEDS.create()),
    RADISH_SEEDS(SeedInfo.RADISH_SEEDS.create()),
    RED_CABBAGE_SEEDS(SeedInfo.RED_CABBAGE_SEEDS.create()),
    STARFRUIT_SEEDS(SeedInfo.STARFRUIT_SEEDS.create()),
    SPANGLE_SEEDS(SeedInfo.SPANGLE_SEEDS.create()),
    SUMMER_SQUASH_SEEDS(SeedInfo.SUMMER_SQUASH_SEEDS.create()),
    SUNFLOWER_SEEDS(SeedInfo.SUNFLOWER_SEEDS.create()),
    TOMATO_SEEDS(SeedInfo.TOMATO_SEEDS.create()),
    WHEAT_SEEDS(SeedInfo.WHEAT_SEEDS.create()),

    // Fall Seeds
    AMARANTH_SEEDS(SeedInfo.AMARANTH_SEEDS.create()),
    ARTICHOKE_SEEDS(SeedInfo.ARTICHOKE_SEEDS.create()),
    BEET_SEEDS(SeedInfo.BEET_SEEDS.create()),
    BOK_CHOY_SEEDS(SeedInfo.BOK_CHOY_SEEDS.create()),
    BROCCOLI_SEEDS(SeedInfo.BROCCOLI_SEEDS.create()),
    CRANBERRY_SEEDS(SeedInfo.CRANBERRY_SEEDS.create()),
    EGGPLANT_SEEDS(SeedInfo.EGGPLANT_SEEDS.create()),
    FAIRY_SEEDS(SeedInfo.FAIRY_SEEDS.create()),
    GRAPE_STARTER(SeedInfo.GRAPE_STARTER.create()),
    PUMPKIN_SEEDS(SeedInfo.PUMPKIN_SEEDS.create()),
    YAM_SEEDS(SeedInfo.YAM_SEEDS.create()),
    RARE_SEED(SeedInfo.RARE_SEED.create()),

    // Winter Seeds
    POWDERMELON_SEEDS(SeedInfo.POWDERMELON_SEEDS.create()),

    // Special Seeds
    ANCIENT_SEEDS(SeedInfo.ANCIENT_SEEDS.create()),

    // Foraged Items
    COMMON_MUSHROOM(ForagingCropInfo.COMMON_MUSHROOM.create()),
    DAFFODIL(ForagingCropInfo.DAFFODIL.create()),
    DANDELION(ForagingCropInfo.DANDELION.create()),
    LEEK(ForagingCropInfo.LEEK.create()),
    MOREL(ForagingCropInfo.MOREL.create()),
    SALMONBERRY(ForagingCropInfo.SALMONBERRY.create()),
    SPRING_ONION(ForagingCropInfo.SPRING_ONION.create()),
    WILD_HORSERADISH(ForagingCropInfo.WILD_HORSERADISH.create()),
    FIDDLEHEAD_FERN(ForagingCropInfo.FIDDLEHEAD_FERN.create()),
    FORAGED_GRAPE(ForagingCropInfo.FORAGED_GRAPE.create()),
    RED_MUSHROOM(ForagingCropInfo.RED_MUSHROOM.create()),
    SPICE_BERRY(ForagingCropInfo.SPICE_BERRY.create()),
    SWEET_PEA(ForagingCropInfo.SWEET_PEA.create()),
    BLACKBERRY(ForagingCropInfo.BLACKBERRY.create()),
    CHANTERELLE(ForagingCropInfo.CHANTERELLE.create()),
    HAZELNUT(ForagingCropInfo.HAZELNUT.create()),
    PURPLE_MUSHROOM(ForagingCropInfo.PURPLE_MUSHROOM.create()),
    WILD_PLUM(ForagingCropInfo.WILD_PLUM.create()),
    CROCUS(ForagingCropInfo.CROCUS.create()),
    CRYSTAL_FRUIT(ForagingCropInfo.CRYSTAL_FRUIT.create()),
    HOLLY(ForagingCropInfo.HOLLY.create()),

    // Minerals
    QUARTZ(MineralsInfo.QUARTZ.create()),
    EARTH_CRYSTAL(MineralsInfo.EARTH_CRYSTAL.create()),
    FROZEN_TEAR(MineralsInfo.FROZEN_TEAR.create()),
    FIRE_QUARTZ(MineralsInfo.FIRE_QUARTZ.create()),
    EMERALD(MineralsInfo.EMERALD.create()),
    AQUAMARINE(MineralsInfo.AQUAMARINE.create()),
    RUBY(MineralsInfo.RUBY.create()),
    AMETHYST(MineralsInfo.AMETHYST.create()),
    TOPAZ(MineralsInfo.TOPAZ.create()),
    JADE(MineralsInfo.JADE.create()),
    DIAMOND(MineralsInfo.DIAMOND.create()),
    PRISMATIC_SHARD(MineralsInfo.PRISMATIC_SHARD.create()),
    COPPER(MineralsInfo.COPPER.create()),
    IRON(MineralsInfo.IRON.create()),
    GOLD(MineralsInfo.GOLD.create()),
    IRIDIUM(MineralsInfo.IRIDIUM.create()),
    COAL(MineralsInfo.COAL.create()),

    // Honey
    HONEY(RecipeInfo.HONEY.getResult()),

    // Dairy Products
    CHEESE(RecipeInfo.CHEESE.getResult()),
    LARGE_MILK_CHEESE(RecipeInfo.LARGE_MILK_CHEESE.getResult()),
    GOAT_CHEESE(RecipeInfo.GOAT_CHEESE.getResult()),
    LARGE_GOAT_CHEESE(RecipeInfo.LARGE_GOAT_CHEESE.getResult()),

    // Egg Products
    MAYONNAISE(RecipeInfo.MAYONNAISE.getResult()),
    LARGE_MAYONNAISE(RecipeInfo.LARGE_MAYONNAISE.getResult()),
    DUCK_MAYONNAISE(RecipeInfo.DUCK_MAYONNAISE.getResult()),
    DINOSAUR_MAYONNAISE(RecipeInfo.DINOSAUR_MAYONNAISE.getResult()),

    // Alcoholic Beverages
    BEER(RecipeInfo.BEER.getResult()),
    PALE_ALE(RecipeInfo.PALE_ALE.getResult()),
    MEAD(RecipeInfo.MEAD.getResult()),

    // Other Beverages
    COFFEE(RecipeInfo.COFFEE.getResult()),

    // Condiments and Oils
    VINEGAR(RecipeInfo.VINEGAR.getResult()),
    TRUFFLE_OIL(RecipeInfo.TRUFFLE_OIL.getResult()),
    CORN_OIL(RecipeInfo.CORN_OIL.getResult()),
    SUNFLOWER_OIL(RecipeInfo.SUNFLOWER_OIL.getResult()),

    // Spring Fruit Wines
    APRICOT_WINE(RecipeInfo.APRICOT_WINE.getResult()),
    CHERRY_WINE(RecipeInfo.CHERRY_WINE.getResult()),
    STRAWBERRY_WINE(RecipeInfo.STRAWBERRY_WINE.getResult()),

    // Summer Fruit Wines
    BANANA_WINE(RecipeInfo.BANANA_WINE.getResult()),
    BLUEBERRY_WINE(RecipeInfo.BLUEBERRY_WINE.getResult()),
    MANGO_WINE(RecipeInfo.MANGO_WINE.getResult()),
    MELON_WINE(RecipeInfo.MELON_WINE.getResult()),
    ORANGE_WINE(RecipeInfo.ORANGE_WINE.getResult()),
    PEACH_WINE(RecipeInfo.PEACH_WINE.getResult()),

    // Fall Fruit Wines
    APPLE_WINE(RecipeInfo.APPLE_WINE.getResult()),
    CRANBERRY_WINE(RecipeInfo.CRANBERRY_WINE.getResult()),
    GRAPE_WINE(RecipeInfo.GRAPE_WINE.getResult()),
    POMEGRANATE_WINE(RecipeInfo.POMEGRANATE_WINE.getResult()),

    // Special Wines
    ANCIENT_FRUIT_WINE(RecipeInfo.ANCIENT_FRUIT_WINE.getResult()),

    // Spring Fruit Juices
    APRICOT_JUICE(RecipeInfo.APRICOT_JUICE.getResult()),
    CHERRY_JUICE(RecipeInfo.CHERRY_JUICE.getResult()),
    STRAWBERRY_JUICE(RecipeInfo.STRAWBERRY_JUICE.getResult()),

    // Summer Fruit Juices
    BANANA_JUICE(RecipeInfo.BANANA_JUICE.getResult()),
    BLUEBERRY_JUICE(RecipeInfo.BLUEBERRY_JUICE.getResult()),
    MANGO_JUICE(RecipeInfo.MANGO_JUICE.getResult()),
    MELON_JUICE(RecipeInfo.MELON_JUICE.getResult()),
    ORANGE_JUICE(RecipeInfo.ORANGE_JUICE.getResult()),
    PEACH_JUICE(RecipeInfo.PEACH_JUICE.getResult()),

    // Fall Fruit Juices
    APPLE_JUICE(RecipeInfo.APPLE_JUICE.getResult()),
    CRANBERRY_JUICE(RecipeInfo.CRANBERRY_JUICE.getResult()),
    GRAPE_JUICE(RecipeInfo.GRAPE_JUICE.getResult()),
    POMEGRANATE_JUICE(RecipeInfo.POMEGRANATE_JUICE.getResult()),

    // Pickled Vegetables
    PICKLED_ARTICHOKE(RecipeInfo.PICKLED_ARTICHOKE.getResult()),
    PICKLED_BEET(RecipeInfo.PICKLED_BEET.getResult()),
    PICKLED_BOK_CHOY(RecipeInfo.PICKLED_BOK_CHOY.getResult()),
    PICKLED_BROCCOLI(RecipeInfo.PICKLED_BROCCOLI.getResult()),
    PICKLED_CAULIFLOWER(RecipeInfo.PICKLED_CAULIFLOWER.getResult()),
    PICKLED_CORN(RecipeInfo.PICKLED_CORN.getResult()),
    PICKLED_EGGPLANT(RecipeInfo.PICKLED_EGGPLANT.getResult()),
    PICKLED_GARLIC(RecipeInfo.PICKLED_GARLIC.getResult()),
    PICKLED_GREEN_BEAN(RecipeInfo.PICKLED_GREEN_BEAN.getResult()),
    PICKLED_HOT_PEPPER(RecipeInfo.PICKLED_HOT_PEPPER.getResult()),
    PICKLED_KALE(RecipeInfo.PICKLED_KALE.getResult()),
    PICKLED_PARSNIP(RecipeInfo.PICKLED_PARSNIP.getResult()),
    PICKLED_POTATO(RecipeInfo.PICKLED_POTATO.getResult()),
    PICKLED_PUMPKIN(RecipeInfo.PICKLED_PUMPKIN.getResult()),
    PICKLED_RADISH(RecipeInfo.PICKLED_RADISH.getResult()),
    PICKLED_RED_CABBAGE(RecipeInfo.PICKLED_RED_CABBAGE.getResult()),
    PICKLED_TOMATO(RecipeInfo.PICKLED_TOMATO.getResult()),
    PICKLED_YAM(RecipeInfo.PICKLED_YAM.getResult()),

    // Spring Fruit Jellies
    APRICOT_JELLY(RecipeInfo.APRICOT_JELLY.getResult()),
    CHERRY_JELLY(RecipeInfo.CHERRY_JELLY.getResult()),
    STRAWBERRY_JELLY(RecipeInfo.STRAWBERRY_JELLY.getResult()),

    // Summer Fruit Jellies
    BANANA_JELLY(RecipeInfo.BANANA_JELLY.getResult()),
    BLUEBERRY_JELLY(RecipeInfo.BLUEBERRY_JELLY.getResult()),
    MANGO_JELLY(RecipeInfo.MANGO_JELLY.getResult()),
    MELON_JELLY(RecipeInfo.MELON_JELLY.getResult()),
    ORANGE_JELLY(RecipeInfo.ORANGE_JELLY.getResult()),
    PEACH_JELLY(RecipeInfo.PEACH_JELLY.getResult()),

    // Fall Fruit Jellies
    APPLE_JELLY(RecipeInfo.APPLE_JELLY.getResult()),
    CRANBERRY_JELLY(RecipeInfo.CRANBERRY_JELLY.getResult()),
    GRAPE_JELLY(RecipeInfo.GRAPE_JELLY.getResult()),
    POMEGRANATE_JELLY(RecipeInfo.POMEGRANATE_JELLY.getResult()),

    // Special Fruit Jellies
    ANCIENT_FRUIT_JELLY(RecipeInfo.ANCIENT_FRUIT_JELLY.getResult()),
    SWEET_GEM_BERRY_JELLY(RecipeInfo.SWEET_GEM_BERRY_JELLY.getResult()),
    POWDERMELON_JELLY(RecipeInfo.POWDERMELON_JELLY.getResult()),

    // Dried Products
    DRIED_MOREL(RecipeInfo.DRIED_MOREL.getResult()),
    DRIED_CHANTERELLE(RecipeInfo.DRIED_CHANTERELLE.getResult()),
    DRIED_APPLE(RecipeInfo.DRIED_APPLE.getResult()),
    RAISINS(RecipeInfo.RAISINS.getResult()),

    // Regular Smoked Fish
    SMOKED_FLOUNDER(RecipeInfo.SMOKED_FLOUNDER.getResult()),
    SMOKED_LIONFISH(RecipeInfo.SMOKED_LIONFISH.getResult()),
    SMOKED_HERRING(RecipeInfo.SMOKED_HERRING.getResult()),
    SMOKED_GHOSTFISH(RecipeInfo.SMOKED_GHOSTFISH.getResult()),
    SMOKED_TILAPIA(RecipeInfo.SMOKED_TILAPIA.getResult()),
    SMOKED_DORADO(RecipeInfo.SMOKED_DORADO.getResult()),
    SMOKED_SUNFISH(RecipeInfo.SMOKED_SUNFISH.getResult()),
    SMOKED_RAINBOW_TROUT(RecipeInfo.SMOKED_RAINBOW_TROUT.getResult()),
    SMOKED_SALMON(RecipeInfo.SMOKED_SALMON.getResult()),
    SMOKED_SARDINE(RecipeInfo.SMOKED_SARDINE.getResult()),
    SMOKED_SHAD(RecipeInfo.SMOKED_SHAD.getResult()),
    SMOKED_BLUE_DISCUS(RecipeInfo.SMOKED_BLUE_DISCUS.getResult()),
    SMOKED_MIDNIGHT_CARP(RecipeInfo.SMOKED_MIDNIGHT_CARP.getResult()),
    SMOKED_SQUID(RecipeInfo.SMOKED_SQUID.getResult()),
    SMOKED_TUNA(RecipeInfo.SMOKED_TUNA.getResult()),
    SMOKED_PERCH(RecipeInfo.SMOKED_PERCH.getResult()),

    // Legendary Smoked Fish
    SMOKED_LEGEND(RecipeInfo.SMOKED_LEGEND.getResult()),
    SMOKED_GLACIERFISH(RecipeInfo.SMOKED_GLACIERFISH.getResult()),
    SMOKED_ANGLER(RecipeInfo.SMOKED_ANGLER.getResult()),
    SMOKED_CRIMSONFISH(RecipeInfo.SMOKED_CRIMSONFISH.getResult()),

    // Artisan Goods (Inedible)
    CLOTH(RecipeInfo.CLOTH.getResult()),
    COPPER_BAR(RecipeInfo.COPPER_BAR.getResult()),
    IRON_BAR(RecipeInfo.IRON_BAR.getResult()),
    GOLD_BAR(RecipeInfo.GOLD_BAR.getResult()),
    IRIDIUM_BAR(RecipeInfo.IRIDIUM_BAR.getResult()),

    ;
    private final InventoryItem inventoryItem;
    private final Item item;
    private final int id;

    // Initialize IDs after enum construction
    private static final int[] ids;

    static {
        ids = new int[values().length];
        for (int i = 0; i < values().length; i++) {
            ids[i] = i + 1;
        }
    }

    ItemFinder(InventoryItem item) {
        this.item = null;
        this.id = ordinal() + 1;
        item.setId(id);
        this.inventoryItem = item;
    }

    ItemFinder(Item item) {
        this.id = ordinal() + 1;
        item.setId(id);
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
        if (id > 0 && id <= values().length) {
            return values()[id - 1];
        }
        return null;
    }

    public static InventoryItem getItemById(int id) {
        ItemFinder finder = getById(id);
        if (finder != null) {
            return finder.getItem() != null ? finder.getItem() : finder.getInventoryItem();
        }
        return null;
    }

    public static InventoryItem getInventoryItemById(int id) {
        ItemFinder finder = getById(id);
        return finder != null ? finder.getInventoryItem() : null;
    }

    public static int getCurrentMaxId() {
        return values().length;
    }

}
