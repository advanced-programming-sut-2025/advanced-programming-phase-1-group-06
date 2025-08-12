package com.ap.Model.Item;

import com.ap.Model.Recipe;

import java.util.ArrayList;

public class ArtisanComponent extends Component {


    String sourceItem;
    String resultItem;
    int processingTime;
    public String type;
    // For Consumable
    public int energyRestore;


    public String getSourceItem() {
        return sourceItem;
    }

    public void setSourceItem(String sourceItem) {
        this.sourceItem = sourceItem;
    }

    public String getResultItem() {
        return resultItem;
    }

    public void setResultItem(String resultItem) {
        this.resultItem = resultItem;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEnergyRestore() {
        return energyRestore;
    }

    public void setEnergyRestore(int energyRestore) {
        this.energyRestore = energyRestore;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    public enum ArtisanType {
    }

    public void craft() {

    }

    public void checkRady() {

    }

    public void update() {

    }

    ArrayList<Recipe> recipes;
}
