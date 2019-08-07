package Algorithms;

import org.junit.Before;
import org.junit.Test;



import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class BinarySearchTest {

    private int[] array;
    private BinarySearch binarySearch;

    @Before
    public void fillArray() {
        this.binarySearch = new BinarySearch();
        this.array = new int[150];
        for (int i = 0; i < this.array.length; i++)
            this.array[i] = (i < 100 ? i : i * 2) + 2;
    }

    @Test
    public void whenElementIsPresentThenReturnsItsIndex() {
        testSearch(87, 85, false);
    }

    @Test
    public void whenElementIsAbsentThenReturnsMinusOne() {
        testSearch(104, -1, false);
    }

    @Test
    public void whenElementIsPresentThenRecursiveSearchReturnsItsIndex() {
        testSearch(87, 85, true);
    }

    @Test
    public void whenElementIsAbsentThenRecursiveSearchReturnsMinusOne() {
        testSearch(104, -1, true);
    }

    private void testSearch(int searchKey, int expectedIndex, boolean recursive) {
        int result = recursive ? binarySearch.recursiveBinarySearch(array, searchKey) :
                binarySearch.binarySearch(array, searchKey);
        assertThat(result, is(expectedIndex));
    }
}


