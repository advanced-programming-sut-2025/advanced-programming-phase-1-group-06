package com.ap.Model.Overlay;

import com.ap.Model.Component;
import com.ap.Model.Season;

import java.util.List;

public class PlantedCropComponent extends Component {
    private String harvestedCropId;
    private List<Integer> growthStages;
    private int totalHarvestTime;
    private boolean oneTime;
    private int regrowthTime;
    private List<Season> seasons;
    private String atlasPath;
    private String texturePath;

    public PlantedCropComponent(String harvestedCropId, List<Integer> growthStages,
                               int totalHarvestTime, boolean oneTime, int regrowthTime,
                               List<Season> seasons) {
        this.harvestedCropId = harvestedCropId;
        this.growthStages = growthStages;
        this.totalHarvestTime = totalHarvestTime;
        this.oneTime = oneTime;
        this.regrowthTime = regrowthTime;
        this.seasons = seasons;
    }

    // Getters
    public String getHarvestedCropId() { return harvestedCropId; }
    public List<Integer> getGrowthStages() { return growthStages; }
    public int getTotalHarvestTime() { return totalHarvestTime; }
    public boolean isOneTime() { return oneTime; }
    public int getRegrowthTime() { return regrowthTime; }
    public List<Season> getSeasons() { return seasons; }
}
