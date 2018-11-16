package race.view.road;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Collections;
import java.util.LinkedList;

public class RoadView extends Pane {

    private LinkedList<ImageView> roadViewList;

    private AnimationTimer timer;

    private double v = 0;
    private double dv = 0;

    public RoadView() {
        roadViewList = new LinkedList<>();

        Image image = new Image("race/multimedia/image/road.png");

        setMaxWidth(image.getWidth());
        final double imageHeight = image.getHeight();
        setMaxHeight(imageHeight);

        var topImageView = new ImageView(image);
        var mainImageView = new ImageView(image);
        var bottomImageView = new ImageView(image);
        topImageView.setTranslateY(-imageHeight);
        bottomImageView.setTranslateY(imageHeight);

        roadViewList.add(bottomImageView);
        roadViewList.add(mainImageView);
        roadViewList.add(topImageView);

        getChildren().add(bottomImageView);
        getChildren().add(mainImageView);
        getChildren().add(topImageView);

        timer = new AnimationTimer() {

            @Override
            public void handle(long l) {
                v += dv;
                if (v <= 0)
                    v = 0;
                if (v >= 10)
                    v = 10;

                ImageView first = roadViewList.getFirst();
                ImageView last = roadViewList.getLast();
                if (first.getTranslateY() >= imageHeight) {
                    first.setTranslateY(last.getTranslateY() - imageHeight);
                    Collections.swap(roadViewList, 0, 2);
                }

                roadViewList.forEach(imageView -> imageView.setTranslateY(imageView.getTranslateY() + v));

//                topImageView.setTranslateY(topImageView.getTranslateY() + v);
//                mainImageView.setTranslateY(mainImageView.getTranslateY() + v);
//                bottomImageView.setTranslateY(bottomImageView.getTranslateY() + v);
            }
        };
        timer.start();

    }

    public void moveUp() {
        dv = 0.2;
    }

    public void moveDown() {
        dv = -0.4;
    }

    public void decreaseSpeed() {
        dv = -0.2;
    }
}
