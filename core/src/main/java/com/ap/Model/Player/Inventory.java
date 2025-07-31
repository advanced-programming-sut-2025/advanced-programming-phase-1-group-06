package com.ap.Model.Player;

import com.ap.Model.Item.Item;

import java.util.ArrayList;
import java.util.Objects;


public class Inventory {
    private final ArrayList<Item> items;
    private int level;

    public ArrayList<Item> getItems() {
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
    }

    Inventory(ArrayList<Item> items, int level){
        this.items = items;
        this.level = level;
    }

    public boolean addItem(Item itemToAdd) {
        for (Item item : items){
            if (item.equals(itemToAdd)){
                item.setAmount(item.getAmount() + itemToAdd.getAmount());
                System.out.println("item amount increased");
                return true;
            }
        }
        if (getCapacity() - items.size() < 1) {
            System.out.println("not enough space in inventory");
            return false;
        }
        items.add(itemToAdd);
        System.out.println("item added to inventory");
        return true;
    }

    public boolean checkExistense(String id, int amount){
        for (Item item : items){
            if (item.getId().equals(id) && item.getAmount() >= amount){
                return true;
            }
        }
        return false;
    }

    public Item getItemById(String id){
        for (Item item : items){
            if (item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    public void removeItem(String name){
        items.removeIf(item -> item.getName().equals(name));
    }

    public void removeItem(String itemName, int amount) {
        if (!hasItemAmount(itemName, amount))
            return;
        for (Item item : items){
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
        for (Item Item : items){
            if (item.getName().equals(Item.getName())){
                if (amount < Item.getAmount()){
                    Item.setAmount(Item.getAmount() - amount);
                    return;
                }
                if (amount >= Item.getAmount()){
                    amount -= Item.getAmount();
                    items.remove(Item);
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


    public boolean hasItemAmount(String name, int amount){
        int hasAmuont = 0;
        for (Item item : items){
            if (item.getName().equals(name)){
                hasAmuont += item.getAmount();
            }
        }
        return (hasAmuont >= amount);
    }

    public boolean hasItem(String name){
        return items.stream().anyMatch(item -> item.getName().equals(name));
    }

    public int getBaseItemCount(String itemName){
        int counter = 0;
        for (Item item : items){
            if (item.getName().equals(itemName)){
                counter += item.getAmount();
            }
        }
        return counter;
    }
    public Item getItemByName(String name){
        for (Item item : items){
            if (item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }


}
