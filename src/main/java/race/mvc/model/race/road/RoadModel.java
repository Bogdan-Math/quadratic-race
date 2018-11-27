package race.mvc.model.race.road;

import race.bus.EventPublisher;

public class RoadModel {

    private double dS;
    private boolean move;

    private EventPublisher eventPublisher;

    public RoadModel(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void dS(double dS) {
        this.dS = dS;

        eventPublisher.publish(RoadModelEvent.CHANGE_V.name());
    }

    public double dS() {
        return dS;
    }

    public boolean move() {
        return move;
    }

    public void move(boolean move) {
        this.move = move;
    }
}
