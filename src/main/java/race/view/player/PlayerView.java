package race.view.player;

import javax.swing.*;
import java.awt.*;

public class PlayerView {

    private Image imageMoveRight;
    private Image imageMoveLeft;
    private Image imageMoveForward;

    public PlayerView() {
        this.imageMoveRight = new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/playerRight.png")).getImage();
        this.imageMoveLeft = new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/playerLeft.png")).getImage();
        this.imageMoveForward = new ImageIcon(getClass().getClassLoader().getResource("race/multimedia/image/player.png")).getImage();
    }


}
