package models.tools;

import models.App;
import models.Game.Coordinates;
import models.Game.Game;
import models.Game.GameMap.GameMap;

public class Pickaxe extends Tool {

    int damage;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Pickaxe(String name, int level, int energyConsumption){
        super(name, level, energyConsumption);
    }

    @Override
    public int getSuccessfulEnergyCost() {
        return 5 - level;
    }

    @Override
    public int getUnsuccessfulEnergyCost() {
        return getSuccessfulEnergyCost() - 1;
    }

    public void mine() {
        // Implement mining logic
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade pickaxe
    }
}
