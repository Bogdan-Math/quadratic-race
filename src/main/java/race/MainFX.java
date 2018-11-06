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
import race.scene.ModeScene;

import java.io.InputStream;

import static race.picture.PictureReader.readPictureAsInputStream;

public class MainFX extends Application {

    private static final String ICON    = "race/picture/icon.png";
    private static final String TITLE   = "Quadratic Race";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        fillHeader(stage);

        Label l = new Label("Hello, JavaFX, running on Java 11");
        l.setId("label_1");

        Button b = new Button("click me!");
        b.setId("button_1");
        b.setOnAction(e -> b.setText("clicked!"));

        Button newWindowButton = new Button();
        newWindowButton.setGraphic(new ImageView(new Image(readPictureAsInputStream("race/picture/icon.png"))));
        newWindowButton.setId("new_window");
        newWindowButton.setOnAction(e -> {
            stage.setScene(new ModeScene());
            moveStageToCenter(stage);
        });

        GridPane ap = new GridPane();
        ap.addRow(1, l, b, newWindowButton);

        Scene scene1 = new Scene(ap);
        stage.setScene(scene1);
        stage.show();
        moveStageToCenter(stage);
    }

    private void fillHeader(Stage stage) {
        stage.setTitle(TITLE);
        InputStream iconAsInputStream = readPictureAsInputStream(ICON);
        stage.getIcons().add(new Image(iconAsInputStream));
    }

    private void moveStageToCenter(Stage stage) {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }
}