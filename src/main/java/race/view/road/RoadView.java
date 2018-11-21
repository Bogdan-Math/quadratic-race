package race.view.road;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import race.model.Road;

import java.util.LinkedList;

import static java.util.Collections.swap;
import static race.multimedia.image.ImageResource.image;

public class RoadView extends Pane {

    public static final Image ROAD_IMAGE = image("race/multimedia/image/road.png");

    private LinkedList<ImageView> roadPieces;

    public RoadView() {
        roadPieces = new LinkedList<>();

        setMaxWidth(ROAD_IMAGE.getWidth());
        setMaxHeight(ROAD_IMAGE.getHeight());

        var topImageView = new ImageView(ROAD_IMAGE);
        var mainImageView = new ImageView(ROAD_IMAGE);
        var bottomImageView = new ImageView(ROAD_IMAGE);
        topImageView.setTranslateY(-ROAD_IMAGE.getHeight());
        bottomImageView.setTranslateY(ROAD_IMAGE.getHeight());

        roadPieces.add(bottomImageView);
        roadPieces.add(mainImageView);
        roadPieces.add(topImageView);

        getChildren().add(bottomImageView);
        getChildren().add(mainImageView);
        getChildren().add(topImageView);
    }

    public LinkedList<ImageView> getRoadPieces() {
        return roadPieces;
    }

    public void move() {
        var roadPieces = getRoadPieces();
        var first = roadPieces.getFirst();
        var last = roadPieces.getLast();
        if (first.getTranslateY() >= ROAD_IMAGE.getHeight()) {
            first.setTranslateY(last.getTranslateY() - ROAD_IMAGE.getHeight());
            int firstElementIndex = 0;
            int lastElementIndex = 2;
            swap(roadPieces, firstElementIndex, lastElementIndex);
        }
    }
}
