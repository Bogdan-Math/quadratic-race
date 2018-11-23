package race.event;

import race.frame.Road;
import race.mvc.model.mode.ModeModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonsAdapter implements ActionListener {

	private JFrame buttonsFrame;
	private ModeModel modeModel;

	public StartButtonsAdapter(JFrame buttonsFrame, ModeModel modeModel) {
		this.buttonsFrame = buttonsFrame;
		this.modeModel = modeModel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		buttonsFrame.dispose();
		new Road(modeModel);
	}
}
