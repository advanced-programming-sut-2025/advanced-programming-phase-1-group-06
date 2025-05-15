package views;


import controllers.GameMenuController;
import models.App;
import models.Game.Game;
import models.Player.Player;
import models.enums.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu implements AppMenu {
    @Override
    public void checkInput(String input, Scanner scanner){
        GameMenuController controller = new GameMenuController();
        Matcher matcher;
        Game game = App.getGame();
        Player currentPlayer = game.getCurrentPlayer();
        if ((matcher = Regex.NEXT_TURN.getMatcher(input)) != null){
            game.nextTurn();
            controller.nextTurn();
        } else if ((matcher = Regex.TIME.getMatcher(input)) != null){

            System.out.println(game.getDateTime().showHour());
        } else if ((matcher = Regex.DATE.getMatcher(input)) != null){
            System.out.println(game.getDateTime().showDate());
        } else if ((matcher = Regex.DATETIME.getMatcher(input)) != null){
            System.out.println(game.getDateTime().showDateTime());
        } else if ((matcher = Regex.DAY_OF_WEEK.getMatcher(input)) != null){
            System.out.println(game.getDateTime().dayOfTheWeek());
        } else if ((matcher = Regex.SEASON.getMatcher(input)) != null){
            System.out.println(game.getDateTime().getSeason());
        } else if ((matcher = Regex.WEATHER.getMatcher(input)) != null){
            System.out.println(game.getWeather().getName());
        } else if ((matcher = Regex.WEATHER_FORECAST.getMatcher(input)) != null){
            System.out.println(game.getWeather().getName());
        } else if ((matcher = Regex.ENERGY_SHOW.getMatcher(input)) != null){
            System.out.println(currentPlayer.getEnergy());
        } else if ((matcher = Regex.ENERGY_SET.getMatcher(input)) != null){
            currentPlayer.setEnergy(Integer.parseInt(matcher.group("value")));
        } else if ((matcher = Regex.ENERGY_UNLIMITED.getMatcher(input)) != null){
            currentPlayer.setEnergy(Integer.MAX_VALUE);
        } else if ((matcher = Regex.INVENTORY_SHOW.getMatcher(input)) != null){
            // TODO
        } else if ((matcher = Regex.INVENTORY_TRASH.getMatcher(input)) != null){
            // TODO
        } else if ((matcher = Regex.TOOLS_EQUIP.getMatcher(input)) != null){
            String toolName = matcher.group("toolName");
            controller.equipTool(toolName);
        } else if ((matcher = Regex.TOOLS_USE.getMatcher(input)) != null){
            String direction = matcher.group("direction");
            controller.useTool(direction);
        } else if ((matcher = Regex.GREENHOUSE_BUILD.getMatcher(input)) != null){
            controller.buildGreenhouse();
        } else if ((matcher = Regex.ANSWER.getMatcher(input)) != null) {
            controller.answerQuestion(matcher.group("answer"));
        } else if ((matcher = Regex.CHEAT_ADVANCE_TIME.getMatcher(input)) != null) {
            controller.advanceTime(Integer.parseInt(matcher.group("hours")));
        } else if ((matcher = Regex.CHEAT_ADVANCE_DATE.getMatcher(input)) != null) {
            controller.advanceDate(Integer.parseInt(matcher.group("days")));
        } else if ((matcher = Regex.WEATHER_SET.getMatcher(input)) != null) {
            controller.setWeatherType(matcher.group("type"));
        } else if ((matcher = Regex.CHEAT_THOR.getMatcher(input)) != null) {
            int x = Integer.parseInt(matcher.group("x"));
            int y = Integer.parseInt(matcher.group("y"));
            controller.callThor(x, y);
        } else if ((matcher = Regex.GREENHOUSE_BUILD.getMatcher(input)) != null) {
            controller.buildGreenhouse();
        } else if ((matcher = Regex.GREENHOUSE_BUILDCHEAT.getMatcher(input)) != null) {
            controller.buildGreenhouseCheat();
        } else if ((matcher = Regex.WALK.getMatcher(input)) != null) {
            int x = Integer.parseInt(matcher.group("x"));
            int y = Integer.parseInt(matcher.group("y"));
            controller.walkTo(x, y);
        } else if ((matcher = Regex.PRINT_MAP.getMatcher(input)) != null) {
            int x = Integer.parseInt(matcher.group("x"));
            int y = Integer.parseInt(matcher.group("y"));
            int size = Integer.parseInt(matcher.group("size"));
            controller.printMapAt(x, y, size);
        } else if ((matcher = Regex.HELP_READING_MAP.getMatcher(input)) != null) {
            controller.showMapHelp();
        } else if ((matcher = Regex.TOOLS_SHOW_CURRENT.getMatcher(input)) != null) {
            controller.showCurrentTool();
        } else if ((matcher = Regex.TOOLS_SHOW_AVAILABLE.getMatcher(input)) != null) {
            controller.showAvailableTools();
        } else if ((matcher = Regex.TOOLS_UPGRADE.getMatcher(input)) != null) {
            controller.upgradeTool(matcher.group("tool"));
        } else if ((matcher = Regex.GIFT.getMatcher(input)) != null) {
            String username = matcher.group("username");
            String item = matcher.group("item");
            int amount = Integer.parseInt(matcher.group("amount"));
            controller.sendGift(username, item, amount);
        } else if ((matcher = Regex.GIFT_LIST.getMatcher(input)) != null) {
            controller.showGiftList();
        } else if ((matcher = Regex.GIFT_RATE.getMatcher(input)) != null) {
            int giftNumber = Integer.parseInt(matcher.group("gift_number"));
            int rate = Integer.parseInt(matcher.group("rate"));
            controller.rateGift(giftNumber, rate);
        } else if ((matcher = Regex.GIFT_HISTORY.getMatcher(input)) != null) {
            controller.showGiftHistory(matcher.group("username"));
        } else if ((matcher = Regex.HUG.getMatcher(input)) != null) {
            controller.hugUser(matcher.group("username"));
        } else if ((matcher = Regex.FLOWER.getMatcher(input)) != null) {
            controller.sendFlower(matcher.group("username"));
        } else if ((matcher = Regex.SHOW_ALL_PRODUCTS.getMatcher(input)) != null) {
            controller.showAllProducts();
        } else if ((matcher = Regex.SHOW_AVAILABLE_PRODUCTS.getMatcher(input)) != null) {
            controller.showAvailableProducts();
        } else if ((matcher = Regex.PURCHASE.getMatcher(input)) != null) {
            String product = matcher.group("product");
            int count = Integer.parseInt(matcher.group("count"));
            controller.purchaseProduct(product, count);
        }



        return;
    }

}
