package race.logic;

import race.object.Enemy;
import race.object.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static race.multimedia.sound.SoundResource.sound;

public class Collision {

	private static final String COLLISION_WITH_GOOD_UNIT_SOUND 	= "race/multimedia/sound/collision_with_good_unit.wav";
	private static final String COLLISION_WITH_BAD_UNIT_SOUND 	= "race/multimedia/sound/collision_with_bad_unit.wav";

	public static List<Enemy> unitVsUnits(List<Enemy> enemies) {

		List<Enemy> changedEnemies = new ArrayList<>(enemies);

		for (int i = 0; i < changedEnemies.size(); i++) {
			for (int j = i + 1; j < changedEnemies.size(); j++) {
				if (changedEnemies.get(i).getRectangle().intersects(changedEnemies.get(j).getRectangle())) {
					changedEnemies.remove(j);
				}
			}
		}
		return changedEnemies;
	}

	public static List<Enemy> playerVsUnits(List<Enemy> enemies, Player p) {

		List<Enemy> changedEnemies = new ArrayList<>(enemies);

		Iterator<Enemy> i = changedEnemies.iterator();
		while (i.hasNext()) {
			Enemy e = i.next();
			if (p.getRectangle().intersects(e.getRectangle())) {
				i.remove();
				if (e.getEnemy() == true) {
					p.setGoodEnemiesPicked(p.getGoodEnemiesPicked() + 1);
					Win.setGlobalQuality(Win.getGlobalQuality() + 1);
					new Thread(() -> sound(COLLISION_WITH_GOOD_UNIT_SOUND).play()).start();
				} else {
					p.setBadEnemiesPicked(p.getBadEnemiesPicked() + 1);
					Win.setGlobalQuality(Win.getGlobalQuality() - 1);
					new Thread(() -> sound(COLLISION_WITH_BAD_UNIT_SOUND).play()).start();
					// JOptionPane.showMessageDialog(null, "Loooose !!!");
					// System.exit(1);
				}
			}
		}
		return changedEnemies;
	}

	public static List<Enemy> removeEnemies(List<Enemy> enemies, Player p) {

		List<Enemy> changedEnemies = new ArrayList<>(enemies);

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
		List<Enemy> syncEnemies = new ArrayList<>(enemies);
		for (Enemy e : syncEnemies) {
			e.move();
			g.drawImage(e.img, e.x, e.y, null);
		}
	}

}
