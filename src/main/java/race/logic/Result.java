package race.logic;

import java.awt.Image;
import javax.swing.ImageIcon;

import race.frame.Finish;
import race.frame.Picture;
import race.frame.Road;
import race.panel.PRoad;

public class Result {

	private Image imgGood = new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/resultGood.png"))
			.getImage();
	private Image imgBad = new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/resultBad.png")).getImage();
	private Image imgAngel = new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/resultAngel.png"))
			.getImage();
	private Image imgDevil = new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/resultDevil.png"))
			.getImage();
	private Image imgNeutral = new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/resultNeutral.png"))
			.getImage();

	private Image img = imgNeutral;

	private Win testWin;
	private PRoad road;

	public Result(Win testWin, PRoad road) {
		this.testWin = testWin;
		this.road = road;
	}

	private void quality(int quality, int max, int min) {

		if (quality > 0) {
			if (quality == max) {
				img = imgAngel;
			} else {
				img = imgGood;
			}
		}

		if (quality == 0) {
			img = imgNeutral;
		}

		if (quality < 0) {
			if (quality == -min) {
				img = imgDevil;
			} else {
				img = imgBad;
			}
		}

	}

	@SuppressWarnings("deprecation")
	public void showResult(Road roadFrame) {
		if (testWin.line()) {

			road.audioThread.stop();// deprecation
			road.enemiesFactory.stop();// deprecation

			quality(Win.getGlobalQuality(),
					road.getPlayer().getBadEnemiesMiss() + road.getPlayer().getGoodEnemiesPicked(),
					road.getPlayer().getGoodEnemiesMiss() + road.getPlayer().getBadEnemiesPicked());

			new Picture(img);
			Win.setGlobalQuality(0);
			new Finish();
			roadFrame.dispose();
		}
	}
}
