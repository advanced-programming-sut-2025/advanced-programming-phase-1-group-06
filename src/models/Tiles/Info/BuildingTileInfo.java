package models.Tiles.Info;

import models.enums.Color;

public enum BuildingTileInfo {
    HOUSE('H', Color.RED_TEXT.getColorCode(), false),
    WALL('|', Color.BLACK_TEXT.getColorCode(), true),
    FLOOR('-', Color.BLACK_TEXT.getColorCode(), true),
    DOOR('=', Color.BLUE_TEXT.getColorCode(), false),
    House(' ', Color.RED_BG.getColorCode(), false);
//    GREENHOUSE('G', Color.BLUE_TEXT.getColorCode());

    public char getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    private char symbol;
    private String color;
    private boolean isBlocked;

    BuildingTileInfo(char symbol, String color, boolean isBlocked) {
        this.symbol = symbol;
        this.color = color;
        this.isBlocked = isBlocked;
    }
}
