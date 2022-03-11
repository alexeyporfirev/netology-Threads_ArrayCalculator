package tools;

import java.util.Random;

public class ArrayGenerator {

    public static int[] generateArray(int size, int maxValue) {
        int[] array = new int[size];
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(maxValue);
        }
        return array;
    }

    public static int getSum(int[] array) {
        int sum = 0;
        for(int el: array) {
            sum += el;
        }
        return sum;
    }

    public static void printArray(int[] array) {
        for(int el: array) {
            System.out.println(el);
        }
    }
}
