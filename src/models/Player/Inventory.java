package models.Player;

import java.util.ArrayList;

import models.ItemFaces.InventoryItem;
import models.ItemFaces.Item;
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

    public boolean addItem(InventoryItem item) {
        for (InventoryItem inventoryItem : items){
            if (item.getId() == inventoryItem.getId()){
                inventoryItem.setAmount(inventoryItem.getAmount() + item.getAmount());
                return true;
            }
        }
        if (getCapacity() - items.size() < 1) {
            return false;
        }
        items.add(item);
        return true;
    }

    public boolean checkExistense(int id, int amount){
        for (InventoryItem item : items){
            if (item.getId() == id && item.getAmount() >= amount){
                return true;
            }
        }
        return false;
    }

    public InventoryItem getItemById(int id){
        for (InventoryItem item : items){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public void removeItem(String itemName, int amount) {
        if (!hasItemAmount(itemName, amount))
            return;
        for (InventoryItem item : items){
            if (itemName.equals(item.getName())){
                if (amount < item.getAmount()){
                    item.setAmount(item.getAmount() - amount);
                    return;
                }
                if (amount >= item.getAmount()){
                    amount -= item.getAmount();
                    items.remove(item);
                }
                if (amount == 0)
                    return;
                if (item.getAmount() > amount)
                    item.setAmount(item.getAmount() - amount);
            }
        }
    }
    public void removeItem(Item item, int amount) {
        if (!hasItemAmount(item.getName(), amount))
            return;
        for (InventoryItem inventoryItem : items){
            if (item.getName().equals(inventoryItem.getName())){
                if (amount < inventoryItem.getAmount()){
                    inventoryItem.setAmount(inventoryItem.getAmount() - amount);
                    return;
                }
                if (amount >= inventoryItem.getAmount()){
                    amount -= inventoryItem.getAmount();
                    items.remove(inventoryItem);
                }
                if (amount == 0)
                    return;
            }
        }
    }

    public int getCapacity(){
        return switch (this.level) {
            case 1 -> 12;
            case 2 -> 24;
            case 3 -> Integer.MAX_VALUE;
            default -> 12;
        };
    }

    public boolean isFull() {
        return items.size() >= getCapacity();
    }

    public boolean hasItemAmount(String name, int amount) {
        return items.stream().anyMatch(item -> item.getName().equals(name) && item.getAmount() >= amount);
    }
    public int getBaseItemCount(String itemName){
        int counter = 0;
        for (InventoryItem item : items){
            if (item.getName().equals(itemName)){
                counter += item.getAmount();
            }
        }
        return counter;
    }
    public InventoryItem getItemByName(String name){
        for (InventoryItem item : items){
            if (item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }
}
