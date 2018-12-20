package race.mvc.controller.restart;

import javafx.scene.Scene;
import race.bus.EventPublisher;
import race.bus.UIEvent;
import race.mvc.view.restart.RestartView;

public class RestartController {

    private EventPublisher eventPublisher;

    public RestartController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public Scene initializeScene() {
        var restartView = new RestartView();
        var scene 		= new Scene(restartView);

        restartView.getRestartButton().setOnAction(e -> eventPublisher.publish(UIEvent.OPEN_APP));
        restartView.getCloseButton().setOnAction(e -> eventPublisher.publish(UIEvent.CLOSE_APP));

        return scene;
    }

}
