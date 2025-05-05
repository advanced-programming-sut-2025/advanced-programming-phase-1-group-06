package models.Player;

import java.util.Arrays;
import java.util.Objects;
import models.Interfaces.InventoryItem;

public class Inventory {
    private InventoryItem[] items;
    private int capacity;
    private int level;

    public void addItem(InventoryItem item) {
    }

    public void removeItem(InventoryItem item) {
    }

    public boolean hasItemAmount(String name, int amount) {
        if (name == null || amount <= 0 || items == null) {
            return false;
        }

        return Arrays.stream(items)
                .filter(Objects::nonNull)
                .filter(item -> name.equals(item.getName()))
                .mapToInt(InventoryItem::getAmount)
                .sum() >= amount;
    }
}
