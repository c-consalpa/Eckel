package Generics.Wildcards;

import java.util.*;


//Covariance: Preserves ordering of subtyping relation. i.e.
//        if A -> B, then Box<A> -> Box<B>
//Contravariance: Reverses the ordering of subtyping relation. i.e.
//        if A -> B, then Box<B> -> Box<A>
//Bivariance: If both of the above applies. i.e.
//        if A -> B, then Box<A> -> Box<B> & Box<B> -> Box<A>
//Invariance: Neither of Covariance or Contravariance apply.

public class Medium_Variance {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
//        Compile-time error:
//        List<Animal> animals1 = new ArrayList<Dog>();

        animals.add(new Animal("Some Lion"));
        animals.add(new Dog("German Shepherd"));
        animals.add(new Cat("RagDoll"));
//        System.out.println(animals);

// won't compile:

        List<Dog> myDogs = new ArrayList<>();
        myDogs.add(new Dog("German Shepherd"));
        myDogs.add(new Dog("Bulldog"));
        myDogs.add(new Dog("Pug"));
//
//        General Rule of Thumb:
//If a structure contains elements with a type of the form ? extends E, we can GET elements out of the structure, but we
// CAN NOT PUT elements into it.

//  General Rule of Thumb:
//  If a structure contains elements with a type of the form ? super E, we can PUT elements into the structure, but we
//  CAN NOT GET elements out of it.


        printNames(myDogs);
    }
    static void printNames(Collection<? extends Animal>  animals) {
        animals.forEach(animal -> System.out.println(animal.name));
    }


    public static void add_N_DogsTo(List<? super Dog> someList, int count) {
        if (count == 0)
            return;

        for (int i = 0; i < count; i++)
            // Adding to the list is allowed
            someList.add(new Dog("Stray Dog " + i ));

        // Reading from the list is NOT allowed. Compilation ERROR !!
        // Animal d = someList.get(0);
    }
}



class Animal {
    String name;
    int troubleMakerRating;

    Animal(String name) {
        this.name = name;
        this.troubleMakerRating = new Random().nextInt();
    }



    }

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}

