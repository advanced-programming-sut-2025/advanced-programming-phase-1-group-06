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

    public void addItem(InventoryItem item) {
        for (InventoryItem inventoryItem : items){
            if (item.getId() == inventoryItem.getId()){
                inventoryItem.setAmount(inventoryItem.getAmount() + item.getAmount());
                return;
            }
        }
        int capacity = getCapacity();
        if (capacity - items.size() < 1)
            System.out.println("not enough inventory space");
        items.add(item);
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

    public boolean hasItemAmount(String name, int amount) {
        return  (getBaseItemCount(name) >= amount);
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
