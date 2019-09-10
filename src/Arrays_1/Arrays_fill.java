package Arrays_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Arrays_fill {
    public static void main(String[] args) {

        int[] arr = new int[32];
        Arrays.fill(arr, 5);


        Comparator<String> comparator_rev = Collections.reverseOrder();

        System.out.println(comparator_rev.compare("a", "b"));
    }
}


class _2BeCompared implements Comparable<String> {


    @Override
    public int compareTo(String o) {
        return 0;
    }
}