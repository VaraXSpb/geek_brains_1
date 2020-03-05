package homework7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Food: " + food);
    }

/*    public void setFood(int food) {
        this.food = food;
    }*/

    /*  public int getFood() {
          return food;
      }*/
    public void decreaseFood(int amount, Animal animal) {
        if (food-amount>=0) {
            System.out.println(animal.getName() + " eating...");
            food -= amount;
            animal.setFeed(true);
            this.info();
        } else {
            System.out.println("Not enough food too feed "+animal.getName());
        }
    }

    public void addFood(int food){
        this.food=food;
    }

}