package race.object;

import java.awt.Image;
import java.awt.Rectangle;

abstract class Unit {

	private static final int MAX_SPEED = 100;
	private static final int MAX_LEFT = 0;
	private static final int MAX_RIGHT = 695;

	public static int getMaxSpeed() {
		return MAX_SPEED;
	}

	static int getMaxLeft() {
		return MAX_LEFT;
	}

	static int getMaxRight() {
		return MAX_RIGHT;
	}

	public Image img;

	public int s = 0;

	public int x;
	public int y;
	public int v;

	int dx = 0;
	int dv = 0;

	public Rectangle getRectangle() {
		return new Rectangle(this.x, this.y, img.getWidth(null), img.getHeight(null));
	}

}
