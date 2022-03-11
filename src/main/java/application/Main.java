package application;

import threads.ArrayRecursiveTask;
import tools.ArrayGenerator;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static int[] array;

    public static void main(String[] args) {

        System.out.println("Введите размер массива: ");
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите максимальное значение для элемента массива: ");
        int maxValue = Integer.parseInt(scanner.nextLine());

        array = ArrayGenerator.generateArray(size, maxValue);
        //ArrayGenerator.printArray(array);

        long startTime0 = System.currentTimeMillis();
        int result = new ForkJoinPool().invoke(new ArrayRecursiveTask(0, array.length, array));
        long endTime0 = System.currentTimeMillis();
        System.out.println("Сумма элементов массива [многопоточное выполнение]: " + result);
        System.out.println("Время выполнения, мс: " + (endTime0 - startTime0));

        long startTime1 = System.currentTimeMillis();
        result = ArrayGenerator.getSum(array);
        long endTime1 = System.currentTimeMillis();
        System.out.println("Сумма элементов массива [однопоточное выполнение]: " + result);
        System.out.println("Время выполнения, мс: " + (endTime1 - startTime1));
    }
}
