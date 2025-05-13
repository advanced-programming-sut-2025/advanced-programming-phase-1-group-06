package models.PlantsAndForaging;

import models.Player.Player;

public interface Growable {

    void grow();
    boolean harvest(Player player);

    String getType();
    int currentGrowthDay();
}
