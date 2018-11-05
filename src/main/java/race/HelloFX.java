package race;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label l = new Label("Hello, JavaFX, running on Java 11");
        l.setId("label_1");

        Button b = new Button("click me!");
        b.setId("button_1");
        b.setOnAction(e -> b.setText("clicked!"));

        StackPane sp = new StackPane(l, b);
        Scene scene = new Scene(sp, 320, 240);
        stage.setScene(scene);
        stage.show();
    }
}