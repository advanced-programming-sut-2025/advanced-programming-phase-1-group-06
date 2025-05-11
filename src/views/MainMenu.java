package views;


import controllers.MainMenuController;
import models.App;
import models.enums.Menu;
import models.enums.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu implements AppMenu {
    @Override
    public void checkInput(String input, Scanner scanner) {
        Matcher matcher;
        MainMenuController controller = new MainMenuController();
        if ((matcher = Regex.LOGOUT.getMatcher(input)) != null){
            controller.goToMenu("login");
        } else if ((matcher = Regex.GO_TO_MENU.getMatcher(input)) != null){
            controller.goToMenu(matcher.group("menuName"));
        } else if ((matcher = Regex.NEW_GAME.getMatcher(input)) != null){
            controller.newGame(matcher, scanner);
        }
    }
}

