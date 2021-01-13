package carrentalsystem;

import java.util.Date;

public class Event implements Comparable<Event> {
    private EventType eventType;
    private String message;
    private Date date;

    @Override
    public String toString() {
        return "Event{" +
                "eventType=" + eventType +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }

    public Event(EventType eventType, String message) {
        this.eventType = eventType;
        this.message = message;
        Constants.dateFormat.format(date);
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int compareTo(Event o) {
        return date.compareTo(o.getDate());
    }

    public EventType getEventType() {
        return eventType;
    }

    enum EventType {
        RESERVED, CHECK_OUT, DELIVERED, RETURNED, DAMAGED;
    }
}
