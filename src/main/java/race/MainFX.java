package race;

import javafx.application.Application;
import javafx.stage.Stage;
import race.bus.EventBus;
import race.bus.EventPublisher;
import race.bus.view.SceneSetter;
import race.mvc.controller.mode.ModeController;
import race.mvc.controller.race.RaceController;
import race.mvc.controller.restart.RestartController;
import race.mvc.model.mode.ModeModelEvent;
import race.mvc.model.race.road.RoadModelEvent;
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

                RoadModelEvent.CHANGE_V.name(),

                PlayerViewEvent.MOVE_LEFT_PRESSED.name(),
                PlayerViewEvent.MOVE_LEFT_RELEASED.name(),
                PlayerViewEvent.MOVE_RIGHT_PRESSED.name(),
                PlayerViewEvent.MOVE_RIGHT_RELEASED.name(),

                "FINISH"
        );

        EventPublisher eventPublisher = new EventBus(events);

        ModeController modeController = new ModeController(eventPublisher);
        RaceController raceController = new RaceController(eventPublisher);
        RestartController restartController = new RestartController(eventPublisher);

        eventPublisher.subscribe(ModeModelEvent.MODE_INITIALIZED.name(), new SceneSetter(stage, raceController.initializeScene()));
        eventPublisher.subscribe("FINISH", new SceneSetter(stage, restartController.initializeScene()));

        eventPublisher.subscribe(ModeViewEvent.SHOW.name(), new SceneSetter(stage, modeController.initializeScene()));
        eventPublisher.publish(ModeViewEvent.SHOW.name());
    }

    private void fillHeaderFor(Stage stage) {
        stage.setTitle(TITLE);
        stage.getIcons().add(image(ICON));
    }

}