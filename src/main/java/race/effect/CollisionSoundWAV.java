package race.effect;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class CollisionSoundWAV {

	public void getBad() throws Throwable {
		playSound("sounds/collision.wav");
	}

	public void getGood() throws Throwable {
		playSound("sounds/takeOne.wav");
	}

	private void playSound(String resource) throws Throwable {
		Clip c = AudioSystem.getClip();
		AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(resource));
		c.open(ais);
		c.loop(0);

	}
}
