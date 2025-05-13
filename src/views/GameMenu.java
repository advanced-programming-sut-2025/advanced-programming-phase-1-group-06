package views;


import controllers.GameMenuController;
import models.App;
import models.Game.Game;
import models.Player.Player;
import models.enums.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu implements AppMenu {
    @Override
    public void checkInput(String input, Scanner scanner){
        GameMenuController controller = new GameMenuController();
        Matcher matcher;
        Game game = App.getGame();
        Player currentPlayer = game.getCurrentPlayer();
        if ((matcher = Regex.NEXT_TURN.getMatcher(input)) != null){
            game.nextTurn();
            controller.nextTurn();
        } else if ((matcher = Regex.TIME.getMatcher(input)) != null){
            System.out.println(game.getDateTime().showHour());
        } else if ((matcher = Regex.DATE.getMatcher(input)) != null){
            System.out.println(game.getDateTime().showDate());
        } else if ((matcher = Regex.DATETIME.getMatcher(input)) != null){
            System.out.println(game.getDateTime().showDateTime());
        } else if ((matcher = Regex.DAY_OF_WEEK.getMatcher(input)) != null){
            System.out.println(game.getDateTime().dayOfTheWeek());
        } else if ((matcher = Regex.SEASON.getMatcher(input)) != null){
            System.out.println(game.getDateTime().getSeason());
        } else if ((matcher = Regex.WEATHER.getMatcher(input)) != null){
            System.out.println(game.getWeather().getName());
        } else if ((matcher = Regex.WEATHER_FORECAST.getMatcher(input)) != null){
            System.out.println(game.getWeather().getName());
        } else if ((matcher = Regex.ENERGY_SHOW.getMatcher(input)) != null){
            System.out.println(currentPlayer.getEnergy());
        } else if ((matcher = Regex.ENERGY_SET.getMatcher(input)) != null){
            currentPlayer.setEnergy(Integer.parseInt(matcher.group("value")));
        } else if ((matcher = Regex.ENERGY_UNLIMITED.getMatcher(input)) != null){
            currentPlayer.setEnergy(Integer.MAX_VALUE);
        } else if ((matcher = Regex.INVENTORY_SHOW.getMatcher(input)) != null){
//            Roham do it later
        } else if ((matcher = Regex.INVENTORY_TRASH.getMatcher(input)) != null){
//            Roham
        } else if ((matcher = Regex.TOOLS_EQUIP.getMatcher(input)) != null){
            controller.equipTool(matcher);
        } else if ((matcher = Regex.TOOLS_USE.getMatcher(input)) != null){
            controller.useTool(matcher);
        }


        return;
    }

}
