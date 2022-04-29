package joshuagrant;

import java.util.function.BiConsumer;

public class JGBinaryTree<E> {
    protected static class Node<E> {
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        protected Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    protected Node<E> root;

    public JGBinaryTree() {
        this(null);
    }

    public JGBinaryTree(Node<E> root) {
        this.root = root;
    }

    public JGBinaryTree(E data, JGBinaryTree<E> leftTree, JGBinaryTree<E> rightTree) {
        root = new Node<>(data);
        root.left = leftTree != null ? leftTree.root : null;
        root.right = rightTree != null ? rightTree.root : null;
    }

    public JGBinaryTree<E> getLeftTree() {
        if (root != null && root.left != null) {
            return new JGBinaryTree<>(root.left);
        }
        return null;
    }

    public JGBinaryTree<E> getRightTree() {
        if (root != null && root.right != null) {
            return new JGBinaryTree<>(root.right);
        }
        return null;
    }

    public E getRootData() {
        return root != null ? root.data : null;
    }

    public boolean isLeaf() {
        return root == null || root.left == null && root.right == null;
    }

    public void preOrderTraversal(BiConsumer<E, Integer> consumer) {
        preOrderTraversal(root, 1, consumer);
    }

    private void preOrderTraversal(Node<E> node, int depth, BiConsumer<E, Integer> consumer) {
        if (node == null) {
            consumer.accept(null, depth);
        } else {
            consumer.accept(node.data, depth);
            preOrderTraversal(node.left, depth + 1, consumer);
            preOrderTraversal(node.right,depth + 1, consumer);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraversal((e, d) -> {
            sb.append("  ".repeat(Math.max(0, d)));
            sb.append(e).append("\n");
        });
        return sb.toString();
    }
}