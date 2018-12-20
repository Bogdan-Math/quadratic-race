package race.mvc.model.race;

import race.mvc.model.race.player.PlayerModel;
import race.mvc.model.race.road.RoadModel;

public class RaceModel {
	
	private static final int EASY_MODE 		= 1000;
	private static final int NORMAL_MODE 	= 100;
	private static final int HARD_MODE 		= 10;
	
	private int millisecondsInterval;

    private RoadModel roadModel;
    private PlayerModel playerModel;

    public RaceModel() {
        roadModel = new RoadModel();
        playerModel = new PlayerModel();
    }
	
	public void setEasyMode() {
		this.millisecondsInterval = EASY_MODE;
	}
	
	public void setNormalMode() {
		this.millisecondsInterval = NORMAL_MODE;
	}
	
	public void setHardMode() {
		this.millisecondsInterval = HARD_MODE;
	}
	
	
	public int getMillisecondsInterval() {
		return millisecondsInterval;
	}

	public RoadModel getRoadModel() {
        return roadModel;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }
}
