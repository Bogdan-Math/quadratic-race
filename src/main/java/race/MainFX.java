package race;

import javafx.application.Application;
import javafx.stage.Stage;
import race.bus.EventBus;
import race.bus.EventPublisher;
import race.mvc.controller.mode.ModeController;
import race.mvc.controller.road.RoadController;
import race.mvc.model.mode.ModeModelEvent;
import race.mvc.view.mode.ModeViewEvent;

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

                ModeModelEvent.MODE_INITIALIZED.name()
        );

        EventPublisher eventPublisher = new EventBus(events);

        new ModeController(eventPublisher, stage);
        new RoadController(eventPublisher, stage);

        eventPublisher.publish(ModeViewEvent.SHOW.name());
    }

    private void fillHeaderFor(Stage stage) {
        stage.setTitle(TITLE);
        stage.getIcons().add(image(ICON));
    }

}