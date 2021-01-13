package designpatterns.creational.singleton;

import java.util.concurrent.TimeUnit;

/**
 * This is lazy execution, since the instance is formed only when getInstance methods are called
 */
public class Singleton {
    private static Singleton instanceLock;
    private static Singleton instanceSynchronized;

    private Singleton() {

    }

    private static void sleepForTime(long sleepTime) {
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Singleton getInstanceLock(long sleepTime) {
        if (null == instanceLock) {
            synchronized (Singleton.class) {
                if (null == instanceLock) {
                    instanceLock = new Singleton();
                }
            }
        }
        sleepForTime(sleepTime);
        return instanceLock;
    }

    public static synchronized Singleton getInstanceSynchronized(long sleepTime) {
        if (null == instanceSynchronized) {
            instanceSynchronized = new Singleton();
        }
        sleepForTime(sleepTime);
        return instanceSynchronized;
    }
}
