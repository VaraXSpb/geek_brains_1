package java3_hw1;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange[] oranges = {new Orange(), new Orange()};
        Apple moreApple = new Apple();

        Box<Orange> box1 = new Box<>(oranges);
        Box<Apple> box3 = new Box<>(apple);
        Box<Apple> box4 = new Box<>(new Apple[]{apple, moreApple});
        box4.addFruits(apple);

        System.out.println(box4.getWeight());
        System.out.println(box1.compare(box4));

        box4.moveFruitsToNewBox(box3);
        System.out.println(box4.getWeight());
        System.out.println(box3.getWeight());
    }
}
