package DataStructures.Linked;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public abstract class BaseLinkedListTest {

    private LinkedList linkedList;

    public abstract LinkedList getList();

    @Before
    public void setUp() {
        this.linkedList = getList();
        linkedList.insertFirst(22);
        linkedList.insertFirst(44);
        linkedList.insertFirst(66);
        linkedList.insertFirst(88);
    }

    /**
     * Вставка по индексу в конец непустого списка
     */

    @Test
    public void whenInsertElementAtEndThenInserted() {
        linkedList.insert(4, 51);
        assertThat(linkedList.toString(), is("[88, 66, 44, 22, 51]"));
        linkedList.insert(5, 52);
        linkedList.insert(6, 53);
        linkedList.insert(7, 54);
        assertThat(linkedList.toString(), is("[88, 66, 44, 22, 51, 52, 53, 54]"));
    }


    /**
     * Вставка в конец непустого списка
     */

    @Test
    public void whenAddLastThenItContainsInsertedElements() {
        linkedList.insertLast(101);
        linkedList.insertLast(500);
        linkedList.insertLast(606);
        assertThat(linkedList.toString(), is("[88, 66, 44, 22, 101, 500, 606]"));
        assertThat(linkedList.get(4), is(101));
        assertThat(linkedList.get(5), is(500));
        assertThat(linkedList.get(6), is(606));
    }

    /**
     * Вставка в конец пустого списка
     */

    @Test
    public void whenAddLastToEmptyListThenItContainsInsertedElements() {
        linkedList = getList();
        linkedList.insertLast(101);
        linkedList.insertLast(500);
        linkedList.insertLast(606);
        assertThat(linkedList.toString(), is("[101, 500, 606]"));
        assertThat(linkedList.get(0), is(101));
        assertThat(linkedList.get(1), is(500));
        assertThat(linkedList.get(2), is(606));
    }

    /**
     * Вставка по индексу в начало непустого списка
     */

    @Test
    public void whenInsertElementsByIndexAtBeginningThenInserted() {
        linkedList.insert(0, 51);
        assertThat(linkedList.get(0), is(51));
        linkedList.insert(0, 52);
        assertThat(linkedList.get(0), is(52));
        assertThat(linkedList.toString(), is("[52, 51, 88, 66, 44, 22]"));
    }

    /**
     * Вставка по индексу в начало пустого списка
     */

    @Test
    public void whenInsertElementsByIndexAtBeginningOfEmptyListThenInserted() {
        this.linkedList = getList();
        linkedList.insert(0, 51);
        assertThat(linkedList.get(0), is(51));
        linkedList.insert(0, 52);
        assertThat(linkedList.get(0), is(52));
        assertThat(linkedList.toString(), is("[52, 51]"));
    }

    /**
     * Вставка в начало непустого списка
     */

    @Test
    public void whenInsertElementAtBeginningThenInserted() {
        linkedList.insertFirst(51);
        assertThat(linkedList.toString(), is("[51, 88, 66, 44, 22]"));
        linkedList.insertFirst(52);
        linkedList.insertFirst(53);
        linkedList.insertFirst(54);
        assertThat(linkedList.toString(), is("[54, 53, 52, 51, 88, 66, 44, 22]"));
    }

    /**
     * Вставка в начало пустого списка
     */

    @Test
    public void whenInsertElementToEmptyListAtBeginningThenInserted() {
        this.linkedList = getList();
        linkedList.insertFirst(51);
        assertThat(linkedList.toString(), is("[51]"));
        linkedList.insertFirst(52);
        linkedList.insertFirst(53);
        linkedList.insertFirst(54);
        assertThat(linkedList.toString(), is("[54, 53, 52, 51]"));
    }

    /**
     * Вставка по индексу в середину списка
     */

    @Test
    public void whenInsertElementsToRandomPositionThenInsertedProperly() {
        // [88, 66, 44, 22]
        linkedList.insert(1, 55);
        assertThat(linkedList.toString(), is("[88, 55, 66, 44, 22]"));
        // [88, 55, 66, 44, 22]
        linkedList.insert(2, 56);
        assertThat(linkedList.toString(), is("[88, 55, 56, 66, 44, 22]"));
        // [88, 55, 56, 66, 44, 22]
        linkedList.insert(4, 59);
        assertThat(linkedList.toString(), is("[88, 55, 56, 66, 59, 44, 22]"));
        // [88, 55, 56, 66, 59, 44, 22]
        linkedList.insert(6, 251);
        assertThat(linkedList.toString(), is("[88, 55, 56, 66, 59, 44, 251, 22]"));
        // [88, 55, 56, 66, 59, 44, 251, 22]
        linkedList.insert(1, 252);
        assertThat(linkedList.toString(), is("[88, 252, 55, 56, 66, 59, 44, 251, 22]"));
        // [88, 252, 55, 56, 66, 59, 44, 251, 22]
        linkedList.insert(7, 255);
        assertThat(linkedList.toString(), is("[88, 252, 55, 56, 66, 59, 44, 255, 251, 22]"));
        // [88, 252, 55, 56, 66, 59, 44, 255, 251, 22]
        linkedList.insert(10, 226);
        assertThat(linkedList.toString(), is("[88, 252, 55, 56, 66, 59, 44, 255, 251, 22, 226]"));
        // [88, 252, 55, 56, 66, 59, 44, 255, 251, 22, 226]
        linkedList.insert(0, 3113);
        assertThat(linkedList.toString(), is("[3113, 88, 252, 55, 56, 66, 59, 44, 255, 251, 22, 226]"));
    }


    /**
     * Удаление элемента из начала списка по индексу
     */

    @Test
    public void whenRemoveByZeroIndexThenElementIsRemoved() {
        linkedList.remove(0);
        assertThat(linkedList.get(0), is(66));
        assertThat(linkedList.get(1), is(44));
        assertThat(linkedList.get(2), is(22));
        assertThat(linkedList.toString(), is("[66, 44, 22]"));
        linkedList.remove(0);
        assertThat(linkedList.get(0), is(44));
        assertThat(linkedList.get(1), is(22));
    }

    /**
     * Удаление элемента из начала списка
     */

    @Test
    public void whenRemoveFirstThenReturnInProperOrder() {
        assertThat(linkedList.removeFirst(), is(88));
        assertThat(linkedList.removeFirst(), is(66));
        assertThat(linkedList.removeFirst(), is(44));
        assertThat(linkedList.removeFirst(), is(22));
    }

    /**
     * Удаление элементов из середины списка по индексу
     */

    @Test
    public void whenRemoveElementFromMidThenElementIsRemoved() {

        linkedList.remove(2);
        assertThat(linkedList.get(0), is(88));
        assertThat(linkedList.get(1), is(66));
        assertThat(linkedList.get(2), is(22));
        linkedList.remove(0);
        assertThat(linkedList.get(0), is(66));
        assertThat(linkedList.get(1), is(22));
        linkedList.remove(1);
        assertThat(linkedList.get(0), is(66));
        linkedList.remove(0);
        assertThat(linkedList.isEmpty(), is(true));


        for (int i = 0; i < 5; i++) {
            linkedList.insertLast(i); // 0, 1, 2, 3, 4
        }

        linkedList.remove(2); // -> 0, 1, 3, 4
        linkedList.remove(1); // -> 0, 3, 4
        linkedList.remove(2); // -> 0, 3
        assertThat(linkedList.toString(), is("[0, 3]"));

    }

    /**
     * Удаление последнего элемента по индексу
     */

    @Test
    public void whenRemoveLastElementFromEndThenElementIsRemoved() {
        linkedList.remove(3);
        assertThat(linkedList.get(2), is(44));
        assertThat(linkedList.get(1), is(66));
        assertThat(linkedList.get(0), is(88));
        linkedList.remove(2);
        assertThat(linkedList.toString(), is("[88, 66]"));
        linkedList.insertLast(22);
        linkedList.insertLast(51);
        assertThat(linkedList.toString(), is("[88, 66, 22, 51]"));
        linkedList.remove(3);
        assertThat(linkedList.toString(), is("[88, 66, 22]"));
        linkedList.remove(2);
        assertThat(linkedList.toString(), is("[88, 66]"));
    }

    /**
     * Удаление последнего элемента
     */

    @Test
    public void whenRemoveLastElementThenLastElementIsRemoved() {
        linkedList.removeLast();
        assertThat(linkedList.get(2), is(44));
        assertThat(linkedList.get(1), is(66));
        assertThat(linkedList.get(0), is(88));
        linkedList.removeLast();
        assertThat(linkedList.toString(), is("[88, 66]"));
        linkedList.insertLast(22);
        linkedList.insertLast(51);
        assertThat(linkedList.toString(), is("[88, 66, 22, 51]"));
        linkedList.removeLast();
        assertThat(linkedList.toString(), is("[88, 66, 22]"));
    }

    /**
     * Удаление по индексу первого элемента из списка с единственным элементом
     */

    @Test
    public void whenListSizeIsOneThenRemoveByZeroIndexClearsIt() {
        linkedList = getList();
        linkedList.insertLast(5);
        linkedList.remove(0);
        assertThat(linkedList.isEmpty(), is(true));
    }

    /**
     * Удаление первого элемента из списка с единственным элементом
     */


    @Test
    public void whenListSizeIsOneThenRemoveFirstClearsIt() {
        linkedList = getList();
        linkedList.insertLast(5);
        linkedList.removeFirst();
        assertThat(linkedList.isEmpty(), is(true));
    }

    /**
     * Удаление последнего элемента из списка с единственным элементом
     */

    @Test
    public void whenListSizeIsOneThenRemoveLastClearsIt() {
        linkedList = getList();
        linkedList.insertLast(5);
        linkedList.removeLast();
        assertThat(linkedList.isEmpty(), is(true));
    }

    /**
     * Удаление всех элементов из списка, удаляя первый
     */

    @Test
    public void whenRemovingAllFirstElementsThenListBecomesEmpty() {
        for (int i = 0; i < 4; i++) {
            linkedList.removeFirst();
        }
        assertThat(linkedList.isEmpty(), is(true));
    }

    /**
     * Удаление всех элементов из списка, удаляя последний
     */

    @Test
    public void whenRemovingAllLastElementsThenListBecomesEmpty() {
        for (int i = 0; i < 4; i++) {
            linkedList.removeLast();
        }
        assertThat(linkedList.isEmpty(), is(true));
    }

    /**
     * Удаление всех элементов из списка, удаляя по нулевому индексу
     */

    @Test
    public void whenRemovingAllElementsByZeroThenListBecomesEmpty() {
        for (int i = 0; i < 4; i++) {
            linkedList.remove(0);
        }
        assertThat(linkedList.isEmpty(), is(true));
    }


    /**
     * Вывод списка
     */

    @Test
    public void whenToStringThenDisplaysAllElements() {
        assertThat(linkedList.toString(), is("[88, 66, 44, 22]"));
    }

    /**
     * Извлечение элементов по индексу
     */

    @Test
    public void whenGetThenReturnsElementByIndex() {
        assertThat(linkedList.get(0), is(88));
        assertThat(linkedList.get(3), is(22));
        assertThat(linkedList.get(2), is(44));
        assertThat(linkedList.get(1), is(66));
        linkedList.insertFirst(100);
        assertThat(linkedList.get(0), is(100));
    }

    /**
     * Извлечение элементов по индексу, когда в списке один элемент
     */

    @Test
    public void whenGetFromListWithOneElementThenReturnsFirstElement() {
        linkedList = getList();
        linkedList.insertLast(0xFF);
        assertThat(linkedList.get(0), is(0xFF));
        assertThat(linkedList.removeFirst(), is(0xFF));
    }

    /**
     * Проверка корректности работы списка после модифицирующих операций
     */

    @After
    public void postModification() {
        linkedList.insert(0, 9);
        assertThat(linkedList.get(0), is(9));
        linkedList.insert(1, 81);
        assertThat(linkedList.get(1), is(81));
        linkedList.insertFirst(5);
        assertThat(linkedList.get(0), is(5));
        linkedList.insertFirst(9);
        assertThat(linkedList.get(0), is(9));
        linkedList.insertLast(55);
        linkedList.insertLast(31);
        assertThat(linkedList.removeLast(), is(31));
        assertThat(linkedList.removeLast(), is(55));
        assertThat(linkedList.removeFirst(), is(9));
    }


}
