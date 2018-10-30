package objects;

import java.awt.Image;
import java.awt.Rectangle;

abstract class MovingUnit {

	private static final int MAX_SPEED = 100;
	private static final int MAX_LEFT = 0;
	private static final int MAX_RIGHT = 695;

	public static int getMaxSpeed() {
		return MAX_SPEED;
	}

	public static int getMaxLeft() {
		return MAX_LEFT;
	}

	public static int getMaxRight() {
		return MAX_RIGHT;
	}

	public Image img;

	public int s = 0;

	public int x;
	public int dx = 0;
	public int y;
	public int dy = 0;
	public int v;
	public int dv = 0;

	public Rectangle getRect() {
		return new Rectangle(this.x, this.y, img.getWidth(null), img.getHeight(null));
	}

}
