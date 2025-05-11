package models.PlantsAndForaging;


import models.Tiles.OverlayTile;

public class Tree extends OverlayTile implements Growable {
    private boolean isFruitful;
    private Crop product;

    public void chop() {
    }

    @Override
    public void grow(){

    }

    @Override
    public void harvest() {

    }

    @Override
    public String getType() {
        return "";
    }

    @Override
    public int currentGrowthDay() {
        return 0;
    }
}

