package race.model.road;

public class RoadModel {

    private static final int ZERO_VELOCITY = 0;
    private static final int MAX_VELOCITY = 10;

    private double v = 0;
    private double dv = 0;

    public RoadModel() {
    }

    public void move() {
        v += dv;
        if (v <= ZERO_VELOCITY) v = ZERO_VELOCITY;
        if (v >= MAX_VELOCITY) v = MAX_VELOCITY;
    }

    public void changeVelocity(double dv) {
        this.dv = dv;
    }

    public double getVelocity() {
        return v;
    }
}
