package race.button;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import race.handler.ModeButtonClickEventHandler;
import race.logic.Mode;

import static race.multimedia.image.ImageResource.image;


public class ModeButton extends Button {

    public ModeButton(String pathToImage, Mode mode) {
        setText(mode.name());
        setGraphic(new ImageView(image(pathToImage)));
        setOnAction(new ModeButtonClickEventHandler(mode));
    }
}
