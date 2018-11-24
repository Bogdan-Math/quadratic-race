package race.bus.view.road;

import race.bus.EventHandler;
import race.mvc.model.road.RoadModel;

public class RoadModelVelocityReducer implements EventHandler {

    private static final double dV = -0.9;

    private RoadModel roadModel;

    public RoadModelVelocityReducer(RoadModel roadModel) {
        this.roadModel = roadModel;
    }

    @Override
    public void handle(String event) {
        roadModel.changeV(dV);
    }
}
