package models.ItemFaces;

import models.Crafting.ArtisanRecipeInfo;
import models.PlantsAndForaging.Info.*;
import models.tools.ToolType;

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
    HONEY(ArtisanRecipeInfo.HONEY.getResult()),

    // Dairy Products
    CHEESE(ArtisanRecipeInfo.CHEESE.getResult()),
    LARGE_MILK_CHEESE(ArtisanRecipeInfo.LARGE_MILK_CHEESE.getResult()),
    GOAT_CHEESE(ArtisanRecipeInfo.GOAT_CHEESE.getResult()),
    LARGE_GOAT_CHEESE(ArtisanRecipeInfo.LARGE_GOAT_CHEESE.getResult()),

    // Egg Products
    MAYONNAISE(ArtisanRecipeInfo.MAYONNAISE.getResult()),
    LARGE_MAYONNAISE(ArtisanRecipeInfo.LARGE_MAYONNAISE.getResult()),
    DUCK_MAYONNAISE(ArtisanRecipeInfo.DUCK_MAYONNAISE.getResult()),
    DINOSAUR_MAYONNAISE(ArtisanRecipeInfo.DINOSAUR_MAYONNAISE.getResult()),

    // Alcoholic Beverages
    BEER(ArtisanRecipeInfo.BEER.getResult()),
    PALE_ALE(ArtisanRecipeInfo.PALE_ALE.getResult()),
    MEAD(ArtisanRecipeInfo.MEAD.getResult()),

    // Other Beverages
    COFFEE(ArtisanRecipeInfo.COFFEE.getResult()),

    // Condiments and Oils
    VINEGAR(ArtisanRecipeInfo.VINEGAR.getResult()),
    TRUFFLE_OIL(ArtisanRecipeInfo.TRUFFLE_OIL.getResult()),
    CORN_OIL(ArtisanRecipeInfo.CORN_OIL.getResult()),
    SUNFLOWER_OIL(ArtisanRecipeInfo.SUNFLOWER_OIL.getResult()),

    // Spring Fruit Wines
    APRICOT_WINE(ArtisanRecipeInfo.APRICOT_WINE.getResult()),
    CHERRY_WINE(ArtisanRecipeInfo.CHERRY_WINE.getResult()),
    STRAWBERRY_WINE(ArtisanRecipeInfo.STRAWBERRY_WINE.getResult()),

    // Summer Fruit Wines
    BANANA_WINE(ArtisanRecipeInfo.BANANA_WINE.getResult()),
    BLUEBERRY_WINE(ArtisanRecipeInfo.BLUEBERRY_WINE.getResult()),
    MANGO_WINE(ArtisanRecipeInfo.MANGO_WINE.getResult()),
    MELON_WINE(ArtisanRecipeInfo.MELON_WINE.getResult()),
    ORANGE_WINE(ArtisanRecipeInfo.ORANGE_WINE.getResult()),
    PEACH_WINE(ArtisanRecipeInfo.PEACH_WINE.getResult()),

    // Fall Fruit Wines
    APPLE_WINE(ArtisanRecipeInfo.APPLE_WINE.getResult()),
    CRANBERRY_WINE(ArtisanRecipeInfo.CRANBERRY_WINE.getResult()),
    GRAPE_WINE(ArtisanRecipeInfo.GRAPE_WINE.getResult()),
    POMEGRANATE_WINE(ArtisanRecipeInfo.POMEGRANATE_WINE.getResult()),

    // Special Wines
    ANCIENT_FRUIT_WINE(ArtisanRecipeInfo.ANCIENT_FRUIT_WINE.getResult()),

    // Spring Fruit Juices
    APRICOT_JUICE(ArtisanRecipeInfo.APRICOT_JUICE.getResult()),
    CHERRY_JUICE(ArtisanRecipeInfo.CHERRY_JUICE.getResult()),
    STRAWBERRY_JUICE(ArtisanRecipeInfo.STRAWBERRY_JUICE.getResult()),

    // Summer Fruit Juices
    BANANA_JUICE(ArtisanRecipeInfo.BANANA_JUICE.getResult()),
    BLUEBERRY_JUICE(ArtisanRecipeInfo.BLUEBERRY_JUICE.getResult()),
    MANGO_JUICE(ArtisanRecipeInfo.MANGO_JUICE.getResult()),
    MELON_JUICE(ArtisanRecipeInfo.MELON_JUICE.getResult()),
    ORANGE_JUICE(ArtisanRecipeInfo.ORANGE_JUICE.getResult()),
    PEACH_JUICE(ArtisanRecipeInfo.PEACH_JUICE.getResult()),

    // Fall Fruit Juices
    APPLE_JUICE(ArtisanRecipeInfo.APPLE_JUICE.getResult()),
    CRANBERRY_JUICE(ArtisanRecipeInfo.CRANBERRY_JUICE.getResult()),
    GRAPE_JUICE(ArtisanRecipeInfo.GRAPE_JUICE.getResult()),
    POMEGRANATE_JUICE(ArtisanRecipeInfo.POMEGRANATE_JUICE.getResult()),

    // Pickled Vegetables
    PICKLED_ARTICHOKE(ArtisanRecipeInfo.PICKLED_ARTICHOKE.getResult()),
    PICKLED_BEET(ArtisanRecipeInfo.PICKLED_BEET.getResult()),
    PICKLED_BOK_CHOY(ArtisanRecipeInfo.PICKLED_BOK_CHOY.getResult()),
    PICKLED_BROCCOLI(ArtisanRecipeInfo.PICKLED_BROCCOLI.getResult()),
    PICKLED_CAULIFLOWER(ArtisanRecipeInfo.PICKLED_CAULIFLOWER.getResult()),
    PICKLED_CORN(ArtisanRecipeInfo.PICKLED_CORN.getResult()),
    PICKLED_EGGPLANT(ArtisanRecipeInfo.PICKLED_EGGPLANT.getResult()),
    PICKLED_GARLIC(ArtisanRecipeInfo.PICKLED_GARLIC.getResult()),
    PICKLED_GREEN_BEAN(ArtisanRecipeInfo.PICKLED_GREEN_BEAN.getResult()),
    PICKLED_HOT_PEPPER(ArtisanRecipeInfo.PICKLED_HOT_PEPPER.getResult()),
    PICKLED_KALE(ArtisanRecipeInfo.PICKLED_KALE.getResult()),
    PICKLED_PARSNIP(ArtisanRecipeInfo.PICKLED_PARSNIP.getResult()),
    PICKLED_POTATO(ArtisanRecipeInfo.PICKLED_POTATO.getResult()),
    PICKLED_PUMPKIN(ArtisanRecipeInfo.PICKLED_PUMPKIN.getResult()),
    PICKLED_RADISH(ArtisanRecipeInfo.PICKLED_RADISH.getResult()),
    PICKLED_RED_CABBAGE(ArtisanRecipeInfo.PICKLED_RED_CABBAGE.getResult()),
    PICKLED_TOMATO(ArtisanRecipeInfo.PICKLED_TOMATO.getResult()),
    PICKLED_YAM(ArtisanRecipeInfo.PICKLED_YAM.getResult()),

    // Spring Fruit Jellies
    APRICOT_JELLY(ArtisanRecipeInfo.APRICOT_JELLY.getResult()),
    CHERRY_JELLY(ArtisanRecipeInfo.CHERRY_JELLY.getResult()),
    STRAWBERRY_JELLY(ArtisanRecipeInfo.STRAWBERRY_JELLY.getResult()),

    // Summer Fruit Jellies
    BANANA_JELLY(ArtisanRecipeInfo.BANANA_JELLY.getResult()),
    BLUEBERRY_JELLY(ArtisanRecipeInfo.BLUEBERRY_JELLY.getResult()),
    MANGO_JELLY(ArtisanRecipeInfo.MANGO_JELLY.getResult()),
    MELON_JELLY(ArtisanRecipeInfo.MELON_JELLY.getResult()),
    ORANGE_JELLY(ArtisanRecipeInfo.ORANGE_JELLY.getResult()),
    PEACH_JELLY(ArtisanRecipeInfo.PEACH_JELLY.getResult()),

    // Fall Fruit Jellies
    APPLE_JELLY(ArtisanRecipeInfo.APPLE_JELLY.getResult()),
    CRANBERRY_JELLY(ArtisanRecipeInfo.CRANBERRY_JELLY.getResult()),
    GRAPE_JELLY(ArtisanRecipeInfo.GRAPE_JELLY.getResult()),
    POMEGRANATE_JELLY(ArtisanRecipeInfo.POMEGRANATE_JELLY.getResult()),

    // Special Fruit Jellies
    ANCIENT_FRUIT_JELLY(ArtisanRecipeInfo.ANCIENT_FRUIT_JELLY.getResult()),
    SWEET_GEM_BERRY_JELLY(ArtisanRecipeInfo.SWEET_GEM_BERRY_JELLY.getResult()),
    POWDERMELON_JELLY(ArtisanRecipeInfo.POWDERMELON_JELLY.getResult()),

    // Dried Products
    DRIED_MOREL(ArtisanRecipeInfo.DRIED_MOREL.getResult()),
    DRIED_CHANTERELLE(ArtisanRecipeInfo.DRIED_CHANTERELLE.getResult()),
    DRIED_APPLE(ArtisanRecipeInfo.DRIED_APPLE.getResult()),
    RAISINS(ArtisanRecipeInfo.RAISINS.getResult()),

    // Regular Smoked Fish
    SMOKED_FLOUNDER(ArtisanRecipeInfo.SMOKED_FLOUNDER.getResult()),
    SMOKED_LIONFISH(ArtisanRecipeInfo.SMOKED_LIONFISH.getResult()),
    SMOKED_HERRING(ArtisanRecipeInfo.SMOKED_HERRING.getResult()),
    SMOKED_GHOSTFISH(ArtisanRecipeInfo.SMOKED_GHOSTFISH.getResult()),
    SMOKED_TILAPIA(ArtisanRecipeInfo.SMOKED_TILAPIA.getResult()),
    SMOKED_DORADO(ArtisanRecipeInfo.SMOKED_DORADO.getResult()),
    SMOKED_SUNFISH(ArtisanRecipeInfo.SMOKED_SUNFISH.getResult()),
    SMOKED_RAINBOW_TROUT(ArtisanRecipeInfo.SMOKED_RAINBOW_TROUT.getResult()),
    SMOKED_SALMON(ArtisanRecipeInfo.SMOKED_SALMON.getResult()),
    SMOKED_SARDINE(ArtisanRecipeInfo.SMOKED_SARDINE.getResult()),
    SMOKED_SHAD(ArtisanRecipeInfo.SMOKED_SHAD.getResult()),
    SMOKED_BLUE_DISCUS(ArtisanRecipeInfo.SMOKED_BLUE_DISCUS.getResult()),
    SMOKED_MIDNIGHT_CARP(ArtisanRecipeInfo.SMOKED_MIDNIGHT_CARP.getResult()),
    SMOKED_SQUID(ArtisanRecipeInfo.SMOKED_SQUID.getResult()),
    SMOKED_TUNA(ArtisanRecipeInfo.SMOKED_TUNA.getResult()),
    SMOKED_PERCH(ArtisanRecipeInfo.SMOKED_PERCH.getResult()),

    // Legendary Smoked Fish
    SMOKED_LEGEND(ArtisanRecipeInfo.SMOKED_LEGEND.getResult()),
    SMOKED_GLACIERFISH(ArtisanRecipeInfo.SMOKED_GLACIERFISH.getResult()),
    SMOKED_ANGLER(ArtisanRecipeInfo.SMOKED_ANGLER.getResult()),
    SMOKED_CRIMSONFISH(ArtisanRecipeInfo.SMOKED_CRIMSONFISH.getResult()),

    // Artisan Goods (Inedible)
    CLOTH(ArtisanRecipeInfo.CLOTH.getResult()),
    COPPER_BAR(ArtisanRecipeInfo.COPPER_BAR.getResult()),
    IRON_BAR(ArtisanRecipeInfo.IRON_BAR.getResult()),
    GOLD_BAR(ArtisanRecipeInfo.GOLD_BAR.getResult()),
    IRIDIUM_BAR(ArtisanRecipeInfo.IRIDIUM_BAR.getResult()),

    // tools
    HOE(ToolType.HOE.getTool()),
    PICKAXE(ToolType.PICKAXE.getTool()),
    AXE(ToolType.AXE.getTool()),
    WATERINGCAN(ToolType.WATERING_CAN.getTool()),
    SCYTHE(ToolType.SCYTHE.getTool()),
    SCISSORS(ToolType.SCISSORS.getTool()),

    // animal products
    MILK(new Item("milk", 38, 125)), // +38 Energy, 125g base price
    LARGE_MILK(new Item("large_milk", 50, 190)), // +50 Energy, 190g base price
    GOAT_MILK(new Item("goat_milk", 50, 225)), // +50 Energy, 225g base price
    LARGE_GOAT_MILK(new Item("large_goat_milk", 75, 345)), // +75 Energy, 345g base price

    EGG(new Item("egg", 25, 50)), // +25 Energy, 50g base price
    LARGE_EGG(new Item("large_egg", 38, 95)), // +38 Energy, 95g base price
    DUCK_EGG(new Item("duck_egg", 45, 95)), // +45 Energy, 95g base price
    DINOSAUR_EGG(new Item("dinosaur_egg", 55, 350)), // +55 Energy, 350g base price
    DUCK_FEATHER(new Item("duck_feather", 250)), // Not edible, just sellable
    RABBITS_FOOT(new Item("rabbits_foot", 565)), // Not edible, just sellable
    WOOL(new Item("wool", 340)),

    // Fish
    FLOUNDER(new Item("flounder", 25, 100)),
    LIONFISH(new Item("lionfish", 30, 150)),
    HERRING(new Item("herring", 20, 30)),
    GHOSTFISH(new Item("ghostfish", 45, 180)),
    TILAPIA(new Item("tilapia", 30, 150)),
    DORADO(new Item("dorado", 45, 100)),
    SUNFISH(new Item("sunfish", 30, 30)),
    RAINBOW_TROUT(new Item("rainbow_trout", 25, 65)),
    SALMON(new Item("salmon", 25, 75)),
    SARDINE(new Item("sardine", 20, 40)),
    SHAD(new Item("shad", 25, 60)),
    BLUE_DISCUS(new Item("blue_discus", 25, 120)),
    MIDNIGHT_CARP(new Item("midnight_carp", 35, 150)),
    SQUID(new Item("squid", 25, 80)),
    TUNA(new Item("tuna", 30, 100)),
    PERCH(new Item("perch", 20, 55)),

    // Legendary Fish
    LEGEND(new Item("legend", 80, 5000)),
    GLACIERFISH(new Item("glacierfish", 75, 4000)),
    ANGLER(new Item("angler", 70, 3000)),
    CRIMSONFISH(new Item("crimsonfish", 75, 3500)),

    // Tree Fruits
    APRICOT(new Item("apricot", 35, 50)),
    CHERRY(new Item("cherry", 35, 80)),
    ORANGE(new Item("orange", 45, 100)),
    PEACH(new Item("peach", 50, 140)),
    POMEGRANATE(new Item("pomegranate", 50, 140)),
    APPLE(new Item("apple", 50, 100)),
    BANANA(new Item("banana", 40, 150)),
    MANGO(new Item("mango", 45, 130)),
    OAK_RESIN(new Item("oak_resin", 150)), // Not edible, harvested every 7 days
    MAPLE_SYRUP(new Item("maple_syrup", 200)), // Not edible, harvested every 9 days
    PINE_TAR(new Item("pine_tar", 100)), // Not edible, harvested every 5 days
    SAP(new Item("sap", -2, 2)), // Edible (negative energy), harvested every day
    MYSTIC_SYRUP(new Item("mystic_syrup", 500, 1000)), // Edible, harvested every 7 days

    // miscellaneous
    // Resources
    TRUFFLE(new Item("truffle", 0, 625)), // Not edible, only sellable
    WOOD(new Item("wood", 2)),
    FIBER(new Item("fiber", 1)),

    // Coop Animals
    CHICKEN(new Item("chicken", 800)), // Purchase price: 800g
    DUCK(new Item("duck", 1200)), // Purchase price: 1,200g
    RABBIT(new Item("rabbit", 8000)), // Purchase price: 8,000g
    DINOSAUR(new Item("dinosaur", 14000)), // Purchase price: 14,000g

    // Barn Animals
    COW(new Item("cow", 1500)), // Purchase price: 1,500g
    GOAT(new Item("goat", 4000)), // Purchase price: 4,000g
    SHEEP(new Item("sheep", 8000)), // Purchase price: 8,000g
    PIG(new Item("pig", 16000)), // Purchase price: 16,000g

    // Add Rice and Powdermelon
    RICE(new Item("rice", 25, 100)), // Regular rice, edible and sellable
    POWDERMELON(new Item("powdermelon", 113, 450)), // New winter crop from 1.6, edible and sellable

    STONE(new Item("stone", 2)), // Base sell price: 2g, not edible
    MAPLE_SEED(new Item("maple seed", 5)), // Base sell price: 5g, not edible
    ACORN(new Item("acorn", 5)), // Base sell price: 5g, not edible
    MAHOGANY_SEED(new Item("mahogany seed", 15)), // Base sell price: 15g, not edible
    PINE_CONE(new Item("pine cone", 5)) // Base sell price: 5g, not edible

    ;
    private final InventoryItem inventoryItem;
    private final Item item;
    private final int id;
    private final int baseID;

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

    /**
     * Finds the ID of an InventoryItem by searching through the enum
     * @param searchItem The InventoryItem to search for
     * @return The ID of the item if found, -1 if not found
     */
    public static int getIdByItem(InventoryItem searchItem) {
        if (searchItem == null) return -1;

        for (ItemFinder item : values()) {
            if (item.getInventoryItem() != null &&
                    item.getInventoryItem().equals(searchItem)) {
                return item.getId();
            }
            // Also check if it's an Item type
            if (item.getItem() != null &&
                    item.getItem().equals(searchItem)) {
                return item.getId();
            }
        }
        return -1;  // Return -1 if item not found
    }

    /**
     * Checks if an InventoryItem exists in the enum
     * @param searchItem The InventoryItem to search for
     * @return true if the item exists, false otherwise
     */
    public static boolean containsItem(InventoryItem searchItem) {
        return getIdByItem(searchItem) != -1;
    }


}
