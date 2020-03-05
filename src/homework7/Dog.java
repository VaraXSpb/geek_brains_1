package homework7;

public class Dog extends Animal {

    public Dog(String name){
        super(name);
    }

    public void bark(Cat cat){
        System.out.println("Dog "+getName()+ " barks at the Cat "+cat.getName());
        cat.scary(this); //this - ссылка на конкретный экземпляр класса Dog
    }

}