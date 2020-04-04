package homework6;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Кошка");
        Dog dog = new Dog("Собака");

        cat.run(100);
        cat.jump(2);
        cat.swim(100);

        dog.run(400);
        dog.jump(3);
        dog.swim(8);

        System.out.println();
        System.out.printf("Создано животных: %d. Из них:\nКотов - %d,\nСобак - %d.", Animal.animalsCount, Cat.catCount, Dog.dogCount);
    }
}
