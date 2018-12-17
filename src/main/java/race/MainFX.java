package race;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import race.bus.EventBus;
import race.bus.UIEvent;
import race.mvc.controller.mode.ModeController;
import race.mvc.controller.race.RaceController;
import race.mvc.controller.restart.RestartController;
import race.mvc.model.mode.ModeModelEvent;
import race.mvc.model.race.road.RoadModelEvent;
import race.mvc.view.WindowEvent;

import java.util.List;

import static java.util.Arrays.asList;
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

        List<Enum> events = asList(
        
                UIEvent.APP_STARTED,
                UIEvent.EASY_MODE_BUTTON_CLICKED,
                UIEvent.NORMAL_MODE_BUTTON_CLICKED,
                UIEvent.HARD_MODE_BUTTON_CLICKED,

                ModeModelEvent.MODE_INITIALIZED,
                
                RoadModelEvent.ROAD_FINISHED,

                WindowEvent.CLOSE
        );

        var eventPublisher = new EventBus(events);

        var modeController      = new ModeController(eventPublisher);
        var raceController      = new RaceController(eventPublisher);
        var restartController   = new RestartController(eventPublisher);

        eventPublisher.subscribe(UIEvent.APP_STARTED,
                e -> show(stage, modeController.initializeScene())
        );

        eventPublisher.subscribe(ModeModelEvent.MODE_INITIALIZED,
                e -> show(stage, raceController.initializeScene())
        );

        eventPublisher.subscribe(RoadModelEvent.ROAD_FINISHED,
                e -> show(stage, restartController.initializeScene())
        );

        eventPublisher.subscribe(WindowEvent.CLOSE,
                e -> stage.close()
        );

        eventPublisher.publish(UIEvent.APP_STARTED);
    }

    private void fillHeaderFor(Stage stage) {
        stage.setTitle(TITLE);
        stage.getIcons().add(image(ICON));
    }

    private void show(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        var primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }

}