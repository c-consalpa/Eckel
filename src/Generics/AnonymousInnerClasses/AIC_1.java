package Generics.AnonymousInnerClasses;

public class AIC_1 {
    public static void main(String[] args) {
        new Customer().toString();
        new Customer().toString();
        new Customer().toString();
        System.out.println(Customer.counter);
    }
}

class Customer {
    public static int counter = 0;
    private final int id = counter++;

    @Override
    public String toString() {
        System.out.println(id);
        return Integer.toString(id);
    }
}
