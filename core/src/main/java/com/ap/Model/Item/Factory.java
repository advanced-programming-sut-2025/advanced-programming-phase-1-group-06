package com.ap.Model.Item;

import com.ap.Model.Recipe;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Scanner;

public class Factory {
    private static Factory instance;
    HashMap<String, ItemData> items = new HashMap<>();
    HashMap<String, OverlayData> overlays;
    HashMap<String, Recipe> recipes;
    ArrayList<String> fruitIds = new ArrayList<>();
    ArrayList<String> vegetableIds = new ArrayList<>();


    public Factory() {
        try {
            Gson gson = new GsonBuilder().create();
            FileReader reader = new FileReader("core/src/main/java/com/ap/Data/ItemData.json");
            ItemDataRoot root = gson.fromJson(reader, ItemDataRoot.class);

            for (ItemData data : root.harvested_crops) {
                items.put(data.id, data);
            }
            for (ItemData data : root.seeds) {
                items.put(data.id, data);
            }
            for (ItemData data : root.tools) {
                items.put(data.id, data);
            }

            // populate fruitIds, vegetableIds, etc. if needed
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        // Add components to item here if needed using data.componentsData
        item.setTexturePath(data.texture);
        return item;
    }

    public Item cloneItem(Item item, int amount) {
        Item newItem = new Item(item.getId(), item.getName(), item.getDescription(), item.getStackSize());
        for (Component comp : item.getComponents().values()) {
            newItem.addComponent(comp); // This should be a copy, not the same instance!
        }
        newItem.setAmount(amount);
        return newItem;
    }

    public Item createItemByName(String name) {
        for (ItemData data : items.values()) {
            if (data.id.equalsIgnoreCase(name)) {
                return createItem(data.id);
            }
        }
        return null;
    }

    /**
     * Creates an item instance using its name (case-insensitive) and amount.
     * Returns null if the item is not found.
     */
    public Item createItemByName(String name, int amount) {
        for (ItemData data : items.values()) {
            if (data.name.equalsIgnoreCase(name)) {
                return createItem(data.id, amount);
            }
        }
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
