package race.mvc.controller.road;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import race.bus.EventPublisher;
import race.bus.model.road.RoadViewProcessor;
import race.bus.view.SceneSetter;
import race.bus.view.road.RoadModelVelocityBooster;
import race.bus.view.road.RoadModelVelocityNeutralizator;
import race.bus.view.road.RoadModelVelocityReducer;
import race.mvc.model.mode.ModeModelEvent;
import race.mvc.model.road.RoadModel;
import race.mvc.model.road.RoadModelEvent;
import race.mvc.view.road.RoadView;
import race.mvc.view.road.RoadViewEvent;

public class RoadController {

    public RoadController(EventPublisher eventPublisher, Stage stage) {
        var roadModel   = new RoadModel(eventPublisher);
        var roadView    = new RoadView();

        Scene roadScene = new Scene(roadView);
        roadScene.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W))
                eventPublisher.publish(RoadViewEvent.MOVE_UP_PRESSED.name());
            if (keyCode.equals(KeyCode.S))
                eventPublisher.publish(RoadViewEvent.MOVE_DOWN_PRESSED.name());
        });

        roadScene.setOnKeyReleased(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W))
                eventPublisher.publish(RoadViewEvent.MOVE_UP_RELEASED.name());
            if (keyCode.equals(KeyCode.S))
                eventPublisher.publish(RoadViewEvent.MOVE_DOWN_RELEASED.name());
        });

        eventPublisher.subscribe(ModeModelEvent.MODE_INITIALIZED.name(), new SceneSetter(stage, roadScene));
        eventPublisher.subscribe(RoadViewEvent.MOVE_UP_PRESSED.name(), new RoadModelVelocityBooster(roadModel));
        eventPublisher.subscribe(RoadViewEvent.MOVE_DOWN_PRESSED.name(), new RoadModelVelocityReducer(roadModel));
        eventPublisher.subscribe(RoadViewEvent.MOVE_UP_RELEASED.name(), new RoadModelVelocityNeutralizator(roadModel));
        eventPublisher.subscribe(RoadViewEvent.MOVE_DOWN_RELEASED.name(), new RoadModelVelocityNeutralizator(roadModel));
        eventPublisher.subscribe(RoadModelEvent.CHANGE_V.name(), new RoadViewProcessor(roadView, roadModel));
    }

}
