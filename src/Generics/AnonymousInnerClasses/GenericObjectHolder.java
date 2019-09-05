package Generics.AnonymousInnerClasses;

import java.util.LinkedList;
import java.util.List;

public class GenericObjectHolder {
    public static List<Class> list = new LinkedList<>();

    public static void main(String[] args) {
        list.add(Integer.class);
        list.add(String.class);
        list.add(Float.class);


        try {
            Integer i = Integer.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }



    }
}

//class mHolder <A> {
//    A data;
//
//    public mHolder(A obj) {
//
//        for (Class<A> cls : GenericObjectHolder.list) {
//            try {
//                data = cls.newInstance();
//                System.out.println("Instantiation successfull: " + cls);
//            } catch (Exception e) {
//                System.out.println("CANNOT INSTANTIATE: ");
//                System.out.println(cls.getName());
//                System.out.println("____________");
//                continue;
//            }
//
//        }
//        System.out.println(data.getClass());
//    }
//
//
//}
//
//class CustomCLass {
//
//}
