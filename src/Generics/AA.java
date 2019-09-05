package Generics;

public class AA {
    public static void main(String[] args) {
        Foo<A_01> foo = new Foo<>(new A_01());

    }
}


// manual class type substitution instead of correct class Foo<T extends A_01>
class Foo<T> {
    A_01 obj;


    public void doo() {
    obj.f();
    }

    public Foo(T obj) {
        this.obj = (A_01) obj;
    }
}

class A_01 {
    public void f() {
        System.out.println("A.f()");
    }
}
