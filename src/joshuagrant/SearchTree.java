package joshuagrant;

import java.util.List;

public interface SearchTree<E extends Comparable<E>> {
    boolean add(E item);
    boolean contains(E item);
    E find(E target);
    E delete(E target);
    boolean remove(E target);
    List<E> toList();
    void clear();
}
