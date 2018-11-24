package race.bus.view.road;

import race.bus.EventHandler;
import race.mvc.model.road.RoadModel;

public class RoadModelVelocityBooster implements EventHandler {

    private static final double dV = 0.6;

    private RoadModel roadModel;

    public RoadModelVelocityBooster(RoadModel roadModel) {
        this.roadModel = roadModel;
    }

    @Override
    public void handle(String event) {
        roadModel.changeV(dV);
    }
}
