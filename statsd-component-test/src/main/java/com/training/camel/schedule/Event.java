package com.training.camel.schedule;

/**
 * Class description.
 *
 * @author Raman_Pliashkou
 */
public class Event {

    private String body;

    private EventType eventType;

    public Event() {
    }

    public Event(String body, EventType eventType) {
        this.body = body;
        this.eventType = eventType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
            .append("body", body)
            .append("eventType", eventType)
            .toString();
    }
}
