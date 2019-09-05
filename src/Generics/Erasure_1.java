package Generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Erasure_1 {
    public static void main(String[] args) {
//        System.out.println(ArrayList.class);
// NOT working:
// System.out.println(ArrayList<String>.getClass());


//    Class c1 = new ArrayList<Integer>().getClass();



    ArrayList<Integer> list = new ArrayList<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));

    }
}
