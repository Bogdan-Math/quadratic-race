package race.bus.view.mode;

import race.bus.EventHandler;
import race.mvc.model.mode.ModeModel;

abstract class AbstractModeModelSetter implements EventHandler {

    ModeModel modeModel;

    AbstractModeModelSetter(ModeModel modeModel) {
        this.modeModel = modeModel;
    }
}
