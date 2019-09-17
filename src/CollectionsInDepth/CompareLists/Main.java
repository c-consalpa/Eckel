package CollectionsInDepth.CompareLists;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        mList<Integer> list_0 = new mList(Integer.class);

        list_0.list.add(1);
//        list_0.list.add(2);
        list_0.list.add(23);


        mList<Integer> list_1 = new mList(Integer.class);
        list_1.list.add(1);
//        list_1.list.add(2);
        list_1.list.add(23);


        System.out.println(list_0);
        System.out.println(list_1);
        System.out.println(list_0.equals(list_1));
    }
}

class mList<T> {
    Class type;

    public List<T> list;

    public mList(Class cls) {
        list = new ArrayList<>();
        type = cls;
    }

    @Override
    public boolean equals(Object object) {
        mList<T> target = (mList)object;


        if (!this.type.equals(target.type)) {
            return false;
        }

        if (list.size() != target.list.size()) {
            return false;
        }



        for (T elem : list) {
            int index = list.indexOf(elem);
            if (!elem.equals(target.list.get(index))) {
                return false;
            }
        }
        return true;
    }


    @Override
    public String toString() {
        return list.toString();
    }
}
