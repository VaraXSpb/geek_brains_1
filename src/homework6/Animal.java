package lesson6;

import java.util.Random;

public abstract class Animal {

    private Random random = new Random();
    private String name;
    private int runLimit;
    private int swimLimit;
    private double jumpLimit;
    static int animalsCount;


    public Animal(String name, int runLimit, int swimLimit, double jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
        animalsCount++;
    }


    protected void run(int distance) {
        runLimit += random.nextInt(runLimit) - runLimit / 2;
        if (runLimit >= distance) {
            System.out.println(name + " пробежал(-а) " + distance + " метров.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " метров. Предел для этого животного - " + runLimit + " метров.");
        }
    }

    protected void swim(int distance) {
        swimLimit += random.nextInt(swimLimit) - swimLimit / 2;
        if (swimLimit >= distance) {
            System.out.println(name + " проплыл(-а) " + distance + " метров.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " метров. Предел для этого животного - " + swimLimit + " метров.");
        }
    }

    protected void jump(double height) {
        jumpLimit += random.nextDouble() * jumpLimit - jumpLimit / 2;
        if (jumpLimit >= height) {
            System.out.println(name + " перепрыгнул(-а) препятсвие в " + height + " метров.");
        } else {
            System.out.printf("%s не может перепрыгнуть препятствие в %.2f метров. Предел для этого животного - %.2f метров.\n", name, height, jumpLimit);
        }
    }
}
