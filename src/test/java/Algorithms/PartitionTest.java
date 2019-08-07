package Algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PartitionTest {

    @Test
    public void whenMultiplePivotsThenPartitioned() {
        int[] array = {8, 1, 5, 7, 3, 9, 4, 2};
        new Partition().partition(array, 5);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void whenEmptyArrayThenOk() {
        int[] array = {};
        new Partition().partition(array, 0);
        assertArrayEquals(array, new int[]{});
    }

    @Test
    public void whenPlainArrayThenPartitioned() {
        int[] array = {9, 0, 6, 5, 4, 8, 2, 1, 3};
        new Partition().partition(array, 5);
        assertThat(array, is(new int[]{3, 0, 1, 2, 4, 8, 5, 6, 9}));
    }

    @Test
    public void whenAllSmallerThanPivotThenOk() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        new Partition().partition(array, 8);
        assertArrayEquals(array, Arrays.copyOf(array, array.length));
    }

    @Test
    public void whenAllGreaterThanPivotThenOk() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        new Partition().partition(array, 0);
        assertArrayEquals(array, Arrays.copyOf(array, array.length));
    }
}