package net.joedoe.app;

import net.joedoe.sync.access.StopThread;
import net.joedoe.sync.excessive.ObservableSet;
import net.joedoe.sync.excessive.SetObserver;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    /**
     * Item 79: Avoid excessive synchronization
     */
    static void item79syncExcessive() {
        ObservableSet<Integer> observableSet = new ObservableSet<>(new HashSet<>());
        System.out.print("  List size | Added element  \n");
        System.out.print("-----------------------------\n");
        observableSet.addObserver((set, element) -> System.out.printf("%11d | %13d%n", set.size(), element));
        item79xecuteService(observableSet);
        for (int i = 0; i < 100; i++) observableSet.add(i);
    }

    private static void item79xecuteService(ObservableSet<Integer> observableSet) {
        observableSet.addObserver(new SetObserver<>() {
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.printf("%11d | %13d%n", set.size(), element);
                if (element == 23) {
                    ExecutorService exec = Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> set.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });
    }
}
