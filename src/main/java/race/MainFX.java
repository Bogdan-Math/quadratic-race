package race;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import race.bus.EventBus;
import race.bus.EventPublisher;
import race.mvc.controller.mode.ModeController;
import race.mvc.model.mode.ModeModelEvent;
import race.mvc.view.mode.ModeViewEvent;

import java.util.Arrays;
import java.util.List;

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

        List<String> events = Arrays.asList(
                ModeViewEvent.CLICK_EASY_MODE_BUTTON.name(),
                ModeViewEvent.CLICK_NORMAL_MODE_BUTTON.name(),
                ModeViewEvent.CLICK_HARD_MODE_BUTTON.name(),
                ModeModelEvent.MODE_INITIALIZED.name()
        );

        EventPublisher eventPublisher = new EventBus(events);

        stage.setScene(new ModeController(eventPublisher).getScene());
        stage.show();

        stage.setResizable(false);
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