package Enums;

public class EnumsBasics {
    public static void main(String[] args) {
        System.out.println(State.values().length);
        System.out.println(System.getenv("CLASSPATH"));
    }
}

enum State {UP, DOWN, SUSPEND}