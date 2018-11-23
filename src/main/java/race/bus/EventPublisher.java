package race.bus;

public interface EventPublisher {
    void subscribe(String event, EventHandler eventHandler);
    void publish(String event);
}
