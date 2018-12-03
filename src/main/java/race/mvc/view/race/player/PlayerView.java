package race.mvc.view.race.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import static race.multimedia.image.ImageResource.image;

public class PlayerView extends Pane {

    private static final Image PLAYER_IMAGE = image("race/multimedia/image/player.png");
    private final ImageView playerView;

    public PlayerView() {
        setMaxWidth(PLAYER_IMAGE.getWidth());
        setMaxHeight(PLAYER_IMAGE.getHeight());
        playerView = new ImageView(PLAYER_IMAGE);
        getChildren().add(playerView);
    }

    public void move(double dx) {
        playerView.setTranslateX(playerView.getTranslateX() + dx);
    }
}
