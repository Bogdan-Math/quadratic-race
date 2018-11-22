package race;

public interface Publisher {
    void subscribe(String eventType, Subscriber subscriber);
    void notify(String eventType);
}
