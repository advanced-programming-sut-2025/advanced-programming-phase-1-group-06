package models.enums;

import views.*;

import java.util.Scanner;

public enum Menu {
    REGISTER(new RegisterMenu()),
    MAIN(new MainMenu()),
    PROFILE(new ProfileMenu()),
    GAME(new GameMenu()),
    ;
    private final AppMenu menu;
    Menu(AppMenu menu){
        this.menu = menu;
    }

    public void checkInput(String input, Scanner scanner){
        this.menu.checkInput(input, scanner);
    }
}
