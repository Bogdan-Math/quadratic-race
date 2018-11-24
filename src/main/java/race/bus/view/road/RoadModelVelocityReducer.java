package race.bus.view.road;

import race.mvc.model.road.RoadModel;

public class RoadModelVelocityReducer extends AbstractRoadModelVelocityChanger {

    private static final double REDUCE_dV = -0.9;

    public RoadModelVelocityReducer(RoadModel roadModel) {
        super(roadModel);
    }

    @Override
    double dV() {
        return REDUCE_dV;
    }
}
