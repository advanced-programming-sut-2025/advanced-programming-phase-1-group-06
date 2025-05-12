package models.enums;

import views.*;

import java.util.Scanner;

public enum Menu {
    REGISTER(new RegisterMenu(), "register"),
    LOGIN(new LoginMenu(), "login"),
    MAIN(new MainMenu(), "main"),
    PROFILE(new ProfileMenu(), "profile"),
    GAME(new GameMenu(), "game"),
    ;
    private final AppMenu menu;
    private final String name;

    public static Menu getMenuByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equalsIgnoreCase(name)) {
                return menu;
            }
        }
        return null;
    }

    public String getName(){
        return name;
    }

    Menu(AppMenu menu, String name){
        this.menu = menu;
        this.name = name;
    }

    public void checkInput(String input, Scanner scanner){
        this.menu.checkInput(input, scanner);
    }
}
