package joshuagrant;

public interface JGStack<E> {
    boolean empty();
    E peek();
    E pop();
    E push(E item);
}
