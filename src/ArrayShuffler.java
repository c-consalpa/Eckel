import java.util.*;

import static java.util.Collections.shuffle;
import static java.util.Collections.sort;

public class ArrayShuffler {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(Integer.toString(i) + "a");
        }

        System.out.println(list);



        ListIterator<String> iterator = list.listIterator();
        int size = list.size();
        Random random = new Random();
        List<String> result = new ArrayList<>();
        while (list.size() != 0) {
            result.add(list.remove(random.nextInt(list.size())));
        }
        System.out.println(result);



        System.out.println(list);
    }
}
