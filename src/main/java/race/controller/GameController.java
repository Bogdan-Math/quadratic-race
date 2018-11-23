package race.controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import race.model.ModeModel;
import race.model.Player;
import race.model.Road;
import race.view.mode.ModeView;
import race.view.player.PlayerView;
import race.view.road.RoadView;

public class GameController {

    private ModeModel modeModel;
    private ModeView modeView;

    private Road road;
    private RoadView roadView;

    private Player player;
    private PlayerView playerView;

    public GameController() {
        this.modeModel = new ModeModel();

        this.road = new Road();
        this.roadView = new RoadView();

        this.player = new Player();
        this.playerView = new PlayerView();

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                player.move();
//                playerView.draw();
                roadView.move();
                roadView.getRoadPieces().forEach(imageView -> move(imageView, player.getVelocity()));
            }
        }.start();

    }

    private void move(ImageView imageView, double v) {
        imageView.setTranslateY(imageView.getTranslateY() + v);
    }

    public Scene getRoadScene() {
        Scene roadScene = new Scene(roadView);
        roadScene.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W)) player.changeVelocity(0.2);
            if (keyCode.equals(KeyCode.S)) player.changeVelocity(-0.4);
        });

        roadScene.setOnKeyReleased(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W)) player.changeVelocity(-0.2);
            if (keyCode.equals(KeyCode.S)) player.changeVelocity(-0.2);
        });
        return roadScene;
    }

}
