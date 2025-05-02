package models.tools;

import models.Game.Coordinates;

public abstract class Tool {
    private int energyConsumption;
    private int level;
    private boolean isEquipped;
    private ToolType toolType;
    public abstract void use(Coordinates coordinates);
    public abstract void upgrade();
    public ToolType getToolType(){
        return toolType;
    }

}

