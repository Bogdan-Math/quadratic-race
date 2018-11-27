package race.bus.view.road;

import race.mvc.model.race.road.RoadModel;

public class RoadModelVelocityBooster extends AbstractRoadModelVelocityChanger {

    private static final double BOOST_dV = 10;

    public RoadModelVelocityBooster(RoadModel roadModel) {
        super(roadModel);
    }

    @Override
    double dV() {
        return BOOST_dV;
    }
}
