package race.multimedia.image;

import javafx.scene.image.Image;

import java.io.InputStream;

import static java.util.Objects.requireNonNull;

public class ImageResource {

    public Image getImage(String pathToImage) {
        InputStream inputStream = requireNonNull(getClass().getClassLoader().getResourceAsStream(pathToImage));
        return new Image(inputStream);
    }
}
