package DataStructures.Linked;

public class DoublyLinkedList implements LinkedList {

    private Node first;
    private Node last;

    @Override
    public void insertFirst(int value) {
        Node newNode = new Node(value);

        if (isEmpty())
            // Если лист пуст, то первый элемент становится последним
            last = newNode;
        else
            // Если first существует, предыдущия для нее - новый элемент
            first.prev = newNode;

        // Следующий для нового - первый
        newNode.next = first;

        // Первый в любом случае - новый
        first = newNode;
    }

    @Override
    public void insertLast(int i) {
        Node newNode = new Node(i);
        if (isEmpty())
            // Если лист пуст, последний элемент становится первым
            first = newNode;
        else {
            // Иначе: следующий элемент для текущего последнего - вставляемый.
            last.next = newNode;
            // Предыдущий элемент для вставляемого - текущий последний.
            newNode.prev = last;
        }

        // Последний в любом случае - новый.
        last = newNode;
    }


    @Override
    public int removeFirst() {

        // Запоминаем исходный узел
        final Node toRemove = first;

        // Если длина списка - 1, то последний элемент - null
        if (toRemove.next == null)
            last = null;
        else
            // Иначе предыдущий элемент для текущго второго - null, потому что он перемещается в
            // начало и перед ним нет элементов
            first.next.prev = null;

        // Новый первый - следующий для текущего первого
        first = first.next;
        return toRemove.value;
    }

    @Override
    public int removeLast() {
        // Запоминаем последний элемент
        final Node tmp = last;

        // Если длина списка - 1, просто удаляемый первый элемент
        if (first.next == null)
            first = null;
        else
            // Иначе: предпоследний элемент становится последним, Т.е для него next - null
            last.prev.next = null;

        // Последний элемент - предыдущий для последнего
        last = last.prev;
        return tmp.value;
    }





    @Override
    public int remove(int i) {

        Node current = first;

        // Ищем удаляемый узел
        while (i-- > 0)
            current = current.next;

        // Если индекс - 0
        if (current == first)
            // Обычная вставка в начало
            first = current.next;
        else
            // Удаляем узел. Переключаем следующий узел. Следующий для предшественника удаляемого - теперь не удаляемый, а следующий для удаляемого
            current.prev.next = current.next;

        // Если удаление из конца
        if (current == last)
            // Обычное удаление из конца
            last = current.prev;
        else
            // Продолжение удаление. Переключаем предыдущий узел. Предыдущий для последующего удаляемому - предшествующий удаляемому.
            current.next.prev = current.prev;

        return current.value;
    }

    /**
     * Вставка элемента по индексу.
     * @param index индекс
     * @param data вставляемые данные
     * @see java.util.LinkedList
     *
     * Использована реализация из стандартной библиотеки
     */

    @Override
    public void insert(int index, int data) {

        final Node newNode = new Node(data);

        Node current = first;
        // Ищем замещаемый узел
        while (index-- > 0)
            current = current.next;

        // Если вставка в конец
        if (current == null) {

            Node l = last;
            // Теперь предыдущий узел для нового - последний
            newNode.prev = l;

            // Последний - новый
            last = newNode;

            // Если лист был пустой при вставке
            if (l == null)
                // Первый узел - это последний (при листе длиной <= 1)
                first = newNode;
            else
                // Если лист был не пустой, следующий узел для бывшего последнего - новый
                l.next = newNode;
        } else {
            // Вставка не в конец

            // Предыдущий узел для замещаемого
            Node prev = current.prev;

            // Предыдущий для нового - предыдущий для замещаемого
            newNode.prev = prev;

            // Следующий для нового - замещаемый (сдвиг замещаемого на 1 вправо)
            newNode.next = current;

            // И наоборот - предыдущий для замещаемого - новый
            current.prev = newNode;

            // Если предыдущий для замещаемого - null, т.е замещаемый - это первый узел
            if (prev == null)
                // Вставляем в начало, т.е первый - новый
                first = newNode;
            else
                // Если замещаемый - не первый, то следующий для предыдущего замещаемого - новый узел
                prev.next = newNode;
        }


    }


    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int get(int i) {

        Node node = first;

        while (i-- > 0)
            node = node.next;

        return node.value;
    }


    private static class Node {

        private int value;

        private Node next;
        private Node prev;

        public Node(int value) {
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
