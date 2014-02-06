package com.training.camel.schedule;

import org.springframework.stereotype.Component;

@Component
public class EventCreateProcessor {

    public void process(Event event) {
        System.out.println("EventCreateProcessor:: " + event);
        /*while (true){

        }*/
    }
}
