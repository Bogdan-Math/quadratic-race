package race.controller.mode;

import javafx.scene.Scene;
import race.frame.Road;
import race.model.mode.ModeModel;
import race.view.mode.ModeView;

public class ModeController {

    private ModeModel modeModel;
    private ModeView modeView;

    public ModeController(ModeModel modeModel, ModeView modeView) {
        this.modeModel = modeModel;
        this.modeView = modeView;
        setHandlers();
    }

    private void setHandlers() {
        modeView.setEasyModeButtonClickHandler(event -> {
            modeModel.setEasyMode();
            new Road(modeModel);
        });

        modeView.setNormalModeButtonClickHandler(event -> {
            modeModel.setNormalMode();
            new Road(modeModel);
        });

        modeView.setHardModeButtonClickHandler(event -> {
            modeModel.setHardMode();
            new Road(modeModel);
        });
    }

    public Scene getModeScene() {
        return new Scene(modeView);
    }
}
