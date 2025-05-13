package models.Game;

import models.Crafting.Bomb;
import models.ItemFaces.InventoryItem;
import models.PlantsAndForaging.Mineral;

import java.util.ArrayList;

public enum CraftingRecipe {
    BOMB("Bomb", new ArrayList<InventoryItem>(){{
        add(new Mineral("Iron").setAmount(3));
        add(new Mineral("Coal").setAmount(1));
    }}, new Bomb());
    private String name;
    private ArrayList<InventoryItem> items;
    private InventoryItem product;
}
