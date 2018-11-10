package race.effect;

import javafx.scene.media.AudioClip;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

import static java.util.Objects.requireNonNull;

public class CollisionSoundWAV {

	public void getBad() {
		playSound("race/multimedia/sound/collision.wav");
	}

	public void getGood() {
		playSound("race/multimedia/sound/takeOne.wav");
	}

	private void playSound(String resource) {
		URL notNullURL = requireNonNull(getClass().getClassLoader().getResource(resource));
		new AudioClip(notNullURL.toExternalForm()).play();

//		Clip c = AudioSystem.getClip();
//		AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(resource));
//		c.open(ais);
//		c.loop(0);

	}
}
