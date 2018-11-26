package race.mvc.controller.race;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import race.bus.EventPublisher;
import race.bus.model.road.RoadViewProcessor;
import race.bus.view.road.RoadModelVelocityBooster;
import race.bus.view.road.RoadModelVelocityNeutralizator;
import race.bus.view.road.RoadModelVelocityReducer;
import race.mvc.model.race.RaceModel;
import race.mvc.model.race.road.RoadModel;
import race.mvc.model.race.road.RoadModelEvent;
import race.mvc.view.race.RaceView;
import race.mvc.view.race.road.RoadView;
import race.mvc.view.race.road.RoadViewEvent;

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

        eventPublisher.subscribe(RoadViewEvent.MOVE_UP_PRESSED.name(), new RoadModelVelocityBooster(roadModel));
        eventPublisher.subscribe(RoadViewEvent.MOVE_DOWN_PRESSED.name(), new RoadModelVelocityReducer(roadModel));
        eventPublisher.subscribe(RoadViewEvent.MOVE_UP_RELEASED.name(), new RoadModelVelocityNeutralizator(roadModel));
        eventPublisher.subscribe(RoadViewEvent.MOVE_DOWN_RELEASED.name(), new RoadModelVelocityNeutralizator(roadModel));
        eventPublisher.subscribe(RoadModelEvent.CHANGE_V.name(), new RoadViewProcessor(roadView, roadModel));
    }

    public Scene initializeScene() {
        Scene scene = new Scene(raceView);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W))
                eventPublisher.publish(RoadViewEvent.MOVE_UP_PRESSED.name());
            if (keyCode.equals(KeyCode.S))
                eventPublisher.publish(RoadViewEvent.MOVE_DOWN_PRESSED.name());
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W))
                eventPublisher.publish(RoadViewEvent.MOVE_UP_RELEASED.name());
            if (keyCode.equals(KeyCode.S))
                eventPublisher.publish(RoadViewEvent.MOVE_DOWN_RELEASED.name());
        });

        return scene;
    }
}
