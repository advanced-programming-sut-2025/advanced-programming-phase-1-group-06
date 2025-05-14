package models.Animals;

import models.ItemFaces.InventoryItem;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Animal {
    private String name;
    private int age;
    private int price;
    private int friendship;
    private boolean isFed;
    private boolean isPetted;
    private HashMap<AnimalProductType, Boolean> products;
    private ArrayList<String> house;

    public Animal(String name, int price, HashMap<AnimalProductType, Boolean> products, ArrayList<String> house) {
        this.name = name;
        this.price = price;
        this.products = products;
        this.house = house;
    }

    public void pet() {
    }

    public InventoryItem getProduct() {
        return null;
    }


    public Animal(String name, int age, int price, int friendship, boolean isFed, boolean isPetted, HashMap<AnimalProductType, Boolean> products, ArrayList<String> house) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.friendship = friendship;
        this.isFed = isFed;
        this.isPetted = isPetted;
        this.products = products;
        this.house = house;
    }
}

