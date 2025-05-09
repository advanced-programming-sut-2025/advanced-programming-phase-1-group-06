package controllers;

import models.App;
import models.enums.Menu;
import views.LoginMenu;

public class MainMenuController {
    public void goToMenu(String menuName) {
        Menu menu = Menu.getMenuByName(menuName);
        if (menuName.equals("login"))
            App.setLoggedInUser(null);
        App.setCurrentMenu(menu);
        System.out.println("you are now in " + App.getCurrentMenu().getName() + " menu.");
    }
}
