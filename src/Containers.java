import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Containers {
    public static void main(String[] args) {
        Integer[] arr = {1,23,4};

        List<Integer> l = Arrays.asList(arr);
        System.out.println(l);
        System.out.println(l.getClass());
        ListIterator<Integer> it =  l.listIterator();
        ((ListIterator<Integer>) it).nextIndex();
            it.nextIndex();

    }
}
