package race.mvc.view.race.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import static race.multimedia.image.ImageResource.image;

public class PlayerView extends Pane {

    public static final Image IMAGE = image("race/multimedia/image/player.png");
    private final ImageView playerView;

    public PlayerView() {
        setMaxWidth(IMAGE.getWidth());
        setMaxHeight(IMAGE.getHeight());
        playerView = new ImageView(IMAGE);
        getChildren().add(playerView);
    }

    public void move(double dx) {
        playerView.setTranslateX(playerView.getTranslateX() + dx);
    }
}
