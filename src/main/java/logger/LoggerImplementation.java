package logger;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LoggerImplementation implements LoggerClient {
    // for fetching in O(1)
    private Map<String, Process> processIdToProcessMap;

    // for sorting by start time
    private TreeMap<Long, String> startTimeToProcessId;

    public LoggerImplementation() {
        processIdToProcessMap = new HashMap<>();
        startTimeToProcessId = new TreeMap<>();
    }

    // do not add the process with same process id
    @Override
    public void start(final String processId) throws Exception {
        if (processIdToProcessMap.containsKey(processId))
            throw new Exception("Process id " + processId + " already exists!");
        final long startTime = System.currentTimeMillis();
        final Process newProcess = new Process(processId, startTime);
        processIdToProcessMap.put(processId, newProcess);
        startTimeToProcessId.put(startTime, processId);
    }

    // exception if process id doesn't exist in logger
    @Override
    public void end(final String processId) throws Exception {
        if (!processIdToProcessMap.containsKey(processId))
            throw new Exception("Process id " + processId + " does not exist!");
        final long endTime = System.currentTimeMillis();
        if (processIdToProcessMap.get(processId).getEndTime() != null)
            throw new Exception("Process id " + processId + " already ended!");
        processIdToProcessMap.get(processId).setEndTime(endTime);
    }

    @Override
    public void poll() {
        final Map.Entry<Long, String> firstEntry = startTimeToProcessId.firstEntry();
        if (firstEntry == null) {
            System.out.println("Empty logger, no process to poll!");
        } else {
            final Process firstProcess = processIdToProcessMap.get(firstEntry.getValue());
            if (firstProcess.getEndTime() == null) {
                System.out.println("Earliest started process has not ended yet!");
            } else {
                // remove the earliest process
                startTimeToProcessId.remove(firstEntry.getKey());
                processIdToProcessMap.remove(firstProcess.getProcessId());
                System.out.println("Process with id " + firstProcess.getProcessId() + " started at " + firstProcess.getStartTime() + " has ended at " + firstProcess.getEndTime() + "!");
            }
        }
    }
}
