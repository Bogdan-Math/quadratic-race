package race.frame;

import javax.swing.*;

class BaseFrame extends JFrame {

	BaseFrame() {
		this("Quadratic Race");
	}

	private BaseFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setIcon();
	}

	private void setIcon() {
		ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("pictures/image.png"));
		this.setIconImage(image.getImage());
	}
}
