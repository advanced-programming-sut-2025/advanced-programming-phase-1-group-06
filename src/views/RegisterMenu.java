package views;

import controllers.RegisterMenuController;
import models.App;
import models.enums.Menu;
import models.enums.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;

public class RegisterMenu implements AppMenu {

    @Override
    public void checkInput(String input, Scanner scanner) {
        Matcher matcher;
        String output = "";
        RegisterMenuController controller = new RegisterMenuController();
        if ((matcher = Regex.REGISTER.getMatcher(input)) != null){
            output = controller.register(matcher, scanner);
        } else if ((matcher = Regex.GO_TO_LOGIN_MENU.getMatcher(input)) != null){
            App.setCurrentMenu(Menu.LOGIN);
            System.out.println("you are now in login menu");
        } else
            System.out.println("wtf (register menu)");
        if (output != null)
            System.out.println(output);
    }
}
