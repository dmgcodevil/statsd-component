package com.training.camel.schedule;

import java.util.Date;
import org.springframework.stereotype.Repository;

/**
 * Class description.
 *
 * @author Raman_Pliashkou
 */
@Repository
public class EventRepository {

    public Event getLastEvent() {
        return new Event(new Date().toString());
    }
}
