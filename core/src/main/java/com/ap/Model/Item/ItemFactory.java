package com.ap.Model.Item;

import java.util.HashMap;

public class ItemFactory {
    HashMap<String, ItemData> items;

    public ItemFactory() {
        //loadedItems = new ArrayList<>();
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
}
