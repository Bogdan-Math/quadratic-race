package race.object;

import java.awt.Image;
import java.awt.event.KeyEvent;

import race.panel.PRoad;

import javax.swing.*;

public class Player extends Unit {

	private final Image imgRight;
	private final Image imgLeft;
	private final Image imgCenter;

	private int high;

	public Player(int x, int y, int v, PRoad road) {
		this.imgCenter = new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/player.png")).getImage();
		this.imgRight = new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/playerRight.png")).getImage();
		this.imgLeft = new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/playerLeft.png")).getImage();
		this.img = imgCenter;
		this.x = x;
		this.y = y;
		this.v = v;
		this.high = road.getRoad().getHeight(null);
	}

	private int goodEnemiesMiss = 0;

	public int getGoodEnemiesMiss() {
		return goodEnemiesMiss;
	}

	public void setGoodEnemiesMiss(int goodEnemiesMiss) {
		this.goodEnemiesMiss = goodEnemiesMiss;
	}

	private int goodEnemiesPicked = 0;

	public int getGoodEnemiesPicked() {
		return goodEnemiesPicked;
	}

	public void setGoodEnemiesPicked(int goodEnemiesPicked) {
		this.goodEnemiesPicked = goodEnemiesPicked;
	}

	private int badEnemiesMiss = 0;

	public int getBadEnemiesMiss() {
		return badEnemiesMiss;
	}

	public void setBadEnemiesMiss(int badEnemiesMiss) {
		this.badEnemiesMiss = badEnemiesMiss;
	}

	private int badEnemiesPicked = 0;

	public int getBadEnemiesPicked() {
		return badEnemiesPicked;
	}

	public void setBadEnemiesPicked(int badEnemiesPicked) {
		this.badEnemiesPicked = badEnemiesPicked;
	}

	private int layer1 = -2 * high;
	private int layer2 = -high;
	private int layer3 = 0;

	public void move() {
		s += v;

		v -= dv;
		if (v <= 0)
			v = 0;
		if (v >= getMaxSpeed())
			v = getMaxSpeed();

		x -= dx;
		if (x <= getMaxLeft())
			x = getMaxLeft();
		if (x >= getMaxRight())
			x = getMaxRight();

		if (getLayer2() + v >= 0) {
			setLayer1(-2 * high);
			setLayer2(-high);
			setLayer3(0);
		} else {
			setLayer1(getLayer1() + v);
			setLayer2(getLayer2() + v);
			setLayer3(getLayer3() + v);
		}

	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP)) {
			dv = -1;
		}
		if ((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN)) {
			dv = 3;
		}
		if ((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT)) {
			dx = -10;
			img = imgRight;
		}
		if ((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT)) {
			dx = 10;
			img = imgLeft;
		}
	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP)) {
			dv = 1;
		}
		if ((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN)) {
			dv = 1;
		}
		if (key == KeyEvent.VK_D || key == KeyEvent.VK_A || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
			dx = 0;
			img = imgCenter;
		}

	}

	public int getLayer1() {
		return layer1;
	}

	public void setLayer1(int layer1) {
		this.layer1 = layer1;
	}

	public int getLayer2() {
		return layer2;
	}

	public void setLayer2(int layer2) {
		this.layer2 = layer2;
	}

	public int getLayer3() {
		return layer3;
	}

	public void setLayer3(int layer3) {
		this.layer3 = layer3;
	}

}
