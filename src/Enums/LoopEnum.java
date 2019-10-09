package Enums;

public class LoopEnum {
    public static void main(String[] args) {
        Nums[] arr = Nums.values();
        for (Nums num: arr) {
            System.out.println(num.getClass());
        }
    }
}

enum Nums {
    ONE, TWO, THREE, TEN;
}
