package race.bus.view;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import race.bus.EventHandler;

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

    private void moveToCenter(Stage stage) {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }
}
