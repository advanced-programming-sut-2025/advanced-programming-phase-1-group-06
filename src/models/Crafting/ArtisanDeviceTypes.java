package models.Crafting;

import models.ItemFaces.InventoryItem;
import models.ItemFaces.ItemFinder;
import models.enums.Fish;

import java.util.ArrayList;

public enum ArtisanDeviceTypes {
    BEE_HOUSE(new ArrayList<Recipe>() {{
        add(RecipeInfo.HONEY.getRecipe());
    }}),

    CHEESE_PRESS(new ArrayList<Recipe>() {{
        add(RecipeInfo.CHEESE.getRecipe());
        add(RecipeInfo.LARGE_MILK_CHEESE.getRecipe());
        add(RecipeInfo.GOAT_CHEESE.getRecipe());
        add(RecipeInfo.LARGE_GOAT_CHEESE.getRecipe());
    }}),

    MAYONNAISE_MACHINE(new ArrayList<Recipe>() {{
        add(RecipeInfo.MAYONNAISE.getRecipe());
        add(RecipeInfo.LARGE_MAYONNAISE.getRecipe());
        add(RecipeInfo.DUCK_MAYONNAISE.getRecipe());
        add(RecipeInfo.DINOSAUR_MAYONNAISE.getRecipe());
    }}),

    KEG(new ArrayList<Recipe>() {{
        // Alcoholic Beverages
        add(RecipeInfo.BEER.getRecipe());
        add(RecipeInfo.PALE_ALE.getRecipe());
        add(RecipeInfo.MEAD.getRecipe());

        // Spring Fruit Wines
        add(RecipeInfo.APRICOT_WINE.getRecipe());
        add(RecipeInfo.CHERRY_WINE.getRecipe());
        add(RecipeInfo.STRAWBERRY_WINE.getRecipe());

        // Summer Fruit Wines
        add(RecipeInfo.BANANA_WINE.getRecipe());
        add(RecipeInfo.BLUEBERRY_WINE.getRecipe());
        add(RecipeInfo.MANGO_WINE.getRecipe());
        add(RecipeInfo.MELON_WINE.getRecipe());
        add(RecipeInfo.ORANGE_WINE.getRecipe());
        add(RecipeInfo.PEACH_WINE.getRecipe());

        // Fall Fruit Wines
        add(RecipeInfo.APPLE_WINE.getRecipe());
        add(RecipeInfo.CRANBERRY_WINE.getRecipe());
        add(RecipeInfo.GRAPE_WINE.getRecipe());
        add(RecipeInfo.POMEGRANATE_WINE.getRecipe());

        // Special Wines
        add(RecipeInfo.ANCIENT_FRUIT_WINE.getRecipe());

        // Other Beverages
        add(RecipeInfo.COFFEE.getRecipe());

        // Spring Fruit Juices
        add(RecipeInfo.APRICOT_JUICE.getRecipe());
        add(RecipeInfo.CHERRY_JUICE.getRecipe());
        add(RecipeInfo.STRAWBERRY_JUICE.getRecipe());

        // Summer Fruit Juices
        add(RecipeInfo.BANANA_JUICE.getRecipe());
        add(RecipeInfo.BLUEBERRY_JUICE.getRecipe());
        add(RecipeInfo.MANGO_JUICE.getRecipe());
        add(RecipeInfo.MELON_JUICE.getRecipe());
        add(RecipeInfo.ORANGE_JUICE.getRecipe());
        add(RecipeInfo.PEACH_JUICE.getRecipe());

        // Fall Fruit Juices
        add(RecipeInfo.APPLE_JUICE.getRecipe());
        add(RecipeInfo.CRANBERRY_JUICE.getRecipe());
        add(RecipeInfo.GRAPE_JUICE.getRecipe());
        add(RecipeInfo.POMEGRANATE_JUICE.getRecipe());
    }}),

    PRESERVE_JAR(new ArrayList<Recipe>() {{
        // Spring Fruit Jellies
        add(RecipeInfo.APRICOT_JELLY.getRecipe());
        add(RecipeInfo.CHERRY_JELLY.getRecipe());
        add(RecipeInfo.STRAWBERRY_JELLY.getRecipe());

        // Summer Fruit Jellies
        add(RecipeInfo.BANANA_JELLY.getRecipe());
        add(RecipeInfo.BLUEBERRY_JELLY.getRecipe());
        add(RecipeInfo.MANGO_JELLY.getRecipe());
        add(RecipeInfo.MELON_JELLY.getRecipe());
        add(RecipeInfo.ORANGE_JELLY.getRecipe());
        add(RecipeInfo.PEACH_JELLY.getRecipe());

        // Fall Fruit Jellies
        add(RecipeInfo.APPLE_JELLY.getRecipe());
        add(RecipeInfo.CRANBERRY_JELLY.getRecipe());
        add(RecipeInfo.GRAPE_JELLY.getRecipe());
        add(RecipeInfo.POMEGRANATE_JELLY.getRecipe());

        // Special Fruit Jellies
        add(RecipeInfo.ANCIENT_FRUIT_JELLY.getRecipe());
        add(RecipeInfo.SWEET_GEM_BERRY_JELLY.getRecipe());
        add(RecipeInfo.POWDERMELON_JELLY.getRecipe());

        // Pickled Vegetables
        add(RecipeInfo.PICKLED_ARTICHOKE.getRecipe());
        add(RecipeInfo.PICKLED_BEET.getRecipe());
        add(RecipeInfo.PICKLED_BOK_CHOY.getRecipe());
        add(RecipeInfo.PICKLED_BROCCOLI.getRecipe());
        add(RecipeInfo.PICKLED_CAULIFLOWER.getRecipe());
        add(RecipeInfo.PICKLED_CORN.getRecipe());
        add(RecipeInfo.PICKLED_EGGPLANT.getRecipe());
        add(RecipeInfo.PICKLED_GARLIC.getRecipe());
        add(RecipeInfo.PICKLED_GREEN_BEAN.getRecipe());
        add(RecipeInfo.PICKLED_HOT_PEPPER.getRecipe());
        add(RecipeInfo.PICKLED_KALE.getRecipe());
        add(RecipeInfo.PICKLED_PARSNIP.getRecipe());
        add(RecipeInfo.PICKLED_POTATO.getRecipe());
        add(RecipeInfo.PICKLED_PUMPKIN.getRecipe());
        add(RecipeInfo.PICKLED_RADISH.getRecipe());
        add(RecipeInfo.PICKLED_RED_CABBAGE.getRecipe());
        add(RecipeInfo.PICKLED_TOMATO.getRecipe());
        add(RecipeInfo.PICKLED_YAM.getRecipe());
    }}),

    LOOM(new ArrayList<Recipe>() {{
        add(RecipeInfo.CLOTH.getRecipe());
    }}),

    OIL_MAKER(new ArrayList<Recipe>() {{
        add(RecipeInfo.TRUFFLE_OIL.getRecipe());
        add(RecipeInfo.CORN_OIL.getRecipe());
        add(RecipeInfo.SUNFLOWER_OIL.getRecipe());
    }}),

    DEHYADRATOR(new ArrayList<Recipe>() {{
        // Spring Fruits
        add(RecipeInfo.DRIED_APRICOT.getRecipe());
        add(RecipeInfo.DRIED_CHERRY.getRecipe());
        add(RecipeInfo.DRIED_STRAWBERRY.getRecipe());

        // Summer Fruits
        add(RecipeInfo.DRIED_BANANA.getRecipe());
        add(RecipeInfo.DRIED_BLUEBERRY.getRecipe());
        add(RecipeInfo.DRIED_MANGO.getRecipe());
        add(RecipeInfo.DRIED_MELON.getRecipe());
        add(RecipeInfo.DRIED_ORANGE.getRecipe());
        add(RecipeInfo.DRIED_PEACH.getRecipe());

        // Fall Fruits
        add(RecipeInfo.DRIED_APPLE.getRecipe());
        add(RecipeInfo.DRIED_CRANBERRY.getRecipe());
        add(RecipeInfo.RAISINS.getRecipe());
        add(RecipeInfo.DRIED_POMEGRANATE.getRecipe());
    }}),

    FISH_SMOKER(new ArrayList<Recipe>() {{
        // Spring Fish
        add(RecipeInfo.SMOKED_FLOUNDER.getRecipe());
        add(RecipeInfo.SMOKED_LIONFISH.getRecipe());
        add(RecipeInfo.SMOKED_HERRING.getRecipe());
        add(RecipeInfo.SMOKED_GHOSTFISH.getRecipe());

        // Summer Fish
        add(RecipeInfo.SMOKED_TILAPIA.getRecipe());
        add(RecipeInfo.SMOKED_DORADO.getRecipe());
        add(RecipeInfo.SMOKED_SUNFISH.getRecipe());
        add(RecipeInfo.SMOKED_RAINBOW_TROUT.getRecipe());

        // Fall Fish
        add(RecipeInfo.SMOKED_SALMON.getRecipe());
        add(RecipeInfo.SMOKED_SARDINE.getRecipe());
        add(RecipeInfo.SMOKED_SHAD.getRecipe());
        add(RecipeInfo.SMOKED_BLUE_DISCUS.getRecipe());

        // Winter Fish
        add(RecipeInfo.SMOKED_MIDNIGHT_CARP.getRecipe());
        add(RecipeInfo.SMOKED_SQUID.getRecipe());
        add(RecipeInfo.SMOKED_TUNA.getRecipe());
        add(RecipeInfo.SMOKED_PERCH.getRecipe());

        // Legendary Fish
        add(RecipeInfo.SMOKED_LEGEND.getRecipe());
        add(RecipeInfo.SMOKED_GLACIERFISH.getRecipe());
        add(RecipeInfo.SMOKED_ANGLER.getRecipe());
        add(RecipeInfo.SMOKED_CRIMSONFISH.getRecipe());
    }}),

    CHARCOAL_KILN(new ArrayList<Recipe>() {{
        add(RecipeInfo.COAL.getRecipe());
    }}),

    FURNACE(new ArrayList<Recipe>() {{
        add(RecipeInfo.COPPER_BAR.getRecipe());
        add(RecipeInfo.IRON_BAR.getRecipe());
        add(RecipeInfo.GOLD_BAR.getRecipe());
        add(RecipeInfo.IRIDIUM_BAR.getRecipe());
    }});

    final ArrayList<Recipe> recipes;

    ArtisanDeviceTypes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    public ArrayList<Recipe> getRecipes() {
        return new ArrayList<>(recipes);
    }

    public ArtisanDevice getArtisanDevice() {
        return new ArtisanDevice(this);
    }
}