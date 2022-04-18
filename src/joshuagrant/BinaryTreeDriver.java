package joshuagrant;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        JGBinaryTree<Integer> tree8 = new JGBinaryTree<>(8, null, null);
        JGBinaryTree<Integer> tree7 = new JGBinaryTree<>(7, null, null);
        JGBinaryTree<Integer> tree6 = new JGBinaryTree<>(6, null, null);
        JGBinaryTree<Integer> tree5 = new JGBinaryTree<>(5, null, null);
        JGBinaryTree<Integer> tree4 = new JGBinaryTree<>(4, tree7, tree8);
        JGBinaryTree<Integer> tree3 = new JGBinaryTree<>(3, tree5, tree6);
        JGBinaryTree<Integer> tree2 = new JGBinaryTree<>(2, tree4, null);
        JGBinaryTree<Integer> tree1 = new JGBinaryTree<>(1, tree2, tree3);
        System.out.println(tree1);
    }
}
