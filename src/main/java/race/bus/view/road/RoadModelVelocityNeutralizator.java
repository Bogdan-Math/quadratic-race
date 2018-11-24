package race.bus.view.road;

import race.bus.EventHandler;
import race.mvc.model.road.RoadModel;

public class RoadModelVelocityNeutralizator implements EventHandler {

    private static final double dV = -0.3;

    private RoadModel roadModel;

    public RoadModelVelocityNeutralizator(RoadModel roadModel) {
        this.roadModel = roadModel;
    }

    @Override
    public void handle(String event) {
        roadModel.changeV(dV);
    }
}
