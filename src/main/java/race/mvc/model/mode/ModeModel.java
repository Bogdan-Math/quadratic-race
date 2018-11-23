package race.mvc.model.mode;

import race.bus.EventPublisher;

public class ModeModel {

    private static final int EASY_MODE = 1000;
    private static final int NORMAL_MODE = 100;
    private static final int HARD_MODE = 10;

    private int millisecondsInterval;

    private EventPublisher eventPublisher;

    public ModeModel(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    //TODO: remove it after global refactor
    public ModeModel(int millisecondsInterval) {
        this.millisecondsInterval = millisecondsInterval;
    }

    public void setEasyMode() {
        this.millisecondsInterval = EASY_MODE;
        eventPublisher.publish(ModeModelEvent.MODE_INITIALIZED.name());
    }

    public void setNormalMode() {
        this.millisecondsInterval = NORMAL_MODE;
        eventPublisher.publish(ModeModelEvent.MODE_INITIALIZED.name());
    }

    public void setHardMode() {
        this.millisecondsInterval = HARD_MODE;
        eventPublisher.publish(ModeModelEvent.MODE_INITIALIZED.name());
    }

    public int getMillisecondsInterval() {
        return millisecondsInterval;
    }
}
