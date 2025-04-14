package models.growables;

import models.Tile;
public class Plant extends Tile implements Growable {
    private boolean isHarvestable;
    private boolean isWatered;
    private boolean isFertilized;
    private Crop product;

    public void harvest() {
    }
}
