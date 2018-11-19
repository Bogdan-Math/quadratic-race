package race.model.road;

import race.model.mode.ModeModel;
import race.model.player.PlayerModel;

public class RoadModel {

    private PlayerModel playerModel;
    private ModeModel modeModel;

    public RoadModel() {
        this.playerModel = new PlayerModel();
        this.modeModel = new ModeModel();
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    public ModeModel getModeModel() {
        return modeModel;
    }
}
