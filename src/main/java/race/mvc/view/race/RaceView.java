package race.mvc.view.race;

import javafx.scene.layout.Pane;
import race.mvc.view.race.player.PlayerView;
import race.mvc.view.race.road.RoadView;

public class RaceView extends Pane {

    private final RoadView roadView;
    private final PlayerView playerView;

    public RaceView() {
        roadView = new RoadView();
        playerView = new PlayerView();
        getChildren().addAll(roadView, playerView);
    }

    public RoadView getRoadView() {
        return roadView;
    }

    public PlayerView getPlayerView() {
        return playerView;
    }
}
