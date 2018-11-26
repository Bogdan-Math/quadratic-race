package race.bus.view.road;

import race.bus.EventHandler;
import race.mvc.model.race.road.RoadModel;

abstract class AbstractRoadModelVelocityChanger implements EventHandler {

    private RoadModel roadModel;

    AbstractRoadModelVelocityChanger(RoadModel roadModel) {
        this.roadModel = roadModel;
    }

    @Override
    public void handle(String event) {
        roadModel.changeV(dV());
    }

    abstract double dV();
}
