package models.Crafting;

import models.Game.Recipe;
import models.ItemFaces.InventoryItem;
import models.ItemFaces.Item;
import models.ItemFaces.ItemFinder;

import java.util.ArrayList;

public enum ArtisanDeviceTypes {
    BEE_HOUSE(null, ),
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
