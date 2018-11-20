package race.controller.mode;

import javafx.scene.Scene;
import race.frame.Road;
import race.model.Mode;
import race.view.mode.ModeView;

public class ModeController {

    private Mode mode;
    private ModeView modeView;

    public ModeController(Mode mode, ModeView modeView) {
        this.mode = mode;
        this.modeView = modeView;
    }


}
