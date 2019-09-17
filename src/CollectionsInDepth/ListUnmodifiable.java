package CollectionsInDepth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUnmodifiable {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3}));
        list.add(1);
        System.out.println(list);
    }
}
