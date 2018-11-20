package race;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import race.controller.GameController;
import race.controller.mode.ModeController;
import race.controller.road.RoadController;
import race.model.Mode;
import race.model.Road;
import race.view.mode.ModeView;
import race.view.road.RoadView;

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

        GameController gameController = new GameController();

//        stage.setScene(gameController.getModeScene());
//        stage.show();

        stage.setScene(gameController.getRoadScene());
        stage.setResizable(false);
        stage.show();

        moveToCenter(stage);
    }

    private void fillHeaderFor(Stage stage) {
        stage.setTitle(TITLE);
        stage.getIcons().add(image(ICON));
    }

//    private Scene newModeScene() {
//        return new ModeController(new Mode(), new ModeView())
//                .getModeScene();
//    }

//    private Scene newRoadScene() {
//        return new RoadController(new Road(), new RoadView())
//                .getRoadScene();
//    }

    private void moveToCenter(Stage stage) {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }
}