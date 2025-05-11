package models.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import models.Interfaces.InventoryItem;
import models.tools.ToolType;

public class Inventory {
    private final ArrayList<InventoryItem> items;
    private int level;

    public ArrayList<InventoryItem> getItems() {
        return items;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    Inventory(){
        level = 1;
        items = new ArrayList<>();
        for (ToolType t : ToolType.values()){
            items.add(t.getTool());
        }
    }

    Inventory(ArrayList<InventoryItem> items, int level){
        this.items = items;
        this.level = level;
    }

    public String addItem(InventoryItem item) {
        int capacity = getCapacity();
        if (capacity - items.size() < 1)
            return "not enough inventory space";
        items.add(item);
        return null;
    }

    public void removeItem(InventoryItem item) {
        items.remove(item);
    }

    public int getCapacity(){
        return switch (this.level) {
            case 1 -> 12;
            case 2 -> 24;
            case 3 -> Integer.MAX_VALUE;
            default -> 12;
        };
    }

    public boolean hasItemAmount(String name, int amount) {
        if (name == null || amount <= 0 || items == null) {
            return false;
        }
        return false;
    }
}
