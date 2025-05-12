package models.enums;

public enum Color {
    WHITE_TEXT("\u001B[37m"),
    BLUE_TEXT("\u001B[34m"),
    CYAN_TEXT("\u001B[36m"),
    YELLOW_TEXT("\u001B[33m"),
    BLACK_TEXT("\u001B[30m"),
    MAGENTA_TEXT("\u001B[35m"),
    GREEN_TEXT("\u001B[32m"),
    RED_TEXT("\u001B[31m"),
    WHITE_BG("\u001B[47m"),
    CYAN_BG("\u001B[46m"),
    BLACK_BG("\u001B[40m"),
    RED_BG("\u001B[41m"),
    BLUE_BG("\u001B[44m"),
    GREEN_BG("\u001B[42m"),
    YELLOW_BG("\u001B[43m"),
    MAGENTA_BG("\u001B[45m"),
    RESET("\u001B[0m");
    private final String colorCode;
    Color(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }
}
