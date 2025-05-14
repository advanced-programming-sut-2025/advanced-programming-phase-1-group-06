package models.Crafting;

import models.ItemFaces.InventoryItem;
import models.ItemFaces.Item;
import models.ItemFaces.ItemFinder;
import java.util.ArrayList;

public enum CraftingRecipeInfo {
    CHERRY_BOMB(
            "Cherry Bomb",
            "Destroys everything within 3 tiles",
            createIngredients(ItemFinder.COPPER, 4, ItemFinder.COAL, 1),
            50,
            1, // Mining level required
            1 // crafting time in minutes
    ),
    BOMB(
            "Bomb",
            "Destroys everything within 5 tiles",
            createIngredients(ItemFinder.IRON, 4, ItemFinder.COAL, 1),
            50,
            2, // Mining level required
            2
    ),
    SPRINKLER(
            "Sprinkler",
            "Waters 4 adjacent tiles",
            createIngredients(ItemFinder.COPPER_BAR, 1, ItemFinder.IRON_BAR, 1),
            0,
            1, // Farming level required
            3
    ),
    QUALITY_SPRINKLER(
            "Quality Sprinkler",
            "Waters 8 adjacent tiles",
            createIngredients(ItemFinder.IRON_BAR, 1, ItemFinder.GOLD_BAR, 1),
            0,
            2, // Farming level required
            4
    ),
    IRIDIUM_SPRINKLER(
            "Iridium Sprinkler",
            "Waters 24 adjacent tiles",
            createIngredients(ItemFinder.GOLD_BAR, 1, ItemFinder.IRIDIUM_BAR, 1),
            0,
            3, // Farming level required
            5
    ),
    CHARCOAL_KILN(
            "Charcoal Kiln",
            "Converts 10 wood into 1 coal",
            createIngredients(ItemFinder.WOOD, 20, ItemFinder.COPPER_BAR, 2),
            0,
            1, // Foraging level required
            3
    ),
    FURNACE(
            "Furnace",
            "Converts ores and coal into bars",
            createIngredients(ItemFinder.COPPER, 20, ItemFinder.STONE, 25),
            0,
            0, // No level required
            4
    ),
    SCARECROW(
            "Scarecrow",
            "Prevents crow attacks within 8 tiles",
            createIngredients(ItemFinder.WOOD, 50, ItemFinder.COAL, 1, ItemFinder.FIBER, 20),
            0,
            0, // No level required
            2
    ),
    DELUXE_SCARECROW(
            "Deluxe Scarecrow",
            "Prevents crow attacks within 12 tiles",
            createIngredients(ItemFinder.WOOD, 50, ItemFinder.COAL, 1, ItemFinder.FIBER, 20, ItemFinder.IRIDIUM, 1),
            0,
            2, // Farming level required
            3
    ),
    BEE_HOUSE(
            "Bee House",
            "Produces honey when placed in a farm",
            createIngredients(ItemFinder.WOOD, 40, ItemFinder.COAL, 8, ItemFinder.IRON_BAR, 1),
            0,
            1, // Farming level required
            4
    ),
    CHEESE_PRESS(
            "Cheese Press",
            "Converts milk into cheese",
            createIngredients(ItemFinder.WOOD, 45, ItemFinder.STONE, 45, ItemFinder.COPPER_BAR, 1),
            0,
            2, // Farming level required
            4
    ),
    KEG(
            "Keg",
            "Converts fruits and vegetables into beverages",
            createIngredients(ItemFinder.WOOD, 30, ItemFinder.COPPER_BAR, 1, ItemFinder.IRON_BAR, 1),
            0,
            3, // Farming level required
            5
    ),
    LOOM(
            "Loom",
            "Converts wool into cloth",
            createIngredients(ItemFinder.WOOD, 60, ItemFinder.FIBER, 30),
            0,
            3, // Farming level required
            4
    ),
    MAYONNAISE_MACHINE(
            "Mayonnaise Machine",
            "Converts eggs into mayonnaise",
            createIngredients(ItemFinder.WOOD, 15, ItemFinder.STONE, 15, ItemFinder.COPPER_BAR, 1),
            0,
            0, // No level required
            3
    ),
    OIL_MAKER(
            "Oil Maker",
            "Converts truffle into oil",
            createIngredients(ItemFinder.WOOD, 100, ItemFinder.GOLD_BAR, 1, ItemFinder.IRON_BAR, 1),
            0,
            3, // Farming level required
            5
    ),
    PRESERVES_JAR(
            "Preserves Jar",
            "Converts vegetables into pickles and fruits into jam",
            createIngredients(ItemFinder.WOOD, 50, ItemFinder.STONE, 40, ItemFinder.COAL, 8),
            0,
            2, // Farming level required
            4
    ),
    DEHYDRATOR(
            "Dehydrator",
            "Dehydrates fruits or mushrooms",
            createIngredients(ItemFinder.WOOD, 30, ItemFinder.STONE, 20, ItemFinder.FIBER, 30),
            0,
            0, // No level required
            4
    ),
    GRASS_STARTER(
            "Grass Starter",
            "Creates grass when placed on ground",
            createIngredients(ItemFinder.WOOD, 1, ItemFinder.FIBER, 1),
            0,
            0, // No level required
            1
    ),
    FISH_SMOKER(
            "Fish Smoker",
            "Converts fish into smoked fish using coal while maintaining quality",
            createIngredients(ItemFinder.WOOD, 50, ItemFinder.IRON_BAR, 3, ItemFinder.COAL, 10),
            0,
            0, // No level required
            4
    ),
    MYSTIC_TREE_SEED(
            "Mystic Tree Seed",
            "Can be planted to grow a mystic tree",
            createIngredients(ItemFinder.ACORN, 5, ItemFinder.MAPLE_SEED, 5,
                    ItemFinder.PINE_CONE, 5, ItemFinder.MAHOGANY_SEED, 5),
            100,
            4, // Foraging level required
            2
    );

    private final String name;
    private final String description;
    private final ArrayList<InventoryItem> ingredients;
    private final int sellPrice;
    private final int requiredLevel;
    private final int craftingTime;

    CraftingRecipeInfo(String name, String description, ArrayList<InventoryItem> ingredients,
                       int sellPrice, int requiredLevel, int craftingTime) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.sellPrice = sellPrice;
        this.requiredLevel = requiredLevel;
        this.craftingTime = craftingTime;
    }

    private static ArrayList<InventoryItem> createIngredients(Object... args) {
        ArrayList<InventoryItem> ingredients = new ArrayList<>();
        for (int i = 0; i < args.length; i += 2) {
            ItemFinder itemFinder = (ItemFinder) args[i];
            int amount = (Integer) args[i + 1];
            InventoryItem item = itemFinder.getItem();
            item.setAmount(amount);
            ingredients.add(item);
        }
        return ingredients;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public ArrayList<InventoryItem> getIngredients() { return new ArrayList<>(ingredients); }
    public int getSellPrice() { return sellPrice; }
    public int getRequiredLevel() { return requiredLevel; }
    public int getCraftingTime() { return craftingTime; }

    public Item createResult() {
        Item item = new Item(false, true, true, sellPrice, 0, description, name);
        item.setAmount(1);
        return item;
    }
}