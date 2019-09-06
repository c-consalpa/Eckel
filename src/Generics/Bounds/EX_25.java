package Generics.Bounds;

public class EX_25 {
    public static void main(String[] args) {
        ImplementsBoth implementsBoth = new ImplementsBoth();
        implementsBoth.f1();
        implementsBoth.f2();
    }
}

interface I_1 {

}

interface I_2 {

}

class ImplementsBoth implements I_1 {
    public <T extends I_1> void f1() {
        T item;
    }

    public <T extends I_2> void f2() {

    }

}
