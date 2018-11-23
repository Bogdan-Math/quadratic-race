package race.mvc.model;

public class Road {

    private static final int EASY_MODE = 1000;
    private static final int NORMAL_MODE = 100;
    private static final int HARD_MODE = 10;

    private int millisecondsInterval;

    public void setEasyMode() {
        this.millisecondsInterval = EASY_MODE;
    }

    public void setNormalMode() {
        this.millisecondsInterval = NORMAL_MODE;
    }

    public void setHardMode() {
        this.millisecondsInterval = HARD_MODE;
    }

    public int getMillisecondsInterval() {
        return millisecondsInterval;
    }
}
