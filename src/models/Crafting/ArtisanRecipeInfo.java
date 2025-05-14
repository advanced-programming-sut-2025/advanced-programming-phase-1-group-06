package models.Crafting;

import models.ItemFaces.*;

import java.util.ArrayList;
public enum ArtisanRecipeInfo {
//    TODO add all the red items to the Itemfinder if they were animal products or fish add them to their own class else
//     just create the Items in here create a new constructor and put the info there. e.g., name and id for all of them,  sellable -> price, edible -> energy,...
    // Honey Products
    HONEY(null, 4 * 24, 75, 350, "It's a sweet syrup produced by bees.", "honey"),
    // Dairy Products
    CHEESE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.MILK.getInventoryItem());
    }}, 3, 100, 230, "It's your basic cheese.", "cheese"),
    LARGE_MILK_CHEESE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.LARGE_MILK.getInventoryItem());
    }}, 3, 100, 345, "It's your basic cheese made from large milk.", "large_milk_cheese"),
    GOAT_CHEESE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.GOAT_MILK.getInventoryItem());
    }}, 3, 100, 400, "Soft cheese made from goat's milk.", "goat_cheese"),
    LARGE_GOAT_CHEESE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.LARGE_GOAT_MILK.getInventoryItem());
    }}, 3, 100, 600, "Soft cheese made from large goat's milk.", "large_goat_cheese"),

    // Egg Products
    MAYONNAISE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.EGG.getInventoryItem());
    }}, 3, 50, 190, "It looks spreadable.", "mayonnaise"),
    LARGE_MAYONNAISE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.LARGE_EGG.getInventoryItem());
    }}, 3, 50, 237, "It looks spreadable, made from large eggs.", "large_mayonnaise"),
    DUCK_MAYONNAISE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.DUCK_EGG.getInventoryItem());
    }}, 3, 75, 375, "It's a rich, yellow mayonnaise.", "duck_mayonnaise"),
    DINOSAUR_MAYONNAISE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.DINOSAUR_EGG.getInventoryItem());
    }}, 3, 125, 800, "It's thick and creamy, with a vivid green hue. It smells like grass and leather.", "dinosaur_mayonnaise"),

    // Alcoholic Beverages
    BEER(new ArrayList<InventoryItem>(){{
        add(ItemFinder.WHEAT.getInventoryItem());
    }}, 24, 50, 200, "Drink in moderation.", "beer"),
    PALE_ALE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.HOPS.getInventoryItem());
    }}, 3 * 24, 50, 300, "Drink in moderation.", "pale_ale"),
    MEAD(new ArrayList<InventoryItem>(){{
        add(ItemFinder.HONEY.getInventoryItem());
    }}, 10, 100, 300, "A fermented beverage made from honey. Drink in moderation.", "mead"),

    // Other Beverages
    COFFEE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.COFFEE_BEAN.getInventoryItem());
    }}, 2, 75, 150, "It smells delicious. This is sure to give you a boost.", "coffee"),

    // Condiments and Oils
    VINEGAR(new ArrayList<InventoryItem>(){{
        add(ItemFinder.RICE.getInventoryItem());
    }}, 10, 13, 100, "An aged fermented liquid used in many cooking recipes.", "vinegar"),
    TRUFFLE_OIL(new ArrayList<InventoryItem>(){{
        add(ItemFinder.TRUFFLE.getInventoryItem());
    }}, 6, 38, 1065, "A gourmet cooking ingredient.", "truffle_oil"),
    CORN_OIL(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CORN.getInventoryItem());
    }}, 6, 13, 100, "All purpose cooking oil.", "corn_oil"),
    SUNFLOWER_OIL(new ArrayList<InventoryItem>(){{
        add(ItemFinder.SUNFLOWER.getInventoryItem());
    }}, 24, 13, 100, "All purpose cooking oil.", "sunflower_oil"),

    // Fruit Wines (using coefficient-based pricing)
    APRICOT_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.APRICOT.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "apricot_wine"),
    CHERRY_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CHERRY.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "cherry_wine"),
    STRAWBERRY_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.STRAWBERRY.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "strawberry_wine"),

    // Summer Fruit Wines
    BANANA_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BANANA.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "banana_wine"),
    BLUEBERRY_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BLUEBERRY.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "blueberry_wine"),
    MANGO_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.MANGO.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "mango_wine"),
    MELON_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.MELON.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "melon_wine"),
    ORANGE_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.ORANGE.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "orange_wine"),
    PEACH_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.PEACH.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "peach_wine"),

    // Fall Fruit Wines
    APPLE_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.APPLE.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "apple_wine"),
    CRANBERRY_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CRANBERRIES.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "cranberry_wine"),
    GRAPE_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.GRAPE.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "grape_wine"),
    POMEGRANATE_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.POMEGRANATE.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "pomegranate_wine"),

    // Special Wines
    ANCIENT_FRUIT_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.ANCIENT_FRUIT.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "ancient_fruit_wine"),
    // Fruit Juices (using coefficient-based pricing)
    APRICOT_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.APRICOT.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "apricot_juice"),
    CHERRY_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CHERRY.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "cherry_juice"),
    STRAWBERRY_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.STRAWBERRY.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "strawberry_juice"),

    // Summer Fruit Juices
    BANANA_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BANANA.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "banana_juice"),
    BLUEBERRY_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BLUEBERRY.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "blueberry_juice"),
    MANGO_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.MANGO.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "mango_juice"),
    MELON_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.MELON.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "melon_juice"),
    ORANGE_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.ORANGE.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "orange_juice"),
    PEACH_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.PEACH.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "peach_juice"),

    // Fall Fruit Juices
    APPLE_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.APPLE.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "apple_juice"),
    CRANBERRY_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CRANBERRIES.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "cranberry_juice"),
    GRAPE_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.GRAPE.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "grape_juice"),
    POMEGRANATE_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.POMEGRANATE.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "pomegranate_juice"),
    // Preserved Foods
    PICKLED_ARTICHOKE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.ARTICHOKE.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_artichoke"),
    PICKLED_BEET(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BEET.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_beet"),
    PICKLED_BOK_CHOY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BOK_CHOY.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_bok_choy"),
    PICKLED_BROCCOLI(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BROCCOLI.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_broccoli"),
    PICKLED_CAULIFLOWER(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CAULIFLOWER.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_cauliflower"),
    PICKLED_CORN(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CORN.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_corn"),
    PICKLED_EGGPLANT(new ArrayList<InventoryItem>(){{
        add(ItemFinder.EGGPLANT.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_eggplant"),
    PICKLED_GARLIC(new ArrayList<InventoryItem>(){{
        add(ItemFinder.GARLIC.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_garlic"),
    PICKLED_GREEN_BEAN(new ArrayList<InventoryItem>(){{
        add(ItemFinder.GREEN_BEAN.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_green_bean"),
    PICKLED_HOT_PEPPER(new ArrayList<InventoryItem>(){{
        add(ItemFinder.HOT_PEPPER.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_hot_pepper"),
    PICKLED_KALE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.KALE.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_kale"),
    PICKLED_PARSNIP(new ArrayList<InventoryItem>(){{
        add(ItemFinder.PARSNIP.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_parsnip"),
    PICKLED_POTATO(new ArrayList<InventoryItem>(){{
        add(ItemFinder.POTATO.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_potato"),
    PICKLED_PUMPKIN(new ArrayList<InventoryItem>(){{
        add(ItemFinder.PUMPKIN.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_pumpkin"),
    PICKLED_RADISH(new ArrayList<InventoryItem>(){{
        add(ItemFinder.RADISH.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_radish"),
    PICKLED_RED_CABBAGE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.RED_CABBAGE.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_red_cabbage"),
    PICKLED_TOMATO(new ArrayList<InventoryItem>(){{
        add(ItemFinder.TOMATO.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_tomato"),
    PICKLED_YAM(new ArrayList<InventoryItem>(){{
        add(ItemFinder.YAM.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_yam"),

    // Jellies (using coefficient-based pricing)
    APRICOT_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.APRICOT.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "apricot_jelly"),

    CHERRY_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CHERRY.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "cherry_jelly"),

    STRAWBERRY_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.STRAWBERRY.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "strawberry_jelly"),

    // Summer Fruit Jellies
    BANANA_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BANANA.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "banana_jelly"),

    BLUEBERRY_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BLUEBERRY.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "blueberry_jelly"),

    MANGO_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.MANGO.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "mango_jelly"),

    MELON_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.MELON.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "melon_jelly"),

    ORANGE_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.ORANGE.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "orange_jelly"),

    PEACH_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.PEACH.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "peach_jelly"),

    // Fall Fruit Jellies
    APPLE_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.APPLE.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "apple_jelly"),

    CRANBERRY_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CRANBERRIES.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "cranberry_jelly"),

    GRAPE_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.GRAPE.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "grape_jelly"),

    POMEGRANATE_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.POMEGRANATE.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "pomegranate_jelly"),

    // Special Fruit Jellies
    ANCIENT_FRUIT_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.ANCIENT_FRUIT.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "ancient_fruit_jelly"),

    SWEET_GEM_BERRY_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.SWEET_GEM_BERRY.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "sweet_gem_berry_jelly"),

    POWDERMELON_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.POWDERMELON.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "powdermelon_jelly"),
    // Dried Products
    DRIED_MOREL(new ArrayList<InventoryItem>(){{
        add(ItemFinder.MOREL.getInventoryItem());
    }}, 24, 50, 25, 7.5, "A package of gourmet mushrooms.", "dried_morel"),
    DRIED_CHANTERELLE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CHANTERELLE.getInventoryItem());
    }}, 24, 50, 25, 7.5, "A package of gourmet mushrooms.", "dried_chanterelle"),
    // Spring Fruit Dried Products
    DRIED_APRICOT(new ArrayList<InventoryItem>(){{
        add(ItemFinder.APRICOT.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_apricot"),

    DRIED_CHERRY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CHERRY.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_cherry"),

    DRIED_STRAWBERRY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.STRAWBERRY.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_strawberry"),

    // Summer Fruit Dried Products
    DRIED_BANANA(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BANANA.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_banana"),

    DRIED_BLUEBERRY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BLUEBERRY.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_blueberry"),

    DRIED_MANGO(new ArrayList<InventoryItem>(){{
        add(ItemFinder.MANGO.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_mango"),

    DRIED_MELON(new ArrayList<InventoryItem>(){{
        add(ItemFinder.MELON.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_melon"),

    DRIED_ORANGE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.ORANGE.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_orange"),

    DRIED_PEACH(new ArrayList<InventoryItem>(){{
        add(ItemFinder.PEACH.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_peach"),

    // Fall Fruit Dried Products
    DRIED_APPLE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.APPLE.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_apple"),
    RAISINS(new ArrayList<InventoryItem>(){{
        add(ItemFinder.GRAPE.getInventoryItem());
    }}, 24, 125, 600, "It's said to be the Junimos' favorite food.", "raisins"),

    DRIED_CRANBERRY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CRANBERRIES.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_cranberry"),

    DRIED_POMEGRANATE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.POMEGRANATE.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_pomegranate"),

    // Special Fruit Dried Products
    DRIED_ANCIENT_FRUIT(new ArrayList<InventoryItem>(){{
        add(ItemFinder.ANCIENT_FRUIT.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_ancient_fruit"),

    DRIED_SWEET_GEM_BERRY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.SWEET_GEM_BERRY.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_sweet_gem_berry"),

    DRIED_POWDERMELON(new ArrayList<InventoryItem>(){{
        add(ItemFinder.POWDERMELON.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_powdermelon"),

    // Smoked Fish
    SMOKED_FLOUNDER(new ArrayList<InventoryItem>(){{
        add(ItemFinder.FLOUNDER.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_flounder"),

    SMOKED_LIONFISH(new ArrayList<InventoryItem>(){{
        add(ItemFinder.LIONFISH.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_lionfish"),

    SMOKED_HERRING(new ArrayList<InventoryItem>(){{
        add(ItemFinder.HERRING.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_herring"),

    SMOKED_GHOSTFISH(new ArrayList<InventoryItem>(){{
        add(ItemFinder.GHOSTFISH.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_ghostfish"),

    SMOKED_TILAPIA(new ArrayList<InventoryItem>(){{
        add(ItemFinder.TILAPIA.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_tilapia"),

    SMOKED_DORADO(new ArrayList<InventoryItem>(){{
        add(ItemFinder.DORADO.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_dorado"),

    SMOKED_SUNFISH(new ArrayList<InventoryItem>(){{
        add(ItemFinder.SUNFISH.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_sunfish"),

    SMOKED_RAINBOW_TROUT(new ArrayList<InventoryItem>(){{
        add(ItemFinder.RAINBOW_TROUT.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_rainbow_trout"),

    SMOKED_SALMON(new ArrayList<InventoryItem>(){{
        add(ItemFinder.SALMON.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_salmon"),

    SMOKED_SARDINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.SARDINE.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_sardine"),

    SMOKED_SHAD(new ArrayList<InventoryItem>(){{
        add(ItemFinder.SHAD.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_shad"),

    SMOKED_BLUE_DISCUS(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BLUE_DISCUS.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_blue_discus"),

    SMOKED_MIDNIGHT_CARP(new ArrayList<InventoryItem>(){{
        add(ItemFinder.MIDNIGHT_CARP.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_midnight_carp"),

    SMOKED_SQUID(new ArrayList<InventoryItem>(){{
        add(ItemFinder.SQUID.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_squid"),

    SMOKED_TUNA(new ArrayList<InventoryItem>(){{
        add(ItemFinder.TUNA.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_tuna"),

    SMOKED_PERCH(new ArrayList<InventoryItem>(){{
        add(ItemFinder.PERCH.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A whole fish, smoked to perfection.", "smoked_perch"),

    // Legendary Fish
    SMOKED_LEGEND(new ArrayList<InventoryItem>(){{
        add(ItemFinder.LEGEND.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A legendary fish, smoked to perfection.", "smoked_legend"),

    SMOKED_GLACIERFISH(new ArrayList<InventoryItem>(){{
        add(ItemFinder.GLACIERFISH.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A legendary fish, smoked to perfection.", "smoked_glacierfish"),

    SMOKED_ANGLER(new ArrayList<InventoryItem>(){{
        add(ItemFinder.ANGLER.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A legendary fish, smoked to perfection.", "smoked_angler"),

    SMOKED_CRIMSONFISH(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CRIMSONFISH.getInventoryItem());
        add(ItemFinder.COAL.getInventoryItem());
    }}, 1, 1.5, 0, 2.0, "A legendary fish, smoked to perfection.", "smoked_crimsonfish"),

    // Artisan Goods (Inedible)
    CLOTH(0, 470, "cloth", "A bolt of fine wool cloth."),
    COAL(0, 50, "coal", "Turns 10 pieces of wood into one piece of coal."),
    COPPER_BAR(0, 10 * 15, "copper bar", "Turns ore and coal into metal bars."),  // 15g is base copper ore price
    IRON_BAR(0, 10 * 75, "iron bar", "Turns ore and coal into metal bars."),    // 75g is base iron ore price
    GOLD_BAR(0, 10 * 150, "gold bar", "Turns ore and coal into metal bars."),   // 150g is base gold ore price
    IRIDIUM_BAR(0, 10 * 300, "iridium bar", "Turns ore and coal into metal bars."); // 300g is base iridium ore price

    private ArrayList<InventoryItem> ingredients;
    private Item result;
    private int energy;
    private int time; // in hours
    private int price;
    private String description;
    private String resultName;

    // Constructor for standard items
    ArtisanRecipeInfo(ArrayList<InventoryItem> ingredients, int time, int energy, int price, String description, String name){
        Item item = new Item();
        this.ingredients = ingredients;
        this.time = time;
        this.energy = energy;
        this.price = price;
        if (price != 0){
            item.setPrice(price);
            item.setSellable(true);
        }
        if (energy != 0){
            item.setEnergy(energy);
        }
        this.result = item;
        this.resultName = name;
        this.description = description;
    }

    // Constructor for coefficient-based items
    ArtisanRecipeInfo(ArrayList<InventoryItem> ingredients, int time, double energyCoefficient, int basePrice, double priceCoefficient, String description, String name){
        this.ingredients = ingredients;
        this.time = time;
        Item item = new Item(name);
        if (energyCoefficient != 0) {
            this.energy = (int) (((Edible) ingredients.getFirst()).getEnergy() * energyCoefficient);
            ((Edible)item).setEnergy(energy);
            item.setEnergy(energy);
        }
        if (priceCoefficient != 0 || basePrice != 0) {
            this.price = basePrice + (int) (((Sellable)ingredients.getFirst()).getPrice() * priceCoefficient);
            ((Sellable)item).setPrice(price);
            item.setPrice(price);
        }
        this.result = item;
        this.resultName = name;
        this.description = description;

    }

    // Constructor for inedible items (only price)
    ArtisanRecipeInfo(int energy, int price, String name, String description) {
        Item item = new Item(name);
        this.energy = energy;
        this.price = price;
        if (price != 0) {
            item.setPrice(price);
            item.setSellable(true);
        }
        if (energy != 0) {
            item.setEnergy(energy);
        }
        result = item;
        this.resultName = name;
        this.description = description;
    }

    public Item getResult() {
        return result;
    }

    public ArrayList<InventoryItem> getIngredients() {
        return ingredients;
    }

    public int getEnergy() {
        return energy;
    }

    public int getTime() {
        return time;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription(){
        return description;
    }

    public ArtisanRecipe getRecipe(){
        return new ArtisanRecipe(this);
    }
}