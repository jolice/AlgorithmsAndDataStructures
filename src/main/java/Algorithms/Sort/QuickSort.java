package Algorithms.Sort;

public class QuickSort implements Sort {

    private static final int THRESHOLD = 10;

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        int size = right - left + 1;
        if (size < THRESHOLD)
            insertionSort(array, left, right);
        else {
            int median = median(array, left, right);
            int partition = partitionIt(array, left, right, median);
            quickSort(array, left, partition - 1);
            quickSort(array, partition + 1, right);
        }
    }

    private int median(int[] array, int left, int right) {
        int center = (left + right) / 2;

        // Упорядочение left и center
        if (array[left] > array[center])
            swap(array, left, center);

        // Упорядочение left и right
        if (array[left] > array[right])
            swap(array, left, right);

        // Упорядочение center и right
        if (array[center] > array[right])
            swap(array, center, right);

        // Размещение медианы на правом краю
        swap(array, center, right - 1);

        return array[right - 1]; // Метод возвращает медиану
    }


    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private int partitionIt(int[] array, int left, int right, int pivot) {

        int leftPtr = left + 1; // Справа от первого элемента
        int rightPtr = right - 2; // Слева от опорного элемента
        while (true) {

            while (array[leftPtr] < pivot)
                leftPtr++;

            while (array[rightPtr] > pivot)
                rightPtr--;

            if (leftPtr >= rightPtr)
                break;
            else
                swap(array, leftPtr++, rightPtr--);
        }

        swap(array, leftPtr, right - 1);
        return leftPtr; // Позиция разбиения
    }

    private void insertionSort(int[] array, int left, int right) {

        int in, out;

        for (out = left + 1; out <= right; out++) {
            int temp = array[out];
            in = out;

            while (in > left && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
    }

}
