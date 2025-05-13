package models.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Last updated by: hassanp30
 * Last updated at: 2025-05-13 12:39:30 UTC
 */
public enum Fish {
    // Spring Fish (Season 1)
    FLOUNDER("Flounder", 100, 1, false),
    LIONFISH("Lionfish", 100, 1, false),
    HERRING("Herring", 30, 1, false),
    GHOSTFISH("Ghostfish", 45, 1, false),
    LEGEND("Legend", 5000, 1, true),

    // Summer Fish (Season 2)
    TILAPIA("Tilapia", 75, 2, false),
    DORADO("Dorado", 100, 2, false),
    SUNFISH("Sunfish", 30, 2, false),
    RAINBOW_TROUT("Rainbow Trout", 65, 2, false),
    CRIMSONFISH("Crimsonfish", 1500, 2, true),

    // Fall Fish (Season 3)
    SALMON("Salmon", 75, 3, false),
    SARDINE("Sardine", 40, 3, false),
    SHAD("Shad", 60, 3, false),
    BLUE_DISCUS("Blue Discus", 120, 3, false),
    ANGLER("Angler", 900, 3, true),

    // Winter Fish (Season 4)
    MIDNIGHT_CARP("Midnight Carp", 150, 4, false),
    SQUID("Squid", 80, 4, false),
    TUNA("Tuna", 100, 4, false),
    PERCH("Perch", 55, 4, false),
    GLACIERFISH("Glacierfish", 1000, 4, true);

    private final String name;
    private final int price;
    private final int season; // 1=Spring, 2=Summer, 3=Fall, 4=Winter
    private final boolean isLegendary;

    private static final List<Fish> CHEAPEST_FISH_TYPE_BY_SEASON = new ArrayList<>();

    static {
        updateCheapestFishList();
    }

    Fish(String name, int price, int season, boolean isLegendary) {
        this.name = name;
        this.price = price;
        this.season = season;
        this.isLegendary = isLegendary;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getSeason() {
        return season;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    public static List<Fish> getCheapestFishBySeason() {
        return new ArrayList<>(CHEAPEST_FISH_TYPE_BY_SEASON);
    }

    private static void updateCheapestFishList() {
        CHEAPEST_FISH_TYPE_BY_SEASON.clear();

        // For each season (1-4)
        for (int season = 1; season <= 4; season++) {
            final int currentSeason = season;
            Fish cheapestFish = Arrays.stream(Fish.values())
                    .filter(Fish -> Fish.getSeason() == currentSeason && !Fish.isLegendary())
                    .min(Comparator.comparingInt(Fish::getPrice))
                    .orElse(null);

            if (cheapestFish != null) {
                CHEAPEST_FISH_TYPE_BY_SEASON.add(cheapestFish);
            }
        }
    }

    public static List<Fish> getFishBySeason(int season) {
        return Arrays.stream(Fish.values())
                .filter(Fish -> Fish.getSeason() == season)
                .toList();
    }

    public static List<Fish> getLegendaryFish() {
        return Arrays.stream(Fish.values())
                .filter(Fish::isLegendary)
                .toList();
    }

    public static List<Fish> getRegularFish() {
        return Arrays.stream(Fish.values())
                .filter(Fish -> !Fish.isLegendary())
                .toList();
    }

    private String getSeasonName() {
        return switch (season) {
            case 1 -> "Spring";
            case 2 -> "Summer";
            case 3 -> "Fall";
            case 4 -> "Winter";
            default -> "Unknown";
        };
    }

    @Override
    public String toString() {
        return String.format("%s (Price: %dg, Season: %s%s)",
                name,
                price,
                getSeasonName(),
                isLegendary ? ", Legendary" : ""
        );
    }
}