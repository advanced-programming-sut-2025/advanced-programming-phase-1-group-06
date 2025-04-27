package PlantsAndForaging;

public interface Growable {
    int growthTime = 0;
    boolean isHarvested = false;
    boolean isWatered = false;
    boolean isFertilized = false;
    Crop product = null;

    void grow();
    void harvest();
}
