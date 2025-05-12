package models.Tiles;

import models.enums.Color;
import models.tools.Tool;

public class Water extends Tile{
    {
        super.isBlocked = true;
        color = Color.CYAN_BG.getColorCode();

    }

    @Override
    public boolean useTool(Tool tool) {
        return true;
    }

    public String showTile() {
        return color + Color.WHITE_TEXT.getColorCode() + '~' + Color.RESET.getColorCode();
    }
}
