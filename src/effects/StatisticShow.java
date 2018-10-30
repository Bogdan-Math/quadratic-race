package effects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import objects.Player;
import panels.PRoad;

public class StatisticShow extends JPanel {

	/**
	 * 
	 */

	private static final double TIME_START = System.currentTimeMillis();
	private PRoad road;

	public StatisticShow(PRoad road) {
		this.road = road;
	}

	public void showInformation(int i, Graphics g, Font font, Color color, String s, int x, int y) {
		g = (Graphics2D) g;
		g.setFont(font);
		g.setColor(color);
		g.drawString(s + i, x, y);
	}

	public void wayShow(Graphics g) {
		g = (Graphics2D) g;
		int way = road.getPlayer().s;
		g.setColor(new Color(112, 146, 190));
		Font font = new Font("Arial", Font.CENTER_BASELINE, 20);
		g.setFont(font);
		g.drawString("Way  " + way + " : " + road.getWinLine() + " m", 10, 25);
	}

	public void speedShow(Graphics g) {
		g = (Graphics2D) g;
		double v = (100 / Player.getMaxSpeed()) * road.getPlayer().v;
		g.setColor(Color.BLACK);
		Font font = new Font("Arial", Font.CENTER_BASELINE, 20);
		g.setFont(font);
		g.drawString("Speed: " + v + " m/s", 625, road.getRoad().getHeight(null) - 50);
	}

	public void timeShow(Graphics g) {

		g = (Graphics2D) g;
		double t = System.currentTimeMillis();
		double T = Math.rint(((t - TIME_START) / 1000) * 10.0) / 10.0;
		g.setColor(Color.BLACK);
		Font font = new Font("Arial", Font.CENTER_BASELINE, 20);
		g.setFont(font);
		g.drawString("Your time = " + T + " s", 10, road.getRoad().getHeight(null) - 50);
	}
}
