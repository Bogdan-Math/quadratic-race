package race.mvc.view.mode;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import race.bus.EventPublisher;

import static race.multimedia.image.ImageResource.image;

public class ModeView extends HBox {

    private static final String EASY = "EASY";
    private static final String NORMAL = "NORMAL";
    private static final String HARD = "HARD";

    private static final Image EASY_BUTTON_IMAGE = image("race/multimedia/image/1_easyButton.png");
    private static final Image NORMAL_BUTTON_IMAGE = image("race/multimedia/image/2_normalButton.png");
    private static final Image HARD_BUTTON_IMAGE = image("race/multimedia/image/3_hardButton.png");

    private static final int PADDING = 20;
    private static final int SPACING = PADDING / 2;

    private EventPublisher eventPublisher;
    private Button easyModeButton;
    private Button normalModeButton;
    private Button hardModeButton;

    public ModeView(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        this.easyModeButton = newModeButton(EASY_BUTTON_IMAGE, EASY);
        this.normalModeButton = newModeButton(NORMAL_BUTTON_IMAGE, NORMAL);
        this.hardModeButton = newModeButton(HARD_BUTTON_IMAGE, HARD);

        easyModeButton.setOnAction(e -> eventPublisher.publish(ModeViewEvent.CLICK_EASY_MODE_BUTTON.name()));
        normalModeButton.setOnAction(e -> eventPublisher.publish(ModeViewEvent.CLICK_NORMAL_MODE_BUTTON.name()));
        hardModeButton.setOnAction(e -> eventPublisher.publish(ModeViewEvent.CLICK_HARD_MODE_BUTTON.name()));

        getChildren().addAll(
                easyModeButton,
                normalModeButton,
                hardModeButton
        );

        setPadding(new Insets(PADDING));
        setSpacing(SPACING);
    }

    private Button newModeButton(Image image, String text) {
        var modeButton = new Button();
        modeButton.setText(text);
        modeButton .setGraphic(new ImageView(image));
        return modeButton;
    }
}
