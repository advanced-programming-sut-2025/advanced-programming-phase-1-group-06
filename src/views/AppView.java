package views;

import models.App;
import models.enums.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;

public class AppView {
    public void run(){
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (true){
            if ((matcher = Regex.EXIT.getMatcher(input)) != null){
                App.exit();
                return;
            }
            App.getCurrentMenu().checkInput(input, scanner);
        }
    }
}
