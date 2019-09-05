package CollectionsInDepth;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIterators {
    public static void main(String[] args) {
        List<String> l = new LinkedList<>();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("d");
        l.add("e");

        System.out.println(l);
        ListIterator<String> it = l.listIterator();

        while (it.hasNext()) {
            it.next();
        }
        it.add("f");
        System.out.println(l);
    }
}
