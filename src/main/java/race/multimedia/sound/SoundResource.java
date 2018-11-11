package race.multimedia.sound;

import javafx.scene.media.AudioClip;

import java.net.URL;

import static java.util.Objects.requireNonNull;

public class SoundResource {

    public AudioClip getSound(String pathToSound) {
        URL url = requireNonNull(getClass().getClassLoader().getResource(pathToSound));
        return new AudioClip(url.toExternalForm());
    }
}
