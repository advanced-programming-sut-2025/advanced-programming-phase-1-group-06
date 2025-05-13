package models.Crafting;

import models.ItemFaces.*;

import java.util.ArrayList;
public enum RecipeInfo {
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
    APPLE_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.APPLE.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "apple_wine"),
    STRAWBERRY_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.STRAWBERRY.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "strawberry_wine"),
    BLUEBERRY_WINE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BLUEBERRY.getInventoryItem());
    }}, 7 * 24, 1.75, 0, 3.0, "Drink in moderation.", "blueberry_wine"),

    // Fruit Juices (using coefficient-based pricing)
    APPLE_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.APPLE.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "apple_juice"),
    STRAWBERRY_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.STRAWBERRY.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "strawberry_juice"),
    BLUEBERRY_JUICE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.BLUEBERRY.getInventoryItem());
    }}, 4 * 24, 2.0, 0, 2.25, "A sweet, nutritious beverage.", "blueberry_juice"),

    // Preserved Foods
    PICKLED_CAULIFLOWER(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CAULIFLOWER.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_cauliflower"),
    PICKLED_POTATO(new ArrayList<InventoryItem>(){{
        add(ItemFinder.POTATO.getInventoryItem());
    }}, 6, 1.75, 50, 2.0, "A jar of your home-made pickles.", "pickled_potato"),

    // Jellies (using coefficient-based pricing)
    APPLE_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.APPLE.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "apple_jelly"),
    STRAWBERRY_JELLY(new ArrayList<InventoryItem>(){{
        add(ItemFinder.STRAWBERRY.getInventoryItem());
    }}, 3 * 24, 2.0, 50, 2.0, "Gooey.", "strawberry_jelly"),

    // Dried Products
    DRIED_MOREL(new ArrayList<InventoryItem>(){{
        add(ItemFinder.MOREL.getInventoryItem());
    }}, 24, 50, 25, 7.5, "A package of gourmet mushrooms.", "dried_morel"),
    DRIED_CHANTERELLE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.CHANTERELLE.getInventoryItem());
    }}, 24, 50, 25, 7.5, "A package of gourmet mushrooms.", "dried_chanterelle"),
    DRIED_APPLE(new ArrayList<InventoryItem>(){{
        add(ItemFinder.APPLE.getInventoryItem());
    }}, 24, 75, 25, 7.5, "Chewy pieces of dried fruit.", "dried_apple"),
    RAISINS(new ArrayList<InventoryItem>(){{
        add(ItemFinder.GRAPE.getInventoryItem());
    }}, 24, 125, 600, "It's said to be the Junimos' favorite food.", "raisins"),

    // Smoked Fish (using coefficient-based pricing)
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

    // Regular Fish - Summer (تابستان)
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

    // Regular Fish - Fall (پاییز)
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

    // Regular Fish - Winter (زمستان)
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
    CLOTH(0, 470),
    COAL(0, 50),
    COPPER_BAR(0, 10 * 15),  // 15g is base copper ore price
    IRON_BAR(0, 10 * 75),    // 75g is base iron ore price
    GOLD_BAR(0, 10 * 150),   // 150g is base gold ore price
    IRIDIUM_BAR(0, 10 * 300); // 300g is base iridium ore price

    private ArrayList<InventoryItem> ingredients;
    private Item craftedItem;
    private int energy;
    private int time; // in hours
    private int price;

    // Constructor for standard items
    RecipeInfo(ArrayList<InventoryItem> ingredients, int time, int energy, int price, String description, String name){
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
        craftedItem = item;
    }

    // Constructor for coefficient-based items
    RecipeInfo(ArrayList<InventoryItem> ingredients, int time, double energyCoefficient, int basePrice, double priceCoefficient, String description, String name){
        this.ingredients = ingredients;
        this.time = time;
        Item item = new Item();
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
        this.craftedItem = item;
    }

    // Constructor for inedible items (only price)
    RecipeInfo(int energy, int price) {
        Item item = new Item();
        this.energy = energy;
        this.price = price;
        if (price != 0) {
            item.setPrice(price);
            item.setSellable(true);
        }
        if (energy != 0) {
            item.setEnergy(energy);
        }
        craftedItem = item;
    }

    public Item getCraftedItem() {
        return craftedItem;
    }
}