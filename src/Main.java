import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Game.GameMap.MapReader;
import views.AppView;

import java.io.IOException;
import java.util.Random;

public class Main {
//    public static void main(String[] args) {
//        AppView.run();
//    }
public static void main(String[] args) throws IOException {
    GameMap gameMap = new MapReader().loadMap("/home/roham/Desktop/Project fr/src/models/Game/GameMap/Maps/map.json");
    MapInitializer m = new MapInitializer(gameMap);
    m.generateObstacles();
    m.getGameMap().print(new Coordinates(0, 0), 30);
}
}