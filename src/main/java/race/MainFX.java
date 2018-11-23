package race;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import race.controller.mode.EasyModeModelSetter;
import race.controller.mode.HardModeModelSetter;
import race.controller.mode.NormalModeModelSetter;
import race.event.EventPublisher;
import race.event.SimpleEventManager;
import race.model.ModeModel;
import race.view.mode.ModeView;
import race.view.mode.ModeViewEvent;

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

        ModeModel modeModel = new ModeModel();

        EventPublisher eventPublisher = new SimpleEventManager(ModeViewEvent.asStringList());
        eventPublisher.subscribe(ModeViewEvent.CLICK_EASY_MODE_BUTTON.name(), new EasyModeModelSetter(modeModel));
        eventPublisher.subscribe(ModeViewEvent.CLICK_NORMAL_MODE_BUTTON.name(), new NormalModeModelSetter(modeModel));
        eventPublisher.subscribe(ModeViewEvent.CLICK_HARD_MODE_BUTTON.name(), new HardModeModelSetter(modeModel));

        ModeView modeView = new ModeView(eventPublisher);
        stage.setScene(new Scene(modeView));
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