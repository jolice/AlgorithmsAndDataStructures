package DataStructures.Hash;

import java.util.Optional;

public class ChainingTable implements HashTable {

    private SortedList[] hashArray;
    private int arraySize;

    public ChainingTable(int size)
    {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int j = 0; j < arraySize; j++)
            hashArray[j] = new SortedList();
    }

    public int hashFunc(int key) // Хеш-функция
    {
        return key % arraySize;
    }

    public void delete(int key) // Удаление элемента
    {
        int hashVal = hashFunc(key); // Хеширование ключа
        hashArray[hashVal].delete(key); // Удаление
    }


    @Override
    public String find(Integer key) {
        int hashVal = hashFunc(key); // Хеширование ключа
        Node theLink = hashArray[hashVal].find(key); // Поиск
        return Optional.ofNullable(theLink).map(Node::getValue).orElse(null); // Метод возвращает найденный элемент
    }

    @Override
    public void insert(Integer key, String value) {
        Node theLink = new Node(key, value);
        int hashVal = hashFunc(key); // Хеширование ключа
        hashArray[hashVal].insert(theLink); // Вставка в позиции hashVal
    }

    @Override
    public String delete(Integer key) {
        int hashVal = hashFunc(key); // Хеширование ключа
        return Optional.ofNullable(hashArray[hashVal].delete(key)).
                map(Node::getValue).orElse(null); // Метод возвращает найденный элемент
    }

    private static class SortedList {

        private Node first;

        private void insert(Node theNode) {
            int key = theNode.key;
            Node previous = null;
            Node current = first;
// До конца списка
            while (current != null && key > current.key) { // Или пока current <= key
                previous = current;
                current = current.next; // Переход к следующему элементу
            }
            if (previous == null) // В начале списка
                first = theNode; // first --> новый элемент
            else // Не в начале
                previous.next = theNode; // prev --> новый элемент
            theNode.next = current; // новый элемент --> current
        }

        private Node delete(int key)
        {
            Node previous = null; // Начиная с первого элемента
            Node current = first;
// До конца списка
            while (current != null && key != current.key) { // или пока key != current
                previous = current;
                current = current.next; // Переход к следующему элементу
            }

            if (current != null) {
// Отсоединение
                if (previous == null) // Если первый элемент,
                    first = first.next; // изменить first
                else // В противном случае
                    previous.next = current.next; // удалить текущий элемент
            }


            return current;
        } // end delete()

        private Node find(int key) // Поиск элемента с заданным ключом
        {
            Node current = first; // Начиная от начала списка
// До конца списка
            while (current != null && current.key <= key) { // или пока ключ не превысит current,
                if (current.key == key) // Искомый элемент?
                    return current; // Совпадение обнаружено
                current = current.next; // Переход к следующему элементу
            }
            return null; // Элемент не найден
        }

    }

    private static class Node {

        private int key;
        private String value;

        private Node next;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}

