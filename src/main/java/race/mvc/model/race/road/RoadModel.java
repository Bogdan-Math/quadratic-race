package race.mvc.model.race.road;

import race.bus.EventPublisher;

public class RoadModel {

    private double dS;

    private boolean speedIncreased;

    private EventPublisher eventPublisher;

    public RoadModel(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void d2S(double d2S) {
        int MAX_dS = 25;
        int MIN_dS = 0;
        double dS = this.dS + d2S;
        if (dS > MAX_dS) this.dS = MAX_dS;
        if (dS < MIN_dS) this.dS = MIN_dS;
        if (dS <= MAX_dS && dS >= MIN_dS) this.dS = dS;

        eventPublisher.publish(RoadModelEvent.CHANGE_V.name());
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
