package com.ap.Model.Player;

import com.ap.Model.Item.Factory;
import com.ap.Model.Item.Item;
import com.ap.Model.Item.ToolComponent;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import java.util.ArrayList;
import java.util.Locale;


public class Inventory {

    private final ArrayList<Item> items;
    private Item equippeditem;
    private int equipedInt = 0;
    private int level;
    private final ArrayList<Item> quickAccessItems;
    private ArrayList<Stack> quickAccessStacks;
    private ArrayList<Stack> inventoryStacks;

    Image selectedImage = new Image(new Texture(Gdx.files.internal("inventory/selected-border.png")));
    private int SLOT_SIZE = 60;

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSize(){
        return switch (level) {
            case 1 -> 12;
            case 2 -> 24;
            case 3 -> items.size() + 12;
            default -> 12;
        };
    }

    private void addTools() {
//        TODO add tools or whatever is needed at the beginning of the game
        Factory factory = Factory.getInstance();
//        Item item = factory.createItem("blue_jazz");
//        Item item = factory.createItem("blue_jazz");

        for (ToolComponent.ToolType toolType : ToolComponent.ToolType.values()){
            try {
                Item item = Factory.getInstance().createItemByName(toolType.name());
                if (item == null) {
                    System.out.println(toolType.name().toLowerCase()+ " isn't found");

                } else
                    addItem(item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    Inventory() {
        level = 1;
        quickAccessItems = new ArrayList<>();
        items = new ArrayList<>();
        quickAccessStacks = new ArrayList<>();
        inventoryStacks = new ArrayList<>();
        addTools();
    }

    Inventory(ArrayList<Item> quickAccessItems, ArrayList<Item> items, int level) {
        this.quickAccessItems = quickAccessItems;
        this.items = items;
        this.level = level;
    }

    public boolean addItem(Item itemToAdd) {
        for (Item item : items) {
            if (item.equals(itemToAdd)) {
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

    public boolean checkExistense(String id, int amount) {
        for (Item item : items) {
            if (item.getId().equals(id) && item.getAmount() >= amount) {
                return true;
            }
        }
        return false;
    }

    public Item getItemById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(String name) {
        items.removeIf(item -> item.getName().equals(name));
    }

    public void removeItem(String itemName, int amount) {
        if (!hasItemAmount(itemName, amount))
            return;
        for (Item item : items) {
            if (itemName.equals(item.getName())) {
                if (amount < item.getAmount()) {
                    item.setAmount(item.getAmount() - amount);
                    return;
                }
                if (amount >= item.getAmount()) {
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
        for (Item Item : items) {
            if (item.getName().equals(Item.getName())) {
                if (amount < Item.getAmount()) {
                    Item.setAmount(Item.getAmount() - amount);
                    return;
                }
                if (amount >= Item.getAmount()) {
                    amount -= Item.getAmount();
                    items.remove(Item);
                }
                if (amount == 0)
                    return;
            }
        }
    }

    public int getCapacity() {
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
        int hasAmuont = 0;
        for (Item item : items) {
            if (item.getName().equals(name)) {
                hasAmuont += item.getAmount();
            }
        }
        return (hasAmuont >= amount);
    }

    public boolean hasItem(String name) {
        return items.stream().anyMatch(item -> item.getName().equals(name));
    }

    public int getBaseItemCount(String itemName) {
        int counter = 0;
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                counter += item.getAmount();
            }
        }
        return counter;
    }

    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }


    public Table getQuickAccessTable(Skin skin) {
        Table table = new Table(skin);
        table.setSize(1920, 200);
        table.setPosition(0, 40);
        table.bottom();
//        table.debug();
        for (int i = 0; i < 12; i++) {
            Stack stack = new Stack();
            Image backgroundImage = new Image(new Texture(Gdx.files.internal("inventory/inventory-slot.png")));
            stack.add(backgroundImage);
            if (quickAccessItems.size() > i)
                stack.add(new Image(new Texture(Gdx.files.internal(quickAccessItems.get(i).getTexturePath()))));
            if (i == equipedInt)
                stack.add(selectedImage);
            table.add(stack).size(SLOT_SIZE, SLOT_SIZE);
            quickAccessStacks.add(stack);
        }
        return table;
    }

    public Table getInventoryTable(Skin skin){
        Table table = new Table(skin);
        table.top();
//        table.debug();

        for (int i = 0; i < 12; i++) {
            Stack stack = new Stack();
            Image backgroundImage = new Image(new Texture(Gdx.files.internal("inventory/inventory-slot.png")));
            stack.add(backgroundImage);
            if (quickAccessItems.size() > i)
                stack.add(new Image(new Texture(Gdx.files.internal(quickAccessItems.get(i).getTexturePath()))));
            table.add(stack).size(SLOT_SIZE * 1.5f, SLOT_SIZE * 1.5f).padBottom(50);
            inventoryStacks.add(stack);
        }
        table.row();
        for (int j = 0; j < getSize() / 12; j ++) {
            for (int i = 0; i < 12; i++) {
                Stack stack = new Stack();
                Image backgroundImage = new Image(new Texture(Gdx.files.internal("inventory/inventory-slot.png")));
                stack.add(backgroundImage);
                if (items.size() > i) {
                    if (!quickAccessItems.contains(items.get(i)) && items.get(i) != null) {
                        try {
                            stack.add(new Image(new Texture(Gdx.files.internal(items.get(i).getTexturePath()))));
                        } catch (Exception e) {
                            Label label = new Label(items.get(i).getName(), skin);
                            stack.add(label);
                            System.out.println(items.get(i).getTexturePath());
                            //                            e.printStackTrace();
                        }
                    }
                }
                table.add(stack).size(SLOT_SIZE * 1.5f, SLOT_SIZE * 1.5f);
                inventoryStacks.add(stack);
            }
            table.row();
        }
        return table;
    }

    public void equipItem(int i, Player player) {
        if (equipedInt >= quickAccessStacks.size()){
            System.out.println(quickAccessStacks.size() + " fuck");
            return;
        }
        quickAccessStacks.get(equipedInt).removeActor(selectedImage);
        equipedInt = i;
        if (equipedInt >= quickAccessStacks.size()){
            System.out.println(quickAccessStacks.size() + " fuck");
            return;
        }
        quickAccessStacks.get(equipedInt).add(selectedImage);
        if (items.size() > i)
            player.setCurrentItem(quickAccessItems.get(i));
    }

    public void equipItem(float y) {
        int amount = (int) y;
        if (equipedInt + amount < 9 && equipedInt > 0){
            equipItem(equipedInt + amount);
        }
    }
}
