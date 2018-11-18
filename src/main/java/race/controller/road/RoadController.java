package race.controller.road;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import race.model.road.RoadModel;
import race.view.road.RoadView;

public class RoadController {

    private RoadModel roadModel;
    private RoadView roadView;

    public RoadController(RoadModel roadModel, RoadView roadView) {
        this.roadModel = roadModel;
        this.roadView = roadView;

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                roadModel.move();
                roadView.move();
                roadView.getRoadPieces().forEach(imageView -> move(imageView, roadModel.getVelocity()));
            }
        }.start();

    }

    public Scene getRoadScene() {
        Scene scene = new Scene(roadView);
        scene.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W)) roadModel.changeVelocity(0.2);
            if (keyCode.equals(KeyCode.S)) roadModel.changeVelocity(-0.4);
        });

        scene.setOnKeyReleased(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W)) roadModel.changeVelocity(-0.2);
            if (keyCode.equals(KeyCode.S)) roadModel.changeVelocity(-0.2);
        });
        return scene;
    }

    private void move(ImageView imageView, double v) {
        imageView.setTranslateY(imageView.getTranslateY() + v);
    }

}
