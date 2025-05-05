package models.Tiles;

import models.PlantsAndForaging.Growable;

public class Dirt extends Tile{
    private boolean isWatered;
    private boolean isFertilized;
    private Growable growable;

    private boolean isHoed;

    private void setHoedDirt() {
        //TODO
        isHoed = true;
    }

    private void unsetHoedDirt() {
        //TODO
        isHoed = false;
    }

    public boolean isFertilized() {
        return isFertilized;
    }

    public boolean isWatered() {
        return isWatered;
    }
}
