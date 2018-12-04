package race.mvc.view.race;

import javafx.scene.layout.Pane;
import race.mvc.view.race.player.PlayerView;
import race.mvc.view.race.road.RoadView;

public class RaceView extends Pane {

    private RoadView roadView;
    private PlayerView playerView;

    public RaceView() {
        roadView = new RoadView();
        playerView = new PlayerView();

        initializePlayerViewPosition();

        getChildren().addAll(roadView, playerView);
    }

    private void initializePlayerViewPosition() {
        playerView.setTranslateX(roadView.getMaxWidth() / 2 - playerView.getMaxWidth() / 2);
        playerView.setTranslateY(roadView.getMaxHeight()  *  3 / 4);
    }

    public RoadView getRoadView() {
        return roadView;
    }

    public PlayerView getPlayerView() {
        return playerView;
    }
}
