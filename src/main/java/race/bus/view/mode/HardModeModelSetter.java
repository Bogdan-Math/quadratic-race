package race.bus.view.mode;

import race.mvc.model.mode.ModeModel;

public class HardModeModelSetter extends AbstractModeModelSetter {

    public HardModeModelSetter(ModeModel modeModel) {
        super(modeModel);
    }

    @Override
    public void handle(Enum event) {
        System.out.println(event);
        this.modeModel.setHardMode();
    }
}
