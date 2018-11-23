package race.mvc.controller.road;

import javafx.scene.Scene;
import javafx.stage.Stage;
import race.bus.EventPublisher;
import race.bus.view.SceneSetter;
import race.mvc.model.RoadModel;
import race.mvc.model.mode.ModeModelEvent;
import race.mvc.view.road.RoadView;

public class RoadController {

    private RoadModel roadModel;
    private RoadView roadView;

    public RoadController(EventPublisher eventPublisher, Stage stage) {
        roadModel = new RoadModel();
        roadView = new RoadView();

        eventPublisher.subscribe(ModeModelEvent.MODE_INITIALIZED.name(), new SceneSetter(stage, new Scene(roadView)));
    }
}
