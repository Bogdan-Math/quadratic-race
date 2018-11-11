package race.frame;

import race.model.mode.ModeModel;
import race.panel.PRoad;

public class Road extends BaseFrame {

	public Road(ModeModel modeModel) {

		PRoad road = new PRoad(modeModel, this);

		int sizeX = road.getRoad().getWidth(null);
		int sizeY = road.getRoad().getHeight(null);
		setSize(sizeX, sizeY);

		add(road);
		// pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
