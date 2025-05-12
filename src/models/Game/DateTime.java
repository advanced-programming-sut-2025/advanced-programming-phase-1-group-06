package models.Game;



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

    public void advanceHour(int hour){
        this.hour += hour;
        if (hour >= 22){
            advanceDay();
        }
    }

    public void advanceDay() {
        day++;
        if (day > 28) {
            day = 1;
            season++;
        }
        hour = TIME_START_HOUR;
        minute = 0;
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

    public String showDateTime(){
        return "date: " + showDate() + "time: " + showHour();
    }

}

