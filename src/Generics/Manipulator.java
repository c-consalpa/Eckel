package Generics;

class ManipulatorTest {
    public static void main(String[] args) {
        HasF hasF = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hasF);
        manipulator.manupulate();

    }
}

// <T extends HasF> - bound, without it, object.f() won't compile
// The bound <T extends HasF> says that T must be of type HasF or something derived from HasF. If this is true, then it
// is safe to call f( ) on obj.

class Manipulator <T extends HasF> {

    public Manipulator(T object) {
        this.object = object;
    }

    T object;
        public void manupulate() {
            object.f();
        }
}


class HasF {
    public void f() {
        System.out.println("HASF!");
    }
}