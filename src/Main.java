import Fruits.Apple;
import Fruits.Box;
import Fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 6, 1, 2, 3, 7};
        String[] arrStr = {"one", "two", "three", "four", "five"};
        swap(arr, 1, 2);
        swap(arrStr, 0, 1);
        ArrToArrayList(arr);


        Box<Apple> appleBox = new Box<Apple>();
        Box<Apple> appleBox2 = new Box<Apple>();

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox2.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<Orange>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        appleBox.getWeight();
        appleBox.compare(orangeBox);
        appleBox.moveFruitsFromBox(appleBox2);



    }

    public static <T> T[] swap(T[] arr, int a, int b) {
        T c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;

        return arr;
    }

//    public static <T> void print(T[] arr) {
//        for (T t : arr) {
//            System.out.print(t + " ");
//        }
//        System.out.println("\n");
//    }

    public static <T> ArrayList<T> ArrToArrayList(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }

}
