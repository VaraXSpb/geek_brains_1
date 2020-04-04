package java3_hw1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {
    private ArrayList <T> fruits=new ArrayList<>();

    public Box(T fruit){
        this.fruits.add(fruit);
    }
    public Box(T[] fruits){
        this.fruits.addAll(Arrays.asList(fruits));
    }

    public void addFruits(T fruit) {
        this.fruits.add(fruit);
    }


    public float getWeight(){
        float weight;
        if (fruits.size()==0){
            return 0;
        }
        if (fruits.get(0) instanceof Apple){
            weight=1f;
        } else if (fruits.get(1) instanceof Orange){
            weight=1.5f;
        } else {
            return 0;
        }
        return weight*fruits.size();
    }

    public boolean compare(Box <? extends Fruit> another){
        return this.getWeight()-another.getWeight()<0.00000001f;
    }

    public void moveFruitsToNewBox(Box <T> newBox){
        for (T fruit : fruits) {
            newBox.addFruits(fruit);
        }
        fruits.clear();
    }
}
