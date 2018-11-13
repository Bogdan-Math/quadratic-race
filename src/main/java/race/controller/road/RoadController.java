package race.controller.road;

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
    }

    public Scene getRoadScene() {
        Scene scene = new Scene(roadView);
        ImageView imageView = roadView.getImageView();
        scene.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W))
                imageView.setTranslateY(imageView.getTranslateY() + 5);
            if (keyCode.equals(KeyCode.S))
                imageView.setTranslateY(imageView.getTranslateY() - 5);
        });

        return scene;
    }
}
