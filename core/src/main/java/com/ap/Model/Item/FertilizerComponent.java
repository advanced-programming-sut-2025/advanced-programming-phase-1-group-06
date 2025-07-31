package com.ap.Model.Item;

import com.ap.Model.Component;

public class FertilizerComponent extends Component {
    private int growthSpeedBonus;
    private int qualityBonus;
    private int waterRetentionChance;

    public FertilizerComponent(int growthSpeedBonus, int qualityBonus, int waterRetentionChance) {
        this.growthSpeedBonus = growthSpeedBonus;
        this.qualityBonus = qualityBonus;
        this.waterRetentionChance = waterRetentionChance;

    }
    // Getters
    public int getGrowthSpeedBonus() { return growthSpeedBonus; }
    public int getQualityBonus() { return qualityBonus; }
    public int getWaterRetention() { return waterRetentionChance; }
}
