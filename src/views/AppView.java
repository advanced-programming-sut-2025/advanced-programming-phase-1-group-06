package views;

import models.App;
import models.enums.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;

public class AppView {
    public static void run(){
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            if ((matcher = Regex.EXIT.getMatcher(input)) != null){
                App.exit();
                return;
            }
            App.getCurrentMenu().checkInput(input, scanner);
        }
    }
}
