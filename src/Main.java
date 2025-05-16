import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Game.GameMap.MapInitializer;
import models.Game.GameMap.MapReader;
import views.AppView;

import java.io.IOException;
import java.util.Random;

public class Main {
//    public static void main(String[] args) {
//        AppView.run();
//    }
public static void main(String[] args) throws IOException {
        GameMap m = new MapReader().loadMap("/home/roham/Desktop/Project fr/src/models/Game/GameMap/Maps/map.json");
        new MapInitializer(m).generateObstacles().getGameMap().print(new Coordinates(0, 0), 80);
         AppView.run();
    }

//    //testing colors
//    public static void main(String[] args) {
//        System.out.println("\033[0;103m" + "stupid nigga");
//        System.out.println("\033[43m" + "smart nigga");
//        System.out.println("\033[1;36m" + "snitch nigga");
//    }
}