package race.view.mode;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class ModePane extends HBox {

    private static final String EASY = "EASY";
    private static final String NORMAL = "NORMAL";
    private static final String HARD = "HARD";

    private static final String EASY_BUTTON_PICTURE = "race/multimedia/image/1_easyButton.png";
    private static final String NORMAL_BUTTON_PICTURE = "race/multimedia/image/2_normalButton.png";
    private static final String HARD_BUTTON_PICTURE = "race/multimedia/image/3_hardButton.png";

    private static final int PADDING = 20;
    private static final int SPACING = PADDING / 2;

    private final ModeButton easyModeButton;
    private final ModeButton normalModeButton;
    private final ModeButton hardModeButton;

    public ModePane() {
        easyModeButton = new ModeButton(EASY_BUTTON_PICTURE, EASY);
        normalModeButton = new ModeButton(NORMAL_BUTTON_PICTURE, NORMAL);
        hardModeButton = new ModeButton(HARD_BUTTON_PICTURE, HARD);

        getChildren().addAll(
                easyModeButton,
                normalModeButton,
                hardModeButton
        );

        setPadding(new Insets(PADDING));
        setSpacing(SPACING);
    }

    public void setEasyModeButtonClickHandler(EventHandler<ActionEvent> clickHandler) {
        easyModeButton.setOnAction(clickHandler);
    }

    public void setNormalModeButtonClickHandler(EventHandler<ActionEvent> clickHandler) {
        normalModeButton.setOnAction(clickHandler);
    }

    public void setHardModeButtonClickHandler(EventHandler<ActionEvent> clickHandler) {
        hardModeButton.setOnAction(clickHandler);
    }
}
