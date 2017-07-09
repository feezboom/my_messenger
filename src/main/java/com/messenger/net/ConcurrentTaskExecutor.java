package com.messenger.net;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by avk on 09.07.17.
 **/
public class ConcurrentTaskExecutor {
    private static Set<Thread> threadSet = new HashSet<>();

    public Set<Thread> getThreadSet() {
        return threadSet;
    }

    public static void setThreadSet(Set<Thread> threadSet) {
        threadSet = threadSet;
    }

    private static void clearFinishedThreads() {
        for (Thread t: threadSet) {
            if (!t.isAlive()) {
                threadSet.remove(t);
            }
        }
    }

    public static void executeTask(Runnable task) {
        clearFinishedThreads();
        Thread thread = new Thread(task);
        thread.run();
    }
}
