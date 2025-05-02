package models.tools;

import models.Game.Coordinates;

public abstract class Tool {
    private int energyConsumption;
    private int level;
    private boolean isEquipped;

    public abstract void use(Coordinates coordinates);
    public abstract void upgrade();
}

