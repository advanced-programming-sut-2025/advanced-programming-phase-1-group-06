package models.Game.GameMap;

import models.Game.Coordinates;
import models.Tiles.Info.BuildingTileInfo;
import models.Tiles.OverlayTiles.BuildingTile;
import models.buildings.Building;
import models.shops.*;

public class MapModifier {
    GameMap gameMap;

    public MapModifier(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void makeBuilding(Coordinates topLeft, int length, int width, Building building) {
        int topx = topLeft.x();
        int topy = topLeft.y();

        for (int y = topy; y < topy + width; y++) {
            gameMap.getTileAt(topx, y).setOverlayTile(new BuildingTile(BuildingTileInfo.WALL, gameMap,
                    new Coordinates(topx, y), building));
            gameMap.getTileAt(topx + length, y).setOverlayTile(new BuildingTile(BuildingTileInfo.WALL,
                    gameMap, new Coordinates(topx + length, y), building));
        }
        for (int x = topx; x < topx + length; x++) {
            gameMap.getTileAt(x, topy).setOverlayTile(new BuildingTile(BuildingTileInfo.FLOOR, gameMap,
                    new Coordinates(x, topy), building));
            gameMap.getTileAt(x, topy + width).setOverlayTile(new BuildingTile(BuildingTileInfo.FLOOR, gameMap,
                    new Coordinates(x, topy + width), building));
        }


        gameMap.getTileAt(topx + length/2, topy + width).setOverlayTile(new BuildingTile(BuildingTileInfo.DOOR,
                gameMap, new Coordinates(topx + length/2, topy + width), building));

        for (int y = topy + 1; y < topy + width; y++) {
            for (int x = topx + 1; x < topx + length ; x++) {
                //TODO BuildingTileInfo for house and other buildings
                gameMap.getTileAt(x, y).setOverlayTile(new BuildingTile(BuildingTileInfo.House, gameMap,
                        new Coordinates(x, y), building));
            }
        }
    }

    public GameMap makeStores() {
        makeBuilding(new Coordinates(4, 4), 5, 4, new Blacksmith());
        makeBuilding(new Coordinates(14, 4), 5, 4, new GeneralStore());
        makeBuilding(new Coordinates(24, 4), 5, 4, new Carpenter());
        makeBuilding(new Coordinates(4, 14), 5, 4, new FishStore());
        makeBuilding(new Coordinates(14, 14), 5, 4, new Saloon());
        makeBuilding(new Coordinates(24, 14), 5, 4, new JojoMart());
        makeBuilding(new Coordinates(34, 14), 5, 4, new Saloon());
        return gameMap;
    }
}


