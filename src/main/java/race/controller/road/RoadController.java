package race.controller.road;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import race.model.Road;
import race.view.road.RoadView;

public class RoadController {

    private Road road;
    private RoadView roadView;

    public RoadController(Road road, RoadView roadView) {
        this.road = road;
        this.roadView = roadView;

        new AnimationTimer() {

            @Override
            public void handle(long now) {
//                road.move();
//                roadView.move();
//                roadView.getRoadPieces().forEach(imageView -> move(imageView, road.getPlayer().getVelocity()));
            }
        }.start();

    }


}
