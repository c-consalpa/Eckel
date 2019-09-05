package CollectionsInDepth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Containers {
    public static void main(String[] args) {
//        List list = Collections.nCopies(3, new String("123"));

        List<Integer> l = Arrays.asList(new Integer[3]);
        l.set(1, 2);
    }
}
