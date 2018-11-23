package race.controller.mode;

import race.model.ModeModel;

public class HardModeModelSetter extends AbstractModeModelSetter {

    public HardModeModelSetter(ModeModel modeModel) {
        super(modeModel);
    }

    @Override
    public void handle(String event) {
        System.out.println(event);
        this.modeModel.setHardMode();
    }
}
