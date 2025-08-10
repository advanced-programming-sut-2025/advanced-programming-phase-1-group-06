package com.ap.Model;


import com.ap.Main;
import com.ap.Model.Enum.WeatherType;

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


    public static Weather weatherRandomizer(){
        String season = Main.getInstance().getClock().getCurrentSeason();
        int sunny, rainy, stormy, snowy;
        switch (season) {
            case "Spring":
                snowy = 0;
                sunny = 60;
                rainy = 85;
                stormy = 100;
                break;
            case "Summer":
                snowy = 0;
                sunny = 80;
                rainy = 90;
                stormy = 100;
                break;
            case "Fall":
                snowy = 0;
                sunny = 50;
                rainy = 70;
                stormy = 100;
                break;
            case "Winter":
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
