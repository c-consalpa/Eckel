package CollectionsInDepth.SetsFunctionality;

import java.util.Set;
import java.util.TreeSet;

public class mSortedSetTest {
    public static void main(String[] args) {
        Set<SortedSetItem> set = new TreeSet<>();

        set.add(new SortedSetItem("abc"));
        set.add(new SortedSetItem("abc"));
        set.add(new SortedSetItem("abd"));
        set.add(new SortedSetItem("qwe"));
        set.add(new SortedSetItem("XYZ"));
        set.add(new SortedSetItem("abc1"));
        set.add(new SortedSetItem("abdcsads"));
        set.add(new SortedSetItem("a"));


        System.out.println(set);
    }


}

class SortedSetItem implements Comparable<SortedSetItem> {
    String str;

    public SortedSetItem(String str2compare) {
        this.str = str2compare;
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(SortedSetItem o) {
// SHort, cool, but unclear notation:
//              Reverse ordering:
        //        return (val > o.val) ? -1 : (val == o.val ? 0 : 1);

//        Illustrative notation


        if (str.length() > o.str.length()) {
        return 1;
        } else if (str.length() < o.str.length()) {
        return -1;
        } else {
//            additional comparison of strings of equal length
            if (str.equals(o.str)) return 0;
            else return 1;
        }

    }

    @Override
    public String toString() {
        return "{"+ str + "}";
    }
}



