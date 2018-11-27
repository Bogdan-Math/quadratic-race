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
    private boolean UP;
    private boolean DOWN;

    public RaceController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        raceView = new RaceView();
        raceModel = new RaceModel(eventPublisher);

        RoadModel roadModel = raceModel.getRoadModel();
        RoadView roadView = raceView.getRoadView();

//        eventPublisher.subscribe(RoadViewEvent.MOVE_UP_PRESSED.name(), new RoadModelVelocityBooster(roadModel));
//        eventPublisher.subscribe(RoadViewEvent.MOVE_DOWN_PRESSED.name(), new RoadModelVelocityReducer(roadModel));
//        eventPublisher.subscribe(RoadViewEvent.MOVE_UP_RELEASED.name(), new RoadModelVelocityNeutralizator(roadModel));
//        eventPublisher.subscribe(RoadViewEvent.MOVE_DOWN_RELEASED.name(), new RoadModelVelocityNeutralizator(roadModel));
//        eventPublisher.subscribe(RoadModelEvent.CHANGE_V.name(), new RoadViewProcessor(roadView, roadModel));
    }

    public Scene initializeScene() {
        RoadModel roadModel = raceModel.getRoadModel();
        RoadView roadView = raceView.getRoadView();

        Scene scene = new Scene(raceView);

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (roadModel.move()) {
                    roadModel.dS(10);
                    roadView.move(roadModel.dS());
                }
            }
        }.start();


        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();

            if (keyCode.equals(KeyCode.W)) {
//                roadModel.dS(true);
//                roadModel.dS(5);
                roadModel.move(true);
//                this.UP = true;
//                roadModel.dS(true);
//                eventPublisher.publish(RoadViewEvent.MOVE_UP_PRESSED.name());
            }
//            if (keyCode.equals(KeyCode.S)) {
//                roadModel.dS(false);
//                roadModel.dS(0);
//                eventPublisher.publish(RoadViewEvent.MOVE_DOWN_PRESSED.name());
//            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W)) {
//                roadModel.dS(false);
                roadModel.move(false);
//                eventPublisher.publish(RoadViewEvent.MOVE_UP_RELEASED.name());
            }
//            if (keyCode.equals(KeyCode.S)) {
//                eventPublisher.publish(RoadViewEvent.MOVE_DOWN_RELEASED.name());
//            }
        });

        return scene;
    }
}
