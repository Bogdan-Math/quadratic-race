package race.mvc.controller.mode;

import javafx.scene.Scene;
import race.bus.EventPublisher;
import race.mvc.model.mode.ModeModel;
import race.mvc.model.mode.ModeModelEvent;
import race.mvc.view.mode.ModeView;
import race.mvc.view.mode.ModeViewEvent;

public class ModeController {

    private EventPublisher eventPublisher;

    public ModeController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;

        var modeModel = new ModeModel(eventPublisher);

        eventPublisher.subscribe(ModeViewEvent.CLICK_EASY_MODE_BUTTON,
                e -> modeModel.setEasyMode()
		);

        eventPublisher.subscribe(ModeViewEvent.CLICK_NORMAL_MODE_BUTTON,
                e -> modeModel.setNormalMode()
        );

        eventPublisher.subscribe(ModeViewEvent.CLICK_HARD_MODE_BUTTON,
                e -> modeModel.setHardMode()
        );

        eventPublisher.subscribe(ModeModelEvent.MODE_INITIALIZED,
                e -> System.out.println("done: " + e.name() + " " + modeModel.getMillisecondsInterval())
        );
    }

    public Scene initializeScene() {
        var modeView 	= new ModeView();
        var scene 		= new Scene(modeView);

        modeView.getEasyModeButton().setOnAction(e -> eventPublisher.publish(ModeViewEvent.CLICK_EASY_MODE_BUTTON));
        modeView.getNormalModeButton().setOnAction(e -> eventPublisher.publish(ModeViewEvent.CLICK_NORMAL_MODE_BUTTON));
        modeView.getHardModeButton().setOnAction(e -> eventPublisher.publish(ModeViewEvent.CLICK_HARD_MODE_BUTTON));

        return scene;
    }
}
