package race.bus.mode.model;

import race.bus.EventHandler;
import race.mvc.model.mode.ModeModel;

public class ModeModelHandler implements EventHandler {

    private ModeModel modeModel;

    public ModeModelHandler(ModeModel modeModel) {
        this.modeModel = modeModel;
    }

    @Override
    public void handle(String event) {
        System.out.println("done: " + event + " " + modeModel.getMillisecondsInterval());
    }
}
