package joshuagrant;

import java.util.List;

public class JGBinarySearchTree<E extends Comparable<E>>
        extends JGBinaryTree<E>
        implements SearchTree<E> {

    protected boolean addReturn;
    protected E deleteReturn;

    public boolean add(E item) {
        add(root, item);
        return addReturn;
    }

    private Node<E> add(Node<E> node, E item) {
        if (node == null) {
            addReturn = true;
            return new Node<>(item);
        } else if (item.compareTo(node.data) == 0) {
            addReturn = false;
            return node;
        } else if (item.compareTo(node.data) < 0) {
            node.left = add(node.left, item);
        } else {
            node.right = add(node.right, item);
        }
        return node;
    }

    public boolean contains(E item) {
        return contains(root, item);
    }

    private boolean contains(Node<E> node, E item) {
        if (node == null) {
            return false;
        } else if (item.compareTo(node.data) == 0) {
            return true;
        } else if (item.compareTo(node.data) < 0) {
            return contains(node.left, item);
        } else {
            return contains(node.right, item);
        }
    }

    public E find(E target) {
        return find(root, target);
    }

    private E find(Node<E> node, E target) {
        if (node == null) {
            return null;
        } else if (target.compareTo(node.data) == 0) {
            return node.data;
        } else if (target.compareTo(node.data) < 0) {
            return find(node.left, target);
        } else {
            return find(node.right, target);
        }
    }

    public E delete(E target) {
        root = delete(root, target);
        return deleteReturn;
    }

    private Node<E> delete(Node<E> node, E item) {
        if (node == null) {
            deleteReturn = null;
            return null;
        } else if (item.compareTo(node.data) < 0) {
            node.left = delete(node.left, item);
        } else if (item.compareTo(node.data) > 0){
            node.right = delete(node.right, item);
        } else {
            deleteReturn = node.data;
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node;
            }
        }
        return node;
    }

    @Override
    public boolean remove(E target) {
        return false;
    }

    @Override
    public List<E> toList() {
        return null;
    }

    @Override
    public void clear() {

    }
}