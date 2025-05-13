package models.Crafting;

import models.ItemFaces.InventoryItem;

import java.util.ArrayList;

public enum ArtisanDeviceTypes {
    BEE_HOUSE(, ),
    LOOM(),
    CHEESE_PRESS(),
    MAYONNAISE_MACHINE(),
    KEG(),
    OIL_MAKER(),
    PRESERVE_JAR(),
    DEHYADRATOR(),
    FISH_SMOKER(),
    CHARCOAL_KILN(),
    FURNACE(),

    ;

    ArrayList<Recipe> recipes;
    InventoryItem item;
    int time; // in hours

    ArtisanDeviceTypes(ArrayList<Recipe> recipes, InventoryItem item, int time) {
        this.recipes = recipes;
        this.item = item;
        this.time = time;
    }
}
