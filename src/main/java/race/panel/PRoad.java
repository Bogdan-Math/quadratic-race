package race.panel;

import race.effect.StatisticShow;
import race.event.KeysAdapter;
import race.frame.Road;
import race.logic.Collision;
import race.logic.Result;
import race.logic.Win;
import race.model.mode.ModeModel;
import race.object.Enemy;
import race.object.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static race.multimedia.sound.SoundResource.sound;

public class PRoad extends JPanel implements ActionListener, Runnable {

	private static final String MAIN_SOUND = "race/multimedia/sound/main.mp3";

	private ModeModel modeModel;
	private int winLine = 25000;

	public int getWinLine() {
		return this.winLine;
	}

	private Timer mainTimer = new Timer(25, this);

	private Image road = new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/road.png")).getImage();

	public Image getRoad() {
		return this.road;
	}

	private Player player = new Player(350, this.road.getHeight(null) - 175, 0,
			new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/player.png")).getImage(),
			new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/playerRight.png")).getImage(),
			new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/playerLeft.png")).getImage(), this);

	public Player getPlayer() {
		return this.player;
	}

	private StatisticShow speed = new StatisticShow(this);
	public Thread enemiesFactory = new Thread(this);
	public Thread audioThread = new Thread(() -> sound(MAIN_SOUND).play());

	private List<Enemy> enemies = new ArrayList<>();
	private Road Froad;

	public PRoad(ModeModel modeModel, Road Froad) {
		this.modeModel = modeModel;
		this.Froad = Froad;
		setPreferredSize(new Dimension(road.getWidth(null), road.getHeight(null)));
		mainTimer.start();
		enemiesFactory.start();
		audioThread.start();
		addKeyListener(new KeysAdapter(player));
		setFocusable(true);
	}

	public void paint(Graphics g) {
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
		Font font = new Font("Arial", Font.BOLD, 20);

		speed.showInformation(player.getBadEnemiesMiss(), g, font, green, "Left behind: +", 625, 25);
		speed.showInformation(player.getGoodEnemiesPicked(), g, font, red, "Picked up: +", 625, 50);
		speed.showInformation(player.getBadEnemiesPicked(), g, font, green, "Picked up: -", 625, 75);
		speed.showInformation(player.getGoodEnemiesMiss(), g, font, red, "Left behind: -", 625, 100);
	}

	private Win testWin 	= new Win(this, player);
	private Result result 	= new Result(testWin, this);

	public void actionPerformed(ActionEvent e) {
		player.move();
		repaint();

		enemies = Collision.unitVsUnits(enemies);
		enemies = Collision.removeEnemies(enemies, player);
		enemies = Collision.playerVsUnits(enemies, player);
	}

	@Override
	public void run() {
		while (true) {
			Random rand = new Random();
			try {
				Thread.sleep(rand.nextInt(modeModel.getMillisecondsInterval()));

				enemies.add(new Enemy(rand.nextInt(700), -200, rand.nextInt(50), rand.nextBoolean(), this));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
