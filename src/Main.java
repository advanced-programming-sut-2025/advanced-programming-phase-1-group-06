import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Game.GameMap.MapReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameMap gameMap = new MapReader().loadMap("/home/roham/Desktop/Project fr/src/models/Game/GameMap/Maps/map.json");
        gameMap.print(new Coordinates(0, 0), 80);


    }
}