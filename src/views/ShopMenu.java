package views;

import models.App;
import models.shops.Shop;

import java.util.Scanner;

public class ShopMenu implements AppMenu{
    Shop shop;

    ShopMenu(Shop shop){
        this.shop = shop;
    }

    @Override
    public void checkInput(String input, Scanner scanner) {
        input = scanner.nextLine();
        shop.checkCommand(input, App.getCurrentPlayer());
    }
}
