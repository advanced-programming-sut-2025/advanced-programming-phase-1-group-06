package views;

import models.App;
import models.enums.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;

public class AppView {
    public static void run(){
        System.out.println("use @generate-password instead of password for generating passwords.");
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            if ((matcher = Regex.EXIT.getMatcher(input)) != null){
                App.exit();
                return;
            }
            if ((matcher = Regex.SHOW_CURRENT_MENU.getMatcher(input)) != null){
                System.out.println(App.getCurrentMenu().getName());
            }
            App.getCurrentMenu().checkInput(input, scanner);
        }
    }
}
