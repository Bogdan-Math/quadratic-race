package race.mvc.view.road;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import race.bus.EventPublisher;
import race.mvc.view.KeyEventsInitializer;

import java.util.LinkedList;

import static java.util.Collections.swap;
import static race.multimedia.image.ImageResource.image;

public class RoadView extends Pane implements KeyEventsInitializer {

    private static final Image ROAD_IMAGE = image("race/multimedia/image/road.png");

    private LinkedList<ImageView> imageViews;

    private EventPublisher eventPublisher;

    public RoadView(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
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

    @Override
    public void initializeKeyEvents() {
        Scene scene = getScene();
        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W))
                eventPublisher.publish(RoadViewEvent.MOVE_UP_PRESSED.name());
            if (keyCode.equals(KeyCode.S))
                eventPublisher.publish(RoadViewEvent.MOVE_DOWN_PRESSED.name());
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W))
                eventPublisher.publish(RoadViewEvent.MOVE_UP_RELEASED.name());
            if (keyCode.equals(KeyCode.S))
                eventPublisher.publish(RoadViewEvent.MOVE_DOWN_RELEASED.name());
        });
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
