package com.training.camel.schedule;

import org.springframework.stereotype.Component;

/**
 * Class description.
 *
 * @author Raman_Pliashkou
 */
@Component
public class EventProcessor {

    public void process(Event event) {
        System.out.println("EventProcessor:: " + event);
    }
}
