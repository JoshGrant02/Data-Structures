package joshuagrant;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorDriver {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(8);
        list.add(0);
        list.add(7);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int i = it.next();
            System.out.println(i);
        }
        it = list.iterator();
        it.next();
        it.remove();
        System.out.println(list.get(0));

    }
}
