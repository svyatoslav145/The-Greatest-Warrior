package theGreatestWarrior.printer;

public enum ColorPrint {
    BLACK("\033[30m"),
    RED("\033[31m"),
    GREEN("\033[32m"),
    YELLOW("\033[33m"),
    BLUE("\033[34m"),
    PURPLE("\033[35m"),
    CYAN("\033[36m"),
    WHITE("\033[37m"),
    RESET("\033[0m");

    private String color;

    public String getColor() {
        return color;
    }

    ColorPrint(String color) {
        this.color = color;
    }
}
