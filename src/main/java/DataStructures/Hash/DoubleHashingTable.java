package DataStructures.Hash;

public class DoubleHashingTable implements HashTable {

    private Node[] hashTable;

    public DoubleHashingTable(int size) {
        this.hashTable = new Node[size];
    }

    @Override
    public String find(Integer key) {
        int hashVal = hash(key); // Хеширование ключа
        int stepSize = doubleHash(key); // Вычисление смещения
        while(hashTable[hashVal] != null) // Пока не найдена пустая ячейка
        { // Ключ найден?
            if(hashTable[hashVal].getKey() == key)
                return hashTable[hashVal].getValue(); // Да, метод возвращает элемент
            hashVal += stepSize; // Прибавление смещения
            hashVal %= hashTable.length; // Возврат к началу
        }
        return null; // Элемент
    }

    @Override
    public void insert(Integer key, String value) {
        int hashVal = hash(key); // Хеширование ключа
        int stepSize = doubleHash(key);// Вычисление смещения
// Пока не будет найдена
        Node node;
        /* заменяем существующий элемент*/
        while ((node = hashTable[hashVal]) != null && node != Node.EMPTY && node.getKey() != key) {
            hashVal += stepSize; // Прибавление смещения
            hashVal %= hashTable.length; // Возврат к началу
        }
        hashTable[hashVal] = new Node(key, value); // Вставка элемента
    }


    @Override
    public String delete(Integer key) {
        int hashVal = hash(key); // Хеширование ключа
        int stepSize = doubleHash(key); // Вычисление смещения
        while(hashTable[hashVal] != null) // Пока не найдена пустая ячейка
        { // Ключ найден?
            if(hashTable[hashVal].getKey() == key)
            {
                Node temp = hashTable[hashVal]; // Временное сохранение
                hashTable[hashVal] = Node.EMPTY; // Удаление элемента
                return temp.getValue(); // Метод возвращает элемент
            }
            hashVal += stepSize; // Прибавление смещения
            hashVal %= hashTable.length; // Возврат к началу
        }
        return null; // Элемент
    }

    private int hash(int key) {
        return key % hashTable.length;
    }

    private static int doubleHash(int key) {
        return 5 - key % 5;
    }
}
