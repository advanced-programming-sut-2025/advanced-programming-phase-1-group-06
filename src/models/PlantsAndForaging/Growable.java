package models.PlantsAndForaging;

public interface Growable {

    void grow();
    void harvest();
    String getType();
    int currentGrowthDay();
    int handleTime(long currentDay);
}
