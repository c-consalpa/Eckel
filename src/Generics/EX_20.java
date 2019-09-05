package Generics;

public class EX_20 {
    public static void main(String[] args) {
mClass mClass = new mClass();
mClass_1 mClass_1 = new mClass_1();


mClass_1.genMethod(mClass);
    }



}


interface mInterface {

    public void f();
    public void g();

}

class mClass implements mInterface {

    @Override
    public void f() {
        System.out.println("f");
    }

    @Override
    public void g() {
        System.out.println("g");
    }

    public void h() {
        System.out.println("class-level H");
    }
}

class mClass_1 {


    public <T extends mInterface> void genMethod(mClass obj) {

        obj.h();

    }
}