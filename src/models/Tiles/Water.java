package models.Tiles;

import models.enums.Color;

public class Water extends Tile{
    {
        super.isBlocked = true;
        color = Color.CYAN_BG.getColorCode();

    }

    public String showTile() {
        return color + Color.WHITE_TEXT.getColorCode() + '~' + Color.RESET.getColorCode();
    }
}
