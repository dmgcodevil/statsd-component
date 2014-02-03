package com.training.camel.schedule;

/**
 * Class description.
 *
 * @author Raman_Pliashkou
 */
public class Event {

    private String body;

    public Event() {
    }

    public Event(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("body='").append(body).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
