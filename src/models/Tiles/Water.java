package models.Tiles;

import models.Player.Player;
import models.enums.Color;
import models.tools.FishingRod;
import models.tools.Tool;
import models.tools.WateringCan;

public class Water extends Tile{
    {
        super.isBlocked = true;
        color = Color.CYAN_BG.getColorCode();

    }

    @Override
    public boolean useTool(Tool tool, Player player) {
        switch (tool) {
            case FishingRod fishingRod -> {
                //catch da fish
                return true;
            }
            case WateringCan wateringCan -> {
                wateringCan.fill();
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public String showTile() {
        return color + Color.WHITE_TEXT.getColorCode() + '~' + Color.RESET.getColorCode();
    }
}
