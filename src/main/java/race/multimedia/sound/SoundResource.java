package race.multimedia.sound;

import javafx.scene.media.AudioClip;

import java.net.URL;

import static java.util.Objects.requireNonNull;

public class SoundResource {

    public static AudioClip sound(String pathToSound) {
        URL url = requireNonNull(SoundResource.class.getClassLoader().getResource(pathToSound));
        return new AudioClip(url.toExternalForm());
    }
}
