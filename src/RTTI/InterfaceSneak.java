package RTTI;

public class InterfaceSneak {
    public static void main(String[] args) {
        ABase a = new BBB();
        ((BBB) a).g();
    }
}

interface ABase {
    void f();
}


class BBB implements ABase {

    @Override
    public void f() {}

    public void g() {}


}