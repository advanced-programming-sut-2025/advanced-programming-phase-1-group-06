package models.Crafting;

import models.ItemFaces.InventoryItem;
import models.ItemFaces.ItemFinder;

import java.util.ArrayList;
import models.enums.Fish

/**
 * Last updated by: hassanp30
 * Last updated at: 2025-05-13 12:44:07 UTC
 */
public enum ArtisanDeviceTypes {
    BEE_HOUSE(new ArrayList<Recipe>() {{
        add(new Recipe(null, RecipeInfo.HONEY.getCraftedItem(), 4 * 24, "Produces honey from nearby flowers."));
    }}, 4 * 24),

    CHEESE_PRESS(new ArrayList<Recipe>() {{
        add(new Recipe(new ArrayList<InventoryItem>() {{
            add(ItemFinder.MILK.getInventoryItem());
        }}, RecipeInfo.CHEESE.getCraftedItem(), 3, "Turns milk into cheese."));
        add(new Recipe(new ArrayList<InventoryItem>() {{
            add(ItemFinder.GOAT_MILK.getInventoryItem());
        }}, RecipeInfo.GOAT_CHEESE.getCraftedItem(), 3, "Turns goat milk into goat cheese."));
    }}, 3),

    MAYONNAISE_MACHINE(new ArrayList<Recipe>() {{
        add(new Recipe(new ArrayList<InventoryItem>() {{
            add(ItemFinder.EGG.getInventoryItem());
        }}, RecipeInfo.MAYONNAISE.getCraftedItem(), 3, "Turns eggs into mayonnaise."));
        add(new Recipe(new ArrayList<InventoryItem>() {{
            add(ItemFinder.DUCK_EGG.getInventoryItem());
        }}, RecipeInfo.DUCK_MAYONNAISE.getCraftedItem(), 3, "Turns duck eggs into duck mayonnaise."));
        add(new Recipe(new ArrayList<InventoryItem>() {{
            add(ItemFinder.DINOSAUR_EGG.getInventoryItem());
        }}, RecipeInfo.DINOSAUR_MAYONNAISE.getCraftedItem(), 3, "Turns dinosaur eggs into dinosaur mayonnaise."));
    }}, 3),

    KEG(new ArrayList<Recipe>() {{
        add(new Recipe(new ArrayList<InventoryItem>() {{
            add(ItemFinder.WHEAT.getInventoryItem());
        }}, RecipeInfo.BEER.getCraftedItem(), 24, "Ferments wheat into beer."));
        add(new Recipe(new ArrayList<InventoryItem>() {{
            add(ItemFinder.HOPS.getInventoryItem());
        }}, RecipeInfo.PALE_ALE.getCraftedItem(), 3 * 24, "Ferments hops into pale ale."));
        // Add wine recipes for each fruit type
        // Add other keg recipes...
    }}, 24),

    LOOM(new ArrayList<Recipe>() {{
        add(new Recipe(new ArrayList<InventoryItem>() {{
            add(ItemFinder.WOOL.getInventoryItem());
        }}, RecipeInfo.CLOTH.getCraftedItem(), 4, "Turns wool into cloth."));
    }}, 4),

    OIL_MAKER(new ArrayList<Recipe>() {{
        add(new Recipe(new ArrayList<InventoryItem>() {{
            add(ItemFinder.TRUFFLE.getInventoryItem());
        }}, RecipeInfo.TRUFFLE_OIL.getCraftedItem(), 6, "Turns truffles into truffle oil."));
        // Add other oil recipes...
    }}, 6),

    PRESERVE_JAR(new ArrayList<Recipe>() {{
        // Add pickle recipes for each vegetable
        // Add jelly recipes for each fruit
    }}, 4 * 24),

    DEHYADRATOR(new ArrayList<Recipe>() {{
        // Add dried fruit recipes
        // Add dried mushroom recipes
    }}, 24),

    FISH_SMOKER(new ArrayList<Recipe>() {{
        for (Fish fish : Fish.values()) {
            add(new Recipe(new ArrayList<InventoryItem>() {{
                add(ItemFinder.valueOf(fish.getName().toUpperCase()).getInventoryItem());
                add(ItemFinder.COAL.getInventoryItem());
            }}, RecipeInfo.valueOf("SMOKED_" + fish.getName()).getCraftedItem(), 1,
                    "Smokes " + fish.getName() + " to perfection."));
        }
    }}, 1),

    CHARCOAL_KILN(new ArrayList<Recipe>() {{
        add(new Recipe(new ArrayList<InventoryItem>() {{
            add(ItemFinder.WOOD.getInventoryItem());
        }}, RecipeInfo.COAL.getCraftedItem(), 1, "Turns wood into coal."));
    }}, 1),

    FURNACE(new ArrayList<Recipe>() {{
        // Add metal bar recipes
    }}, 4);

    final ArrayList<Recipe> recipes;
    final int time; // in hours

    ArtisanDeviceTypes(ArrayList<Recipe> recipes, int time) {
        this.recipes = recipes;
        this.time = time;
    }

    public ArrayList<Recipe> getRecipes() {
        return new ArrayList<>(recipes);
    }

    public int getTime() {
        return time;
    }
}