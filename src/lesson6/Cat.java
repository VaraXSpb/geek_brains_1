package lesson6;

public class Cat extends Animal {
    static int catCount;

    public Cat(String name) {
        super(name, 200, 0, 2);
        catCount++;
    }

    @Override
    protected void swim(int distance) {
        System.out.println("Кошка не умеет плавать!");
    }
}
