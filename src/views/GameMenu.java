package views;


import controllers.GameMenuController;
import models.Game.Game;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu implements AppMenu {
    @Override
    public void checkInput(String input, Scanner scanner){
        GameMenuController controller = new GameMenuController();
        Matcher matcher;
//        if ((matcher = Regex.harkhari.getMatcher(input)) != null){
//            controller.methodharkhario(input, scanner);
//        }
        return;
    }
}
