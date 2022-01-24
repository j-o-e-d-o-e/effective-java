package net.joedoe.app;

import net.joedoe.sync.access.StopThread;

/**
 * <strong>Title</strong>: Concurrency
 * <br>
 * <strong>Items</strong>: 78-84
 */
class Chapter11 {
    /**
     * Item 78: Synchronize access to shared mutable data
     */
    static void item78syncAccess() {
        try {
            StopThread.main(new String[]{});
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
