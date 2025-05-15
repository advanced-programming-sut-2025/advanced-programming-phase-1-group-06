package models.CraftingAndCooking;

import java.util.ArrayList;

public enum ArtisanDeviceTypes {
    BEE_HOUSE(new ArrayList<ArtisanRecipe>() {{
        add(ArtisanRecipeInfo.HONEY.getRecipe());
    }}),

    CHEESE_PRESS(new ArrayList<ArtisanRecipe>() {{
        add(ArtisanRecipeInfo.CHEESE.getRecipe());
        add(ArtisanRecipeInfo.LARGE_MILK_CHEESE.getRecipe());
        add(ArtisanRecipeInfo.GOAT_CHEESE.getRecipe());
        add(ArtisanRecipeInfo.LARGE_GOAT_CHEESE.getRecipe());
    }}),

    MAYONNAISE_MACHINE(new ArrayList<ArtisanRecipe>() {{
        add(ArtisanRecipeInfo.MAYONNAISE.getRecipe());
        add(ArtisanRecipeInfo.LARGE_MAYONNAISE.getRecipe());
        add(ArtisanRecipeInfo.DUCK_MAYONNAISE.getRecipe());
        add(ArtisanRecipeInfo.DINOSAUR_MAYONNAISE.getRecipe());
    }}),

    KEG(new ArrayList<ArtisanRecipe>() {{
        // Alcoholic Beverages
        add(ArtisanRecipeInfo.BEER.getRecipe());
        add(ArtisanRecipeInfo.PALE_ALE.getRecipe());
        add(ArtisanRecipeInfo.MEAD.getRecipe());

        // Spring Fruit Wines
        add(ArtisanRecipeInfo.APRICOT_WINE.getRecipe());
        add(ArtisanRecipeInfo.CHERRY_WINE.getRecipe());
        add(ArtisanRecipeInfo.STRAWBERRY_WINE.getRecipe());

        // Summer Fruit Wines
        add(ArtisanRecipeInfo.BANANA_WINE.getRecipe());
        add(ArtisanRecipeInfo.BLUEBERRY_WINE.getRecipe());
        add(ArtisanRecipeInfo.MANGO_WINE.getRecipe());
        add(ArtisanRecipeInfo.MELON_WINE.getRecipe());
        add(ArtisanRecipeInfo.ORANGE_WINE.getRecipe());
        add(ArtisanRecipeInfo.PEACH_WINE.getRecipe());

        // Fall Fruit Wines
        add(ArtisanRecipeInfo.APPLE_WINE.getRecipe());
        add(ArtisanRecipeInfo.CRANBERRY_WINE.getRecipe());
        add(ArtisanRecipeInfo.GRAPE_WINE.getRecipe());
        add(ArtisanRecipeInfo.POMEGRANATE_WINE.getRecipe());

        // Special Wines
        add(ArtisanRecipeInfo.ANCIENT_FRUIT_WINE.getRecipe());

        // Other Beverages
        add(ArtisanRecipeInfo.COFFEE.getRecipe());

        // Spring Fruit Juices
        add(ArtisanRecipeInfo.APRICOT_JUICE.getRecipe());
        add(ArtisanRecipeInfo.CHERRY_JUICE.getRecipe());
        add(ArtisanRecipeInfo.STRAWBERRY_JUICE.getRecipe());

        // Summer Fruit Juices
        add(ArtisanRecipeInfo.BANANA_JUICE.getRecipe());
        add(ArtisanRecipeInfo.BLUEBERRY_JUICE.getRecipe());
        add(ArtisanRecipeInfo.MANGO_JUICE.getRecipe());
        add(ArtisanRecipeInfo.MELON_JUICE.getRecipe());
        add(ArtisanRecipeInfo.ORANGE_JUICE.getRecipe());
        add(ArtisanRecipeInfo.PEACH_JUICE.getRecipe());

        // Fall Fruit Juices
        add(ArtisanRecipeInfo.APPLE_JUICE.getRecipe());
        add(ArtisanRecipeInfo.CRANBERRY_JUICE.getRecipe());
        add(ArtisanRecipeInfo.GRAPE_JUICE.getRecipe());
        add(ArtisanRecipeInfo.POMEGRANATE_JUICE.getRecipe());
    }}),

    PRESERVE_JAR(new ArrayList<ArtisanRecipe>() {{
        // Spring Fruit Jellies
        add(ArtisanRecipeInfo.APRICOT_JELLY.getRecipe());
        add(ArtisanRecipeInfo.CHERRY_JELLY.getRecipe());
        add(ArtisanRecipeInfo.STRAWBERRY_JELLY.getRecipe());

        // Summer Fruit Jellies
        add(ArtisanRecipeInfo.BANANA_JELLY.getRecipe());
        add(ArtisanRecipeInfo.BLUEBERRY_JELLY.getRecipe());
        add(ArtisanRecipeInfo.MANGO_JELLY.getRecipe());
        add(ArtisanRecipeInfo.MELON_JELLY.getRecipe());
        add(ArtisanRecipeInfo.ORANGE_JELLY.getRecipe());
        add(ArtisanRecipeInfo.PEACH_JELLY.getRecipe());

        // Fall Fruit Jellies
        add(ArtisanRecipeInfo.APPLE_JELLY.getRecipe());
        add(ArtisanRecipeInfo.CRANBERRY_JELLY.getRecipe());
        add(ArtisanRecipeInfo.GRAPE_JELLY.getRecipe());
        add(ArtisanRecipeInfo.POMEGRANATE_JELLY.getRecipe());

        // Special Fruit Jellies
        add(ArtisanRecipeInfo.ANCIENT_FRUIT_JELLY.getRecipe());
        add(ArtisanRecipeInfo.SWEET_GEM_BERRY_JELLY.getRecipe());
        add(ArtisanRecipeInfo.POWDERMELON_JELLY.getRecipe());

        // Pickled Vegetables
        add(ArtisanRecipeInfo.PICKLED_ARTICHOKE.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_BEET.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_BOK_CHOY.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_BROCCOLI.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_CAULIFLOWER.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_CORN.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_EGGPLANT.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_GARLIC.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_GREEN_BEAN.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_HOT_PEPPER.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_KALE.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_PARSNIP.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_POTATO.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_PUMPKIN.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_RADISH.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_RED_CABBAGE.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_TOMATO.getRecipe());
        add(ArtisanRecipeInfo.PICKLED_YAM.getRecipe());
    }}),

    LOOM(new ArrayList<ArtisanRecipe>() {{
        add(ArtisanRecipeInfo.CLOTH.getRecipe());
    }}),

    OIL_MAKER(new ArrayList<ArtisanRecipe>() {{
        add(ArtisanRecipeInfo.TRUFFLE_OIL.getRecipe());
        add(ArtisanRecipeInfo.CORN_OIL.getRecipe());
        add(ArtisanRecipeInfo.SUNFLOWER_OIL.getRecipe());
    }}),

    DEHYADRATOR(new ArrayList<ArtisanRecipe>() {{
        // Spring Fruits
        add(ArtisanRecipeInfo.DRIED_APRICOT.getRecipe());
        add(ArtisanRecipeInfo.DRIED_CHERRY.getRecipe());
        add(ArtisanRecipeInfo.DRIED_STRAWBERRY.getRecipe());

        // Summer Fruits
        add(ArtisanRecipeInfo.DRIED_BANANA.getRecipe());
        add(ArtisanRecipeInfo.DRIED_BLUEBERRY.getRecipe());
        add(ArtisanRecipeInfo.DRIED_MANGO.getRecipe());
        add(ArtisanRecipeInfo.DRIED_MELON.getRecipe());
        add(ArtisanRecipeInfo.DRIED_ORANGE.getRecipe());
        add(ArtisanRecipeInfo.DRIED_PEACH.getRecipe());

        // Fall Fruits
        add(ArtisanRecipeInfo.DRIED_APPLE.getRecipe());
        add(ArtisanRecipeInfo.DRIED_CRANBERRY.getRecipe());
        add(ArtisanRecipeInfo.RAISINS.getRecipe());
        add(ArtisanRecipeInfo.DRIED_POMEGRANATE.getRecipe());
    }}),

    FISH_SMOKER(new ArrayList<ArtisanRecipe>() {{
        // Spring Fish
        add(ArtisanRecipeInfo.SMOKED_FLOUNDER.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_LIONFISH.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_HERRING.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_GHOSTFISH.getRecipe());

        // Summer Fish
        add(ArtisanRecipeInfo.SMOKED_TILAPIA.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_DORADO.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_SUNFISH.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_RAINBOW_TROUT.getRecipe());

        // Fall Fish
        add(ArtisanRecipeInfo.SMOKED_SALMON.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_SARDINE.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_SHAD.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_BLUE_DISCUS.getRecipe());

        // Winter Fish
        add(ArtisanRecipeInfo.SMOKED_MIDNIGHT_CARP.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_SQUID.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_TUNA.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_PERCH.getRecipe());

        // Legendary Fish
        add(ArtisanRecipeInfo.SMOKED_LEGEND.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_GLACIERFISH.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_ANGLER.getRecipe());
        add(ArtisanRecipeInfo.SMOKED_CRIMSONFISH.getRecipe());
    }}),

    CHARCOAL_KILN(new ArrayList<ArtisanRecipe>() {{
        add(ArtisanRecipeInfo.COAL.getRecipe());
    }}),

    FURNACE(new ArrayList<ArtisanRecipe>() {{
        add(ArtisanRecipeInfo.COPPER_BAR.getRecipe());
        add(ArtisanRecipeInfo.IRON_BAR.getRecipe());
        add(ArtisanRecipeInfo.GOLD_BAR.getRecipe());
        add(ArtisanRecipeInfo.IRIDIUM_BAR.getRecipe());
    }});

    final ArrayList<ArtisanRecipe> artisanRecipes;

    ArtisanDeviceTypes(ArrayList<ArtisanRecipe> artisanRecipes) {
        this.artisanRecipes = artisanRecipes;
    }

    public ArrayList<ArtisanRecipe> getRecipes() {
        return new ArrayList<>(artisanRecipes);
    }

    public ArtisanDevice getArtisanDevice() {
        return new ArtisanDevice(this);
    }
}