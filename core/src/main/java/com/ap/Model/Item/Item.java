package com.ap.Model.Item;

import com.ap.Model.Component;

import java.util.HashMap;
import java.util.Map;

public class Item {
    private String id;
    private String name;
    private String description;
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

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getStackSize() { return stackSize; }

//    public void useItem() {
//        usageComponent.useItem();
//    }

    public boolean equals(Object o) { // for stacking purposes
        if (this == o) return true;
        if (!(o instanceof Item other)) return false;
        return id.equals(other.id) && qualityTier == other.qualityTier && price == other.price;
    }
}
