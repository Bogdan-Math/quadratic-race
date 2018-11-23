package race.controller.mode;

import race.model.ModeModel;

public class NormalModeModelSetter extends AbstractModeModelSetter {

    public NormalModeModelSetter(ModeModel modeModel) {
        super(modeModel);
    }

    @Override
    public void handle(String event) {
        System.out.println(event);
        this.modeModel.setNormalMode();
    }
}
