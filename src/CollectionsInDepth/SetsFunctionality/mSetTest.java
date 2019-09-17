package CollectionsInDepth.SetsFunctionality;

import java.util.HashSet;
import java.util.Set;

public class mSetTest {


    public static void main(String[] args) {
        Set<mSet_Item<Integer>> set = new HashSet<>();
//        set.add(new mSet_Item(1,10));
        set.add(new mSet_Item(2, 5));
        set.add(new mSet_Item(2, 5));
        set.add(new mSet_Item(5, 5));

//        set.add(new mSet_Item(1, 1));
//        set.add(new mSet_Item(1,5));
        System.out.println(set);
    }
}

class mSet_Item<T> {
    int x, y;

    @Override
    public String toString() {
        return this.hashCode() + ": {" + x + ":" + y + "};";
    }

    public mSet_Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x*y;
    }

    @Override
    public boolean equals(Object obj) {
//        equals always overridden with hashcode();
        if (obj instanceof mSet_Item && (this.x * this.y) == (((mSet_Item)obj).x * ((mSet_Item) obj).y)) {
            return true;
        } else {
            return false;
        }
    }
}

