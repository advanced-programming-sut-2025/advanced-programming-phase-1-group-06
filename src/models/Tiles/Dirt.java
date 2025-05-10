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
        symbol = '+';
    }

    private void unsetHoedDirt() {
        //TODO
        isHoed = false;
        symbol = '.';
    }

    public boolean isFertilized() {
        return isFertilized;
    }

    public boolean isWatered() {
        return isWatered;
    }

    public boolean isHoed() {
        return isHoed;
    }

    public Growable getGrowable() {
        return growable;
    }

    public void setHoed(boolean isHoed) {
        this.isHoed = isHoed;
    }

    public void setWatered(boolean isWatered) {
        this.isWatered = isWatered;
    }

    public void setFertilized(boolean isFertilized) {
        this.isFertilized = isFertilized;
    }

    public void setGrowable(Growable growable) {
        this.growable = growable;
    }
}
