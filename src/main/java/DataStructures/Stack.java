package DataStructures;

/**
 * Структура данных, работающая по принципу LIFO
 */

@SuppressWarnings("unchecked")
public class Stack<E> {

    /**
     * Конструирует стек фиксированного размера
     *
     * @param size размер стека
     */

    public Stack(int size) {
        this.array = new Object[size];
    }

    private Object[] array;

    /**
     * Индикатор вершины стека
     */
    private int top;


    /**
     * Размещает элемент на вершине стека.
     *
     * @param element размещяемый элемент
     */

    public void push(E element) {
        array[top++] = element;
    }

    /**
     * Извлекает элемент с вершины стека. Используется префиксный
     * инкремент, поскольку элемент нужно извлечь с предыдущей позиции:
     * top всегда соответствует пустой ячейке, потому что после вставки элемента
     * он увеличивается на 1 и перемещается на пустую позицию, следующую после
     * только что вставленного элемента.
     *
     * @return элемент с вершины стека
     */

    public E pop() {
        return (E) array[--top];
    }

    /**
     * Возвращает элемент с вершины стека. Извлекается элемент top - 1,
     * поскольку top всегда указывает на пустую ячейку. Подробнее в описании
     * метода pop.
     *
     * @return элемент с вершины стека
     */
    public E peek() {
        return (E) array[top - 1];
    }

    /**
     * Проверяет, есть ли в стеке элементы.
     *
     * @return пустой ли стек
     */

    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Проверяет, заполнен ли стек.
     *
     * @return истина, если индикатор вершины равен длине массива.
     */

    public boolean isFull() {
        return top == array.length;
    }


}
