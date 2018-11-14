package race.view.road;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class RoadView extends Group {

    private ImageView imageViewMiddle;

    private TranslateTransition transition;

    double v = 0;

    public RoadView() {
        Image image = new Image("race/multimedia/image/road.png");

        imageViewMiddle = new ImageView(image);

        getChildren().add(imageViewMiddle);
    }

    public void moveUp() {
        transition = new TranslateTransition();
        transition.setDuration(Duration.millis(500));
        transition.setNode(imageViewMiddle);
        v += 10;
        transition.setByY(v);
        transition.setAutoReverse(false);
        transition.play();
    }

    public void moveDown() {
        transition = new TranslateTransition();
        transition.setDuration(Duration.millis(500));
        transition.setNode(imageViewMiddle);
        v -= 10;
        transition.setByY(v);
        transition.setAutoReverse(false);
        transition.play();
    }

}
