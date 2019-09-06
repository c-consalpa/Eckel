package Generics.Wildcards;

public class NumberIntegerCovariance {
    public static void main(String[] args) {
//      won't work:
//  Holder<? extends Number> holder = new Holder<>(new String("asd"));
        Holder<? extends Number> holder = new Holder<>(new Integer(1));
        Holder<? extends Number> holderD = new Holder<>(new Double(2d));
        Holder<? extends Number> holderF = new Holder<>(new Float(3f));
        System.out.println(holder);
    }
}


class Holder<T> {
    T item;


    public Holder(T item) {
        this.item = item;
    }

    public void add(T elem) {
        item = elem;
    }

    @Override
    public String toString() {
        return "ITEM: " + item.getClass();
    }
}