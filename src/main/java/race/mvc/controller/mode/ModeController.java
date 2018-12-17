package race.mvc.controller.mode;

import javafx.scene.Scene;
import race.bus.EventPublisher;
import race.bus.UIEvent;
import race.mvc.model.mode.ModeModel;
import race.mvc.model.mode.ModeModelEvent;
import race.mvc.view.mode.ModeView;

public class ModeController {

    private EventPublisher eventPublisher;

    public ModeController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;

        var modeModel = new ModeModel(eventPublisher);

        eventPublisher.subscribe(UIEvent.EASY_MODE_BUTTON_CLICKED,
                e -> modeModel.setEasyMode()
		);

        eventPublisher.subscribe(UIEvent.NORMAL_MODE_BUTTON_CLICKED,
                e -> modeModel.setNormalMode()
        );

        eventPublisher.subscribe(UIEvent.HARD_MODE_BUTTON_CLICKED,
                e -> modeModel.setHardMode()
        );

        eventPublisher.subscribe(ModeModelEvent.MODE_INITIALIZED,
                e -> System.out.println("done: " + e.name() + " " + modeModel.getMillisecondsInterval())
        );
    }

    public Scene initializeScene() {
        var modeView 	= new ModeView();
        var scene 		= new Scene(modeView);

        modeView.getEasyModeButton().setOnAction(e -> eventPublisher.publish(UIEvent.EASY_MODE_BUTTON_CLICKED));
        modeView.getNormalModeButton().setOnAction(e -> eventPublisher.publish(UIEvent.NORMAL_MODE_BUTTON_CLICKED));
        modeView.getHardModeButton().setOnAction(e -> eventPublisher.publish(UIEvent.HARD_MODE_BUTTON_CLICKED));

        return scene;
    }
}
