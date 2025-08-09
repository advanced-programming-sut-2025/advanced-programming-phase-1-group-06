package com.ap.Model.Player;

import com.ap.Model.Item.Factory;
import com.ap.Model.Item.Item;
import com.ap.Model.Item.ToolComponent;
import com.ap.View.InGameMenus.InventoryView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

import java.util.ArrayList;


public class Inventory {

    private Item equippeditem;
    private int equipedInt = 0;
    private int level;
    private final ArrayList<Item> items;
    private final ArrayList<Item> quickAccessItems;

    public float SLOT_DIMENSION = 100;
    public float INVENTORY_START_X = 400;
    public float INVENTORY_START_Y = 900;
    public float QUICK_ACCESS_START_X = 500;
    public float QUICK_ACCESS_START_Y = 80;
    private ArrayList<Slot> inventorySlots;
    private ArrayList<Slot> quickAccessSlots;
    private Image selectedBorder;

    public InventoryView inventoryView;

    private DragAndDrop dragAndDrop;

    Image selectedImage = new Image(new Texture(Gdx.files.internal("inventory/selected-border.png")));
    private int SLOT_SIZE = 60;

    Inventory() {
        level = 1;
        inventorySlots = new ArrayList<>();
        quickAccessSlots = new ArrayList<>();
        quickAccessItems = new ArrayList<>();
        items = new ArrayList<>();
        addTools();
        dragAndDrop = new DragAndDrop();
        selectedBorder = new Image(new Texture(Gdx.files.internal("inventory/selected-border.png")));
        selectedBorder.setSize(SLOT_SIZE, SLOT_SIZE);
        initiateSlots();
    }

    public void setInventoryView(InventoryView inventoryView) {
        this.inventoryView = inventoryView;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSize() {
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

        for (ToolComponent.ToolType toolType : ToolComponent.ToolType.values()) {
            try {
                if (toolType.equals(ToolComponent.ToolType.FISHING_ROD) || toolType.equals(ToolComponent.ToolType.MILK_PAIL)) {
                    continue;
                }
                Item item = Factory.getInstance().createItemByName(toolType.name());
                if (item == null) {
                    System.out.println(toolType.name().toLowerCase() + " isn't found");

                } else {
                    addItem(item);
                    quickAccessItems.add(item);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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

    public void initiateQuickAccessSlots() {
        Slot slot;
        float x = QUICK_ACCESS_START_X;
        float y = QUICK_ACCESS_START_Y;
        for (int i = 0; i < 12; i++) {
            slot = new Slot(inventorySlots.get(i));
            slot.setCoordinates(x, y);
            x += SLOT_SIZE;
            if (slot.itemImage != null) {
                slot.itemImage.setPosition(slot.x, slot.y);
            }
            quickAccessSlots.add(slot);
        }
    }

    public void drawQuickAccess(Stage stage) {
        Group itemImages = new Group();
        Group slotImages = new Group();
        for (int i = 0; i < 12; i++) {
            Slot slot = quickAccessSlots.get(i);
            if (slot.itemImage != null) {
                slot.itemImage.setPosition(slot.x, slot.y);
                itemImages.addActor(slot.itemImage);
            }
            quickAccessSlots.add(slot);
            Image slotImage = new Image(new Texture("inventory/inventory-slot.png"));
            slotImages.setSize(SLOT_SIZE, SLOT_SIZE);
            slotImage.setPosition(slot.x, slot.y);
            slotImages.addActor(slotImage);
        }
        stage.addActor(slotImages);
        stage.addActor(itemImages);
    }

    public void initiateSlots() {
        inventorySlots.clear();
        float x = INVENTORY_START_X;
        float y = INVENTORY_START_Y;
        Item item = null;
        Slot slot;
        int index = 1;
        for (int i = 0; i < 12; i++) {
            item = null;
            if (quickAccessItems.size() > i) {
                if (quickAccessItems.get(i) != null) {
                    item = quickAccessItems.get(i);
                }
            }
            slot = new Slot(item, index, x, y);
            inventorySlots.add(slot);
            x += SLOT_DIMENSION;
            index++;
        }
        x = INVENTORY_START_X;
        y -= SLOT_DIMENSION + 50;
        for (int i = 0; i < getSize() / 12; i++) {
            for (int j = 0; j < 12; j++) {
                item = null;
                if (items.size() > index - 1) {
                    if (items.get(index - 1) != null && !quickAccessItems.contains(items.get(index - 1))) {
                        item = items.get(index - 1);
                    }
                }
                slot = new Slot(item, index, x, y);
                inventorySlots.add(slot);
                index++;
                x += (SLOT_DIMENSION);
            }
            y -= SLOT_DIMENSION;
        }
        initiateQuickAccessSlots();
    }

    public void equipItem(float y, Player player) {
        int amount = (int) y;
        Slot slot = inventorySlots.get(amount);
        if (equipedInt + amount < 9 && equipedInt > 0) {
            selectedImage.setPosition(slot.x, slot.y);
            player.setCurrentItem(slot.getItem());
        }
    }

    public void drawInventory(Stage stage) {
        Group slotGroup = new Group();
        Group imageGroup = new Group();
        for (Slot slot : inventorySlots) {
            if (slot.y > 1000 || slot.y < 40) {
                continue;
            }
            Image image = new Image(new Texture(Gdx.files.internal("inventory/inventory-slot.png")));
            image.setSize(SLOT_DIMENSION, SLOT_DIMENSION);
            image.setPosition(slot.x, slot.y);
            slotGroup.addActor(image);
            if (slot.getItem() != null) {
                imageGroup.addActor(slot.getItemImage());
            }
        }
        stage.addActor(slotGroup);
        stage.addActor(imageGroup);
    }

    public Slot getSlotByCoordinate(float x, float y) {
        for (Slot slot : inventorySlots) {
            if (slot.x <= x && slot.y <= y && slot.x + SLOT_DIMENSION >= x && slot.y + SLOT_DIMENSION >= y) {
                return slot;
            }
        }
        return null;
    }

    public ArrayList<Slot> getInventorySlots() {
        return inventorySlots;
    }

    class Slot {


        private Item item;
        public int index;
        public float x, y;
        private Image itemImage;
        private float touchOffsetX;
        private float touchOffsetY;
        private float startX;
        private float startY;

        public Slot(Slot slot) {
            this.item = slot.item;

            if (item != null) {
                itemImage = new Image(new Texture(Gdx.files.internal(item.getTexturePath())));
                itemImage.setSize(SLOT_SIZE, SLOT_SIZE);
            }
            this.index = slot.index;
        }

        public Slot(Item item, int index, float x, float y) {
            this.item = item;
            this.index = index;
            this.x = x;
            this.y = y;
            itemImage = null;
            if (item != null) {
                itemImage = new Image(new Texture(Gdx.files.internal(item.getTexturePath())));
                itemImage.setPosition(x, y);
                itemImage.setSize(100, 100);
                itemImage.addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        if (itemImage == null) {
                            System.out.println("item image null");
                            return true;
                        }
                        touchOffsetX = x;
                        touchOffsetY = y;
                        startX = itemImage.getX();
                        startY = itemImage.getY();
                        return true;
                    }

                    @Override
                    public void touchDragged(InputEvent event, float x, float y, int pointer) {
                        if (itemImage == null) {
                            System.out.println("item image null");
                            return;
                        }
                        itemImage.setPosition(
                            event.getStageX() - touchOffsetX,
                            event.getStageY() - touchOffsetY
                        );
                    }

                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        if (itemImage == null){
                            System.out.println("item image null");
                            return;
                        }
                        Slot toSlot = getSlotByCoordinate(itemImage.getX() + itemImage.getWidth() / 2, itemImage.getY() + itemImage.getHeight() / 2);
                        if (toSlot != null) {
                            itemImage.setPosition(toSlot.x, toSlot.y);
                            Slot fromSlot = getSlotByCoordinate(startX + itemImage.getWidth() / 2, startY + itemImage.getHeight() / 2);
                            swapItem(toSlot, fromSlot);
                        } else {
                            itemImage.setPosition(startX, startY);
                        }
                    }
                });

            }
        }

        public static void swapItem(Slot slot1, Slot slot2) {
            Item item = slot1.item;
//            Image itemImage = slot1.itemImage;
            slot1.item = slot2.item;
//            slot1.itemImage = slot2.itemImage;
            slot2.item = item;
//            slot2.itemImage = itemImage;
            if (slot1.item != null){
                slot1.setItemImage(new Image(new Texture(Gdx.files.internal(slot1.item.getTexturePath()))), slot1.x, slot1.y, 100);
                System.out.println("slot1: " + slot1.index);
            }
            if (slot2.item != null){
                slot2.setItemImage(new Image(new Texture(Gdx.files.internal(slot2.item.getTexturePath()))), slot2.x, slot2.y, 100);
//                slot2.itemImage.setPosition(slot1.x, slot2.y);
                System.out.println("slot2: " + slot2.index);
            }
        }

        public Image getItemImage() {
            return itemImage;
        }

        public void setItemImage(Image itemImage, float x, float y, float size) {
            this.itemImage = itemImage;
            if(itemImage != null){
                itemImage.setPosition(x, y);
                itemImage.setSize(size, size);
            }
        }

        public void setItemImage(Image itemImage) {
            this.itemImage = itemImage;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public void setCoordinates(float x, float y) {
            this.x = x;
            this.y = y;
            if (itemImage != null)
                itemImage.setPosition(x, y);
        }
    }

}

