package logger;

public class Main {

    public static void main(String[] args) throws Exception {
        LoggerClient loggerClient = new LoggerImplementation();
        loggerClient.start("1");
        Thread.sleep(10);
        loggerClient.start("2");
        Thread.sleep(10);
        loggerClient.end("2");
        Thread.sleep(10);

        loggerClient.poll();

        loggerClient.start("3");

        // process does not exist
        try {
            loggerClient.end("10");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // already started process
        try {
            loggerClient.start("3");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Thread.sleep(10);
        loggerClient.end("3");


        // already ended process
        try {
            loggerClient.end("3");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        loggerClient.poll();

        Thread.sleep(10);
        loggerClient.end("1");

        // all processes started have ended
        loggerClient.poll();
        loggerClient.poll();
        loggerClient.poll();
        loggerClient.poll();

        Thread.sleep(10);
        loggerClient.start("4");
        Thread.sleep(10);
        loggerClient.end("4");
        Thread.sleep(10);

        loggerClient.poll();
        loggerClient.poll();
    }
}
