package race.view.road;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class RoadView extends Pane {

    private ImageView imageView0;
    private ImageView imageView1;

    private AnimationTimer timer;

    private double v = 0;
    private double dv = 0;

    public RoadView() {
        Image image = new Image("race/multimedia/image/road.png");
        setMaxWidth(image.getWidth());
        setMaxHeight(image.getHeight());

        imageView0 = new ImageView(image);
        imageView1 = new ImageView(image);
        imageView1.setTranslateY( - image.getHeight() );

        getChildren().add(imageView0);
        getChildren().add(imageView1);

        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                v += dv;
                if (v <= 0)
                    v = 0;
                if (v >= 10)
                    v = 10;

                imageView0.setTranslateY(imageView0.getTranslateY() + v);
                imageView1.setTranslateY(imageView1.getTranslateY() + v);
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
