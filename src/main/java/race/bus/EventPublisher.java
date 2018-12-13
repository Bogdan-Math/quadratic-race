package race.bus;

public interface EventPublisher {
    void subscribe(Enum event, EventHandler eventHandler);
    void publish(Enum event);
}
