package models.Game;

public class DateTime {
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int season;

    public long getPreciseTime() {
        return ((((season * 28L) + day) * 24) + hour) * 60 + minute;
    }

    public void advanceTime() {
    }
}

