package race.bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus implements EventPublisher {

    private Map<String, List<EventHandler>> eventMap;

    public EventBus(List<Enum> events) {
        eventMap = new HashMap<>();
        events.forEach(event -> eventMap.put(event.name(), new ArrayList<>()));
    }

    @Override
    public void subscribe(Enum event, EventHandler eventHandler) {
        eventMap.get(event.name()).add(eventHandler);
    }

    @Override
    public void publish(Enum event) {
        List<EventHandler> eventHandlers = eventMap.get(event.name());
        for (EventHandler eventHandler : eventHandlers) {
            eventHandler.handle(event);
        }
    }
}
