package race.frame;

import race.model.Mode;
import race.panel.PRoad;

public class Road extends BaseFrame {

	public Road(Mode mode) {

		PRoad road = new PRoad(mode, this);

		int sizeX = road.getRoad().getWidth(null);
		int sizeY = road.getRoad().getHeight(null);
		setSize(sizeX, sizeY);

		add(road);
		// pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
