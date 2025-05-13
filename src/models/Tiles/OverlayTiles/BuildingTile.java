package models.Tiles.OverlayTiles;


import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.Tiles.Info.BuildingTileInfo;
import models.enums.Color;
import models.tools.Tool;

public class BuildingTile extends OverlayTile {
    public BuildingTileInfo getBuildingTileInfo() {
        return buildingTileInfo;
    }

    BuildingTileInfo buildingTileInfo;

    public BuildingTile(BuildingTileInfo buildingTileInfo, GameMap gameMap, Coordinates coordinates) {
        super(buildingTileInfo.getSymbol(), buildingTileInfo.getColor(), Integer.MAX_VALUE, true,
                gameMap, coordinates);
        this.buildingTileInfo = buildingTileInfo;
    }

    @Override
    public boolean useTool(Tool tool, Player player) {
        return false;
    }
}
