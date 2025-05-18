package models.Game;


import models.App;

public class DateTime {
    private static final int TIME_START_HOUR = 9;
    private static final int TIME_END_HOUR = 22;

    private int minute;
    private int hour;
    private int day;
    private int season; // 1: Spring 2: Summer 3: Fall 4: Winter

    public DateTime(){
        minute = 0;
        hour = 9;
        day = 1;
        season = 1;
    }

    public DateTime(int minute, int hour, int day, int season) {
        this.minute = minute;
        this.hour = hour;
        this.day = day;
        this.season = season;
    }


    public long getPreciseTime() {
        return ((((season * 28L) + day) * 24) + hour) * 60 + minute;
    }

    public long getPreciseDay(){return getPreciseTime() / 24;}


    public void advanceHour(int amount){
        this.hour += amount;
        if (hour > 24){
            advanceDay(hour / 24);
            hour -= ((int)(hour / 24)) * 24;
        }
        if (hour >= 22){
            advanceDay(1);
            hour = 9;
        }
        if (hour < 9){
            hour = 9;
        }
        App.getGame().advanceHour();
    }

    public void advanceDay(int amount) {
        // TODO add foraging everyday
        day += amount;
        if (day > 28) {
            season += (day / 28) % 4;
            day = day % 28;
        }
        hour = TIME_START_HOUR;
        minute = 0;
        App.getGame().adavanceDay();
    }

    public int showHour(){
        return hour;
    }

    public int getSeasonNumber(){
        return season;
    }

    public String getSeason(){
        return switch (season){
            case 1 -> "Spring";
            case 2 -> "Summer";
            case 3 -> "Fall";
            case 4 -> "Winter";
            default -> "idk";
        };
    }

    public String showDate(){
        String seasonName = getSeason();
        return switch (day % 10){
          case 1 -> day + "st of " + seasonName;
          case 2 -> day + "nd of " + seasonName;
          case 3 -> day + "rd of " + seasonName;
          default -> day + "th of " + seasonName;
        };
    }

    public String dayOfTheWeek(){
        return switch (day % 7){
            case 0 -> "saturday";
            case 1 -> "sunday";
            case 2 -> "monday";
            case 3 -> "tuesday";
            case 4 -> "wednesday";
            case 5 -> "thursday";
            case 6 -> "friday";
            default -> "idk";
        };
    }
    public String getFormattedDateTime() {
        // Calculate year (starting from 2025)
        int year = 2025 + ((season - 1) / 4);

        // Calculate month (1-12)
        int month = ((season - 1) % 4) * 3 + day / 10 + 1;

        // Ensure month stays within 1-12 range
        if (month > 12) {
            month = 12;
        }

        // Format components with leading zeros where needed
        String formattedMonth = String.format("%02d", month);
        String formattedDay = String.format("%02d", day);
        String formattedHour = String.format("%02d", hour);
        String formattedMinute = String.format("%02d", minute);
        String formattedSecond = "00"; // Since your game doesn't track seconds

        // Return in YYYY-MM-DD HH:MM:SS format
        return String.format("%d-%s-%s %s:%s:%s",
                year,
                formattedMonth,
                formattedDay,
                formattedHour,
                formattedMinute,
                formattedSecond);
    }

    public String showDateTime(){
        return "date: " + showDate() + "time: " + showHour();
    }

}

