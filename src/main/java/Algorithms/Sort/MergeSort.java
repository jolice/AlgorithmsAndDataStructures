package Algorithms.Sort;


public class MergeSort implements Sort {

    private int[] ints;

    @Override
    public void sort(int[] ints) {
        if (ints.length > 0) {
            this.ints = ints;
            int[] workspace = new int[ints.length];
            sort(workspace, 0, ints.length - 1);
        }
    }

    private void sort(int[] workSpace, int lowerBound, int upperBound) {


        if (lowerBound != upperBound) {

            // Середина текущего диапазона
            int mid = (lowerBound + upperBound) / 2;

            // Сортируем первую часть текущего диапазона
            sort(workSpace, lowerBound, mid);

            // Сортируем вторую часть текущего диапазона
            sort(workSpace, mid + 1, upperBound);

            // Сливаем отсортированные части
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    /**
     * Сливает отсортированные диапазоны массива [lowPtr, highPtr) [highPtr, upperBound]
     * в один отсортированный диапазон.
     * <p>
     * Это достигается последствием слияния этих диапазонов в отдельном массиве и копирования
     * результата слияния в исходный массив начиная с lowPtr и заканчивая higherBound.
     *
     * @param workSpace  сервисный массив, в котором осуществляется слияние
     * @param lowPtr     нижняя грань первого диапазона
     * @param highPtr    конец первого диапазона и начало второго
     * @param upperBound конец второго диапазона
     */

    private void merge(int[] workSpace, int lowPtr, int highPtr,  /* Верхняя грань
     второго сливаемого диапазона */ int upperBound) {


        // Счетчик для рабочей области
        int j = 0;

        // Начало первого диапазона
        int lowerBound = lowPtr;

        // Середина между двумя сливаемыми диапазонами, конец первого и начало второго
        int mid = highPtr - 1;

        // Общая длина сливаемых диапазонов
        int n = upperBound - lowerBound + 1;


        // Пока счетчик для 1 диапазона (начальный индекс диапазона) меньше вершины 1 диапазона
        // И счетчик для 2 диапазона (начальный индекс) диапазона меньше вершины второго диапазона
        while (lowPtr <= mid && highPtr <= upperBound)

            // Вычисление наименьшего элемента
            if (ints[lowPtr] < ints[highPtr])
                // Наименьший - из первого диапазона
                workSpace[j++] = ints[lowPtr++];
            else
                // Наименьший - из второго диапазона
                workSpace[j++] = ints[highPtr++];

        // В итоге вставляем наименьший в результирующий массив

        // Если в первом массиве остались необработанные элементы, вставляем в результирующий
        while (lowPtr <= mid)
            workSpace[j++] = ints[lowPtr++];

        // Если во втором массиве остались необработанные элементы, вставляем в результирующий
        while (highPtr <= upperBound)
            workSpace[j++] = ints[highPtr++];

        // Вставляем результат слияния в результирующий массив, начиная с исходного диапазона
        for (j = 0; j < n; j++)
            ints[lowerBound + j] = workSpace[j];
    }
}
