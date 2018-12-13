package race.mvc.controller.restart;

import javafx.scene.Scene;
import race.bus.EventPublisher;
import race.mvc.view.WindowEvent;
import race.mvc.view.mode.ModeViewEvent;
import race.mvc.view.restart.RestartView;

public class RestartController {

    private EventPublisher eventPublisher;

    public RestartController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;

    }

    public Scene initializeScene() {
        RestartView restartView = new RestartView();
        Scene scene = new Scene(restartView);

        restartView.getRestartButton().setOnAction(e -> eventPublisher.publish(ModeViewEvent.SHOW));
        restartView.getCloseButton().setOnAction(e -> eventPublisher.publish(WindowEvent.CLOSE));

        return scene;
    }

}
