package race.mvc.controller.race;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import race.bus.EventPublisher;
import race.bus.UIEvent;
import race.mvc.model.race.RaceModel;
import race.mvc.view.race.RaceView;

import static race.multimedia.sound.SoundResource.sound;

public class RaceController {
    
    private static final AudioClip MAIN_SOUND = sound("race/multimedia/sound/main.mp3");

    private boolean moveForward;
    private boolean moveBack;
    private boolean moveLeft;
    private boolean moveRight;

    private EventPublisher eventPublisher;

    public RaceController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public Scene initializeScene() {
        
        MAIN_SOUND.play();
	
		var raceModel   = new RaceModel();
        var raceView    = new RaceView();
        var scene       = new Scene(raceView);

        var roadModel   = raceModel.getRoadModel();
        var roadView    = raceView.getRoadView();

        var playerModel = raceModel.getPlayerModel();
        var playerView  = raceView.getPlayerView();

        moveForward = false;
        moveBack    = false;
        moveLeft    = false;
        moveRight   = false;
        
		new AnimationTimer() {

            @Override
            public void handle(long now) {

                if (roadModel.isFinished()) {
                    this.stop();
                    eventPublisher.publish(UIEvent.ROAD_FINISHED);
                }

                if (moveForward) {
                    roadModel.d2S(0.3);
                }
                if (!moveForward) {
                    roadModel.d2S(-0.3);
                }
                if (moveBack) {
                    roadModel.d2S(-0.5);
                }
                roadView.move(roadModel.dS());


                if (moveLeft || moveRight) {
                    if (moveLeft) {
                        playerModel.dx(-7);
                    }
                    if (moveRight) {
                        playerModel.dx(7);
                    }
                } else {
                    playerModel.dx(0);
                }
                playerView.move(playerModel.dx());
            }
        }.start();


        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            var keyCode = keyEvent.getCode();

            if (keyCode.equals(KeyCode.W)) {
                moveForward = true;
            }
            if (keyCode.equals(KeyCode.S)) {
                moveBack 	= true;
            }
            if (keyCode.equals(KeyCode.A)) {
                moveLeft 	= true;
                moveRight 	= false;
            }
            if (keyCode.equals(KeyCode.D)) {
                moveRight 	= true;
                moveLeft 	= false;
            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            var keyCode = keyEvent.getCode();
            
            if (keyCode.equals(KeyCode.W)) {
                moveForward = false;
            }
            if (keyCode.equals(KeyCode.S)) {
                moveBack 	= false;
            }
            if (keyCode.equals(KeyCode.A)) {
                moveLeft 	= false;
            }
            if (keyCode.equals(KeyCode.D)) {
                moveRight 	= false;
            }
        });

        return scene;
    }
}
