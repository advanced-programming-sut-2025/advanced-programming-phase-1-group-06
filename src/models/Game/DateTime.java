package models.Game;



public class DateTime {
    private static final int TIME_START_HOUR = 9;
    private static final int TIME_END_HOUR = 22;
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int season;

    public long getPreciseTime() {
        return ((((season * 28L) + day) * 24) + hour) * 60 + minute;
    }

    public void advanceDay() {
        day++;
        if (day > 28) {
            day = 1;
            month++;
        }
        if (month > season * 3) {
            season++;
        }
        hour = TIME_START_HOUR;
        minute = 0;
    }
}

