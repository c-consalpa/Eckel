package CollectionsInDepth.ListFunctionality;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIter {
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);

        ListIterator<Integer> lit = list.listIterator();
        while (lit.hasNext()) {
            lit.next();
            lit.set(22);

        }
        System.out.println(list);
    }


}
