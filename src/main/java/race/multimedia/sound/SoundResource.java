package race.multimedia.sound;

import javafx.scene.media.AudioClip;

import java.net.URL;

import static java.util.Objects.requireNonNull;

public class SoundResource {

    private static final String MAIN_SOUND = "race/multimedia/sound/main.mp3";

    public AudioClip getSound() {
        URL notNullURL = requireNonNull(getClass().getClassLoader().getResource(MAIN_SOUND));
        return new AudioClip(notNullURL.toExternalForm());
    }
}
