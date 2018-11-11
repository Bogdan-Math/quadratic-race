package race;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import race.scene.ModeScene;

import static race.multimedia.image.ImageResource.image;

public class MainFX extends Application {

    private static final String ICON    = "race/multimedia/image/icon.png";
    private static final String TITLE   = "Quadratic Race";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        fillHeaderFor(stage);

        stage.setScene(new ModeScene());
        stage.show();

        moveToCenter(stage);
    }

    private void fillHeaderFor(Stage stage) {
        stage.setTitle(TITLE);
        stage.getIcons().add(image(ICON));
    }

    private void moveToCenter(Stage stage) {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }
}