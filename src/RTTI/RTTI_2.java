package RTTI;

import java.lang.reflect.InvocationTargetException;

public class RTTI_2 {
    public static void main(String[] args) {
        AA aa = null;
        try {
            aa = AA.class.getDeclaredConstructor(int.class).newInstance(1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(aa.equals(new AA(2)));
    }
}


class AA {
    public int value;

    public AA(int value) {
        this.value = value;
    }

    void mdo() {
    System.out.println("mdo");
    }

    @Override
    public boolean equals(Object obj) {
        if (this.value == ((AA) obj).value) {
            return true ;
        } else return false;
    }
}

class BB {

}