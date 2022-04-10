package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitBox;


    public Box(T... fruits) {
        this.fruitBox = new ArrayList<>(Arrays.asList(fruits));
    }

    public void addFruit(T fruit) {
        fruitBox.add(fruit);
    }

    public float getWeight() {
        float fruitWeight = 0.0f;
        for (T fruits : fruitBox) {
            fruitWeight += fruits.getWeight();
        }
        return fruitWeight;
    }

    public boolean compare(Box<?> fruit) {
        return Math.abs((this.getWeight() - fruit.getWeight())) < 0.000001;
    }

    public void moveFruitsFromBox(Box<T> fruit) {
        fruit.fruitBox.addAll(this.fruitBox);
        this.fruitBox.clear();
    }

}
