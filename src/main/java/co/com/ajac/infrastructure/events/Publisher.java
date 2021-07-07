package co.com.ajac.infrastructure.events;

import co.com.ajac.infrastructure.api.events.Event;
import co.com.ajac.infrastructure.api.events.EventPublisher;
import io.vavr.collection.List;
import org.springframework.stereotype.Component;

@Component
public class Publisher implements EventPublisher {
    @Override
    public List<Event> publish(List<Event> list) {
        return list;
    }
}
