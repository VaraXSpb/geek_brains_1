package lesson6;

public class Dog extends Animal {
    static int dogCount;

    public Dog(String name) {
        super(name, 500, 10, 0.5);
        dogCount++;
    }
}