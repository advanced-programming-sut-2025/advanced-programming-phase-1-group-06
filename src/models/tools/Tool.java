package models.tools;

import models.App;
import models.Game.Coordinates;
import models.Interfaces.InventoryItem;

public abstract class Tool implements InventoryItem {
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

    public String getName(){
        return name;
    }

    @Override
    public int getAmount(){
        return 1;
    }

    public void use(Coordinates coordinates){
        if (App.getTile(coordinates).useTool(this)){
            App.getCurrentPlayer().dimnishEnergy(getEnergyCost());
        } else
            App.getCurrentPlayer().dimnishEnergy(getEnergyCost() - 1);
    }

}

