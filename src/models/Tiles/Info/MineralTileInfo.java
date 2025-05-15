package models.Tiles.Info;

import models.PlantsAndForaging.Info.MineralsInfo;
import models.enums.Color;

import java.util.Arrays;
import java.util.Random;

public enum MineralTileInfo {

    ROCK(Color.WHITE_TEXT.getColorCode(), 'o', 1, MineralsInfo.ROCK, 0),
    COPPER(Color.RED_TEXT.getColorCode(), '0', 1, MineralsInfo.COPPER, 100),
    IRON(Color.WHITE_TEXT.getColorCode(), '0', 2, MineralsInfo.IRON, 60),
    GOLD(Color.YELLOW_TEXT.getColorCode(), '0', 3, MineralsInfo.GOLD, 30),
    IRIDIUM(Color.MAGENTA_TEXT.getColorCode(), '0', 4, MineralsInfo.IRIDIUM, 10);

    public static MineralTileInfo getRandomly() {
        return null;
    }

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
    private int chance;
    MineralTileInfo(String color, char symbol, int hardness, MineralsInfo mineralsInfo, int chance) {
        this.color = color;
        this.symbol = symbol;
        this.hardness = hardness;
        this.mineralsInfo = mineralsInfo;
        this.chance = chance;
    }

}
