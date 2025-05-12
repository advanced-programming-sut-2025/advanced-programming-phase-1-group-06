package models.Tiles.Info;

import models.enums.Color;

public enum BuildingTileInfo {
    HOUSE('H', Color.RED_TEXT.getColorCode()),
    GREENHOUSE('G', Color.BLUE_TEXT.getColorCode());

    public char getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }

    private char symbol;
    private String color;

    BuildingTileInfo(char symbol, String color) {
        this.symbol = symbol;
        this.color = color;
    }
}
