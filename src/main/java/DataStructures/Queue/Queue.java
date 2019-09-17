package DataStructures.Queue;

public interface Queue<E> {

    boolean isFull();

    boolean isEmpty();

    E peek();

    E remove();

    void insert(E i);

    int size();
}
