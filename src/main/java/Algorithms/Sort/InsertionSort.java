package Algorithms.Sort;

public class InsertionSort implements Sort {

    @Override
    public void sort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            // Запоминаем текущий элемент, покольку он скорее всего будет замещен сдвигом
            int current = ints[i];
            int n;
            // Пока текущий элемент меньше предыдущего
            for (n = i; n > 0 && ints[n - 1] > current; n--)
                ints[n] = ints[n - 1];

            ints[n] = current;
        }
    }

}
