package threads;

import java.util.concurrent.RecursiveTask;

public class ArrayRecursiveTask extends RecursiveTask<Integer> {

    private int start;
    private int end;
    private int[] array;

    /**
     * Создание рекурсивной задачи
     * @param start начальный индекс в массиве
     * @param end конечный индекс в массиве
     * @param array массив с целыми числами
     */
    public ArrayRecursiveTask(int start, int end, int[] array) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        final int diff = end - start;
        switch(diff) {
            case 0: return 0;
            case 1: return array[start];
            case 2: return array[start] + array[start + 1];
//            case 3: return array[start] + array[start + 1] + array[start + 2];
//            case 4: return array[start] + array[start + 1] + array[start + 2] + array[start + 3] ;
            default: return forkTasksAndGetResult();
        }
    }

    private int forkTasksAndGetResult() {
        final int middle = (end - start) / 2 + start;
        ArrayRecursiveTask task1 = new ArrayRecursiveTask(start, middle, array);
        ArrayRecursiveTask task2 = new ArrayRecursiveTask(middle, end, array);
        invokeAll(task1, task2);
        return task1.join() + task2.join();

    }


}
