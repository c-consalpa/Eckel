package Generics.Wildcards;

import java.util.LinkedList;
import java.util.List;

public class CatsIntoDogs {


    public static void main(String[] args) {
        List<Cat_1> list = new LinkedList<>( );
//        list.add(new Dog_1());

        System.out.println(list.get(0));
    }
}

class Cat_1 extends Animal_1 {

}

class Dog_1 extends Animal_1{


}

class Animal_1 {

}