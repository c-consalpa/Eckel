package Annotations;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface Test {

    int f3() default 666;
}

public class TestAnnotations {
    public static void main(String[] args) throws NoSuchMethodException {
        mAnnotated mAnnotated = new mAnnotated();
        Class<mAnnotated> classObject = mAnnotated.class;
        readAnnotaions(classObject);


        Method method = mAnnotated.getClass().getMethod("act", new Class[]{});
        readAnnotaions(method);

    }

    private static void readAnnotaions(AnnotatedElement elem) {
        Annotation[] annotations = elem.getAnnotations();
        int i = annotations.length;
        for (Annotation an :
                annotations) {
            if (an instanceof Test) {
                Test testAnnotation = (Test) an;
                System.out.println("Processing:");
                System.out.println(elem.getClass());
                System.out.println(testAnnotation.f3());

            }
        }
    }
}

@Test(

)
class mAnnotated {
    public String firstName;

    @Test (f3 = 999)
    public void act() {

    }
}




