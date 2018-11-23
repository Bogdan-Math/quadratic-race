package race.controller.mode;

import race.event.EventHandler;
import race.model.ModeModel;

abstract class AbstractModeModelSetter implements EventHandler {

    ModeModel modeModel;

    AbstractModeModelSetter(ModeModel modeModel) {
        this.modeModel = modeModel;
    }
}
