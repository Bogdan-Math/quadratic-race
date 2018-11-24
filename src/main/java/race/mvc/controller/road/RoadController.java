package race.mvc.controller.road;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import race.bus.EventPublisher;
import race.bus.view.SceneSetter;
import race.mvc.model.road.RoadModel;
import race.mvc.model.mode.ModeModelEvent;
import race.mvc.view.road.RoadView;

public class RoadController {

    private RoadModel roadModel;
    private RoadView roadView;

    public RoadController(EventPublisher eventPublisher, Stage stage) {
        roadModel = new RoadModel();
        roadView = new RoadView();

        Scene roadScene = new Scene(roadView);
        roadScene.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W)) roadModel.changeVelocity(0.3);
            if (keyCode.equals(KeyCode.S)) roadModel.changeVelocity(-0.6);
        });

        roadScene.setOnKeyReleased(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W)) roadModel.changeVelocity(-0.3);
            if (keyCode.equals(KeyCode.S)) roadModel.changeVelocity(-0.3);
        });

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                roadModel.move();
                roadView.move();
                roadView.getRoadPieces().forEach(imageView -> move(imageView, roadModel.getVelocity()));
            }
        }.start();


        eventPublisher.subscribe(ModeModelEvent.MODE_INITIALIZED.name(), new SceneSetter(stage, roadScene));
    }

    private void move(ImageView imageView, double v) {
        imageView.setTranslateY(imageView.getTranslateY() + v);
    }

}
