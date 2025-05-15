package models.Game;


import models.App;
import models.ItemFaces.InventoryItem;
import models.enums.WeatherType;

import java.util.Random;

public class Weather {
    private final double energyConsumptionRate;
    private final boolean isWatery;
    private final String name;


    public String getName() {
        return name;
    }

    public boolean isWatery() {
        return isWatery;
    }

    public double getEnergyConsumptionRate() {
        return energyConsumptionRate;
    }


    public Weather(String name, boolean isWatery, double energyConsumptionRate){
        this.name = name;
        this.isWatery = isWatery;
        this.energyConsumptionRate = energyConsumptionRate;
    }

    public void setEffects() {
    }

    public void lightning(Coordinates coordiante){
//        TODO implement lightning. or don't doesn't really matter. we're screwed either way.
    }

    public static Weather weatherRandomizer(){
        int season = App.getGame().getDateTime().getSeasonNumber();
        int sunny, rainy, stormy, snowy;
        switch (season) {
            case 1:
                snowy = 0;
                sunny = 60;
                rainy = 85;
                stormy = 100;
               break;
            case 2:
                snowy = 0;
                sunny = 80;
                rainy = 90;
                stormy = 100;
                break;
            case 3:
                snowy = 0;
                sunny = 50;
                rainy = 70;
                stormy = 100;
                break;
            case 4:
                snowy = 40;
                sunny = 50;
                rainy = 80;
                stormy = 100;
                break;
            default:
                snowy = 25;
                sunny = 50;
                rainy = 75;
                stormy = 100;
        }
        Random r = new Random();
        int randomNumber = r.nextInt(100) + 1;
        if (randomNumber < snowy)
            return WeatherType.SNOWY.getWeather();
        else if (randomNumber < sunny)
            return WeatherType.SUNNY.getWeather();
        else if (randomNumber < rainy)
            return WeatherType.RAINY.getWeather();
        else if (randomNumber < stormy)
            return WeatherType.STORMY.getWeather();
        return WeatherType.SUNNY.getWeather();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Weather other = (Weather) obj;
        // Compare only by name, ignoring amount
        return getName().equals(other.getName());
    }


}
