package race.mvc.model.race;

import race.bus.EventPublisher;
import race.mvc.model.race.player.PlayerModel;
import race.mvc.model.race.road.RoadModel;

public class RaceModel {

    private RoadModel roadModel;
    private PlayerModel playerModel;

    public RaceModel() {
        roadModel = new RoadModel();
        playerModel = new PlayerModel();
    }

    public RoadModel getRoadModel() {
        return roadModel;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }
}
