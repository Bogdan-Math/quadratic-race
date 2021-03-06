package race.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import race.object.Player;

public class KeysAdapter extends KeyAdapter {

	private Player p;

	public KeysAdapter(Player p) {
		this.p = p;
	}

	public void keyPressed(KeyEvent e) {
		p.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		p.keyReleased(e);
	}
}
