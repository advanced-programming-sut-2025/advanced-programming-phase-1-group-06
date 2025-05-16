package models.Tiles.OverlayTiles;


import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.Tiles.Info.BuildingTileInfo;
import models.buildings.Building;
import models.enums.Color;
import models.tools.Tool;

public class BuildingTile extends OverlayTile {
    public BuildingTileInfo getBuildingTileInfo() {
        return buildingTileInfo;
    }

    BuildingTileInfo buildingTileInfo;
    Building building;
    public BuildingTile(BuildingTileInfo buildingTileInfo, GameMap gameMap, Coordinates coordinates, Building building) {
        super(buildingTileInfo.getSymbol(), buildingTileInfo.getColor(), 0, buildingTileInfo.isBlocked(),
                gameMap, coordinates);
        this.buildingTileInfo = buildingTileInfo;
        this.building = building;
    }


    @Override
    public boolean useTool(Tool tool, Player player) {
        return false;
    }
}
