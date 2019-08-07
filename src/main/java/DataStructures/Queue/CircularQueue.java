package DataStructures.Queue;

@SuppressWarnings("unchecked")
public class CircularQueue<E> implements Queue<E> {

    private Object[] array;

    /**
     * Голова очереди
     */
    private int front;

    /**
     * Хвост очереди
     */
    private int rear;

    /**
     * Размер очереди
     */
    private int size;

    public CircularQueue(int capacity) {
        array = new Object[capacity];
    }

    @Override
    public void insert(E i) {

        // Циклический перенос
        if (rear == array.length)
            rear = 0;

        array[rear++] = i;
        size++;
    }

    @Override
    public E remove() {

        // Сперва извлечем элемент из конца
        E element = (E) array[front++];

        // Если в результате последнего удаления front - конец массива, обнуляем
        if (front == array.length)
            front = 0;

        size--;
        return element;
    }

    @Override
    public E peek() {
        return (E) array[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (size > 0) {
            sb.append(array[front]);
            for (int i = front + 1; i != rear; i++) {
                if (i == array.length) {
                    i = 0;
                }
                sb.append(", ").append(array[i]);
            }
        }
        return sb.append("]").toString();
    }


}
