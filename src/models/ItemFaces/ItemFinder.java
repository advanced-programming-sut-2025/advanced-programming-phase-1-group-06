package models.ItemFaces;

import models.CraftingAndCooking.ArtisanRecipeInfo;
import models.PlantsAndForaging.Info.*;
import models.PlantsAndForaging.Seed;
import models.tools.FishingRodType;
import models.tools.ToolType;

public enum ItemFinder {
    // Spring Crops
    // Spring Crops (1-13)
    BLUE_JAZZ(new Item("blue jazz", 45, 50)),        // Energy: 45, Price: 50
    CARROT(new Item("carrot", 75, 35)),              // Energy: 75, Price: 35
    CAULIFLOWER(new Item("cauliflower", 75, 175)),   // Energy: 75, Price: 175
    COFFEE_BEAN(new Item("coffee bean", 0, 15)),     // Not edible (Energy: 0), Price: 15
    GARLIC(new Item("garlic", 20, 60)),             // Energy: 20, Price: 60
    GREEN_BEAN(new Item("green bean", 25, 40)),      // Energy: 25, Price: 40
    KALE(new Item("kale", 50, 110)),                // Energy: 50, Price: 110
    PARSNIP(new Item("parsnip", 25, 35)),           // Energy: 25, Price: 35
    POTATO(new Item("potato", 25, 80)),              // Energy: 25, Price: 80
    RHUBARB(new Item("rhubarb", 0, 220)),           // Not edible (Energy: 0), Price: 220
    STRAWBERRY(new Item("strawberry", 50, 120)),     // Energy: 50, Price: 120
    TULIP(new Item("tulip", 45, 30)),               // Energy: 45, Price: 30
    UNMILLED_RICE(new Item("unmilled rice", 3, 30)), // Energy: 3, Price: 30

    // Summer Crops (14-27)
    BLUEBERRY(new Item("blueberry", 25, 50)),        // Energy: 25, Price: 50
    CORN(new Item("corn", 25, 50)),                  // Energy: 25, Price: 50
    HOPS(new Item("hops", 45, 25)),                  // Energy: 45, Price: 25
    HOT_PEPPER(new Item("hot pepper", 13, 40)),      // Energy: 13, Price: 40
    MELON(new Item("melon", 113, 250)),              // Energy: 113, Price: 250
    POPPY(new Item("poppy", 45, 140)),              // Energy: 45, Price: 140
    RADISH(new Item("radish", 45, 90)),             // Energy: 45, Price: 90
    RED_CABBAGE(new Item("red cabbage", 75, 260)),   // Energy: 75, Price: 260
    STARFRUIT(new Item("starfruit", 125, 750)),      // Energy: 125, Price: 750
    SUMMER_SPANGLE(new Item("summer spangle", 45, 90)), // Energy: 45, Price: 90
    SUMMER_SQUASH(new Item("summer squash", 63, 45)), // Energy: 63, Price: 45
    SUNFLOWER(new Item("sunflower", 45, 80)),        // Energy: 45, Price: 80
    TOMATO(new Item("tomato", 20, 60)),             // Energy: 20, Price: 60
    WHEAT(new Item("wheat", 0, 25)),                 // Not edible (Energy: 0), Price: 25

    // Fall Crops (28-41)
    AMARANTH(new Item("amaranth", 50, 150)),         // Energy: 50, Price: 150
    ARTICHOKE(new Item("artichoke", 30, 160)),       // Energy: 30, Price: 160
    BEET(new Item("beet", 30, 100)),                // Energy: 30, Price: 100
    BOK_CHOY(new Item("bok choy", 25, 80)),         // Energy: 25, Price: 80
    BROCCOLI(new Item("broccoli", 63, 70)),         // Energy: 63, Price: 70
    CRANBERRIES(new Item("cranberries", 38, 75)),    // Energy: 38, Price: 75
    EGGPLANT(new Item("eggplant", 20, 60)),         // Energy: 20, Price: 60
    FAIRY_ROSE(new Item("fairy rose", 45, 290)),     // Energy: 45, Price: 290
    GRAPE(new Item("grape", 38, 80)),               // Energy: 38, Price: 80
    PUMPKIN(new Item("pumpkin", 0, 320)),           // Not edible (Energy: 0), Price: 320
    YAM(new Item("yam", 45, 160)),                  // Energy: 45, Price: 160
    SWEET_GEM_BERRY(new Item("sweet gem berry", 0, 3000)), // Not edible (Energy: 0), Price: 3000
    POWDER_MELON(new Item("powdermelon", 63, 60)),   // Energy: 63, Price: 60
    ANCIENT_FRUIT(new Item("ancient fruit", 0, 550)),  // Not edible (Energy: 0), Price: 550

    // Tree Saplings (42-52)
    // Tree Saplings (42-55)
    APRICOT_SAPLING(new Item("apricot sapling", 0, 2000)),    // Fruit: Apricot - Energy: 38, Price: 59
    CHERRY_SAPLING(new Item("cherry sapling", 0, 3400)),      // Fruit: Cherry - Energy: 38, Price: 80
    BANANA_SAPLING(new Item("banana sapling", 0, 3500)),      // Fruit: Banana - Energy: 75, Price: 150
    MANGO_SAPLING(new Item("mango sapling", 0, 3500)),        // Fruit: Mango - Energy: 100, Price: 130
    ORANGE_SAPLING(new Item("orange sapling", 0, 3200)),      // Fruit: Orange - Energy: 38, Price: 100
    PEACH_SAPLING(new Item("peach sapling", 0, 3400)),        // Fruit: Peach - Energy: 38, Price: 140
    APPLE_SAPLING(new Item("apple sapling", 0, 3000)),        // Fruit: Apple - Energy: 38, Price: 100
    POMEGRANATE_SAPLING(new Item("pomegranate sapling", 0, 3600)),  // Fruit: Pomegranate - Energy: 38, Price: 140
    ACORNS(new Item("acorns", 0, 200)),                       // Product: Oak Resin - Price: 150, Not Edible
    MAPLE_SEEDS(new Item("maple seeds", 0, 200)),             // Product: Maple Syrup - Price: 200, Not Edible
    PINE_CONES(new Item("pine cones", 0, 200)),               // Product: Pine Tar - Price: 100, Not Edible
    MAHOGANY_SEEDS(new Item("mahogany seeds", 0, 250)),       // Product: Sap - Energy: -2, Price: 2
    MUSHROOM_TREE_SEEDS(new Item("mushroom tree seeds", 0, 300)),  // Product: Common Mushroom - Energy: 38, Price: 40
    MYSTIC_TREE_SEEDS(new Item("mystic tree seeds", 0, 750)),  // Product: Mystic Syrup - Energy: 500, Price: 1000

    // Should I continue with the next section?
    // Seeds (55-104)
    // Summer Seeds
    // Spring Seeds
    JAZZ_SEEDS(new Seed("Jazz Seeds", "1-2-2-2", 7, -1, true, "1", false)),
    CARROT_SEEDS(new Seed("Carrot Seeds", "1-1-1", 3, -1, true, "1", false)),
    CAULIFLOWER_SEEDS(new Seed("Cauliflower Seeds", "1-2-4-4-1", 12, -1, true, "1", true)),
    COFFEE_BEAN_SEED(new Seed("Coffee Bean", "1-2-2-3-2", 10, 2, false, "1-2", false)),
    GARLIC_SEEDS(new Seed("Garlic Seeds", "1-1-1-1", 4, -1, true, "1", false)),
    BEAN_STARTER(new Seed("Bean Starter", "1-1-1-3-4", 10, 3, false, "1", false)),
    KALE_SEEDS(new Seed("Kale Seeds", "1-2-2-1", 6, -1, true, "1", false)),
    PARSNIP_SEEDS(new Seed("Parsnip Seeds", "1-1-1-1", 4, -1, true, "1", false)),
    POTATO_SEEDS(new Seed("Potato Seeds", "1-1-1-2-1", 6, -1, true, "1", false)),
    RHUBARB_SEEDS(new Seed("Rhubarb Seeds", "2-2-2-3-4", 13, -1, true, "1", false)),
    STRAWBERRY_SEEDS(new Seed("Strawberry Seeds", "1-1-2-2-2", 8, 4, false, "1", false)),
    TULIP_BULB(new Seed("Tulip Bulb", "1-1-2-2", 6, -1, true, "1", false)),
    RICE_SHOOT(new Seed("Rice Shoot", "1-2-2-3", 8, -1, true, "1", false)),

    // Summer Seeds
    BLUEBERRY_SEEDS(new Seed("Blueberry Seeds", "1-3-3-4-2", 13, 4, false, "2", false)),
    CORN_SEEDS(new Seed("Corn Seeds", "2-3-3-3-3", 14, 4, false, "2-3", false)),
    HOPS_STARTER(new Seed("Hops Starter", "1-1-2-3-4", 11, 1, false, "2", false)),
    PEPPER_SEEDS(new Seed("Pepper Seeds", "1-1-1-1-1", 5, 3, false, "2", false)),
    MELON_SEEDS(new Seed("Melon Seeds", "1-2-3-3-3", 12, -1, true, "2", true)),
    POPPY_SEEDS(new Seed("Poppy Seeds", "1-2-2-2", 7, -1, true, "2", false)),
    RADISH_SEEDS(new Seed("Radish Seeds", "2-1-2-1", 6, -1, true, "2", false)),
    RED_CABBAGE_SEEDS(new Seed("Red Cabbage Seeds", "2-1-2-2-2", 9, -1, true, "2", false)),
    STARFRUIT_SEEDS(new Seed("Starfruit Seeds", "2-3-2-3-3", 13, -1, true, "2", false)),
    SPANGLE_SEEDS(new Seed("Spangle Seeds", "1-2-3-1", 8, -1, true, "2", false)),
    SUMMER_SQUASH_SEEDS(new Seed("Summer Squash Seeds", "1-1-1-2-1", 6, 3, false, "2", false)),
    SUNFLOWER_SEEDS(new Seed("Sunflower Seeds", "1-2-3-2", 8, -1, true, "2-3", false)),
    TOMATO_SEEDS(new Seed("Tomato Seeds", "2-2-2-2-3", 11, 4, false, "2", false)),
    WHEAT_SEEDS(new Seed("Wheat Seeds", "1-1-1-1", 4, -1, true, "2-3", false)),

    // Fall Seeds
    AMARANTH_SEEDS(new Seed("Amaranth Seeds", "1-2-2-2", 7, -1, true, "3", false)),
    ARTICHOKE_SEEDS(new Seed("Artichoke Seeds", "2-2-1-2-1", 8, -1, true, "3", false)),
    BEET_SEEDS(new Seed("Beet Seeds", "1-1-2-2", 6, -1, true, "3", false)),
    BOK_CHOY_SEEDS(new Seed("Bok Choy Seeds", "1-1-1-1", 4, -1, true, "3", false)),
    BROCCOLI_SEEDS(new Seed("Broccoli Seeds", "2-2-2-2", 8, 4, false, "3", false)),
    CRANBERRY_SEEDS(new Seed("Cranberry Seeds", "1-2-1-1-2", 7, 5, false, "3", false)),
    EGGPLANT_SEEDS(new Seed("Eggplant Seeds", "1-1-1-1", 5, 5, false, "3", false)),
    FAIRY_SEEDS(new Seed("Fairy Seeds", "1-4-4-3", 12, -1, true, "3", false)),
    GRAPE_STARTER(new Seed("Grape Starter", "1-1-2-3-3", 10, 3, false, "3", false)),
    PUMPKIN_SEEDS(new Seed("Pumpkin Seeds", "1-2-3-4-3", 13, -1, true, "3", true)),
    YAM_SEEDS(new Seed("Yam Seeds", "1-3-3-3", 10, -1, true, "3", false)),
    RARE_SEED(new Seed("Rare Seed", "2-4-6-6-6", 24, -1, true, "3", false)),

    // Special Seeds
    POWDERMELON_SEEDS(new Seed("Powdermelon Seeds", "1-2-1-2-1", 7, -1, true, "4", true)),
    ANCIENT_SEEDS(new Seed("Ancient Seeds", "2-7-7-7-5", 28, 7, false, "1-2-3", false)),
    // Foraged Items (beginning)
    COMMON_MUSHROOM(new Item("common mushroom", 38, 40)),
    DAFFODIL(new Item("daffodil", 0, 30)),
    DANDELION(new Item("dandelion", 0, 40)),
    LEEK(new Item("leek", 40, 60)),
    MOREL(new Item("morel", 50, 150)),
    SALMONBERRY(new Item("salmonberry", 25, 5)),
    SPRING_ONION(new Item("spring onion", 35, 8)),
    WILD_HORSERADISH(new Item("wild horseradish", 30, 50)),
    FIDDLEHEAD_FERN(new Item("fiddlehead fern", 35, 90)),
    FORAGED_GRAPE(new Item("foraged grape", 30, 80)),
    RED_MUSHROOM(new Item("red mushroom", -50, 75)),  // Negative energy because it's poisonous
    SPICE_BERRY(new Item("spice berry", 35, 80)),
    SWEET_PEA(new Item("sweet pea", 0, 50)),
    BLACKBERRY(new Item("blackberry", 30, 20)),
    CHANTERELLE(new Item("chanterelle", 45, 160)),
    HAZELNUT(new Item("hazelnut", 40, 90)),
    PURPLE_MUSHROOM(new Item("purple mushroom", 125, 250)),  // High energy - special mushroom
    WILD_PLUM(new Item("wild plum", 35, 85)),
    CROCUS(new Item("crocus", 0, 60)),
    CRYSTAL_FRUIT(new Item("crystal fruit", 50, 150)),
    HOLLY(new Item("holly", -25, 80)),  // Negative energy - it's toxic
    // Minerals
    // Minerals and Gems
    QUARTZ(new Item("quartz", 0, 25)),             // Common crystal from caves
    EARTH_CRYSTAL(new Item("earth crystal", 0, 50)),    // Surface resinous substance
    FROZEN_TEAR(new Item("frozen tear", 0, 75)),    // Mythical yeti tear crystal
    FIRE_QUARTZ(new Item("fire quartz", 0, 100)),    // Hot lava crystal
    EMERALD(new Item("emerald", 0, 250)),          // Brilliant green precious stone
    AQUAMARINE(new Item("aquamarine", 0, 180)),     // Blue-green shimmery gem
    RUBY(new Item("ruby", 0, 250)),               // Rich colored precious stone
    AMETHYST(new Item("amethyst", 0, 100)),        // Purple quartz variant
    TOPAZ(new Item("topaz", 0, 80)),              // Common but beautiful gem
    JADE(new Item("jade", 0, 200)),               // Pale green ornamental
    DIAMOND(new Item("diamond", 0, 750)),          // Rare valuable gem
    PRISMATIC_SHARD(new Item("prismatic shard", 0, 2000)), // Very rare, unknown origin

    // Ores
    COPPER(new Item("copper", 0, 5)),          // Common smeltable ore
    IRON(new Item("iron", 0, 10)),            // Fairly common ore
    GOLD(new Item("gold", 0, 25)),            // Precious smeltable ore
    IRIDIUM(new Item("iridium", 0, 100)),      // Exotic ore with unique properties
    COAL(new Item("coal", 0, 15)),            // Combustible crafting material
    // Honey
    // Honey
    HONEY(new Item("honey", 75, 350)),  // Energy: 75, Price: 350g, Processing: 4 Days

    // Dairy Products
    CHEESE(new Item("cheese", 100, 230)),  // Energy: 100, Price: 230g, From: Milk
    LARGE_MILK_CHEESE(new Item("large milk cheese", 100, 345)),  // Energy: 100, Price: 345g, From: Large Milk
    GOAT_CHEESE(new Item("goat cheese", 100, 400)),  // Energy: 100, Price: 400g, From: Goat Milk
    LARGE_GOAT_CHEESE(new Item("large goat cheese", 100, 600)),  // Energy: 100, Price: 600g, From: Large Goat Milk

    // Egg Products
    MAYONNAISE(new Item("mayonnaise", 50, 190)),  // Energy: 50, Price: 190g, From: Egg
    LARGE_MAYONNAISE(new Item("large mayonnaise", 50, 237)),  // Energy: 50, Price: 237g, From: Large Egg
    DUCK_MAYONNAISE(new Item("duck mayonnaise", 75, 375)),  // Energy: 75, Price: 375g, From: Duck Egg
    DINOSAUR_MAYONNAISE(new Item("dinosaur mayonnaise", 125, 800)),  // Energy: 125, Price: 800g, From: Dinosaur Egg

    // Alcoholic Beverages
    BEER(new Item("beer", 50, 200)),  // Energy: 50, Price: 200g, From: Wheat
    PALE_ALE(new Item("pale ale", 50, 300)),  // Energy: 50, Price: 300g, From: Hops
    MEAD(new Item("mead", 100, 300)),  // Energy: 100, Price: 300g, From: Honey

    // Other Beverages
    COFFEE(new Item("coffee", 75, 150)),  // Energy: 75, Price: 150g, From: Coffee Bean (5)

    // Condiments and Oils
    VINEGAR(new Item("vinegar", 13, 100)),  // Energy: 13, Price: 100g, From: Rice
    TRUFFLE_OIL(new Item("truffle oil", 38, 1065)),  // Energy: 38, Price: 1065g, From: Truffle
    CORN_OIL(new Item("corn oil", 13, 100)),  // Energy: 13, Price: 100g, From: Corn
    SUNFLOWER_OIL(new Item("sunflower oil", 13, 100)),  // Energy: 13, Price: 100g, From: Sunflower/Seeds
    // Spring Fruit Wines
    // Spring Fruit Wines
    APRICOT_WINE(new Item("apricot wine", 61, 150)),  // Energy: 35 * 1.75 = 61, Price: 50 * 3 = 150
    CHERRY_WINE(new Item("cherry wine", 61, 240)),     // Energy: 35 * 1.75 = 61, Price: 80 * 3 = 240
    STRAWBERRY_WINE(new Item("strawberry wine", 88, 360)),  // Energy: 50 * 1.75 = 88, Price: 120 * 3 = 360

    // Summer Fruit Wines
    BANANA_WINE(new Item("banana wine", 70, 450)),     // Energy: 40 * 1.75 = 70, Price: 150 * 3 = 450
    BLUEBERRY_WINE(new Item("blueberry wine", 44, 150)),  // Energy: 25 * 1.75 = 44, Price: 50 * 3 = 150
    MANGO_WINE(new Item("mango wine", 79, 390)),       // Energy: 45 * 1.75 = 79, Price: 130 * 3 = 390
    MELON_WINE(new Item("melon wine", 198, 750)),      // Energy: 113 * 1.75 = 198, Price: 250 * 3 = 750
    ORANGE_WINE(new Item("orange wine", 79, 300)),     // Energy: 45 * 1.75 = 79, Price: 100 * 3 = 300
    PEACH_WINE(new Item("peach wine", 88, 420)),       // Energy: 50 * 1.75 = 88, Price: 140 * 3 = 420

    // Fall Fruit Wines
    APPLE_WINE(new Item("apple wine", 88, 300)),       // Energy: 50 * 1.75 = 88, Price: 100 * 3 = 300
    CRANBERRY_WINE(new Item("cranberry wine", 67, 225)),  // Energy: 38 * 1.75 = 67, Price: 75 * 3 = 225
    GRAPE_WINE(new Item("grape wine", 67, 240)),       // Energy: 38 * 1.75 = 67, Price: 80 * 3 = 240
    POMEGRANATE_WINE(new Item("pomegranate wine", 88, 420)),  // Energy: 50 * 1.75 = 88, Price: 140 * 3 = 420

    // Special Wines
    // Spring Fruit Juices
    APRICOT_JUICE(new Item("apricot juice", 70, 113)),     // Energy: 35 * 2 = 70, Price: 50 * 2.25 = 113
    CHERRY_JUICE(new Item("cherry juice", 70, 180)),       // Energy: 35 * 2 = 70, Price: 80 * 2.25 = 180
    STRAWBERRY_JUICE(new Item("strawberry juice", 100, 270)),  // Energy: 50 * 2 = 100, Price: 120 * 2.25 = 270

    // Summer Fruit Juices
    BANANA_JUICE(new Item("banana juice", 80, 338)),       // Energy: 40 * 2 = 80, Price: 150 * 2.25 = 338
    BLUEBERRY_JUICE(new Item("blueberry juice", 50, 113)), // Energy: 25 * 2 = 50, Price: 50 * 2.25 = 113
    MANGO_JUICE(new Item("mango juice", 90, 293)),         // Energy: 45 * 2 = 90, Price: 130 * 2.25 = 293
    MELON_JUICE(new Item("melon juice", 226, 563)),        // Energy: 113 * 2 = 226, Price: 250 * 2.25 = 563
    ORANGE_JUICE(new Item("orange juice", 90, 225)),       // Energy: 45 * 2 = 90, Price: 100 * 2.25 = 225
    PEACH_JUICE(new Item("peach juice", 100, 315)),        // Energy: 50 * 2 = 100, Price: 140 * 2.25 = 315

    // Fall Fruit Juices
    APPLE_JUICE(new Item("apple juice", 100, 225)),        // Energy: 50 * 2 = 100, Price: 100 * 2.25 = 225
    CRANBERRY_JUICE(new Item("cranberry juice", 76, 169)), // Energy: 38 * 2 = 76, Price: 75 * 2.25 = 169
    GRAPE_JUICE(new Item("grape juice", 76, 180)),         // Energy: 38 * 2 = 76, Price: 80 * 2.25 = 180
    POMEGRANATE_JUICE(new Item("pomegranate juice", 100, 315)), // Energy: 50 * 2 = 100, Price: 140 * 2.25 = 315

    // Pickled Vegetables (1.75× base energy, 2× base price + 50)
    PICKLED_ARTICHOKE(new Item("pickled artichoke", 53, 370)),      // Energy: 30 * 1.75 = 53, Price: 160 * 2 + 50 = 370
    PICKLED_BEET(new Item("pickled beet", 53, 250)),               // Energy: 30 * 1.75 = 53, Price: 100 * 2 + 50 = 250
    PICKLED_BOK_CHOY(new Item("pickled bok choy", 44, 210)),       // Energy: 25 * 1.75 = 44, Price: 80 * 2 + 50 = 210
    PICKLED_BROCCOLI(new Item("pickled broccoli", 110, 190)),      // Energy: 63 * 1.75 = 110, Price: 70 * 2 + 50 = 190
    PICKLED_CAULIFLOWER(new Item("pickled cauliflower", 131, 400)), // Energy: 75 * 1.75 = 131, Price: 175 * 2 + 50 = 400
    PICKLED_CORN(new Item("pickled corn", 44, 150)),               // Energy: 25 * 1.75 = 44, Price: 50 * 2 + 50 = 150
    PICKLED_EGGPLANT(new Item("pickled eggplant", 35, 170)),      // Energy: 20 * 1.75 = 35, Price: 60 * 2 + 50 = 170
    PICKLED_GARLIC(new Item("pickled garlic", 35, 170)),          // Energy: 20 * 1.75 = 35, Price: 60 * 2 + 50 = 170
    PICKLED_GREEN_BEAN(new Item("pickled green bean", 44, 130)),   // Energy: 25 * 1.75 = 44, Price: 40 * 2 + 50 = 130
    PICKLED_HOT_PEPPER(new Item("pickled hot pepper", 23, 130)),   // Energy: 13 * 1.75 = 23, Price: 40 * 2 + 50 = 130
    PICKLED_KALE(new Item("pickled kale", 88, 270)),              // Energy: 50 * 1.75 = 88, Price: 110 * 2 + 50 = 270
    PICKLED_PARSNIP(new Item("pickled parsnip", 44, 120)),        // Energy: 25 * 1.75 = 44, Price: 35 * 2 + 50 = 120
    PICKLED_POTATO(new Item("pickled potato", 44, 210)),          // Energy: 25 * 1.75 = 44, Price: 80 * 2 + 50 = 210
    PICKLED_PUMPKIN(new Item("pickled pumpkin", 0, 690)),         // Not edible, Price: 320 * 2 + 50 = 690
    PICKLED_RADISH(new Item("pickled radish", 79, 230)),          // Energy: 45 * 1.75 = 79, Price: 90 * 2 + 50 = 230
    PICKLED_RED_CABBAGE(new Item("pickled red cabbage", 131, 570)), // Energy: 75 * 1.75 = 131, Price: 260 * 2 + 50 = 570
    PICKLED_TOMATO(new Item("pickled tomato", 35, 170)),         // Energy: 20 * 1.75 = 35, Price: 60 * 2 + 50 = 170
    PICKLED_YAM(new Item("pickled yam", 79, 370)),             // Energy: 45 * 1.75 = 79, Price: 160 * 2 + 50 = 370
    // Spring Fruit Jellies
    // Spring Fruit Juices
    // Regular Smoked Fish
    SMOKED_FLOUNDER(new Item("smoked flounder", 38, 200)),       // Energy: 25 * 1.5 = 38, Price: 100 * 2 = 200
    SMOKED_LIONFISH(new Item("smoked lionfish", 45, 300)),       // Energy: 30 * 1.5 = 45, Price: 150 * 2 = 300
    SMOKED_HERRING(new Item("smoked herring", 30, 60)),         // Energy: 20 * 1.5 = 30, Price: 30 * 2 = 60
    SMOKED_GHOSTFISH(new Item("smoked ghostfish", 68, 360)),     // Energy: 45 * 1.5 = 68, Price: 180 * 2 = 360
    SMOKED_TILAPIA(new Item("smoked tilapia", 45, 300)),        // Energy: 30 * 1.5 = 45, Price: 150 * 2 = 300
    SMOKED_DORADO(new Item("smoked dorado", 68, 200)),          // Energy: 45 * 1.5 = 68, Price: 100 * 2 = 200
    SMOKED_SUNFISH(new Item("smoked sunfish", 45, 60)),         // Energy: 30 * 1.5 = 45, Price: 30 * 2 = 60
    SMOKED_RAINBOW_TROUT(new Item("smoked rainbow trout", 38, 130)), // Energy: 25 * 1.5 = 38, Price: 65 * 2 = 130
    SMOKED_SALMON(new Item("smoked salmon", 38, 150)),          // Energy: 25 * 1.5 = 38, Price: 75 * 2 = 150
    SMOKED_SARDINE(new Item("smoked sardine", 30, 80)),        // Energy: 20 * 1.5 = 30, Price: 40 * 2 = 80
    SMOKED_SHAD(new Item("smoked shad", 38, 120)),            // Energy: 25 * 1.5 = 38, Price: 60 * 2 = 120
    SMOKED_BLUE_DISCUS(new Item("smoked blue discus", 38, 240)), // Energy: 25 * 1.5 = 38, Price: 120 * 2 = 240
    SMOKED_MIDNIGHT_CARP(new Item("smoked midnight carp", 53, 300)), // Energy: 35 * 1.5 = 53, Price: 150 * 2 = 300
    SMOKED_SQUID(new Item("smoked squid", 38, 160)),          // Energy: 25 * 1.5 = 38, Price: 80 * 2 = 160
    SMOKED_TUNA(new Item("smoked tuna", 45, 200)),           // Energy: 30 * 1.5 = 45, Price: 100 * 2 = 200
    SMOKED_PERCH(new Item("smoked perch", 30, 110)),         // Energy: 20 * 1.5 = 30, Price: 55 * 2 = 110

    // Legendary Smoked Fish
    SMOKED_LEGEND(new Item("smoked legend", 120, 10000)),        // Energy: 80 * 1.5 = 120, Price: 5000 * 2 = 10000
    SMOKED_GLACIERFISH(new Item("smoked glacierfish", 113, 8000)), // Energy: 75 * 1.5 = 113, Price: 4000 * 2 = 8000
    SMOKED_ANGLER(new Item("smoked angler", 105, 6000)),        // Energy: 70 * 1.5 = 105, Price: 3000 * 2 = 6000
    SMOKED_CRIMSONFISH(new Item("smoked crimsonfish", 113, 7000)), // Energy: 75 * 1.5 = 113, Price: 3500 * 2 = 7000

    // Artisan Goods (Inedible)
    CLOTH(new Item("cloth", 470)),
    COPPER_BAR(new Item("copper bar", 150)),
    IRON_BAR(new Item("iron bar", 750)),
    GOLD_BAR(new Item("gold bar", 1500)),
    IRIDIUM_BAR(new Item("iridium bar", 3000)),

    // tools
    HOE(ToolType.HOE.getTool()),
    PICKAXE(ToolType.PICKAXE.getTool()),
    AXE(ToolType.AXE.getTool()),
    WATERINGCAN(ToolType.WATERING_CAN.getTool()),
    SCYTHE(ToolType.SCYTHE.getTool()),
    SCISSORS(ToolType.SCISSORS.getTool()),
    TRAINING_FISHING_ROD(FishingRodType.TRAINING.create()),
    BAMBOO_FISHING_ROD(FishingRodType.BAMBOO.create()),
    FIBERGLASS_FISHING_ROD(FishingRodType.FIBERGLASS.create()),
    IRIDIUM_FISHING_ROD(FishingRodType.IRIDIUM.create()),


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


    // Initialize IDs after enum construction
    private final InventoryItem inventoryItem;
    private final Item item;
    private final int id;
    private static final int[] ids;

    static {
        ids = new int[values().length];
        for (int i = 0; i < values().length; i++) {
            ids[i] = i + 1;
        }
    }

    ItemFinder(InventoryItem item) {
        this.inventoryItem = item;
        this.item = null;
        this.id = ordinal() + 1;
        if (item != null) {
            item.setId(id);
        }
    }

    ItemFinder(Item item) {
        this.inventoryItem = item;
        this.item = item;
        this.id = ordinal() + 1;
        if (item != null) {
            item.setId(id);
        }
    }

    public int getId() {
        return id;
    }

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public Item getItem(int amount) {
        item.setAmount(amount);
        return item;
    }

    public Item getItem() {
        return getItem(1);
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

//    public static InventoryItem getItemByName(String searchName) {
//        if (searchName == null) return null;
//
//        for (ItemFinder item : values()) {
//            // Check InventoryItem first
//            if (item.getInventoryItem() != null &&
//                    item.getInventoryItem().getName().equals(searchName)) {
//                return item.getInventoryItem();
//            }
//            // Also check Item type since some entries are Items
//            if (item.getItem() != null &&
//                    item.getItem().getName().equals(searchName)) {
//                return item.getItem();
//            }
//        }
//        return null;  // Return null if item not found
//    }

    public static InventoryItem getItemByName(String searchName) {
        if (searchName == null) return null;
        for (ItemFinder itemFinder : values()) {
            if (itemFinder.inventoryItem.getName().equals(searchName)) {
                return itemFinder.inventoryItem;
            }
        }
        return null;  // Return null if item not found
    }


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

    public static boolean containsItem(InventoryItem searchItem) {
        return getIdByItem(searchItem) != -1;
    }


}
