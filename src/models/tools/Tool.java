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
    public abstract boolean useTool(Tool tool, Player player);
    public void use(Coordinates coordinates, Player player){
        if (App.getTile(coordinates, player).useTool(this)){
            App.getCurrentPlayer().dimnishEnergy(getEnergyCost());
        } else
            App.getCurrentPlayer().dimnishEnergy(getEnergyCost() - 1);
    }

}

