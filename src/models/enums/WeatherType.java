package models.enums;

import models.Game.Weather;

public enum WeatherType {
    SUNNY(new Weather("sunny", false, 1)),
    RAINY(new Weather("rainy", true, 1.5)),
    STORMY(new Weather("stormy" ,true, 1.5)),
    SNOWY(new Weather("snowy", false, 2)),
    ;


    Weather weather;

    WeatherType(Weather weather){
        this.weather = weather;
    }

    public Weather getWeather(){
        return weather;
    }

    public static Weather getWeatherByName(String weatherName){
        return switch (weatherName){
            case "sunny" -> SUNNY.getWeather();
            case "rainy" -> RAINY.getWeather();
            case "stormy" -> STORMY.getWeather();
            case "snowy" -> SNOWY.getWeather();
            default -> SUNNY.getWeather();
        };
    }
}
