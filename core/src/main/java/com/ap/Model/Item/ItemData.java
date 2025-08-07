package com.ap.Model.Item;

import java.util.List;
import java.util.Map;

public class ItemData {
    String id;
    String name;
    String description;
    int stackSize;
    int basePrice;
    List<Map<String, Object>> componentsData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public List<Map<String, Object>> getComponentsData() {
        return componentsData;
    }

    public void setComponentsData(List<Map<String, Object>> componentsData) {
        this.componentsData = componentsData;
    }
}
