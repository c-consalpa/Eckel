package RTTI;

public class RTTI_1 {
    public static void main(String[] args) {
    A a = new B();
        System.out.println(a.getClass());

    }


}
class A {

}

class B extends A {

}