package race.frame;

import race.panel.PStart;

public class Start extends BaseFrame {

	public Start() {
		add(new PStart(this));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
