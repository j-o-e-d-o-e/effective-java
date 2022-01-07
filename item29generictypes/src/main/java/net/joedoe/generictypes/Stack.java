package net.joedoe.generictypes;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // compiler cannot ensure type-safety due to the unchecked cast
    // but, I guarantee it by suppressing its warning
    @SuppressWarnings("unchecked")
    public Stack() {
        // cannot create array of non-reifiable type, such as `new E[]`
        // therefore, casts Object[] to the generic array type
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * <b>Item 31: use bounded wildcards to increase API flexibility</b>
     * <ul>
     * <li>parameterized type (`src`) represents a producer, therefore >`<? extends E>`</li>
     * <li>here: `src` produces `E` instances for use by the Stack</li>
     * </ul>
     */
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) push(e);
    }

    /**
     * <b>Item 31: use bounded wildcards to increase API flexibility</b>
     * <ul>
     * <li>parameterized type (`dst`) represents a consumer, therefore `<? super E>`</li>
     * <li>here: `dst` consumes `E` instances from the stack</li>
     * </ul>
     */
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) dst.add(pop());
    }

    private void ensureCapacity() {
        if (elements.length == size) elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
