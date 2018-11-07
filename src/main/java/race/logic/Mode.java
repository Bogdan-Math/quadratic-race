package race.logic;

public enum Mode {

    EASY(50),
    NORMAL(100),
    HARD(150);

    private int maxEnemiesCount;

    Mode(int maxEnemiesCount) {
        this.maxEnemiesCount = maxEnemiesCount;
    }

    public int getMaxEnemiesCount() {
        return maxEnemiesCount;
    }
}
