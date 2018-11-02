package race.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import race.object.Enemy;
import race.object.Player;
import race.logic.Collision;
import race.logic.Difficulty;
import race.logic.Result;
import race.logic.Win;
import race.effect.GlobalMusicMP3;
import race.effect.StatisticShow;
import race.event.KeysAdapter;
import race.frame.Road;

public class PRoad extends JPanel implements ActionListener, Runnable {

	private int difficulty;
	private int winLine = 25000;

	public int getWinLine() {
		return this.winLine;
	}

	private Timer mainTimer = new Timer(25, this);

	/* Image img = new ImageIcon("res/road.png").getImage(); */
	private Image road = new ImageIcon(getClass().getClassLoader().getResource("pictures/road.png")).getImage();

	public Image getRoad() {
		return this.road;
	}

	// private Image pressTab = new
	// ImageIcon(getClass().getClassLoader().getResource("pictures/TAB.png")).getImage();

	private Player player = new Player(350, this.road.getHeight(null) - 175, 0,
			new ImageIcon(getClass().getClassLoader().getResource("pictures/player.png")).getImage(),
			new ImageIcon(getClass().getClassLoader().getResource("pictures/playerRight.png")).getImage(),
			new ImageIcon(getClass().getClassLoader().getResource("pictures/playerLeft.png")).getImage(), this);

	public Player getPlayer() {
		return this.player;
	}

	private StatisticShow speed = new StatisticShow(this);
	public Thread enemiesFactory = new Thread(this);
	public Thread audioThread = new Thread(new GlobalMusicMP3());

	private List<Enemy> enemies = new ArrayList<Enemy>();
	private Road Froad;

	public PRoad(Difficulty difficulty, Road Froad) {
		this.Froad = Froad;
		setPreferredSize(new Dimension(road.getWidth(null), road.getHeight(null)));
		checkDifficulty(difficulty);
		mainTimer.start();
		enemiesFactory.start();
		audioThread.start();
		addKeyListener(new KeysAdapter(player));
		setFocusable(true);
	}

	private void checkDifficulty(Difficulty d) {
		if (d == Difficulty.easy) {
			this.difficulty = 1000;
		}
		if (d == Difficulty.normal) {
			this.difficulty = 500;
		}
		if (d == Difficulty.hard) {
			this.difficulty = 25;
		}
	}

	public void paint(Graphics g) {
		g = (Graphics2D) g;

		g.drawImage(road, 0, player.getLayer1(), null);
		g.drawImage(road, 0, player.getLayer2(), null);
		g.drawImage(road, 0, player.getLayer3(), null);
		g.drawImage(player.img, player.x, player.y, null);

		Collision.paintEnemies(g, enemies);

		speed.speedShow(g);
		speed.wayShow(g);
		speed.timeShow(g);

		result.showResult(Froad);

		Color green = new Color(237, 28, 36);
		Color red = new Color(34, 177, 76);
		Font font = new Font("Arial", Font.CENTER_BASELINE, 20);

		speed.showInformation(player.getBadEnemiesMiss(), g, font, green, "Left behind: +", 625, 25);
		speed.showInformation(player.getGoodEnemiesPicked(), g, font, red, "Picked up: +", 625, 50);
		speed.showInformation(player.getBadEnemiesPicked(), g, font, green, "Picked up: -", 625, 75);
		speed.showInformation(player.getGoodEnemiesMiss(), g, font, red, "Left behind: -", 625, 100);
	}

	Win testWin = new Win(this, player);
	Result result = new Result(testWin, this);

	public void actionPerformed(ActionEvent e) {
		player.move();
		repaint();

		enemies = Collision.enemyVsEnemies(enemies);
		enemies = Collision.removeEnemies(enemies, player);
		enemies = Collision.playerVsEnemies(enemies, player);
	}

	@Override
	public void run() {
		while (true) {
			Random rand = new Random();
			try {
				Thread.sleep(rand.nextInt(this.difficulty));

				enemies.add(new Enemy(rand.nextInt(700), -200, rand.nextInt(50), rand.nextBoolean(), this));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
