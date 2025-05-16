package views;

import controllers.LoginMenuController;
import controllers.RegisterMenuController;
import models.App;
import models.enums.Menu;
import models.enums.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;

public class LoginMenu implements AppMenu {

    @Override
    public void checkInput(String input, Scanner scanner) {
        Matcher matcher;
        String output = "";
        LoginMenuController controller = new LoginMenuController();
        if ((matcher = Regex.LOGIN.getMatcher(input)) != null){
            output = controller.login(matcher, scanner);
        } else if ((matcher = Regex.FORGET.getMatcher(input)) != null){
            output = controller.forgotPassword(matcher, scanner);
        } else if ((matcher = Regex.GO_TO_REGISTER_MENU.getMatcher(input)) != null){
            App.setCurrentMenu(Menu.REGISTER);
            System.out.println("you are now in register menu");
        }
        else
            System.out.println("wtf");

        if (!output.isEmpty())
            System.out.println(output);
    }
}
