package logger;

public class Process {
    private String processId;
    private Long startTime;
    private Long endTime;

    public Process(String processId, long startTime) {
        this.processId = processId;
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public String getProcessId() {
        return processId;
    }

    public Long getStartTime() {
        return startTime;
    }
}
