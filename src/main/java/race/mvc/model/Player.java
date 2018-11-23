package race.mvc.model;

public class Player {

    private static final int MIN_VELOCITY = 0;
    private static final int MAX_VELOCITY = 10;

    private double v = 0;
    private double dv = 0;

    public void move() {
        v += dv;
        if (v <= MIN_VELOCITY) v = MIN_VELOCITY;
        if (v >= MAX_VELOCITY) v = MAX_VELOCITY;
    }

    public void changeVelocity(double dv) {
        this.dv = dv;
    }

    public double getVelocity() {
        return v;
    }
}
