package panels;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import subPanels.StartButtons;
import subPanels.Text;

public class PStart extends JPanel {

	/**
	 * 
	 */
	public PStart(JFrame buttonsFrame) {
		setLayout(new GridLayout(2, 1));
		add(new Text("Choose your difficulty"));
		add(new StartButtons(buttonsFrame));
	}
}
