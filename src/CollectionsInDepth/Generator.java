package CollectionsInDepth;

import java.util.Arrays;
import java.util.Random;



//Class Hierarchy:
//        BASE
//      /   |   \
//     A    B    C


// Generator is parameterized by BASE to return random Base-derived object.


class GenTest {
    public static Class[] classes = new Class[]{A.class, B.class, C.class};
    public static void main(String[] args) {
    Generator<Base> generator = new Generator<>();
        System.out.println(Arrays.toString(generator.nextBundle(5)));
    }
}

public class Generator<T> {
    T[] resultBundle;

    public Generator() {

    }

    public T[] nextBundle(int q) {
        resultBundle = (T[]) new Object[q];

        for (int i = 0; i < q; i++) {
            Random random = new Random();
            try {
                resultBundle[i] = (T) GenTest.classes[random.nextInt(3)].newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return resultBundle;
    }
}

class Base {
    @Override
    public String toString() {
        return "BASE";
    }
}

class B extends Base{
    @Override
    public String toString() {
        return "B";
    }
}

class C extends Base {
    @Override
    public String toString() {
        return "C";
    }
}

class A extends Base {
    @Override
    public String toString() {
        return "A";
    }
}


