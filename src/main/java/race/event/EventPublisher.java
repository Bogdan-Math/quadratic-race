package race.event;

public interface EventPublisher {
    void subscribe(String event, EventHandler eventHandler);
    void publish(String event);
}
