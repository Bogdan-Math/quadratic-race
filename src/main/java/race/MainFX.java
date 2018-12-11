package race;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import race.bus.EventBus;
import race.bus.EventPublisher;
import race.mvc.controller.mode.ModeController;
import race.mvc.controller.race.RaceController;
import race.mvc.controller.restart.RestartController;
import race.mvc.model.mode.ModeModelEvent;
import race.mvc.model.race.road.RoadModelEvent;
import race.mvc.view.WindowEvent;
import race.mvc.view.mode.ModeViewEvent;
import race.mvc.view.race.player.PlayerViewEvent;
import race.mvc.view.race.road.RoadViewEvent;

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

        List<String> events = asList(

                ModeViewEvent.SHOW.name(),
                ModeViewEvent.CLICK_EASY_MODE_BUTTON.name(),
                ModeViewEvent.CLICK_NORMAL_MODE_BUTTON.name(),
                ModeViewEvent.CLICK_HARD_MODE_BUTTON.name(),

                ModeModelEvent.MODE_INITIALIZED.name(),

                RoadViewEvent.MOVE_UP_PRESSED.name(),
                RoadViewEvent.MOVE_UP_RELEASED.name(),
                RoadViewEvent.MOVE_DOWN_PRESSED.name(),
                RoadViewEvent.MOVE_DOWN_RELEASED.name(),

                RoadModelEvent.V_CHANGED.name(),

                PlayerViewEvent.MOVE_LEFT_PRESSED.name(),
                PlayerViewEvent.MOVE_LEFT_RELEASED.name(),
                PlayerViewEvent.MOVE_RIGHT_PRESSED.name(),
                PlayerViewEvent.MOVE_RIGHT_RELEASED.name(),

                RoadModelEvent.ROAD_FINISHED.name(),

                WindowEvent.CLOSE.name()
        );

        EventPublisher eventPublisher = new EventBus(events);

        ModeController modeController = new ModeController(eventPublisher);
        RaceController raceController = new RaceController(eventPublisher);
        RestartController restartController = new RestartController(eventPublisher);

        eventPublisher.subscribe(ModeViewEvent.SHOW.name(), e -> {
            stage.setScene(modeController.initializeScene());
            stage.setResizable(false);
            stage.show();
            moveToCenter(stage);
        });

        eventPublisher.subscribe(ModeModelEvent.MODE_INITIALIZED.name(), e -> {
            stage.setScene(raceController.initializeScene());
            stage.setResizable(false);
            stage.show();
            moveToCenter(stage);
        });

        eventPublisher.subscribe(RoadModelEvent.ROAD_FINISHED.name(), e -> {
            stage.setScene(restartController.initializeScene());
            stage.setResizable(false);
            stage.show();
            moveToCenter(stage);
        });

        eventPublisher.subscribe(WindowEvent.CLOSE.name(), e -> {
            stage.close();
        });

        eventPublisher.publish(ModeViewEvent.SHOW.name());
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