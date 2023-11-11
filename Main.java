// Base class
class Animal {
    void speak() {
        System.out.println("The animal makes a sound.");
    }
}

// Subclass Dog
class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("The dog barks.");
    }
}

// Subclass Cat
class Cat extends Animal {
    @Override
    void speak() {
        System.out.println("The cat meows.");
    }

    void parentSpeak() {
        super.speak(); // Calling the speak method of the superclass (Animal)
    }
}

// Main class to test the hierarchy
public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myAnimal.speak(); // Outputs: The animal makes a sound.
        myDog.speak();    // Outputs: The dog barks.
        myCat.speak();    // Outputs: The cat meows.

        // Demonstrating the use of super
        ((Cat)myCat).parentSpeak(); // Outputs: The animal makes a sound.
    }
}
