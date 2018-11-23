package race.panel;

import race.event.StartButtonsAdapter;
import race.model.ModeModel;

import java.awt.*;

import javax.swing.*;

public class PStart extends JPanel {

	private Image buttonEasy = new ImageIcon(getClass().getClassLoader().getResource("race/picture/1_easyButton.png"))
			.getImage();

	private Image buttonNormal = new ImageIcon(getClass().getClassLoader().getResource("race/picture/2_normalButton.png"))
			.getImage();

	private Image buttonHard = new ImageIcon(getClass().getClassLoader().getResource("race/picture/3_hardButton.png"))
			.getImage();

	public PStart(JFrame buttonsFrame) {
		setLayout(new GridLayout(2, 1));
		add(new Text("Choose your difficulty"));
		add(new StartButtons(buttonsFrame));
	}

	class StartButtons extends JPanel {

		StartButtons(JFrame buttonsFrame) {

			JButton b1 = new JButton("easy");
			JButton b2 = new JButton("normal");
			JButton b3 = new JButton("hard");

			b1.setIcon(new ImageIcon(buttonEasy));
			b1.setVerticalTextPosition(AbstractButton.BOTTOM);
			b1.setHorizontalTextPosition(AbstractButton.CENTER);

			b2.setIcon(new ImageIcon(buttonNormal));
			b2.setVerticalTextPosition(AbstractButton.BOTTOM);
			b2.setHorizontalTextPosition(AbstractButton.CENTER);

			b3.setIcon(new ImageIcon(buttonHard));
			b3.setVerticalTextPosition(AbstractButton.BOTTOM);
			b3.setHorizontalTextPosition(AbstractButton.CENTER);

			b1.addActionListener(new StartButtonsAdapter(buttonsFrame, new ModeModel(1000)));
			b2.addActionListener(new StartButtonsAdapter(buttonsFrame, new ModeModel(100)));
			b3.addActionListener(new StartButtonsAdapter(buttonsFrame, new ModeModel(10)));

			add(b1);
			add(b2);
			add(b3);
		}
	}

}
