package frame;

import panel.PFinish;

public class Finish extends BaseFrame {

	public Finish() {
		add(new PFinish(this));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
