package race.controller.road;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import race.model.road.RoadModel;
import race.view.road.RoadView;

public class RoadController {

    private RoadModel roadModel;
    private RoadView roadView;

    public RoadController(RoadModel roadModel, RoadView roadView) {
        this.roadModel = roadModel;
        this.roadView = roadView;
    }

    public Scene getRoadScene() {
        Scene scene = new Scene(roadView);
        scene.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            System.out.println(keyCode);
            if (keyCode.equals(KeyCode.W)) roadView.moveUp();
            if (keyCode.equals(KeyCode.S)) roadView.moveDown();
        });

        scene.setOnKeyReleased(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            System.out.println(keyCode);
            if (keyCode.equals(KeyCode.W)) roadView.moveDown();
            if (keyCode.equals(KeyCode.S)) roadView.moveUp();
        });
        return scene;
    }
}
