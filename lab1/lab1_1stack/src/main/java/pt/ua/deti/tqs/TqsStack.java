package pt.ua.deti.tqs;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TqsStack<T> {

    private final LinkedList<T> list;
    private int limit;

    public TqsStack() {
        this.list = new LinkedList<>();
        this.limit = 100;
    }

    public void push(T element) {

        if (list.size() >= limit)
            throw new IllegalStateException();

        list.addFirst(element);

    }

    public T pop() {

        if (list.size() == 0)
            throw new NoSuchElementException();

        return list.removeFirst();

    }

    public T peek() {

        if (list.size() == 0)
            throw new NoSuchElementException();

        return list.getFirst();

    }

    public Integer size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return this.limit;
    }

}
