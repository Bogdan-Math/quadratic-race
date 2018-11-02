package race.frame;

import race.panel.PFinish;

public class Finish extends BaseFrame {

	public Finish() {
		add(new PFinish(this));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
