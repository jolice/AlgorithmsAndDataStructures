package DataStructures.Hash;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

public abstract class BaseHashTableTest {

    private static final int TABLE_SIZE = 16;

    protected abstract HashTable getHashTable();

    private HashTable hashTable;

    @Before
    public void setUp() {
        this.hashTable = getHashTable();
        // 1, 2, 4, 8, 16, 32
        for (int i = 0; i < 6; i++) {
            hashTable.insert((int) Math.pow(2, i), String.valueOf(i));
        }
    }

    /**
     * Обычная вставка степеней двойки и поиск
     */

    @Test
    public void whenInsertElementThenElementExists() {
        for (int i = 0; i < 6; i++) {
            // Проверяем степени двойки
            assertThat(hashTable.find((int) Math.pow(2, i)), is(String.valueOf(i)));
        }
    }

    /**
     * Вставка с коллизией и поиск
     */

    @Test
    public void whenInsertCollisionThenElementsExists() {

        insertWithCollision();

        // Коллизия - 5
        hashTable.insert(21, "_21_");
        hashTable.insert(37, "_37_");

        for (int i = 0; i < 10; i++) {
            assertThat(hashTable.find(39 + TABLE_SIZE * i), is(String.valueOf(i)));
        }

        assertThat(hashTable.find(21), is("_21_"));
        assertThat(hashTable.find(37), is("_37_"));
    }

    /**
     * Вставка с заменой существующего элемента
     */

    @Test
    public void whenReplaceExistingElementThenReplaced() {
        assertThat(hashTable.find(2), is("1"));
        hashTable.insert(2, "2_new");
        assertThat(hashTable.find(2), is("2_new"));
        hashTable.insert(2, "2_new_new");
        assertThat(hashTable.find(2), is("2_new_new"));
    }

    /**
     * Поиск удаленного элемента
     */

    @Test
    public void whenFindAbsentElementThenReturnsNull() {
        assertThat(hashTable.find(32), is("5"));
        for (int i = 1; i < 64; i++) {
            // вставлены только степени двойки, проверяем, не является ли таким число
            if ((i & (i - 1)) != 0) {
                assertNull(hashTable.find(i));
            } else {
                int power = (int) (Math.log(i) / Math.log(2));
                assertThat(hashTable.find(i), is(String.valueOf(power)));
            }
        }
    }

    /**
     * Удаление элемента
     */

    @Test
    public void whenDeleteElementThenElementIsDeleted() {
        for (int i = 0; i < 6; i++) {
            int key = (int) Math.pow(2, i);
            String value = String.valueOf(i);
            assertThat(hashTable.find(key), is(value));
            assertThat(hashTable.delete(key), is(value));
            assertNull(hashTable.find(key));
        }
    }

    /**
     * Удаление элемента при коллизии
     */

    @Test
    public void whenDeleteCollidedElementThenDeleted() {
       insertWithCollision();
       assertThat(hashTable.delete(39), is("0"));
       assertThat(hashTable.find(55), is("1"));
       assertThat(hashTable.delete(55), is("1"));
       assertNull(hashTable.find(39));
       assertNull(hashTable.find(55));
    }


    /**
     * Удаление несуществующего элемента
     */

    @Test
    public void whenDeleteAbsentElementThenReturnsNull() {
        assertThat(hashTable.delete(51), is(nullValue()));
    }


    private void insertWithCollision() {
        this.hashTable = getHashTable();
        for (int i = 0; i < 10; i++) {
            // Коллизия - хеш-функция всегда равна 7
            hashTable.insert(39 + TABLE_SIZE * i, String.valueOf(i));
        }
    }


}
