package object;

import javax.swing.ImageIcon;

import panel.PRoad;

public class Enemy extends MovingUnit {

	private PRoad road;

	private boolean enemy;

	public boolean getEnemy() {
		return enemy;
	}

	public Enemy(int x, int y, int v, boolean enemy, PRoad road) {
		this.enemy = enemy;
		if (enemy == true) {
			this.img = new ImageIcon(getClass().getClassLoader().getResource("pictures/enemyGood.png")).getImage();
		} else {
			this.img = new ImageIcon(getClass().getClassLoader().getResource("pictures/enemyBad.png")).getImage();
		}
		this.x = x;
		this.y = y;
		this.v = v;
		this.road = road;
	}

	public void move() {
		y = y + road.getPlayer().v - v;
	}

}
