package logic;

import object.Player;
import panel.PRoad;

public class Win {

	private PRoad road;
	private Player p;
	private static int globalQuality = 0;

	// public Enemy enemy;

	public Win(PRoad road, Player p) {
		this.road = road;
		this.p = p;
	}

	public boolean line() {
		if (p.s >= road.getWinLine()) {
			return true;
		} else
			return false;
	}

	public static int getGlobalQuality() {
		return globalQuality;
	}

	public static void setGlobalQuality(int globalQuality) {
		Win.globalQuality = globalQuality;
	}
}
