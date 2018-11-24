package race.bus.view.road;

import race.mvc.model.road.RoadModel;

public class RoadModelVelocityBooster extends AbstractRoadModelVelocityChanger {

    private static final double BOOST_dV = 0.6;

    public RoadModelVelocityBooster(RoadModel roadModel) {
        super(roadModel);
    }

    @Override
    double dV() {
        return BOOST_dV;
    }
}
