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
        // Initialization/load ItemData.json into 'items'
        // Omitted: loading logic
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public Item createItem(String itemId) {
        return createItem(itemId, 1);
    }

    public Item createItem(String itemId, int amount) {
        ItemData data = items.get(itemId);
        if (data == null) return null;

        Item item = new Item(data.id, data.name, data.description, data.stackSize);
        if (data.getBasePrice() != 0) item.setPrice(data.getBasePrice());
        item.setAmount(amount);
        return item;
    }

    public Item cloneItem(Item item, int amount) {
        Item newItem = new Item(item.getId(), item.getName(), item.getDescription(), item.getStackSize());
        for (Component comp : item.getComponents().values()) {
            // You may need to implement a deepCopy/clone for each component
            newItem.addComponent(comp); // This should be a copy, not the same instance!
        }
        newItem.setAmount(amount);
        return newItem;
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
