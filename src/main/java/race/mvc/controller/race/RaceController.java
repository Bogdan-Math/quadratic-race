package race.mvc.controller.race;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import race.bus.EventPublisher;
import race.mvc.model.race.RaceModel;
import race.mvc.model.race.road.RoadModel;
import race.mvc.view.race.RaceView;
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

        Scene scene = new Scene(raceView);

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (roadModel.speedIccreased()) {
                    roadModel.d2S(0.3);
                }
                if (roadModel.speedDecreased()) {
                    roadModel.d2S(-0.3);
                }
                roadView.move(roadModel.dS());
            }
        }.start();


        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();

            if (keyCode.equals(KeyCode.W)) {
               // roadModel.d2S(0.3);
                roadModel.move(true);
            }
            if (keyCode.equals(KeyCode.S)) {
            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W)) {
                roadModel.move(false);
            }
            if (keyCode.equals(KeyCode.S)) {
            }
        });

        return scene;
    }
}
