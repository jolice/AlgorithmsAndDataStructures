package DataStructures.Linked;

public class FirstLastLinkedList implements LinkedList {

    private Node first;
    private Node last;

    @Override
    public void insertFirst(int i) {
        Node newNode = new Node(i);
        // Если лист пуст, последний элемент становится первым
        if (isEmpty())
            last = newNode;

        // Если first == null, то след.элемент - тоже null, иначе first
        newNode.next = first;

        // first в любом случае - следующий элемент
        first = newNode;
    }

    @Override
    public void insertLast(int i) {
        Node newNode = new Node(i);

        // Если лист пуст, первый элемент - новый
        if (isEmpty())
            first = newNode;
        else
            // Иначе вызывался метод, присваивающий last значение, и last - не null.
            // Назначаем следующий элементом для последнего - новый.
            last.next = newNode;

        // Последний - в любом случае новый
        last = newNode;
    }

    @Override
    public int removeFirst() {
        // Запоминаем значение
        int tmp = first.value;

        // Если лист пустой, т.е в нем один элемент, last и first -> null
        if (first.next == null)
            last = null;

        // В любой случае первый элемент - это следующий для первого
        first = first.next;
        return tmp;
    }

    @Override
    public int get(int index) {
        Node node = first;
        while (index-- > 0)
            node = node.next;
        return node.value;
    }


    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /* ------------------------------------------------------------------------------------------- */

    /*  <=======> Методы контракта ниже как правило не используются в этой реализации  <=======>   */

    /* ------------------------------------------------------------------------------------------- */

    @Override
    public int removeLast() {

        Node prev = first;
        Node current = first;

        // Ищем предпоследний узел
        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        int item = current.value;

        if (prev == current) {
            first = null;
            last = null;
        } else {
            prev.next = null;
            last = prev;
        }

        return item;
    }


    @Override
    public int remove(int index) {

        // Если индекс 0
        if (index == 0) {
            // Просто удаляем из начала
            return removeFirst();
        } else {

            // Ищем предшественника удаляемого
            Node previous = first;
            while (index-- > 1)
                previous = previous.next;

            // Если удаляемый узел - последний, изменяем last ссылку
            if (previous.next == last) {
                last = previous;
            }

            // Запоминаем значение удаляемого узла
            int item = previous.next.value;

            // Следующий для предшествующего - следующий для удаляемого, узел удален
            previous.next = previous.next.next;

            return item;
        }

    }

    @Override
    public void insert(int index, int data) {
        Node newNode = new Node(data);

        // Если втавка в начало
        if (index == 0) {
            insertFirst(data);
        } else {

            // Ищем предшественника вставляемого узла
            Node prev = first;
            while (index-- > 1) {
                prev = prev.next;
            }

            // Если вставка в конец списка
            if (prev == last) {
                // Следующий для последнего - вставляемый
                last.next = newNode;

                // Вставляемый - последний
                last = newNode;
            } else {
                // Вставляем узел между prev и prev.next

                // Следующий для вставляемого - следующий для предшественника замещаемого
                newNode.next = prev.next;

                // Следующий для предшествующего - новый
                prev.next = newNode;
            }

        }
    }

    private static class Node {

        private int value;

        private Node next;

        private Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @Override
    public String toString() {

        Node node = this.first;
        if (node == null) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            while (node != null) {
                sb.append(node.value).append(", ");
                node = node.next;
            }
            return sb.substring(0, sb.lastIndexOf(",")) + "]";
        }
    }




}
