package designpatterns.creational.singleton;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SingletonTest {
    public static void main(String[] args) throws InterruptedException {

        long sleepTime = 1;
        int threadSize = 5;

        // runnable for lock initialization of singleton
        Runnable lockTask = () -> Singleton.getInstanceLock(sleepTime);

        // runnable for synchronized initialization of singleton
        Runnable synchronizedTask = () -> Singleton.getInstanceSynchronized(sleepTime);

        // running the tasks
        lockTask.run();
        synchronizedTask.run();


        // getting list of threads to be run
        List<Thread> lockList = getThreadList(threadSize, lockTask);
        List<Thread> synchronizedList = getThreadList(threadSize, synchronizedTask);


        // running the threads and comparing the time of synchronized and double lock method
        executeListOfThreads(lockList, "Double lock");
        executeListOfThreads(synchronizedList, "Synchronized");
    }

    /**
     * @param threadSize number of threads that should run the the task
     * @param task       task to run
     * @return list of threads
     */
    private static ArrayList<Thread> getThreadList(int threadSize, Runnable task) {
        return new ArrayList<Thread>() {{
            for (int i = 0; i < threadSize; i++) {
                add(new Thread(task));
            }
        }};
    }

    /**
     * @param threadList list of threads to be executed asynchronously
     * @param identifier to printChars time required for running the list of threads
     * @throws InterruptedException if sleep methods throws exception
     */
    private static void executeListOfThreads(List<Thread> threadList, String identifier) throws InterruptedException {
        Instant start = Instant.now();
        for (Thread thread : threadList) {
            thread.start();
        }

        // wait for all threads to finish execution
        for (Thread thread : threadList) {
            thread.join();
        }

        Instant end = Instant.now();
        System.out.println(identifier + ", time in milli seconds : " + Duration.between(start, end).toMillis());
    }
}
