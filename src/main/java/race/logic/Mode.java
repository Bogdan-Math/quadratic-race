package race.logic;

public enum Mode {
    EASY("race/picture/1_easyButton.png"),
    NORMAL("race/picture/2_normalButton.png"),
    HARD("race/picture/3_hardButton.png");

    private String pathToImage;

    Mode(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public String getPathToImage() {
        return pathToImage;
    }
}
