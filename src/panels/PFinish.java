package panels;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import subPanels.FinishButtons;
import subPanels.Text;

public class PFinish extends JPanel {

	/**
	 * 
	 */

	public PFinish(JFrame buttonsFrame) {
		setLayout(new GridLayout(2, 1));
		add(new Text("aaand???"));
		add(new FinishButtons(buttonsFrame));
	}
}
