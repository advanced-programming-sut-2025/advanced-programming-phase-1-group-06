package models.tools;

import models.Game.Coordinates;
import models.Interfaces.InventoryItem;

public abstract class Tool implements InventoryItem {
    String name;
    protected int energyConsumption;
    protected int level;
    protected boolean isEquipped;
    public abstract void use(Coordinates coordinates);
    public abstract void upgrade();

    public Tool(){}

    public Tool(String name, int level, int energyConsumption){
        this.name = name;
        this.level = 1;
        this.energyConsumption = energyConsumption;
        isEquipped = false;
    }

    public String getName(){
        return name;
    }

    @Override
    public int getAmount(){
        return 1;
    }

}

