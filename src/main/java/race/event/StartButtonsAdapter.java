package race.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import race.frame.Road;
import race.logic.Difficulty;

public class StartButtonsAdapter implements ActionListener {

	JFrame buttonsFrame;
	Difficulty difficulty;

	public StartButtonsAdapter(JFrame buttonsFrame, Difficulty difficulty) {
		this.buttonsFrame = buttonsFrame;
		this.difficulty = difficulty;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		buttonsFrame.dispose();
		new Road(difficulty);
	}
}
