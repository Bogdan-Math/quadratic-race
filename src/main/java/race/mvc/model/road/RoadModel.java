package race.mvc.model.road;

import race.bus.EventPublisher;

public class RoadModel {

    private static final int MIN_V = 0;
    private static final int MAX_V = 25;

    private double v = 0;

    private EventPublisher eventPublisher;

    public RoadModel(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void changeV(double dv) {
        v += dv;
        if (v <= MIN_V) v = MIN_V;
        if (v >= MAX_V) v = MAX_V;

        eventPublisher.publish(RoadModelEvent.CHANGE_V.name());
    }

    public double getV() {
        return v;
    }

}
