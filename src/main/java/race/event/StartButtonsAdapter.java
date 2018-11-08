package race.event;

import race.frame.Road;
import race.logic.Mode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonsAdapter implements ActionListener {

	private JFrame buttonsFrame;
	private Mode mode;

	public StartButtonsAdapter(JFrame buttonsFrame, Mode mode) {
		this.buttonsFrame = buttonsFrame;
		this.mode = mode;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		buttonsFrame.dispose();
		new Road(mode);
	}
}
