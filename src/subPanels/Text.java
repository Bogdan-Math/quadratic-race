package subPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Text extends JPanel {

	/**
	 * 
	 */

	public Text(String text) {
		setLayout(new BorderLayout());
		JLabel choose = new JLabel();
		choose.setText(text);
		choose.setFont(new Font("Verdana", Font.PLAIN, 12));
		choose.setForeground(new Color(127, 127, 127));
		choose.setVerticalAlignment(JLabel.CENTER);
		choose.setHorizontalAlignment(JLabel.CENTER);
		this.add(choose);
	}
}
