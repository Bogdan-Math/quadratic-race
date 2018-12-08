package race.mvc.controller.restart;

import javafx.scene.Scene;
import race.bus.EventPublisher;
import race.mvc.view.restart.RestartView;

public class RestartController {

    private RestartView restartView;
    private EventPublisher eventPublisher;

    public RestartController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;

        this.restartView = new RestartView();
    }

    public Scene initializeScene() {
        Scene scene = new Scene(restartView);

        restartView.getRestartButton().setOnAction(e -> System.out.println("RESTART"));
        restartView.getCloseButton().setOnAction(e -> System.out.println("CLOSE"));

        return scene;
    }

}
