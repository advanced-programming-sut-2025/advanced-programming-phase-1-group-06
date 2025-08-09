package com.ap.Model;

import com.ap.Model.Item.ItemData;
import com.ap.Model.Item.ItemDataRoot;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

public class Recipe {

    private String itemId;
    private String itemName;
    private Map<String, Integer> ingredients;

    //    TODO load the recipes into this array; add methods to retrieve items through item instance and or name.
    //    TODO also add items from the recipes to the ItemData.json as a new category.
    private static ArrayList<Recipe> recipes;
    public void load() {
        try {
            Gson gson = new GsonBuilder().create();
            FileReader reader = new FileReader("core/src/main/java/com/ap/Data/Recipes.json");
            Recipe root = gson.fromJson(reader, Recipe.class);


            // populate fruitIds, vegetableIds, etc. if needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
