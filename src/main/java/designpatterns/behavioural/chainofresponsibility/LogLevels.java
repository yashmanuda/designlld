package designpatterns.behavioural.chainofresponsibility;

public enum LogLevels {
    DEBUG, INFO, WARNING, ERROR, FATAL;

    public static LogLevels[] getAllLogLevels() {
        return values();
    }
}
