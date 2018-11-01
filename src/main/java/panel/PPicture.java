package panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PPicture extends JPanel {

	private Image picture;

	public PPicture(Image picture) {
		this.picture = picture;
		setPreferredSize(new Dimension(picture.getWidth(null), picture.getHeight(null)));
	}

	public void paintComponent(Graphics g) {
		g.drawImage(picture, 0, 0, null);
	}

	public Image getPicture() {
		return this.picture;
	}
}
