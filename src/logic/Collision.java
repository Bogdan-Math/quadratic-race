package logic;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import object.Enemy;
import object.Player;
import effect.CollisionSoundWAV;

public class Collision {

	public static List<Enemy> enemyVsEnemies(List<Enemy> enemies) {

		List<Enemy> changedEnemies = new ArrayList<Enemy>(enemies);

		for (int i = 0; i < changedEnemies.size(); i++) {
			for (int j = i + 1; j < changedEnemies.size(); j++) {
				if (changedEnemies.get(i).getRect().intersects(changedEnemies.get(j).getRect())) {
					changedEnemies.remove(j);
				}
			}
		}
		return changedEnemies;
	}

	public static List<Enemy> playerVsEnemies(List<Enemy> enemies, Player p) {

		CollisionSoundWAV sound = new CollisionSoundWAV();
		List<Enemy> changedEnemies = new ArrayList<Enemy>(enemies);

		Iterator<Enemy> i = changedEnemies.iterator();
		while (i.hasNext()) {
			Enemy e = i.next();
			if (p.getRect().intersects(e.getRect())) {
				i.remove();
				if (e.getEnemy() == true) {
					p.setGoodEnemiesPicked(p.getGoodEnemiesPicked() + 1);
					Win.setGlobalQuality(Win.getGlobalQuality() + 1);
					try {
						sound.getGood();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				} else {
					p.setBadEnemiesPicked(p.getBadEnemiesPicked() + 1);
					Win.setGlobalQuality(Win.getGlobalQuality() - 1);
					try {
						sound.getBad();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
					// JOptionPane.showMessageDialog(null, "Loooose !!!");
					// System.exit(1);
				}
			}
		}
		return changedEnemies;
	}

	public static List<Enemy> removeEnemies(List<Enemy> enemies, Player p) {

		List<Enemy> changedEnemies = new ArrayList<Enemy>(enemies);

		Iterator<Enemy> i = changedEnemies.iterator();
		while (i.hasNext()) {
			Enemy e = i.next();
			if (e.y <= -801) {
				i.remove();
			} else if (e.y >= 801) {
				i.remove();
				if (e.getEnemy() == true) {
					p.setGoodEnemiesMiss(p.getGoodEnemiesMiss() + 1);
					Win.setGlobalQuality(Win.getGlobalQuality() - 1);
				} else {
					p.setBadEnemiesMiss(p.getBadEnemiesMiss() + 1);
					Win.setGlobalQuality(Win.getGlobalQuality() + 1);
				}
			}
		}
		return changedEnemies;
	}

	public static void paintEnemies(Graphics g, List<Enemy> enemies) {

		g = (Graphics2D) g;
		// Enemy e = null;

		List<Enemy> syncEnemies = new ArrayList<Enemy>(enemies);
		// List<Enemy> syncEnemies = new CopyOnWriteArrayList<Enemy>(enemies);//
		// /////////!!!!!!!
		Iterator<Enemy> i = syncEnemies.iterator();

		while (i.hasNext()) {
			Enemy e = i.next();/////////// ??????????????????
			e.move();
			g.drawImage(e.img, e.x, e.y, null);
		}
	}

}
