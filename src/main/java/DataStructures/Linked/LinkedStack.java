package DataStructures.Linked;

public class LinkedStack<E> {

    private Node<E> first;

    public void push(E e) {
        first = new Node<>(e, first);
    }

    public E peek() {
        return first.value;
    }

    public E pop() {
        E value = first.value;
        first = first.next;
        return value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private static class Node<E> {

        private E value;
        private Node<E> next;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
