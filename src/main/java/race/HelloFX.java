package race;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label l = new Label("Hello, JavaFX, running on Java 11");
        l.setId("lab1");
        Scene scene = new Scene(l, 320, 240);
        stage.setScene(scene);
        stage.show();
    }
}