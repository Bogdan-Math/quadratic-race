package race.image;

import javafx.scene.image.Image;

public class ImageReader {

    public static Image readImage(String pathToPicture) {
        return new Image(ImageReader.class.getClassLoader().getResourceAsStream(pathToPicture));
    }
}
