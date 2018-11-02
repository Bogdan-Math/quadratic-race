package race.panel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import race.event.FinishButtonsAdapter;

public class PFinish extends JPanel {

	private Image buttonEasy = new ImageIcon(getClass().getClassLoader().getResource("pictures/restart.png"))
			.getImage();

	private Image buttonNormal = new ImageIcon(getClass().getClassLoader().getResource("pictures/close.png"))
			.getImage();


	public PFinish(JFrame buttonsFrame) {
		setLayout(new GridLayout(2, 1));
		add(new Text("aaand???"));
		add(new FinishButtons(buttonsFrame));
	}

	class FinishButtons extends JPanel {


		FinishButtons(JFrame buttonsFrame) {

			JButton b1 = new JButton("restart");
			JButton b2 = new JButton("close");

			b1.setIcon(new ImageIcon(buttonEasy));
			b1.setVerticalTextPosition(AbstractButton.BOTTOM);
			b1.setHorizontalTextPosition(AbstractButton.CENTER);

			b2.setIcon(new ImageIcon(buttonNormal));
			b2.setVerticalTextPosition(AbstractButton.BOTTOM);
			b2.setHorizontalTextPosition(AbstractButton.CENTER);

			b1.addActionListener(new FinishButtonsAdapter(buttonsFrame));
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});

			add(b1);
			add(b2);
		}
	}

}
