package designpatterns.behavioural.chainofresponsibility;

import designpatterns.behavioural.chainofresponsibility.loggers.Logger;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Logger logger = Logger.getConsoleLogger()
                .appendNextAndGet(Logger.getFileLogger())
                .appendNextAndGet(Logger.getEmailLogger());

        // all + file
        logger.log("Some warning!", LogLevels.WARNING);

        // all + email
        logger.log("Some error!", LogLevels.ERROR);

        // all + file
        logger.log("Some debug information!", LogLevels.DEBUG);

        // all + email
        logger.log("Some fatal error!", LogLevels.FATAL);
    }
}
