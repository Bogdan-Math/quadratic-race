package race.mvc.view.race;

import javafx.scene.layout.Pane;
import race.mvc.view.race.player.PlayerView;
import race.mvc.view.race.road.RoadView;

public class RaceView extends Pane {

    private RoadView roadView;
    private PlayerView playerView;

    public RaceView() {
        roadView = new RoadView();
        playerView = new PlayerView();

        initializePlayerViewStartPosition();

        getChildren().addAll(roadView, playerView);
    }

    private void initializePlayerViewStartPosition() {
        playerView.setTranslateX(roadView.getMaxWidth() / 2 - playerView.getMaxWidth() / 2);
        playerView.setTranslateY(roadView.getMaxHeight()  *  3 / 4);
    }

    public RoadView getRoadView() {
        return roadView;
    }

    public PlayerView getPlayerView() {
        return playerView;
    }
    
    public void move(double rvMove, double pvMove) {
    	checkPlayerViewBounds();
    	roadView.move(rvMove);
    	playerView.move(pvMove);
	}
    
    private void checkPlayerViewBounds() {
		double rvLeftBound 	= 0;
		double rvRightBound = roadView.getWidth();

		double pvLeftBound 	= playerView.getTranslateX();
		double pvRightBound = pvLeftBound + playerView.getWidth();
		
		if (pvLeftBound <= rvLeftBound) {
			playerView.setTranslateX(rvLeftBound);
		}
	
		if (pvRightBound >= rvRightBound) {
			playerView.setTranslateX(rvRightBound - playerView.getWidth());
		}
	}
}
