package views;

import controllers.ProfileMenuController;
import models.App;
import models.enums.Menu;
import models.enums.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;

public class ProfileMenu implements AppMenu{
    @Override
    public void checkInput(String input, Scanner scanner) {
        Matcher matcher;
        ProfileMenuController controller = new ProfileMenuController();
        if ((matcher = Regex.CHANGE_USERNAME.getMatcher(input)) != null){
            System.out.println(controller.changeUsername(matcher, scanner));
        } else if((matcher = Regex.CHANGE_NICKNAME.getMatcher(input)) != null){
            System.out.println(controller.changeNickname(matcher, scanner));
        } else if ((matcher = Regex.CHANGE_EMAIL.getMatcher(input)) != null){
            System.out.println(controller.changeEmail(matcher, scanner));
        } else if ((matcher = Regex.CHANGE_PASSSWORD.getMatcher(input)) != null){
            System.out.println(controller.changePassword(matcher, scanner));
        } else if ((matcher = Regex.USER_INFO.getMatcher(input)) != null){
            System.out.println(controller.showUserInfo());
        } else if ((matcher = Regex.BACK.getMatcher(input)) != null){
            App.setCurrentMenu(Menu.MAIN);
            System.out.println("you are now in main menu");
        }
    }
}
