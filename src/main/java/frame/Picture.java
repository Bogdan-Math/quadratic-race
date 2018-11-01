package frame;

import java.awt.Image;

import panel.PPicture;

public class Picture extends BaseFrame {

	public Picture(Image result) {
		PPicture picture = new PPicture(result);

		int sizeX = picture.getPicture().getWidth(null);
		int sizeY = picture.getPicture().getHeight(null);
		setSize(sizeX, sizeY);

		add(picture);

		setLocationRelativeTo(null);
		setVisible(true);
	}
}