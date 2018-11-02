package race.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import race.frame.Start;

public class FinishButtonsAdapter implements ActionListener {

	JFrame buttonsFrame;

	public FinishButtonsAdapter(JFrame buttonsFrame) {
		this.buttonsFrame = buttonsFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		buttonsFrame.dispose();
		new Start();
	}
}
