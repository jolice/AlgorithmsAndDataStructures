package DataStructures.Queue;

@SuppressWarnings("unchecked")
public class ArrayPriorityQueue<E extends Comparable<E>> implements Queue<E> {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayPriorityQueue<>(10);
        queue.insert(3);
        queue.insert(1);
        queue.insert(8);
        while (!queue.isEmpty())
            System.out.println(queue.remove());
    }

    private Comparable<E>[] array;
    private int size;

    public ArrayPriorityQueue(int capacity) {
        this.array = new Comparable[capacity];
    }

    @Override
    public void insert(E item) {
        if (size == 0) {
            array[0] = item;
        } else {
            int i;
            for (i = size; i > 0; i--) {
                // Сортируем в обратном порядке
                if (item.compareTo((E) array[i - 1]) > 0) {
                    array[i] = array[i - 1];
                } else {
                    break;
                }
            }
            array[i] = item;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    public E remove() {
        return (E) array[--size];
    }

    @Override
    public E peek() {
        return (E) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
