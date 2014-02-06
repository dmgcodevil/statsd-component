package com.training.camel.schedule;

import com.training.camel.TestEnum;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class description.
 *
 * @author Raman_Pliashkou
 */
@Repository
public class EventRepository {

    public List<Event> getLastEvents(TestEnum testEnum, int limit) {
        System.out.println("getLastEvent: " + limit + " enum: " + testEnum);
        List<Event> events = new ArrayList<>();
        events.add(new Event(new Date().toString(), EventType.CREATED));
        events.add(new Event(new Date().toString(), EventType.CHANGED));
        return events;
    }
}
