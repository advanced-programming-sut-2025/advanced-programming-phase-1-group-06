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
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Clock extends Group {
    private static final float SCALE = 2.0f; // Adjust this value to change overall size

    private float SEASON_IMAGE_Y = 25 ;
    private float SEASON_IMAGE_X = 70;

    private float SEASON_IMAGE_WIDTH;
    private float SEASON_IMAGE_HEIGHT;

    private float WEATHER_IMAGE_Y = 25;
    private float WEATHER_IMAGE_X = -28;

    private float SEASON_IMAGE_SCALE = 4;

    //    private TextureAtlas weatherAtlas = new TextureAtlas("Clock/weather.atlas");
    //    private TextureAtlas seasonsAtlas = new TextureAtlas("Clock/seasons.atlas");
    private TextureRegion clockBase = new TextureRegion(new Texture("Clock/clock_base.png"));
    private TextureRegion clockHand = new TextureRegion(new Texture("Clock/clock_hand.png"));
    private Image sunny = new Image(new Texture(Gdx.files.internal("Clock/sunny.png")));
    private Image rainy = new Image(new Texture(Gdx.files.internal("Clock/rainy.png")));
    private Image snowy = new Image(new Texture(Gdx.files.internal("Clock/snowy.png")));
    private Image stormy = new Image(new Texture(Gdx.files.internal("Clock/stormy.png")));
    private Image fall = new Image(new Texture(Gdx.files.internal("Clock/fall.png")));
    private Image winter = new Image(new Texture(Gdx.files.internal("Clock/winter.png")));
    private Image spring = new Image(new Texture(Gdx.files.internal("Clock/spring.png")));
    private Image summer = new Image(new Texture(Gdx.files.internal("Clock/summer.png")));
    private Image seasonIcon;
    private Image weatherIcon;
    private Image weatherImage;
    private Image seasonImage;



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
        setPosition(0, 0);

        setupLabels(skin);

        // Create icon actors (no drawables yet)
        weatherImage = sunny;
        seasonImage  = spring;

        SEASON_IMAGE_HEIGHT = weatherImage.getHeight() * SEASON_IMAGE_SCALE;
        SEASON_IMAGE_WIDTH = weatherImage.getWidth() * SEASON_IMAGE_SCALE;
        weatherImage.setSize(SEASON_IMAGE_WIDTH, SEASON_IMAGE_HEIGHT);
        weatherImage.setPosition(WEATHER_IMAGE_X, WEATHER_IMAGE_Y);

        seasonImage.setSize(SEASON_IMAGE_WIDTH, SEASON_IMAGE_HEIGHT);
        seasonImage.setPosition(SEASON_IMAGE_X, SEASON_IMAGE_Y);

        // Add to this Group so they’re part of the stage graph

        addActor(weatherImage);
        addActor(seasonImage);


        initIcons();

        updateDisplay();
        Main.getInstance().setClock(this);
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

        // ---- Position the icon actors to match your absolute clock placement ----
        float baseX = Gdx.graphics.getWidth()  - getWidth() * SCALE;
        float baseY = Gdx.graphics.getHeight() - getHeight() * SCALE;

        // Same offsets you used when batch-drawing
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
//        if (weatherIcon != null) {
//            batch.draw(weatherIcon, getX() + 20, getY() + 50); // Adjust position
//        }
//
//        if (seasonIcon != null) {
//            batch.draw(seasonIcon, getX() + 40, getY() + 50); // Adjust position
//        }

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

    public void setWeatherIcon(Image icon) {
        this.weatherIcon = icon;
        if (icon != null) {
            weatherImage.setSize(SEASON_IMAGE_WIDTH, SEASON_IMAGE_HEIGHT);
            weatherImage.setPosition(WEATHER_IMAGE_X, WEATHER_IMAGE_Y);
        }
    }

    public void setSeasonIcon(Image icon) {
        this.seasonIcon = icon;
        if (icon != null) {
            seasonImage.setSize(SEASON_IMAGE_WIDTH, SEASON_IMAGE_HEIGHT);
            seasonImage.setPosition(SEASON_IMAGE_X, SEASON_IMAGE_Y);
        }
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
