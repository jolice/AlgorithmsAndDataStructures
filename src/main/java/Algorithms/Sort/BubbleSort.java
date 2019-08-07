package Algorithms.Sort;

import java.lang.reflect.Field;

public class BubbleSort implements Sort {


    @Override
    public void sort(int[] array) {
        // Позиция последней перестановки
        int unsortedHigherBound = array.length;
        while (unsortedHigherBound != 0) {
            // Позиция последней перестновки для текущего цикла. Предположим, что массив отсортирован (0)
            int lastSwap = 0;
            for (int j = 1; j < unsortedHigherBound; j++) {
                if (array[j - 1] > array[j]) {
                    int t = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = t;
                    // Была перестановка, массив не отсортирован
                    lastSwap = j;
                }
            }
            // Если lastSwap = 0, цикл завершается, иначе продолжается до позиции посл. перестановки
            unsortedHigherBound = lastSwap;

        }
    }

}
