package models.PlantsAndForaging;

public interface Growable {

    void grow();
    void harvest();
    String getType();
    boolean getStatus();
    int currentGrowthDay();
    void handleTime(long currentDay);
}
