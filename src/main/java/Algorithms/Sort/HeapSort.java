package Algorithms.Sort;

public class HeapSort implements Sort {

    @Override
    public void sort(int[] arr) {

        int size = arr.length;

        // Построение пирамиды из массива
        for (int j = (size >>> 1) - 1; j >= 0; j--)
            heapify(arr, j, size);

        // Извлечение из пирамиды с сохранением в конце массива
        for (int j = size - 1; j >= 0; j--) {
            int root = arr[0];
            arr[0] = arr[--size];
            heapify(arr, 0, size);   // Восстанавливаем пирамиду после извлечения элемента
            arr[j] = root;
        }
    }

    private void heapify(int[] heapArray, int index, int currentSize) {

        int top = heapArray[index]; // Сохранение корня текущей пирамиды (не обязательно 0)
        while (index < currentSize >>> 1) { // до нижнего уровня

            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            int largerChild;

            // Определение большего потомка
            if (rightChild < currentSize &&
                    heapArray[leftChild] <
                            heapArray[rightChild])
                largerChild = rightChild;
            else
                largerChild = leftChild;

            // Если текущий узел больше потомка, операция завершена
            if (top >= heapArray[largerChild])
                break;

            // Иначе - продолжаем. Потомок сдвигается вверх, текущий узел идет ниже.
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }
}
