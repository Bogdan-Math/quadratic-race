package race.multimedia.image;

import javafx.scene.image.Image;

public class ImageResource {

    public Image getImage(String pathToImage) {
        return new Image(getClass().getClassLoader().getResourceAsStream(pathToImage));
    }
}
