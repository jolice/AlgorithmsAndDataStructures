package DataStructures.Linked;

public interface LinkedList {

    /**
     * Вставляет элемент на определенную позицию
     *
     * @param index    индекс
     * @param data вставляемые данные
     */

    void insert(int index, int data);

    /**
     * Удаляет и возвращает последний элемент
     *
     * @return последний элемент в списке
     */

    int removeLast();

    /**
     * Удаляет и взовращает первый элемент
     *
     * @return первый элемент в списке
     */

    int removeFirst();

    /**
     * Вставляет элемент в конец списка
     *
     * @param i вставляемый элемент
     */
    void insertLast(int i);

    /**
     * Вставляет элемент в начало списка
     *
     * @param i вставляемый элемент
     */

    void insertFirst(int i);

    /**
     * Удаляет элемент по индексу
     *
     * @param i индекс
     * @return удаленный элемент
     */

    int remove(int i);

    /**
     * Проверяет, пуст ли список
     *
     * @return есть ли в списке хотя бы один элемент
     */
    boolean isEmpty();

    /**
     * Возвращает элемент по индексу
     *
     * @param i индекс
     * @return элемент по индексу
     */

    int get(int i);



}
