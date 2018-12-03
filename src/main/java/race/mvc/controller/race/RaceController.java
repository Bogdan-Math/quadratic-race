package race.mvc.controller.race;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import race.bus.EventPublisher;
import race.mvc.model.race.RaceModel;
import race.mvc.model.race.player.PlayerModel;
import race.mvc.model.race.road.RoadModel;
import race.mvc.view.race.RaceView;
import race.mvc.view.race.player.PlayerView;
import race.mvc.view.race.road.RoadView;

public class RaceController {

    private RaceView raceView;
    private RaceModel raceModel;
    private EventPublisher eventPublisher;

    public RaceController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        raceView = new RaceView();
        raceModel = new RaceModel(eventPublisher);

        RoadModel roadModel = raceModel.getRoadModel();
        RoadView roadView = raceView.getRoadView();
    }

    public Scene initializeScene() {
        RoadModel roadModel = raceModel.getRoadModel();
        RoadView roadView = raceView.getRoadView();

        PlayerModel playerModel = raceModel.getPlayerModel();
        PlayerView playerView = raceView.getPlayerView();

        Scene scene = new Scene(raceView);

        new AnimationTimer() {

            @Override
            public void handle(long now) {

                if (roadModel.speedIncreased()) {
                    roadModel.d2S(0.3);
                }
                if (!roadModel.speedIncreased()) {
                    roadModel.d2S(-0.3);
                }
                roadView.move(roadModel.dS());


                if (playerModel.moveLeft() || playerModel.moveRight()) {
                    if (playerModel.moveLeft()) {
                        playerModel.dx(-7);
                    }
                    if (playerModel.moveRight()) {
                        playerModel.dx(7);
                    }
                } else {
                    playerModel.dx(0);
                }
                playerView.move(playerModel.dx());
            }
        }.start();


        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();

            if (keyCode.equals(KeyCode.W)) {
                roadModel.increaseSpeed(true);
            }
            if (keyCode.equals(KeyCode.S)) {

            }
            if (keyCode.equals(KeyCode.A)) {
                playerModel.moveLeft(true);
            }
            if (keyCode.equals(KeyCode.D)) {
                playerModel.moveRight(true);
            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W)) {
                roadModel.increaseSpeed(false);
            }
            if (keyCode.equals(KeyCode.S)) {
            }
            if (keyCode.equals(KeyCode.A)) {
                playerModel.moveLeft(false);
            }
            if (keyCode.equals(KeyCode.D)) {
                playerModel.moveRight(false);
            }
        });

        return scene;
    }
}
