package race.mvc.view.race.road;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.LinkedList;

import static java.util.Collections.swap;
import static race.multimedia.image.ImageResource.image;

public class RoadView extends Pane {

    private static final Image ROAD_IMAGE = image("race/multimedia/image/road.png");

    private LinkedList<ImageView> imageViews;

    public RoadView() {
        this.imageViews = new LinkedList<>();

        setMaxWidth(ROAD_IMAGE.getWidth());
        setMaxHeight(ROAD_IMAGE.getHeight());

        var topImageView = new ImageView(ROAD_IMAGE);
        topImageView.setTranslateY(-ROAD_IMAGE.getHeight());

        var mainImageView = new ImageView(ROAD_IMAGE);

        var bottomImageView = new ImageView(ROAD_IMAGE);
        bottomImageView.setTranslateY(ROAD_IMAGE.getHeight());

        imageViews.add(bottomImageView);
        imageViews.add(mainImageView);
        imageViews.add(topImageView);

        getChildren().add(bottomImageView);
        getChildren().add(mainImageView);
        getChildren().add(topImageView);
    }

    public void move(double dv) {
        swapPiecesIfNeed();
        imageViews.forEach(imageView -> imageView.setTranslateY(imageView.getTranslateY() + dv));
    }

    private void swapPiecesIfNeed() {
        var first   = imageViews.getFirst();
        var last    = imageViews.getLast();
        if (first.getTranslateY() >= ROAD_IMAGE.getHeight()) {
            first.setTranslateY(last.getTranslateY() - ROAD_IMAGE.getHeight());
            int firstElementIndex   = 0;
            int lastElementIndex    = 2;
            swap(imageViews, firstElementIndex, lastElementIndex);
        }
    }
}
