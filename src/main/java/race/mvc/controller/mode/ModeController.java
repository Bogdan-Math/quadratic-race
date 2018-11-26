package race.mvc.controller.mode;

import javafx.scene.Scene;
import race.bus.EventPublisher;
import race.bus.model.mode.RaceViewCreator;
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

    private EventPublisher eventPublisher;

    public ModeController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;

        modeModel = new ModeModel(eventPublisher);
        modeView = new ModeView();

        //subscribe on mode view events
        eventPublisher.subscribe(ModeViewEvent.CLICK_EASY_MODE_BUTTON.name(), new EasyModeModelSetter(modeModel));
        eventPublisher.subscribe(ModeViewEvent.CLICK_NORMAL_MODE_BUTTON.name(), new NormalModeModelSetter(modeModel));
        eventPublisher.subscribe(ModeViewEvent.CLICK_HARD_MODE_BUTTON.name(), new HardModeModelSetter(modeModel));

        //subscribe on mode model events
        eventPublisher.subscribe(ModeModelEvent.MODE_INITIALIZED.name(), new RaceViewCreator(modeModel));
    }

    public Scene initializeScene() {
        Scene scene = new Scene(modeView);

        modeView.getEasyModeButton().setOnAction(e -> eventPublisher.publish(ModeViewEvent.CLICK_EASY_MODE_BUTTON.name()));
        modeView.getNormalModeButton().setOnAction(e -> eventPublisher.publish(ModeViewEvent.CLICK_NORMAL_MODE_BUTTON.name()));
        modeView.getHardModeButton().setOnAction(e -> eventPublisher.publish(ModeViewEvent.CLICK_HARD_MODE_BUTTON.name()));

        return scene;
    }
}
