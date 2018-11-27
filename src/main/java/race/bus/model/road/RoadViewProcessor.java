package race.bus.model.road;

import javafx.animation.AnimationTimer;
import race.bus.EventHandler;
import race.mvc.model.race.road.RoadModel;
import race.mvc.view.race.road.RoadView;

import static java.util.Objects.isNull;

public class RoadViewProcessor implements EventHandler {

    private RoadView roadView;
    private RoadModel roadModel;
    private AnimationTimer animationTimer;

    public RoadViewProcessor(RoadView roadView, RoadModel roadModel) {
        this.roadView = roadView;
        this.roadModel = roadModel;
    }

    @Override
    public void handle(String event) {
        if (isNull(animationTimer)) {
            animationTimer = new AnimationTimer() {

                @Override
                public void handle(long now) {
//                    if (roadModel.dS()) {
//                        roadView.dS(roadModel.getS());
//                    }
                }
            };
            animationTimer.start();
        }
    }

}
