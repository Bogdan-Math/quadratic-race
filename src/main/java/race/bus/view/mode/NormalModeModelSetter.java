package race.bus.view.mode;

import race.mvc.model.mode.ModeModel;

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
