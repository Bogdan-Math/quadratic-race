package race.view.mode;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import static race.multimedia.image.ImageResource.image;

//TODO: move to ModeMane
class ModeButton extends Button {

    ModeButton(String pathToImage, String text) {
        setText(text);
        setGraphic(new ImageView(image(pathToImage)));
    }
}
