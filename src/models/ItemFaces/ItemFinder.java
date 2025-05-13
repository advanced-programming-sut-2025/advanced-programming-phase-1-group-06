package models.ItemFaces;

import models.PlantsAndForaging.Info.*;

/**
 *  MAKE SURE YOU SET THE VALUES TO 1 WHEN CREATING NEW OBJECTS
 */
public enum ItemFinder {
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
    POWDERMELON(CropInfo.POWDERMELON.create()),
    ANCIENT_FRUIT(CropInfo.ANCIENT_FRUIT.create()),

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
// foregingCrop

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
    SNOW_YAM(ForagingCropInfo.SNOW_YAM.create()),
    WINTER_ROOT(ForagingCropInfo.WINTER_ROOT.create()),
// mineral
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


    ;




    ;

    InventoryItem inventoryItem;
    Item item;

    ItemFinder(InventoryItem item){
        this.inventoryItem = item;
    }
    ItemFinder(Item item){this.item = item;}
    ItemFinder(){}

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }
}
