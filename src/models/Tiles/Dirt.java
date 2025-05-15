package models.Tiles;

import models.PlantsAndForaging.Growable;
import models.Player.Player;
import models.Tiles.OverlayTiles.OverlayTile;
import models.enums.Color;
import models.tools.Hoe;
import models.tools.Pickaxe;
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
        color = (isHoed) ? Color.RED_BG.getColorCode() : Color.YELLOW_BG.getColorCode();
        this.growable = growable;
    }

    private void setHoedDirt() {
        color = Color.RED_BG.getColorCode();
        isHoed = true;
    }

    private void unsetHoedDirt() {
        color = Color.YELLOW_BG.getColorCode();
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
    public void setOverlayTile(OverlayTile overlayTile) {
        super.setOverlayTile(overlayTile);
        if (growable != null && overlayTile instanceof Growable g) {
            setGrowable(g);
        }
    }
    @Override
    public boolean useTool(Tool tool, Player player) {
        if (overlayTile != null) {
            return overlayTile.useTool(tool, player);
        }
        else {
            switch (tool) {
                case Hoe hoe -> {
                    if (isHoed) {
                        //TODO wrong tool use energy cost
                        return false;
                    }
                    else {
                        //TODO correct tool use energy cost
                        setHoedDirt();
                        return true;
                    }
                }
                case Pickaxe pickaxe -> {
                    if (isHoed) {
                        //TODO correct tool use
                        unsetHoedDirt();
                        return true;
                    }
                    else {
                        //TODO wrong
                        return false;
                    }
                }
                default -> {
                    return false;
                }
            }
        }

    }
}
