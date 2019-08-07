package DataStructures.Heap;

public class Heap {

    /**
     * Массив для хранения пирамиды
     */
    private int[] heapArray;

    /**
     * Размер пирамиды (количество элементы)
     */
    private int size;

    /**
     * Конструирует пирамиду фиксированного размера
     *
     * @param capacity вместительность кучи
     */

    public Heap(int capacity) {
        this.heapArray = new int[capacity];
    }

    /**
     * Вводит элемент в пирамиду (кучу)
     *
     * @param key элемент
     * @return был ли вставлен элемент в кучу
     */

    public boolean insert(int key) {

        if (size == heapArray.length) // Проверка, не заполнен ли массив
            return false;

        heapArray[size] = key; // Размещение в конце массива
        siftUp(); // Смещение вверх
        size++;
        return true;
    }

    /**
     * Извлекает элемент с максимальным приоритетом
     *
     * @return максимальный элемент в пирамиде
     */

    public int remove() {
        Integer root = heapArray[0]; // Сохранение корня
        heapArray[0] = heapArray[--size]; // Корень заменяется последним узел
        siftDown(); // Нисходящее просеивание
        return root;
    }

    /**
     * Просеивает элемент через кучу вниз, перемещая его на правильную позицию
     */

    private void siftDown() {

        int index = 0;  // Текущий индекс перемещаемого элемента
        int largerChild; // Индекс большего потомка
        int top = heapArray[index]; // Сохранение корня
        while (index < size >>> 1) { // Пока у узла имеется хотя бы один потомок

            int leftChild = 2 * index + 1; // Индекс левого потомка
            int rightChild = leftChild + 1; // Индекс правого потомка

            // Определение большего потомка
            if (rightChild < size && // (Правый потомок существует?)
                    heapArray[rightChild] > heapArray[leftChild])
                largerChild = rightChild;
            else
                largerChild = leftChild;

            // Если просеиваемый элемент больше потомка, его позиция корректна, операция завершена
            if (top >= heapArray[largerChild]) {
                break;
            }

            heapArray[index] = heapArray[largerChild]; // Сдвигаем потомка вверх
            index = largerChild; // Переход вниз
        }

        heapArray[index] = top; // Размещаем элемент по найденному индексу
    }

    /**
     * Просеивает элемент через кучу вверх после вставки
     */

    private void siftUp() {

        int index = size;
        int parent = (index - 1) >>> 1;
        int bottom = heapArray[index];

        // Пока не переместились к вершине пирамиды и вставляемый элемент больше родителя, сдвигаем вверх
        while (index > 0 && heapArray[parent] < bottom) {
            heapArray[index] = heapArray[parent]; // Узел перемещается вниз
            index = parent; // индекс перемещается вверх
            parent = (parent - 1) >>> 1; // новый родитель - родитель текущего родителя
         }

        // Индекс для вставки найден, размещаем
        heapArray[index] = bottom;
    }


}
