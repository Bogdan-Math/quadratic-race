package race.controller.mode;

import race.frame.Road;
import race.model.mode.ModeModel;
import race.view.mode.ModePane;

public class ModeController {

    private ModeModel modeModel;
    private ModePane modePane;

    public ModeController(ModeModel modeModel, ModePane modePane) {
        this.modeModel = modeModel;
        this.modePane = modePane;
        setHandlers();
    }

    private void setHandlers() {
        modePane.setEasyModeButtonClickHandler(event -> {
            modeModel.setEasyMode();
            new Road(modeModel);
        });

        modePane.setNormalModeButtonClickHandler(event -> {
            modeModel.setNormalMode();
            new Road(modeModel);
        });

        modePane.setHardModeButtonClickHandler(event -> {
            modeModel.setHardMode();
            new Road(modeModel);
        });
    }
}
