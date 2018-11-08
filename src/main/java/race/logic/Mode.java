package race.logic;

public enum Mode {

    EASY(1000),
    NORMAL(100),
    HARD(10);

    private int millisecondsInterval;

    Mode(int millisecondsInterval) {
        this.millisecondsInterval = millisecondsInterval;
    }

    public int getMillisecondsInterval() {
        return millisecondsInterval;
    }
}
