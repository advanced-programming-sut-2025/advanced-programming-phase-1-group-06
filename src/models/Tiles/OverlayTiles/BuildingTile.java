package models.Tiles.OverlayTiles;


import models.Tiles.Info.BuildingTileInfo;
import models.enums.Color;

public class BuildingTile extends OverlayTile {
    public BuildingTileInfo getBuildingTileInfo() {
        return buildingTileInfo;
    }

    BuildingTileInfo buildingTileInfo;

    public BuildingTile(BuildingTileInfo buildingTileInfo) {
        super(buildingTileInfo.getSymbol(), buildingTileInfo.getColor(), Integer.MAX_VALUE, true);
        this.buildingTileInfo = buildingTileInfo;
    }





    @Override
    public void useTool() {

    }
}
