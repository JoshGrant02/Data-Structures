package joshuagrant;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JGArrayList<E> implements List<E> {

    private class JGIterator implements Iterator<E> {
        private int next = 0;
        private E lastSeen = null;

        @Override
        public boolean hasNext() {
            return next < size;
        }

        @Override
        public E next() {
            lastSeen = data[next++];
            return lastSeen;
        }

        public void remove() {
             if (lastSeen != null) {
                 JGArrayList.this.remove(lastSeen);
                 lastSeen = null;
             }
        }
    }

    private static final int INITIAL_CAPACITY = 10;

    private int size;
    private int capacity;
    private E[] data;

    public JGArrayList() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public JGArrayList(int capacity) {
        size = 0;
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new JGIterator();
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
    public boolean add(E e) {
        if (size >= capacity) {
            reallocate();
        }
        data[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        remove(index);
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
    public boolean addAll(int index, Collection<? extends E> c) {
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

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        size = 0;
        data = (E[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " doesn't exist. Dummy");
        }
        return data[index];
    }

    @Override
    public E set(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " doesn't exist. Dummy");
        }
        E oldValue = data[index];
        data[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " doesn't exist. Dummy");
        }
        if (size >= capacity) {
            reallocate();
        }
        System.arraycopy(data, index, data, index + 1, size - index);

        data[index] = element;
        ++size;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " doesn't exist. Dummy");
        }
        E element = data[index];
        System.arraycopy(data, index + 1, data, index, size - index);
        --size;
        return element;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    private void reallocate() {
        int newCapacity = capacity*2;
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, capacity);
        capacity = newCapacity;
        data = newData;
    }
}
