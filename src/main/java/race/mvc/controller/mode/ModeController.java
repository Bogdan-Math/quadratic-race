package race.mvc.controller.mode;

import javafx.scene.Scene;
import javafx.stage.Stage;
import race.bus.EventPublisher;
import race.bus.model.mode.ModeModelHandler;
import race.bus.view.SceneSetter;
import race.bus.view.mode.EasyModeModelSetter;
import race.bus.view.mode.HardModeModelSetter;
import race.bus.view.mode.NormalModeModelSetter;
import race.mvc.model.mode.ModeModel;
import race.mvc.model.mode.ModeModelEvent;
import race.mvc.view.mode.ModeView;
import race.mvc.view.mode.ModeViewEvent;

public class ModeController {

    private ModeModel modeModel;
    private ModeView modeView;

    public ModeController(EventPublisher eventPublisher, Stage stage) {
        modeModel = new ModeModel(eventPublisher);
        modeView = new ModeView(eventPublisher);

        //subscribe on mode view events
        eventPublisher.subscribe(ModeViewEvent.SHOW.name(), new SceneSetter(stage, new Scene(modeView)));
        eventPublisher.subscribe(ModeViewEvent.CLICK_EASY_MODE_BUTTON.name(), new EasyModeModelSetter(modeModel));
        eventPublisher.subscribe(ModeViewEvent.CLICK_NORMAL_MODE_BUTTON.name(), new NormalModeModelSetter(modeModel));
        eventPublisher.subscribe(ModeViewEvent.CLICK_HARD_MODE_BUTTON.name(), new HardModeModelSetter(modeModel));

        //subscribe on mode model events
        eventPublisher.subscribe(ModeModelEvent.MODE_INITIALIZED.name(), new ModeModelHandler(modeModel));

    }

    public Scene getScene() {
        return new Scene(modeView);
    }
}
