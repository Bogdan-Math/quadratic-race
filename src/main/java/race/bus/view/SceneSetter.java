package race.bus.view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import race.bus.EventHandler;

import static race.StageManipulator.moveToCenter;

public class SceneSetter implements EventHandler {

    private Stage stage;
    private Scene scene;

    public SceneSetter(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
    }

    @Override
    public void handle(String event) {
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        moveToCenter(stage);
    }
}
