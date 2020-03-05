package homework7;

public class Cat extends Animal {
    private int countOfFoodToEat=10;

    public Cat(String name) {
        super(name);
    }

    public void eat(Plate plate) {
        if (this.isFeed()){
            System.out.println("Cat "+getName()+" is full");
        } else {
            plate.decreaseFood(countOfFoodToEat, this);
        }
    }

    public void scary(Dog dog){
        System.out.println("Cat "+getName()+" was afraid of Dog "+dog.getName());
    }
}