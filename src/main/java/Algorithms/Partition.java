package Algorithms;

public class Partition {

    public int partition(int[] array, int pivot) {
        return partition(array, 0, array.length - 1, pivot);
    }

    public int partition(int[] array, int left, int right, int pivot) {

        int leftPtr = left; // Справа от первого элемента
        int rightPtr = right; // Слева от опорного элемента
        while (true) {


            while (leftPtr < right && array[leftPtr] < pivot) {
                leftPtr++;
            }

            while (rightPtr > left && array[rightPtr] > pivot) {
                rightPtr--;
            }

            if (leftPtr >= rightPtr)
                break;
            else
                swap(array, leftPtr++, rightPtr--);
        }
        return leftPtr;

    }

    private void swap(int[] array, int dex1, int dex2) {
        int temp = array[dex1];
        array[dex1] = array[dex2];
        array[dex2] = temp;
    }

}
