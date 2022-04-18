package joshuagrant;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class SimpleStack<E> implements JGStack<E> {
    private final LinkedList<E> data = new LinkedList<>();

    @Override
    public boolean empty() {
        return data.isEmpty();
    }

    @Override
    public E peek() throws EmptyStackException {
        if (!data.isEmpty()) {
            return data.getFirst();
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public E pop() throws EmptyStackException {
        if (!data.isEmpty()) {
            return data.removeFirst();
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public E push(E item) {
        data.addFirst(item);
        return item;
    }
}
