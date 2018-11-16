package race.view.road;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class RoadView extends Pane {

    private Queue<ImageView> roadQueue;

    private AnimationTimer timer;

    private double v = 0;
    private double dv = 0;

    public RoadView() {
        Image image = new Image("race/multimedia/image/road.png");
        setMaxWidth(image.getWidth());
        setMaxHeight(image.getHeight());

        roadQueue = new ArrayBlockingQueue<>(3);
        var topImageView = new ImageView(image);
        var mainImageView = new ImageView(image);
        var bottomImageView = new ImageView(image);
        topImageView.setTranslateY(-image.getHeight());
        bottomImageView.setTranslateY(image.getHeight());

//        roadQueue.add(bottomImageView);
//        roadQueue.add(mainImageView);
//        roadQueue.add(topImageView);

        getChildren().add(topImageView);
        getChildren().add(mainImageView);
        getChildren().add(bottomImageView);

        timer = new AnimationTimer() {

            @Override
            public void handle(long l) {
                v += dv;
                if (v <= 0)
                    v = 0;
                if (v >= 10)
                    v = 10;

//                ImageView bottom = roadQueue.poll();

//                if (bottom.getTranslateY() >= image.getHeight()) {
//                    roadQueue.add(bottom);
//                }

//                roadQueue.forEach(imageView ->
//                        imageView.setTranslateY(imageView.getTranslateY() + v));

                topImageView.setTranslateY(topImageView.getTranslateY() + v);
                mainImageView.setTranslateY(mainImageView.getTranslateY() + v);
                bottomImageView.setTranslateY(bottomImageView.getTranslateY() + v);
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
