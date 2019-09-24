package CollectionsInDepth.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparableListTest {
    public static void main(String[] args) {
        ArrayList<ComparableList> list = new ArrayList<>();

//        list.add(new ComparableList("b"));
//        list.add(new ComparableList("a"));
//        list.add(new ComparableList("с"));
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);


        ArrayList<ComparableList> listComparat = new ArrayList<>();
        listComparat.add(new ComparableList("ads"));
        listComparat.add(new ComparableList("aaa"));
        listComparat.add(new ComparableList("ada"));

        System.out.println(listComparat);
        Collections.sort(listComparat, new SortByStr1());
        System.out.println(listComparat);



    }
}

class ComparableList implements Comparable<ComparableList> {
    String str1 = "";
    String str2 = "";

    public ComparableList(String ccc) {
        str1 = ccc;
    }

    @Override
    public int compareTo(ComparableList obj) {
            return str1.compareTo(obj.str1);
    }


    @Override
    public String toString() {
        return str1;
    }
}

class SortByStr1 implements Comparator<ComparableList> {


    @Override
    public int compare(ComparableList o1, ComparableList o2) {
        return o1.str1.compareTo(o2.str1);
    }
}
