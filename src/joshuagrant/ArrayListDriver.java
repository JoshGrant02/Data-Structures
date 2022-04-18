package joshuagrant;

public class ArrayListDriver {
    public static void main(String[] args) {
        JGArrayList<Integer> list = new JGArrayList<>();
        list.add(5);
        System.out.println(list.get(0));
        System.out.println(list.size());
        list.add(3);
        System.out.println(list.get(1));
        System.out.println(list.size());
        list.add(1, 4);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.set(0, 15);
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.size());
    }
}
