package logger;

public interface LoggerClient {

    void start(String processId) throws Exception;

    void end(String processId) throws Exception;

    /**
     * Will printChars to output stream only if earliest (unfinished) started process has ended
     * It will printChars only for one process per call, if there exists any process
     */
    void poll();
}
