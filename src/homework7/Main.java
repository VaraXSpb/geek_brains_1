package homework7;

public class Main {
    private static String[] catName={"Barsik","Murzik","Cris","Mura","Sema","Marta","Kitty","Lora","Shiba","Sonya"};

    public static void main(String[] args) {
        Cat[] cats=new Cat[10];
        Plate plate = new Plate(92);
        for (int i = 0; i <cats.length ; i++) {
            Cat cat = new Cat(catName[i]);
            cat.eat(plate);
            cat.showFeedStatus();
            System.out.println();
        }

       /* Cat cat = new Cat("Murzik");

        Dog dog=new Dog("Rex");

        cat.eat(plate);
        cat.eat(plate);
        dog.bark(cat);*/
    }
}
