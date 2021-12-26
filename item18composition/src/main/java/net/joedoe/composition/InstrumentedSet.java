package net.joedoe.composition;

import java.util.Collection;
import java.util.Set;

// Wrapper class
public class InstrumentedSet<E> extends ForwardingSet<E> {
    // additional counter (why wrapper and forwarding class became necessary)
    // HashSet's addAll() invokes add(), therefore if inheritance is used
    // items added by addAll() are counted twice
    private int addCount = 0;

    public InstrumentedSet(Set<E> s){
        super(s);
    }

    @Override
    public boolean add(E e){
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c){
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }
}
