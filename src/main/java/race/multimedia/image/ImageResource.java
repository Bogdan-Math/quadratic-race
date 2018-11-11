package race.multimedia.image;

import javafx.scene.image.Image;

import java.io.InputStream;

import static java.util.Objects.requireNonNull;

public class ImageResource {

    public static Image image(String pathToImage) {
        InputStream inputStream = requireNonNull(ImageResource.class.getClassLoader().getResourceAsStream(pathToImage));
        return new Image(inputStream);
    }
}
