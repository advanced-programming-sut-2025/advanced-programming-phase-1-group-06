package models.Tiles.Info;

import models.PlantsAndForaging.Info.MineralsInfo;
import models.enums.Color;

public enum MineralTileInfo {

    ROCK(Color.WHITE_TEXT.getColorCode(), '0', 1, MineralsInfo.ROCK);

    public String getColor() {
        return color;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getHardness() {
        return hardness;
    }

    public MineralsInfo getMineralsInfo() {
        return mineralsInfo;
    }

    private String color;
    private char symbol;
    private int hardness;
    private MineralsInfo mineralsInfo;
    MineralTileInfo(String color, char symbol, int hardness, MineralsInfo mineralsInfo) {
        this.color = color;
        this.symbol = symbol;
        this.hardness = hardness;
        this.mineralsInfo = mineralsInfo;

    }

}
