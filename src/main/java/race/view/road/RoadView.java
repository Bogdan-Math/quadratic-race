package race.view.road;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RoadView extends Group {

    private ImageView imageView;

    public RoadView() {
        Image image = new Image("race/multimedia/image/road.png");
        imageView = new ImageView(image);
        getChildren().add(imageView);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
