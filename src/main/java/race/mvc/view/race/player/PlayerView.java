package race.mvc.view.race.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import static race.multimedia.image.ImageResource.image;

public class PlayerView extends Pane {

    private static final Image PLAYER_IMAGE = image("race/multimedia/image/player.png");

    public PlayerView() {
        setMaxWidth(PLAYER_IMAGE.getWidth());
        setMaxHeight(PLAYER_IMAGE.getHeight());
        getChildren().add(new ImageView(PLAYER_IMAGE));
    }

//    @Override
//    public void initializeKeyEvents() {
//        Scene scene = initializeScene();
//        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
//            KeyCode keyCode = keyEvent.getCode();
//            if (keyCode.equals(KeyCode.A))
//                setTranslateX(getTranslateX() - 4);
//                eventPublisher.publish(PlayerViewEvent.MOVE_LEFT_PRESSED.name());
//            if (keyCode.equals(KeyCode.D))
//                setTranslateX(getTranslateX() + 4);
//                eventPublisher.publish(PlayerViewEvent.MOVE_RIGHT_PRESSED.name());
//        });

//        scene.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
//            KeyCode keyCode = keyEvent.getCode();
//            if (keyCode.equals(KeyCode.A))
//                System.out.println("AAA");
//                eventPublisher.publish(PlayerViewEvent.MOVE_LEFT_RELEASED.name());
//            if (keyCode.equals(KeyCode.D))
//                System.out.println("DDD");
//                eventPublisher.publish(PlayerViewEvent.MOVE_RIGHT_RELEASED.name());
//        });
//    }
}
