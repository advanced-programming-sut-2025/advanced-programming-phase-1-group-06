package com.ap.Model.Item;

import java.util.HashMap;
import java.util.Map;

public class Item {
    private String id;
    private String name;
    private String description;
    private int stackCount;
    private int stackSize;
    private Map<Class<? extends Component>, Component> components;
    private int qualityTier;
    private int price; // -1 for unsellable items
    private String texturePath;



    public Item(String id, String name, String description, int stackSize) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stackSize = stackSize;
        this.components = new HashMap<>();
    }

    public Item(String id, String name, String description) {
        this(id, name, description, 1);
    }

    public void addComponent(Component component) {
        components.put(component.getClass(), component);
        component.setObject(this);
    }

    @SuppressWarnings("unchecked")
    public <T extends Component> T getComponent(Class<T> componentType) {
        return (T) components.get(componentType);
    }

    public <T extends Component> boolean hasComponent(Class<T> componentType) {
        return components.containsKey(componentType);
    }

    public Map<Class<? extends Component>, Component> getComponents() {
        return components;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getStackSize() { return stackSize; }
    public int getPrice() { return price; }
//    public void useItem() {
//        usageComponent.useItem();
//    }


    public String getTexturePath() {
        return texturePath;
    }

    public void setAmount(int amount) { this.stackCount = amount; }
    public int getAmount() { return stackCount; }

    public boolean equals(Item item) {
        return !item.hasComponent(ToolComponent.class) &&
            id.equals(item.getId()) &&
            qualityTier == item.qualityTier &&
            price == item.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTexturePath(String texturePath) {
        this.texturePath = texturePath;
    }

    public void setComponents(Map<Class<? extends Component>, Component> components) {
        this.components = components;
    }


}
