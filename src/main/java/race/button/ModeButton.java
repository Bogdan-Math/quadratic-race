package race.button;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import race.handler.ModeButtonClickEventHandler;
import race.logic.Mode;
import race.multimedia.image.ImageResource;


public class ModeButton extends Button {

    public ModeButton(String pathToImage, Mode mode) {
        setText(mode.name());
        setGraphic(new ImageView(new ImageResource().getImage(pathToImage)));
        setOnAction(new ModeButtonClickEventHandler(mode));
    }
}
