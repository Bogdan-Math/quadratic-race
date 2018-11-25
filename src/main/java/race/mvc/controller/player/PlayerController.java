package race.mvc.controller.player;

import race.bus.EventPublisher;
import race.mvc.model.player.PlayerModel;
import race.mvc.view.player.PlayerView;

public class PlayerController {

    private final PlayerModel playerModel;
    private final PlayerView playerView;

    public PlayerController(EventPublisher eventPublisher) {
        playerModel = new PlayerModel();
        playerView = new PlayerView(eventPublisher);
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    public PlayerView getPlayerView() {
        return playerView;
    }
}
