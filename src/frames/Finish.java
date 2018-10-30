package frames;

import panels.PFinish;

public class Finish extends Basic {

	/**
	 * 
	 */

	public Finish() {
		add(new PFinish(this));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
