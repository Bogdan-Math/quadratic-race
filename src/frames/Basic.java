package frames;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Basic extends JFrame {

	/**
	 * 
	 */

	public Basic() {
		this("Quadratic Race");
	}

	public Basic(String title) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle(title);
		setIcon();

		setResizable(false);
	}

	private void setIcon() {
		ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("pictures/image.png"));
		this.setIconImage(image.getImage());
	}
}
