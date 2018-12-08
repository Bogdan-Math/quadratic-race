package race.mvc.view.restart;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import static race.multimedia.image.ImageResource.image;

public class RestartView extends HBox {

    private static final String RESTART = "RESTART";
    private static final String CLOSE = "CLOSE";

    private static final Image RESTART_BUTTON_IMAGE = image("race/multimedia/image/1_easyButton.png");
    private static final Image CLOSE_BUTTON_IMAGE = image("race/multimedia/image/2_normalButton.png");

    private static final int PADDING = 20;
    private static final int SPACING = PADDING / 2;

    private Button restartButton;
    private Button closeButton;

    public RestartView() {
        this.restartButton = newRestartViewButton(RESTART_BUTTON_IMAGE, RESTART);
        this.closeButton = newRestartViewButton(CLOSE_BUTTON_IMAGE, CLOSE);

        getChildren().addAll(
                restartButton,
                closeButton
        );

        setPadding(new Insets(PADDING));
        setSpacing(SPACING);
    }

    private Button newRestartViewButton(Image image, String text) {
        var modeButton = new Button();
        modeButton.setText(text);
        modeButton.setGraphic(new ImageView(image));
        return modeButton;
    }

    public Button getRestartButton() {
        return restartButton;
    }

    public Button getCloseButton() {
        return closeButton;
    }
}
