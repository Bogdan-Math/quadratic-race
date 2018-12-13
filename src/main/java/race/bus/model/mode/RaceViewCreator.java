package race.bus.model.mode;

import race.bus.EventHandler;
import race.mvc.model.mode.ModeModel;

public class RaceViewCreator implements EventHandler {

    private ModeModel modeModel;

    public RaceViewCreator(ModeModel modeModel) {
        this.modeModel = modeModel;
    }

    @Override
    public void handle(Enum event) {
        System.out.println("done: " + event + " " + modeModel.getMillisecondsInterval());
    }
}
