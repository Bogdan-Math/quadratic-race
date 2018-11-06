package race;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.InputStream;

import static race.picture.PictureReader.readPictureAsInputStream;

public class MainFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        InputStream iconAsInputStream = readPictureAsInputStream("race/picture/image.png");
        stage.getIcons().add(new Image(iconAsInputStream));

        Label l1 = new Label("clicked!!!");
        Scene scene2 = new Scene(l1, 100, 50);

        Label l = new Label("Hello, JavaFX, running on Java 11");
        l.setId("label_1");

        Button b = new Button("click me!");
        b.setId("button_1");
        b.setOnAction(e -> b.setText("clicked!"));

        Button newWindowButton = new Button();
        newWindowButton.setGraphic(new ImageView(new Image(readPictureAsInputStream("race/picture/image.png"))));
        newWindowButton.setId("new_window");
        newWindowButton.setOnAction(e -> {
            stage.setScene(scene2);
            moveStageToCenter(stage);
        });

        GridPane ap = new GridPane();
        ap.addRow(1, l, b, newWindowButton);

        Scene scene1 = new Scene(ap, 320, 240);
        stage.setScene(scene1);
        stage.show();
        moveStageToCenter(stage);
    }

    private void moveStageToCenter(Stage stage) {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }
}