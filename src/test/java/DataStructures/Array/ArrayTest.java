package DataStructures.Array;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ArrayTest {

    private Array array;

    @Before
    public void initArray() {
        this.array = new Array(100);
        this.array.insert(77);
        this.array.insert(99);
        this.array.insert(44);
        this.array.insert(55);
        this.array.insert(22);
        this.array.insert(88);
        this.array.insert(11);
        this.array.insert(222);
        this.array.insert(66);
        this.array.insert(33);
    }


    @Test
    public void whenGetArrayElementsThenTheyAreEqualToInserted() {
        long[] expectedArray = new long[]{77, 99, 44, 55, 22, 88, 11, 222, 66, 33};
        long[] copyOfGivenArray = array.getArray();
        assertThat(array.getSize(), is(expectedArray.length));
        assertThat(expectedArray, is(copyOfGivenArray));
    }

    @Test
    public void whenFindAbsentElementThenFindReturnsFalse() {
        assertThat(array.find(35), is(false));
    }

    @Test
    public void whenFindPresentElementThenReturnsFalse() {
        assertThat(array.find(77), is(true));
    }

    @Test
    public void whenDeletingElementsThenArrayIsModifiedProperly() {
        array.delete(222);
        array.delete(55);
        array.delete(99);
        long[] expectedResultAfterRemoval = {77, 44, 22, 88, 11, 66, 33};
        long[] copyOfGivenArrayAfterRemoval = array.getArray();
        assertThat(expectedResultAfterRemoval, is(copyOfGivenArrayAfterRemoval));
    }

    @Test
    public void whenInsertingElementsAtSpecificIndexThenArrayIsProperlyUpdated() {
        array.insert(33, 4);
        assertThat(array.get(4), is(33L));
        array.insert(262, 8);
        assertThat(array.get(8), is(262L));
        array.insert(266, 5);
        assertThat(array.get(5), is(266L));
    }

    @Test
    public void whenGetMaxElementThenReturnsRealMaxElement() {
        assertThat(array.getMax(), is(222L));
    }

    @Test
    public void whenGetMinElementThenReturnsRealMinElement() {
        assertThat(array.getMin(), is(11L));
    }

    @Test
    public void whenRemoveMaxElementThenArrayDoesNotContainIt() {
        long[] expectedArray = new long[]{77, 99, 44, 55, 22, 88, 11, 66, 33};
        array.removeMax();
        assertThat(array.getArray(), is(expectedArray));
    }

    @Test
    public void whenRemoveMinElementThenArrayDoesNotContainIt() {
        long[] expectedArray = new long[]{77, 99, 44, 55, 22, 88, 222, 66, 33};
        array.removeMin();
        assertThat(array.getArray(), is(expectedArray));
    }

    @Test
    public void whenRemovingDuplicatesThenArrayDoesNotContainDuplicates() {
        long[] expectedArray = array.getArray();
        array.insert(77);
        array.insert(44);
        array.insert(88);
        array.insert(222);
        assertThat(array.getSize(), is(14));
        assertThat(array.removeDuplicates(), is(4));
        assertThat(array.getArray(), is(expectedArray));
    }


}
