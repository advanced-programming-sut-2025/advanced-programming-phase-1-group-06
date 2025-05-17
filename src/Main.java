import models.Game.Coordinates;
import models.Game.Game;
import models.Game.GameMap.GameMap;
import models.Game.GameMap.MapInitializer;
import models.Game.GameMap.MapModifier;
import models.Game.GameMap.MapReader;
import views.AppView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        AppView.run();
    }
}

/*
register -u hassan -p aA#12345 aA#12345 -n hassan -e hassan@gmail.com -g male
pick question -q 4 -a nirvana -c nirvana
go to register menu
register -u roham -p aA#12345 aA#12345 -n roham -e roham@gmail.com -g male
pick question -q 5 -a shotor -c shotor
go to register menu
register -u sara -p aA#12345 aA#12345 -n sara -e sara@gmail.com -g female
pick question -q 5 -a eagle -c eagle
go to login menu
login -u hassan -p aA#12345
game new -u hassan sara roham
game map 1
game map 1
game map 1
forget password -u hassan
nirvana
*/