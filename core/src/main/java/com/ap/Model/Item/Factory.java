package com.ap.Model.Item;

import com.ap.Model.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class Factory {
    private static Factory instance;
    HashMap<String, ItemData> items;
    HashMap<String, OverlayData> overlays;
    HashMap<String, Recipe> recipes;
    ArrayList<String> fruitIds;
    ArrayList<String> vegetableIds;
    public Factory() {
        //loadedItems = new ArrayList<>();
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return null;
    }

    public Item createItem(String itemName) {
        return createItem(itemName, 1);
    }

    public Item createItem(String itemName, int amount) {
        return null;
    }

    public Item cloneItem(Item item, int amount) {
        return null;
    }

    public boolean hasCategory(Item item, String category) {
        switch (category) {
            case "fruit":
                return fruitIds.contains(item.getId());

            case "vegetable":
                return vegetableIds.contains(item.getId());

            case "ore":

        }
        return false;
    }
}
