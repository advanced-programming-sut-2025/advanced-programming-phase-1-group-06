package com.ap.View;

import com.ap.Main;
import com.ap.Model.Weather;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Clock extends Group {
    private static final float SCALE = 2.0f; // Adjust this value to change overall size
    //    private TextureAtlas weatherAtlas = new TextureAtlas("Clock/weather.atlas");
//    private TextureAtlas seasonsAtlas = new TextureAtlas("Clock/seasons.atlas");
    private TextureRegion clockBase = new TextureRegion(new Texture("Clock/clock_base.png"));
    private TextureRegion clockHand = new TextureRegion(new Texture("Clock/clock_hand.png"));
    private TextureRegion sunny = new TextureRegion(new Texture("Clock/sunny.png"));
    private TextureRegion rainy = new TextureRegion(new Texture("Clock/rainy.png"));
    private TextureRegion snowy = new TextureRegion(new Texture("Clock/snowy.png"));
    private TextureRegion stormy = new TextureRegion(new Texture("Clock/stormy.png"));
    private TextureRegion fall = new TextureRegion(new Texture("Clock/fall.png"));
    private TextureRegion winter = new TextureRegion(new Texture("Clock/winter.png"));
    private TextureRegion spring = new TextureRegion(new Texture("Clock/spring.png"));
    private TextureRegion summer = new TextureRegion(new Texture("Clock/summer.png"));
    private TextureRegion seasonIcon;
    private TextureRegion weatherIcon;

    private Label dayLabel;
    private Label timeLabel;
    private Label moneyLabel;

    private int currentDay = 1;
    private String currentSeason = "Spring";
    private int gameHour = 9;
    private int gameMinute = 0;
    private int playerMoney = 500;
    private long totalMinute;
    private Weather weather;

    // Timing
    private float gameTimeAccumulator = 0f;
    private float gameMinuteLength = 1f; // Real seconds per game minute

    // Hand rotation
    private float handRotation = 0f;

    public Clock(Skin skin) {
        setSize(clockBase.getRegionWidth() * SCALE, clockBase.getRegionHeight() * SCALE);

        // Set position in top-right corner
        setPosition(0, 0);

        // Create labels
        setupLabels(skin);
        updateDisplay();
        Main.getInstance().setClock(this);
        initIcons();
    }

    private void setupLabels(Skin skin) {
        // Day label (e.g., "Mon. 1")
        dayLabel = new Label("", skin);
        dayLabel.setPosition(0, 90); // Adjust based on your sprite
        addActor(dayLabel);

        // Time label (e.g., "6:00 am")
        timeLabel = new Label("", skin);
        timeLabel.setPosition(-10, 0); // Adjust based on your sprite
        addActor(timeLabel);

        // Money label (bottom area)
        moneyLabel = new Label("", skin);
        moneyLabel.setPosition(57, -80); // Adjust based on your sprite
        addActor(moneyLabel);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // Update game time
        gameTimeAccumulator += delta;

        if (gameTimeAccumulator >= gameMinuteLength) {
            gameTimeAccumulator = 0f;
            advanceGameTime();
            updateDisplay();
        }

        // Update hand rotation (smooth animation)
        updateHandRotation();
    }

    private void advanceGameTime() {
        gameMinute += 10; // Stardew Valley increments by 10 minutes

        if (gameMinute >= 60) {
            gameMinute = 0;
            gameHour++;

            if (gameHour >= 22) {
                gameHour = 9;
                currentDay++;

                // Randomize weather and update icon
                weather = Weather.weatherRandomizer();
                switch (weather.getName().toLowerCase()) {
                    case "sunny":
                        setWeatherIcon(sunny);
                        break;
                    case "stormy":
                        setWeatherIcon(stormy);
                        break;
                    case "snowy":
                        setWeatherIcon(snowy);
                        break;
                    case "rainy":
                        setWeatherIcon(rainy);
                        break;
                    default:
                        setWeatherIcon(sunny); // safe default
                }

                // Handle season change
                if (currentDay > 28) {
                    currentDay = 1;
                    advanceSeason();
                }
            }
        }
    }

    private void advanceSeason() {
        switch (currentSeason) {
            case "Spring":
                currentSeason = "Summer";
                setSeasonIcon(summer);
                break;
            case "Summer":
                currentSeason = "Fall";
                setSeasonIcon(fall);
                break;
            case "Fall":
                currentSeason = "Winter";
                setSeasonIcon(winter);
                break;
            case "Winter":
                currentSeason = "Spring";
                setSeasonIcon(spring);
                break;
        }
    }

    // Call this once in constructor to set initial icons
    private void initIcons() {
        // Set initial season icon
        switch (currentSeason) {
            case "Spring":
                setSeasonIcon(spring);
                break;
            case "Summer":
                setSeasonIcon(summer);
                break;
            case "Fall":
                setSeasonIcon(fall);
                break;
            case "Winter":
                setSeasonIcon(winter);
                break;
        }

        // Set default weather icon
        setWeatherIcon(sunny);
    }

    private void updateHandRotation() {
        // Calculate hand position based on time
        // 12-hour format: 12 hours = 360 degrees
        int startingHour = 9;
        float totalGameHours = 13;
        float hourAngle = ((gameHour - startingHour) + (gameMinute / 60f)) / totalGameHours * 180f; // 30 degrees per hour
        handRotation = 180f - hourAngle; // Offset so 12 o'clock points up
    }

    private void updateDisplay() {
        // Update day label
        String dayOfWeek = getDayOfWeek();
        dayLabel.setText(dayOfWeek + " " + currentDay);

        // Update time label
        String period = gameHour < 12 ? "am" : "pm";
        int displayHour = gameHour == 0 ? 12 : (gameHour > 12 ? gameHour - 12 : gameHour);
        timeLabel.setText(String.format("%d:%02d %s", displayHour, gameMinute, period));

        // Update money label
        moneyLabel.setText(String.valueOf(playerMoney));
    }

    private String getDayOfWeek() {
        String[] daysOfWeek = {"Mon.", "Tue.", "Wed.", "Thu.", "Fri.", "Sat.", "Sun."};
        return daysOfWeek[(currentDay - 1) % 7];
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // Draw clock base using actor's position
        batch.draw(clockBase, Gdx.graphics.getWidth() - getWidth() * SCALE,
            Gdx.graphics.getHeight() - getHeight() * SCALE,
            getWidth() * SCALE, getHeight() * SCALE);

        // Draw clock hand (rotated around center)
        float centerX = (float) (getX() - 55 - clockHand.getRegionWidth() * Math.sin(Math.toRadians(handRotation)));
        float centerY = (float) (getY() + 40 + clockHand.getRegionHeight() * Math.cos(Math.toRadians(handRotation)));

        batch.draw(clockHand,
            centerX,
            centerY,
            clockHand.getRegionWidth() * 0.5f,  // origin X
            clockHand.getRegionHeight() * 0.5f, // origin Y
            clockHand.getRegionWidth(),
            clockHand.getRegionHeight(),
            SCALE + 1, SCALE + 1, // scale
            handRotation);

        // Draw weather/season icons if you have them
        if (weatherIcon != null) {
            batch.draw(weatherIcon, getX() + 20, getY() + 50); // Adjust position
        }

        if (seasonIcon != null) {
            batch.draw(seasonIcon, getX() + 40, getY() + 50); // Adjust position
        }

        // Draw all child actors (labels)
        super.draw(batch, parentAlpha);
    }

    // Public methods to interact with the clock
    public void setGameTime(int hour, int minute) {
        this.gameHour = hour;
        this.gameMinute = minute;
        updateDisplay();
    }

    public void setDay(int day) {
        this.currentDay = day;
        updateDisplay();
    }

    public void setSeason(String season) {
        this.currentSeason = season;
        updateDisplay();
    }

    public void setMoney(int money) {
        this.playerMoney = money;
        updateDisplay();
    }

    public void addMoney(int amount) {
        this.playerMoney += amount;
        updateDisplay();
    }

    public void setWeatherIcon(TextureRegion icon) {
        this.weatherIcon = icon;
    }

    public void setSeasonIcon(TextureRegion icon) {
        this.seasonIcon = icon;
    }

    public void setGameSpeed(float minutesPerSecond) {
        this.gameMinuteLength = 1f / minutesPerSecond;
    }

    // Getters
    public int getCurrentHour() {
        return gameHour;
    }

    public int getCurrentMinute() {
        return gameMinute;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public String getCurrentSeason() {
        return currentSeason;
    }

    public int getMoney() {
        return playerMoney;
    }

    public long getTotalMinutes(){
        return totalMinute;
    }
}
