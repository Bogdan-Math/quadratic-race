package race.picture;

import java.io.InputStream;

public class PictureReader {

    public static InputStream readPictureAsInputStream(String pathToPicture) {
        return PictureReader.class.getClassLoader().getResourceAsStream(pathToPicture);
    }
}
