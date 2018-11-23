package race.controller.mode;

import race.model.ModeModel;

public class EasyModeModelSetter extends AbstractModeModelSetter {

    public EasyModeModelSetter(ModeModel modeModel) {
        super(modeModel);
    }

    @Override
    public void handle(String event) {
        System.out.println(event);
        this.modeModel.setEasyMode();
    }
}
