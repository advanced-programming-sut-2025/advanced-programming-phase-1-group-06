package com.ap.Model.Player;

import com.ap.Main;
import com.ap.Model.Item.ConsumableComponent;
import com.ap.Model.Item.Factory;
import com.ap.Model.Item.Item;
import com.ap.Model.Item.ToolComponent;
import com.ap.Model.Recipe;
import com.ap.View.InGameMenus.InventoryView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

import java.util.*;


public class Inventory {

    private Item equippeditem;
    private int equipedInt = 0;
    private int level;
    private final ArrayList<Item> items;

    private float TRASHCAN_X;
    private float TRASHCAN_Y;
    private float TRASHCAN_WIDTH;
    private float TRASHCAN_HEIGHT;

    public float INVENTORY_SLOT_DIMENSION = 100;
    public float INVENTORY_START_X = 400;
    public float INVENTORY_START_Y = 900;
    public float QUICK_ACCESS_START_X = 600;
    public float QUICK_ACCESS_START_Y = 80;
    private ArrayList<Slot> inventorySlots;
    private ArrayList<Slot> quickAccessSlots;
    private Stage stage;
    private Image selectedBorder;

    Group itemImages = new Group();
    Group slotImages = new Group();


    public InventoryView inventoryView;

    private DragAndDrop dragAndDrop;

    Image selectedImage;
    private int QUICK_ACCESS_SLOT_SIZE = 60;

    Inventory() {
        level = 1;
        inventorySlots = new ArrayList<>();
        quickAccessSlots = new ArrayList<>();
        items = new ArrayList<>();
        items.ensureCapacity(24);
        dragAndDrop = new DragAndDrop();
        selectedBorder = new Image(new Texture(Gdx.files.internal("inventory/selected-border.png")));
        selectedBorder.setSize(QUICK_ACCESS_SLOT_SIZE, QUICK_ACCESS_SLOT_SIZE);
        selectedImage = new Image(new Texture(Gdx.files.internal("inventory/selected-border.png")));
        initiateInventorySlots();
        addTools();
    }

    public void setTrashcanInfo(float x, float y, float width, float height) {
        TRASHCAN_Y = y;
        TRASHCAN_X = x;
        TRASHCAN_HEIGHT = height;
        TRASHCAN_WIDTH = width;
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
    /*
     "wood": 50,
     "iron_bar": 3,
     "coal": 10
     */

    private void addTools() {
        Item balls = Factory.getInstance().createItemByName("kale");
        System.out.println(balls.getComponents());
        ConsumableComponent c = (balls.getComponent(ConsumableComponent.class));
        System.out.println("energy: " + c.getEnergyRestore());
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
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        initiateInventorySlots();
    }

    Inventory(ArrayList<Item> quickAccessItems, ArrayList<Item> items, int level) {
        this.items = items;
        this.level = level;
    }

    public boolean addItem(Item itemToAdd) {
        if (itemToAdd == null)
            return false;
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
        for (Slot slot : inventorySlots){
            if (slot.item == null){
                System.out.println(slot.index);
                slot.item = itemToAdd;
                slot.itemImage = new Image(new Texture(Gdx.files.internal(itemToAdd.getTexturePath())));
                slot.itemImage.setSize(INVENTORY_SLOT_DIMENSION, INVENTORY_SLOT_DIMENSION);
                slot.itemImage.setPosition(slot.x, slot.y);
                slot.addImageListeners(slot.itemImage);
                break;
            }
        }

        sortSlots();
        initiateQuickAccessSlots();
        System.out.println(itemToAdd.getName() + " item added to inventory");
        return true;
    }

    public boolean hasItem(Item item) {
        for (Item inventoryItem : items) {
            if (inventoryItem.hasAmount(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean canCraft(Recipe recipe) {
        for (Item item : recipe.getIngredient()) {
            if (!hasItem(item)) {
                System.out.println(item.getName());
                return false;
            }
        }
        return true;
    }

    public boolean craft(Recipe r) {
        if (!canCraft(r)) {
            return false;
        }
        for (Item item : r.getIngredient()) {
            removeItem(item);
        }
        addItem(r.getItem());
        return true;
    }

    // Inventory.java
    public boolean removeItem(Item target) {
        for (Iterator<Item> it = items.iterator(); it.hasNext(); ) {
            Item i = it.next();
            if (i == target || i.equals(target) || i.getId().equals(target.getId())) {
                i.setAmount(i.getAmount() - target.getAmount());
                if (i.getAmount() <= 0) {
                    it.remove();
                    removeItemFromSlot(i);
                }
                return true;
            }
        }
        return false;
    }

    public void removeItemFromSlot(Item item){
        for (Slot slot : inventorySlots){
            if (slot.item == item){
                slot.item = null;
                slot.itemImage = null;
            }
        }
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

    public void removeItemByName(String name) {
        items.removeIf(item -> item.getName().equals(name));
    }

    public void removeItemFromSlots(Item item) {
        items.remove(item);
        Slot slot = getInventorySlotByItem(item);
        slot.item = null;
        slot.itemImage = null;
        slot = getQuickAccessSlotByItem(item);
        slot.item = null;
        slot.itemImage = null;
    }

    public void removeItemAmountByName(String itemName, int amount) {
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

    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
/*

=================================================================================================
    ui stuff

*/

    public void initiateQuickAccessSlots() {
        quickAccessSlots.clear();
        Slot slot;
        float x = QUICK_ACCESS_START_X;
        float y = QUICK_ACCESS_START_Y;
        for (int i = 0; i < 12; i++) {
            slot = new Slot(inventorySlots.get(i), this);
            slot.setCoordinates(x, y);
            x += QUICK_ACCESS_SLOT_SIZE;
            if (slot.itemImage != null) {
                slot.itemImage.setPosition(slot.x, slot.y);
                slot.itemImage.setSize(QUICK_ACCESS_SLOT_SIZE, QUICK_ACCESS_SLOT_SIZE);
            }
            quickAccessSlots.add(slot);
        }
    }

    public void drawQuickAccess(Stage stage) {
        slotImages.clearChildren();
        itemImages.clearChildren();
        this.stage = stage;
        for (int i = 0; i < 12; i++) {
            Slot slot = quickAccessSlots.get(i);
            if (slot.itemImage != null) {
                slot.itemImage.setPosition(slot.x, slot.y);
                itemImages.addActor(slot.itemImage);
            }
            quickAccessSlots.add(slot);
            Image slotImage = new Image(new Texture("inventory/inventory-slot.png"));
            slotImage.setSize(QUICK_ACCESS_SLOT_SIZE, QUICK_ACCESS_SLOT_SIZE);
            slotImage.setPosition(slot.x, slot.y);
            slotImages.addActor(slotImage);
            if (i == equipedInt) {
                selectedImage.setPosition(slot.x - 5, slot.y - 5);
                selectedImage.setSize(QUICK_ACCESS_SLOT_SIZE * 1.15f, QUICK_ACCESS_SLOT_SIZE * 1.15f);
            }
        }
        stage.addActor(slotImages);
        stage.addActor(itemImages);
//        selectedImage.toFront();
        stage.addActor(selectedImage);
    }

    public void initiateInventorySlots() {
        inventorySlots.clear();
        float x = INVENTORY_START_X;
        float y = INVENTORY_START_Y;
        Item item = null;
        Slot slot;
        int index = 1;
        for (int i = 0; i < 12; i++) {
            item = null;
            if (items.size() > i) {
                if (items.get(i) != null) {
                    item = items.get(i);
                }
            }
            slot = new Slot(item, index, x, y, this);
            inventorySlots.add(slot);
            x += INVENTORY_SLOT_DIMENSION;
            index++;
        }
        x = INVENTORY_START_X;
        y -= INVENTORY_SLOT_DIMENSION + 50;
        for (int i = 0; i < getSize() / 12; i++) {
            for (int j = 0; j < 12; j++) {
                item = null;
                if (items.size() > index - 1) {
                    if (items.get(index - 1) != null) {
                        item = items.get(index - 1);
                    }
                }
                slot = new Slot(item, index, x, y, this);
                inventorySlots.add(slot);
                index++;
                x += (INVENTORY_SLOT_DIMENSION);
            }
            y -= INVENTORY_SLOT_DIMENSION;
        }
        initiateQuickAccessSlots();
    }

    public void equipItem(int amount, Player player) {
        Slot slot = quickAccessSlots.get(amount);
        if (amount <= 12 && amount >= 0) {
            equipedInt = amount;
            selectedImage.setPosition(slot.x - 5, slot.y - 5);
            player.setCurrentItem(slot.getItem());
//            selectedImage.toFront();
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
            image.setSize(INVENTORY_SLOT_DIMENSION, INVENTORY_SLOT_DIMENSION);
            image.setPosition(slot.x, slot.y);
            slotGroup.addActor(image);
            if (slot.getItem() != null) {
//                System.out.println("slot " + slot.index + " has item " + slot.item.getName());
                imageGroup.addActor(slot.getItemImage());
                if (slot.getItem().getAmount() != 1) {
                    Label label = new Label("" + slot.getItem().getAmount(), Main.getInstance().getSkin());
                    label.setPosition(slot.x + INVENTORY_SLOT_DIMENSION - label.getWidth(), slot.y);
                    imageGroup.addActor(label);
                }
            }
        }
        stage.addActor(slotGroup);
        stage.addActor(imageGroup);
    }

    public Slot getSlotByCoordinate(float x, float y) {
        for (Slot slot : inventorySlots) {
            if (slot.x <= x && slot.y <= y && slot.x + INVENTORY_SLOT_DIMENSION >= x && slot.y + INVENTORY_SLOT_DIMENSION >= y) {
                return slot;
            }
        }
        return null;
    }

    public Slot getInventorySlotByItem(Item item) {
        for (Slot slot : inventorySlots) {
            if (slot.item == item) {
                return slot;
            }
        }
        return null;
    }

    public Slot getQuickAccessSlotByItem(Item item) {
        for (Slot slot : quickAccessSlots) {
            if (slot.item == item) {
                return slot;
            }
        }
        return null;
    }

    public boolean checkTrashcan(float x, float y) {
        return (TRASHCAN_X <= x && TRASHCAN_Y <= y && TRASHCAN_X + TRASHCAN_WIDTH >= x && TRASHCAN_Y + TRASHCAN_HEIGHT >= y);
    }

    public ArrayList<Slot> getInventorySlots() {
        return inventorySlots;
    }

    public void sortSlots(){
        inventorySlots.sort(Comparator.comparingInt(s -> s.index));
        initiateQuickAccessSlots();
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
        private Inventory inventory;

        public Slot(Slot slot, Inventory inventory) {
            this.inventory = inventory;
            this.item = slot.item;
            if (item != null) {
                itemImage = new Image(new Texture(Gdx.files.internal(item.getTexturePath())));
                itemImage.setSize(QUICK_ACCESS_SLOT_SIZE, QUICK_ACCESS_SLOT_SIZE);
            }
            this.index = slot.index;
        }

        public Slot(Item item, int index, float x, float y, Inventory inventory) {
            this.inventory = inventory;
            this.item = item;
            this.index = index;
            this.x = x;
            this.y = y;
            itemImage = null;
            if (item != null) {
                itemImage = new Image(new Texture(Gdx.files.internal(item.getTexturePath())));
                itemImage.setPosition(x, y);
                itemImage.setSize(INVENTORY_SLOT_DIMENSION, INVENTORY_SLOT_DIMENSION);
                addImageListeners(itemImage);
            }
        }

        public void addImageListeners(Image itemImage) {
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
                    if (itemImage == null) {
                        System.out.println("item image null");
                        return;
                    }
                    if (checkTrashcan(itemImage.getX() + itemImage.getWidth() / 2, itemImage.getY() + itemImage.getHeight() / 2)) {
                        inventory.removeItemFromSlots(item);
                        itemImage.remove();
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

        public static void swapItem(Slot toSlot, Slot fromSlot) {
//            // Swap items
//            Item tempItem = toSlot.item;
//            toSlot.item = fromSlot.item;
//            fromSlot.item = tempItem;
//
//            if (toSlot.item != null) {
////                System.out.println(toSlot.item.getName() + "moved from index " + fromSlot.index + " to " + toSlot.index);
//            }
//
//            // Store original images
//            Image tempImage = toSlot.itemImage;
//
//            // Update positions and images
//            if (toSlot.item != null) {
//                if (fromSlot.itemImage != null) {
//                    toSlot.itemImage = fromSlot.itemImage;
//                    toSlot.itemImage.setPosition(toSlot.x, toSlot.y);
//
//                } else {
//                    toSlot.createNewItemImage(); // Create new image with listeners
//                }
//            } else {
//                toSlot.itemImage = null;
//            }
//
//            if (fromSlot.item != null) {
//                if (tempImage != null) {
//                    fromSlot.itemImage = tempImage;
//                    fromSlot.itemImage.setPosition(fromSlot.x, fromSlot.y);
//                } else {
//                    fromSlot.createNewItemImage(); // Create new image with listeners
//                }
//            } else {
//                fromSlot.itemImage = null;
//            }
//            fromSlot.inventory.initiateQuickAccessSlots();
            int a = toSlot.index;
            System.out.println(fromSlot.getItem().getName());
            toSlot.index = fromSlot.index;
            fromSlot.index = a;
            float b = toSlot.x;
            toSlot.x = fromSlot.x;
            fromSlot.x = b;
            b = toSlot.y;
            toSlot.y = fromSlot.y;
            fromSlot.y = b;
            fromSlot.inventory.sortSlots();
            System.out.println(toSlot.inventory.getInventorySlots().get(fromSlot.index- 1).item.getName());
            System.out.println("from slot at index: " + toSlot.index + " to lost at index " + fromSlot.index);
        }

        private void createNewItemImage() {
            if (item != null) {
                itemImage = new Image(new Texture(Gdx.files.internal(item.getTexturePath())));
                itemImage.setPosition(x, y);
                itemImage.setSize(100, 100);
                addDragListener();
            }
        }

        private void addDragListener() {
            itemImage.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    touchOffsetX = x;
                    touchOffsetY = y;
                    startX = itemImage.getX();
                    startY = itemImage.getY();
                    return true;
                }

                @Override
                public void touchDragged(InputEvent event, float x, float y, int pointer) {
                    itemImage.setPosition(
                        event.getStageX() - touchOffsetX,
                        event.getStageY() - touchOffsetY
                    );
                    itemImage.toFront(); // Bring dragged item to front
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    Slot toSlot = getSlotByCoordinate(
                        itemImage.getX() + itemImage.getWidth() / 2,
                        itemImage.getY() + itemImage.getHeight() / 2
                    );

                    if (toSlot != null && toSlot != Slot.this) { // Check if not same slot
                        Slot fromSlot = Slot.this;
                        swapItem(toSlot, fromSlot);
                    } else {
                        // Return to original position if invalid drop
                        itemImage.setPosition(startX, startY);
                    }
                }
            });
        }

        public Image getItemImage() {
            return itemImage;
        }

        public void setItemImage(Image itemImage, float x, float y, float size) {
            this.itemImage = itemImage;
            if (itemImage != null) {
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

