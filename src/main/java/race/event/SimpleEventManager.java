package race.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleEventManager implements EventPublisher {

    private Map<String, List<EventHandler>> eventMap;

    public SimpleEventManager(List<String> events) {
        eventMap = new HashMap<>();
        events.forEach(event -> eventMap.put(event, new ArrayList<>()));
    }

    @Override
    public void subscribe(String event, EventHandler eventHandler) {
        eventMap.get(event).add(eventHandler);
    }

    @Override
    public void publish(String event) {
        eventMap.get(event).forEach(eventHandler -> eventHandler.handle(event));
    }
}
