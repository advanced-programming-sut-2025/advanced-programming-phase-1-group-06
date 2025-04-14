package models.tools;

import models.Coordinate;

public abstract class Tool {
    private int energyConsumption;
    private int level;
    private boolean isEquipped;

    public abstract void use(Coordinate coordinate);
    public abstract void upgrade();
}

