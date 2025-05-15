package models.Tiles.Info;

import models.Tiles.Flooring;
import models.enums.Color;

public enum FlooringInfo {
    GRASS(Color.GREEN_BG.getColorCode()),
    STONE(Color.BLACK_BG.getColorCode()),
    Stone(Color.BLACK_BG.getColorCode()),
    grass(Color.GREEN_BG.getColorCode());
    public String getColor() {
        return color;
    }

    private String color;

    FlooringInfo(String color) {
        this.color = color;
    }


}
