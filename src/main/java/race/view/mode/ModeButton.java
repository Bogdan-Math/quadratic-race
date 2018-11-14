package race.view.mode;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import static race.multimedia.image.ImageResource.image;

//TODO: moveUp to ModeView
class ModeButton extends Button {

    ModeButton(String pathToImage, String text) {
        setText(text);
        setGraphic(new ImageView(image(pathToImage)));
    }
}
