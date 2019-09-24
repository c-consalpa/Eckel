package CollectionsInDepth.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CheckedCollections {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(1);

        Collections.fill(list, 12);
//        Collection mCollection = Collections.checkedCollection(list, Integer.class);
//        System.out.println(mCollection);
        System.out.println(list);



    }
}
