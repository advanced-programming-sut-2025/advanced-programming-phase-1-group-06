package models.buildings;

import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Tiles.OverlayTiles.OverlayTile;

import java.util.ArrayList;

public class Building {
    protected OverlayTile tile;
    protected String name;
    protected Coordinates balaChap;
    protected Coordinates doorCoordinates;
    protected GameMap insideBuilding;

    public Building(Coordinates balaChap, Coordinates doorCoordinates) {
        this.balaChap = balaChap;
        this.doorCoordinates = doorCoordinates;

    }
}
