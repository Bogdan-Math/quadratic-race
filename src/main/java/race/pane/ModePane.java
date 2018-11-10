package race.pane;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import race.button.ModeButton;
import race.logic.Mode;

public class ModePane extends HBox {

    private static final int PADDING = 20;
    private static final int SPACING = PADDING / 2;

    private static final String EASY_BUTTON_PICTURE = "race/multimedia/image/1_easyButton.png";
    private static final String NORMAL_BUTTON_PICTURE = "race/multimedia/image/2_normalButton.png";
    private static final String HARD_BUTTON_PICTURE = "race/multimedia/image/3_hardButton.png";

    public ModePane() {
        setPadding(new Insets(PADDING));
        setSpacing(SPACING);

        getChildren().addAll(
                new ModeButton(EASY_BUTTON_PICTURE, Mode.EASY),
                new ModeButton(NORMAL_BUTTON_PICTURE, Mode.NORMAL),
                new ModeButton(HARD_BUTTON_PICTURE, Mode.HARD)
        );
    }
}
