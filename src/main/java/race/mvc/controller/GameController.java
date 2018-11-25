package race.mvc.controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import race.bus.EventPublisher;
import race.bus.view.SceneSetter;
import race.mvc.controller.player.PlayerController;
import race.mvc.controller.road.RoadController;
import race.mvc.model.mode.ModeModelEvent;
import race.mvc.view.player.PlayerView;
import race.mvc.view.road.RoadView;

public class GameController {

    public GameController(EventPublisher eventPublisher, Stage stage) {
        RoadController roadController = new RoadController(eventPublisher);
        PlayerController playerController = new PlayerController(eventPublisher);

        RoadView roadView = roadController.getRoadView();
        PlayerView playerView = playerController.getPlayerView();

        Scene gameScene = new Scene(new Pane(roadView, playerView));
        roadView.initializeKeyEvents();
        playerView.initializeKeyEvents();

        eventPublisher.subscribe(ModeModelEvent.MODE_INITIALIZED.name(), new SceneSetter(stage, gameScene));
    }
}
