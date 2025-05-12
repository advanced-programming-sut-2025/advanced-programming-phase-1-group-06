package models.Tiles;

import models.PlantsAndForaging.Growable;
import models.enums.Color;
import models.tools.Tool;

public class Dirt extends Tile{
    private boolean isWatered;
    private boolean isFertilized;
    private Growable growable;

    private boolean isHoed;

    public Dirt() {
        color = Color.YELLOW_BG.getColorCode();
        isHoed = false;
        isWatered = false;
        isFertilized = false;
        growable = null;
    }

    public Dirt(boolean isWatered, boolean isFertilized, boolean isHoed, Growable growable) {
        this.isWatered = isWatered;
        this.isFertilized = isFertilized;
        this.isHoed = isHoed;
        this.growable = growable;
    }

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

    @Override
    public void useTool(Tool tool) {
        
    }
}
