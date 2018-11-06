package race.pane;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import race.button.ModeButton;
import race.logic.Mode;

public class ModePane extends HBox {

    private static final int PADDING = 20;
    private static final int SPACING = PADDING / 2;

    public ModePane() {
        setPadding(new Insets(PADDING));
        setSpacing(SPACING);

        getChildren().addAll(
                new ModeButton(Mode.EASY),
                new ModeButton(Mode.NORMAL),
                new ModeButton(Mode.HARD)
        );
    }
}
