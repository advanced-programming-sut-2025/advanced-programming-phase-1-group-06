package models.PlantsAndForaging;

import models.Player.Player;

public interface Growable {

    void grow(long currentDay);
    boolean harvest(Player player);
    String getType();
    boolean getStatus();
    int currentGrowthDay();
    void handleTime(long currentDay);
}
