package joshuagrant;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JGLinkedList<E> implements List<E> {

    private static class Node<E> {
        Node<E> next;
        E data;

        private Node(E e, Node<E> next) {
            data = e;
            this.next = next;
        }

        private Node(E e) {
            this(e, null);
        }
    }

    private int size;
    private Node<E> head;

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
        return null;
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
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        ++size;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
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

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException{
        validateIndex(index);
        Node<E> currentNode = getNode(index);
        return currentNode.data;
    }

    @Override
    public E set(int index, E element) {
        validateIndex(index);
        Node<E> currentNode = getNode(index);
        E oldData = currentNode.data;
        currentNode.data = element;
        return oldData;
    }

    @Override
    public void add(int index, E element) {
        validateIndex(index);
        Node<E> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> currentNode = getNode(index - 1);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        size++;
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " doesn't exist. Dummy");
        }
    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        E result;
        Node<E> currentNode = getNode(index - 1);
        result = currentNode.next.data;
        currentNode.next = currentNode.next.next;
        --size;
        return result;
    }

    private Node<E> getNode(int index) {
        Node<E> currentNode = head;
        for (int i = 0; i < index; ++i) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<E> current = head;
        while (current != null && !current.data.equals(o)) {
            current = current.next;
            ++index;
        }
        return index == size ? -1 : index;
    }


    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}