package DataStructures.Array;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class OrderedArrayTest {



    private OrderedArray array;

    @Before
    public void fillArray() {
        array = new OrderedArray(100);
        array.add(77);
        array.add(99);
        array.add(44);
        array.add(55);
        array.add(22);
        array.add(88);
        array.add(11);
        array.add(00);
        array.add(66);
        array.add(33);
    }

    @Test
    public void whenInsertingNumbersInRandomOrderThenArrayStaysSorted() {
        int[] expectedResult = {00, 11, 22, 33, 44, 55, 66, 77, 88, 99};
        assertThat(array.getArray(), is(expectedResult));
    }

    @Test
    public void whenDeletingElementFromMiddleThenArrayStaysOrdered() {
        int[] expectedResult = {00, 11, 33, 66, 77, 88};
        array.delete(22);
        array.delete(44);
        array.delete(55);
        array.delete(99);
        assertThat(array.getArray(), is(expectedResult));
    }

    @Test
    public void whenDeletingAbsentElementThenDeleteReturnsFalse() {
        assertThat(array.delete(101), is(false));
    }

    @Test
    public void whenMergingThenResultArrayIsOrdered() {
        int[] arrayToMerge = {15, 25, 35, 45, 75};
        array.merge(arrayToMerge);
        int[] expectedArray = new int[]{00, 11, 15, 22, 25, 33, 35, 44, 45, 55, 66, 75, 77, 88, 99};
        assertThat(array.getArray(), is(expectedArray));
    }


}
