package DataStructures.Linked;

/**
 * Однонаправленный односвязный список
 */
public class BasicLinkedList implements LinkedList {

    private Node first;

    @Override
    public void insertFirst(int i) {
        Node newNode = new Node(i);
        // Вставляем в начало списка, т.е след. узел для новый - текущий первый
        newNode.next = first;
        // Новый становится перрвым
        first = newNode;
    }

    @Override
    public int removeFirst() {
        // Запоминаем первый узел
        Node temp = first;
        // Первый теперь - следующий для бывшего первого
        first = first.next;
        return temp.value;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }


    @Override
    public int remove(int index) {

        Node current = first;
        Node previous = first;

        // Получаем ссылки на удаляемый узел и предыдущий

        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }

        // Если удаляемый узел - первый
        if (current == first)
            // обычная процедура удаления первого элемента
            first = first.next;
        else
            // Удаляем узел из цепочки: после предшествующего удаляемому
            // теперь находится не удаляемый узел, а следующий для удаляемого
            previous.next = current.next;

        return current.value;
    }

    @Override
    public int get(int index) {
        Node node = first;
        while (index-- > 0)
            node = node.next;
        return node.value;
    }


    /* ------------------------------------------------------------------------------------------- */

    /*  <=======> Методы контракта ниже как правило не используются в этой реализации  <=======>   */

    /* ------------------------------------------------------------------------------------------- */

    @Override
    public void insertLast(int i) {
        Node node = first;

        Node newNode = new Node(i);

        // Если лист пуст - новый узел - просто становится первым
        if (node == null)
            first = newNode;
        else {
            // Ищем последний узел (ссылки на last нет, список односторонний)
            while (node.next != null)
                node = node.next;
            // Присоединяем к последнему узлу
            node.next = newNode;
        }
    }

    @Override
    public void insert(int index, int data) {
        Node newNode = new Node(data);
        // Если индекс - 0
        if (index == 0) {
            // Обычная вставка в начало
            newNode.next = first;
            first = newNode;
        } else {
            Node prev = first;
            // Ищем узел, предшествующий тому, на место которого будет произведена вставка
            // Итерация до 1, т.к ищем предыдущий (i - 1), а не i-й
            while (index-- > 1) {
                prev = prev.next;
            }

            // Вставляем между двумя узлами. Следующий для нового - следующий для предшествующего (замещаемый)
            newNode.next = prev.next;
            // Следующий для предшествующего - новый. Узел вставлен
            prev.next = newNode;
        }
    }

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

        if (prev == current)
            first = null;
        else
            prev.next = null;


        return item;
    }


    private static class Node {

        private int value;
        private Node next;


        Node(int value) {
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
