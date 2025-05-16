package models.tools;

import models.App;
import models.Game.Coordinates;
import models.ItemFaces.InventoryItem;
import models.Player.Player;

public abstract class Tool extends InventoryItem {
    String name;

    public int getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(int energyCost) {
        this.energyCost = energyCost;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    protected int energyCost;
    protected int level;
    protected boolean isEquipped;
    public abstract void upgrade();
    public Tool(){}

    public Tool(String name, int level, int energyCost){
        this.name = name;
        this.level = 1;
        this.energyCost = energyCost;
        isEquipped = false;
    }
    public abstract int getSuccessfulEnergyCost();
    public abstract int getUnsuccessfulEnergyCost();
    public String getName(){
        return name;
    }

    @Override
    public int getAmount(){
        return 1;
    }

    @Override
    public String toString(){
        String levelName = switch (level){
            case 0 -> "default";
            case 1 -> "copper";
            case 2 -> "iron";
            case 3 -> "gold";
            case 4 -> "iridium";
            default -> "default";
        };
        return (levelName + " " + name);
    }
}

