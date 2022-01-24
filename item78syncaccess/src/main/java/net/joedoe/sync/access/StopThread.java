package net.joedoe.sync.access;


import java.util.concurrent.TimeUnit;

public class StopThread {
//    private static boolean stopRequested;
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
//            while (!StopThread.stopRequested()) i++;
            while (!stopRequested) i++;
            System.out.printf("i: %,d%n", i);
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
//        StopThread.requestStop();
        stopRequested = true;
    }

//    static synchronized void requestStop() {
//        stopRequested = true;
//    }

//    static synchronized boolean stopRequested() {
//        return stopRequested;
//    }
}
