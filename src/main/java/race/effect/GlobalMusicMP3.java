package race.effect;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class GlobalMusicMP3 implements Runnable {

	@Override
	public void run() {
		try {
			//TODO: move sound to correct directory
			Player globalSound = new Player(getClass().getClassLoader().getResourceAsStream("sounds/sound.mp3"));
			globalSound.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
}
