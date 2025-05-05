package views;

import controllers.RegisterMenuController;
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
        }else if ((matcher = Regex.LOGIN.getMatcher(input)) != null){
            output = controller.login(matcher, scanner);
        }

        if (output != null)
            System.out.println(output);
    }
}
