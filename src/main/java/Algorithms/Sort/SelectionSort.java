package Algorithms.Sort;

public class SelectionSort implements Sort{

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int tIndex = i;
            // поиск наименьшего элемента от [i  до S]
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < (array[tIndex])) {
                    tIndex = j;
                }
            }
            // обмен наименьшего элемента из [i + 1 до S] с текущим
            int that = array[tIndex];
            array[tIndex] = array[i];
            array[i] = that;
        }
    }
}
