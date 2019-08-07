package DataStructures.Hash;

public class OpenAddressingTable implements HashTable {


    private int size;
    private Node[] hashTable;

    public OpenAddressingTable(int size) {
        this.hashTable = new Node[size];
    }

    @Override
    public String find(Integer key) {
        // (Метод предполагает, что таблица не заполнена)
        int hashVal = hash(key); // Хеширование ключа
        while (hashTable[hashVal] != null) // Пока не будет найдена пустая ячейка
        { // Ключ найден?
            if (hashTable[hashVal].getKey() == key)
                return hashTable[hashVal].getValue(); // Да, вернуть элемент
            ++hashVal; // Переход к следующей ячейке
            hashVal %= hashTable.length; // При достижении конца таблицы
        } // происходит возврат к началу
        return null;
    }

    @Override
    public void insert(Integer key, String value) {


        double loadFactor = (double) size / hashTable.length;

        if (loadFactor >= MAX_LOAD_FACTOR)
            rehash();


        // (Метод предполагает, что таблица не заполнена)
        // Получение ключа
        int hashVal = hash(key);// Хеширование ключа
// Пока не будет найдена

        Node node;
        /* заменяем существующий элемент*/
        while ((node = hashTable[hashVal]) != null && node != Node.EMPTY && node.getKey() != key) {
            ++hashVal; // Переход к следующей ячейке
            hashVal %= hashTable.length; // При достижении конца таблицы
        }

        hashTable[hashVal] = new Node(key, value);
        size++;
    }


    @Override
    public String delete(Integer key) {
        int hashVal = hash(key); // Хеширование ключа
        while (hashTable[hashVal] != null) // Пока не будет найдена пустая ячейка
        { // Ключ найден?

            if (hashTable[hashVal].getKey() == key) {
                Node temp = hashTable[hashVal]; // Временное сохранение
                hashTable[hashVal] = Node.EMPTY;  // Удаление элемента
                size--;
                return temp.getValue(); // Метод возвращает элемент
            }
            ++hashVal; // Переход к следующей ячейке
            hashVal %= hashTable.length; // При достижении конца таблицы
        } // происходит возврат к началу
        return null;
    }

    private void rehash() {

        Node[] currentTable = this.hashTable;

        // Ищем простой размер таблицы

        int length = nextPrime(currentTable.length * 2);

        // Расширяем таблицу
        this.hashTable = new Node[length];


        for (Node node : currentTable) {
            if (node != null && node != Node.EMPTY) {
                int key = node.getKey();
                // С учетом новой длины таблицы
                int hashVal = hash(key);
                Node currentNode;
                while ((currentNode = hashTable[hashVal]) != null && currentNode != Node.EMPTY && currentNode.getKey() != key) {
                    ++hashVal;
                    hashVal %= hashTable.length;
                }
                hashTable[hashVal] = node;
            }
        }
    }

    private int hash(int key) {
        return key % hashTable.length;
    }

    private static int nextPrime(int number) {
        while (!isPrime(number))
            number++;
        return number;
    }

    private static boolean isPrime(int number) {
        boolean result = number % 2 == 1;
        if (result) {
            for (int i = 3; i < number; i++) {
                if (number % i == 0) {
                    result = false;
                }
            }
        }
        return result;
    }
}
