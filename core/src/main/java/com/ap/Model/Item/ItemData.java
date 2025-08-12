package com.ap.Model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemData {
    public String id;
    public String name;
    public String description;
    public int stackSize;
    public int basePrice = 0; // Optional
    public String recipeId;

    public String texture;
    public ArrayList<ComponentData> componentsData;

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public ArrayList<ComponentData> getComponentsData() {
        return componentsData;
    }

    public void setComponentsData(ArrayList<ComponentData> componentsData) {
        this.componentsData = componentsData;
    }

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

    public String getRecipeId() {
        return recipeId;
    }
}
