package joshuagrant;

import java.util.*;

public class JGQueue<E> implements Queue<E> {
    private static final int MAX_ITEMS = 1_000_000;
    LinkedList<E> data = new LinkedList<>();

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) throws IllegalStateException {
        if (data.size() >= MAX_ITEMS) {
            throw new IllegalStateException("The queue is at capacity");
        }
        data.addLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        data.remove(o);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        if (data.size() >= MAX_ITEMS) {
            throw new IllegalStateException("The queue is at capacity");
        }
        data.addLast(e);
        return true;
    }

    @Override
    public E remove() {
        if (data.isEmpty()) {
            throw new NoSuchElementException("No such element");
        }
        return data.removeFirst();
    }

    @Override
    public E poll() {
        if (data.isEmpty()) {
            return null;
        }
        return data.removeFirst();
    }

    @Override
    public E element() {
        if (data.isEmpty()) {
            throw new NoSuchElementException("No such element");
        }
        return data.getFirst();
    }

    @Override
    public E peek() {
        if (data.isEmpty()) {
            return null;
        }
        return data.getFirst();
    }
}
