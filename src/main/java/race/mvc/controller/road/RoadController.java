package race.mvc.controller.road;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
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
import race.mvc.view.player.PlayerView;
import race.mvc.view.road.RoadView;
import race.mvc.view.road.RoadViewEvent;

public class RoadController {

    private final RoadModel roadModel;
    private final RoadView roadView;

    public RoadController(EventPublisher eventPublisher) {
        roadModel =     new RoadModel(eventPublisher);
        roadView =      new RoadView(eventPublisher);

        eventPublisher.subscribe(RoadViewEvent.MOVE_UP_PRESSED.name(), new RoadModelVelocityBooster(roadModel));
        eventPublisher.subscribe(RoadViewEvent.MOVE_DOWN_PRESSED.name(), new RoadModelVelocityReducer(roadModel));
        eventPublisher.subscribe(RoadViewEvent.MOVE_UP_RELEASED.name(), new RoadModelVelocityNeutralizator(roadModel));
        eventPublisher.subscribe(RoadViewEvent.MOVE_DOWN_RELEASED.name(), new RoadModelVelocityNeutralizator(roadModel));
        eventPublisher.subscribe(RoadModelEvent.CHANGE_V.name(), new RoadViewProcessor(roadView, roadModel));
    }

    public RoadModel getRoadModel() {
        return roadModel;
    }

    public RoadView getRoadView() {
        return roadView;
    }
}
