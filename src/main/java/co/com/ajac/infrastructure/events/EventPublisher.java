package co.com.ajac.infrastructure.events;

import co.com.ajac.messaging.events.Event;
import co.com.ajac.messaging.publishers.PublisherProvider;
import io.vavr.collection.List;
import io.vavr.concurrent.Future;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher implements PublisherProvider {

    @Override
    public Future<List<Event>> publish(List<Event> list) {
        return Future.successful(list);
    }
}
