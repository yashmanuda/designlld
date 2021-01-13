package designpatterns.behavioural.chainofresponsibility.loggers;

import designpatterns.behavioural.chainofresponsibility.LogLevels;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.function.Consumer;

/**
 * This is the main component that the client will call
 * It will further call the next component if there exists
 * Client doesn't need to know which component is sending the response / getting engaged
 * Decoupling the client and the receiver
 */
public interface Logger {
    void log(String message, LogLevels severity);

    default Logger appendNextAndGet(Logger nextLogger) {
        return (message, severity) -> {
            // invoke current logger
            this.log(message, severity);

            // invoke next logger
            nextLogger.log(message, severity);
        };
    }

    static Logger getLogger(Consumer<String> stringConsumer, LogLevels... logLevels) {
        EnumSet<LogLevels> logLevelsSet = EnumSet.copyOf(Arrays.asList(logLevels));
        return ((message, severity) -> {
            if (logLevelsSet.contains(severity)) {
                stringConsumer.accept(message);
            }
        });
    }

    static Logger getConsoleLogger() {
        return getLogger(x -> System.err.println("Printing to console!"), LogLevels.getAllLogLevels());
    }

    static Logger getEmailLogger() {
        return getLogger(x -> System.err.println("Sending email!"), LogLevels.FATAL, LogLevels.ERROR);
    }

    static Logger getFileLogger() {
        return getLogger(x -> System.err.println("Logging to file!"), LogLevels.INFO, LogLevels.DEBUG, LogLevels.WARNING);
    }
}
