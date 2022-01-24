package net.joedoe.sync.excessive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

// Thread-safe observable set with CopyOnWriteArrayList
public class ObservableSet<E> extends ForwardingSet<E> {
    private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();


    public ObservableSet(Set<E> set) {
        super(set);
    }

    // Observers subscribe to notifications
    public void addObserver(SetObserver<E> observer) {
        observers.add(observer);
    }

    // Observers un-subscribe to notifications
    public boolean removeObserver(SetObserver<E> observer) {
        return observers.remove(observer);
    }

    private void notifyElementAdded(E element) {
        for (SetObserver<E> observer : observers) observer.added(this, element);
    }


    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added) notifyElementAdded(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) result |= add(element); // Calls notifyElementAdded
        return result;
    }
}
