package Generics;

import java.util.HashMap;
import java.util.Map;

class Building {}
class House extends Building {}
public class ClassTypeCapture<T> {

    Class<T> kind;
    public ClassTypeCapture() {

        map.put("Building", Building.class);
        map.put("House", House.class);
        map.put("String", String.class);
    }

    Map<String,Class<?>> map = new HashMap<>();

    public void createNew(String typeName) {
        if (map.containsKey(typeName)) {
            try {
                map.get(typeName).newInstance();
            } catch (Exception e) {
                System.out.println("CANT instantiate");
            }
        } else {
            System.out.println("No such object template in the pool");
        }

    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }
    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>();
        ctt1.createNew("Building");
        ctt1.createNew("Object");





    }
}
