package frames;

import panels.PStart;

public class Start extends Basic {

	/**
	 * 
	 */

	public Start() {
		add(new PStart(this));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
