package race.mvc.model.race.road;

public class RoadModel {

    private double S;
    private double dS;

    private boolean speedIncreased;

    public void d2S(double d2S) {
        int MAX_dS = 25;
        int MIN_dS = 0;
        double dS = this.dS + d2S;
        if (dS > MAX_dS) this.dS = MAX_dS;
        if (dS < MIN_dS) this.dS = MIN_dS;
        if (dS <= MAX_dS && dS >= MIN_dS) this.dS = dS;

        this.S += this.dS;
        System.out.println(this.S);
    }

    public double S() {
        return S;
    }

    public double dS() {
        return dS;
    }

    public boolean speedIncreased() {
        return speedIncreased;
    }

    public void increaseSpeed(boolean speedIncreased) {
        this.speedIncreased = speedIncreased;
    }
}
