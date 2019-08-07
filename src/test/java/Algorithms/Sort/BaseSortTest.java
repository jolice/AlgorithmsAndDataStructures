package Algorithms.Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public abstract class BaseSortTest {

    abstract Sort getSort();

    private void testSort(int[] input, int[] expected) {
        getSort().sort(input);
        assertThat(input, is(expected));
    }

    @Test
    public void testSortEmptyArray() {
        testSort(new int[]{},
                new int[]{});
    }

    @Test
    public void testSortSmallSortedArray() {
        testSort(new int[]{1, 2, 3, 4, 5},
                new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testSortSmallReverseSortedArray() {
        testSort(new int[]{5, 4, 3, 2, 1},

                new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testSortSmallSortedArrayWithOnlyNegativeValues() {
        testSort(new int[]{-5, -4, -3, -2, -1},
                new int[]{-5, -4, -3, -2, -1});
    }

    @Test
    public void testSortSmallReverseSortedArrayWithOnlyNegativeValues() {
        testSort(new int[]{-1, -2, -3, -4, -5},
                new int[]{-5, -4, -3, -2, -1});
    }

    @Test
    public void testSortSmallSortedArrayWithTwoValuesSwapped() {
        testSort(new int[]{1, 2, 5, 4, 3},
                new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testSortLargeSortedArray() {
        testSort(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
    }

    @Test
    public void testSortLargeReverseSortedArray() {
        testSort(new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
                new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
    }

    @Test
    public void testSortLargeArrayWithTwoValuesSwapped() {
        testSort(new int[]{0, 1, 2, 8, 4, 5, 6, 7, 3, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
    }

    @Test
    public void testSortLargeSortedArrayWithOnlyNegativeValues() {
        testSort(new int[]{-20, -19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1},
                new int[]{-20, -19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1});
    }

    @Test
    public void testSortLargeReverseSortedArrayWithOnlyNegativeValues() {
        testSort(new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12, -13, -14, -15, -16, -17, -18, -19, -20},
                new int[]{-20, -19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1});
    }

    @Test
    public void testSortJumbledArrayWithSmallRangeOfValues() {
        testSort(new int[]{5, -3, 2, 0, -5, 1, 4, -4, -2, 3, -1},
                new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5});
    }

    @Test
    public void testSortJumbledArrayWithLargeRangeOfValues() {
        testSort(new int[]{102, 10, -50, 2938, 108, -4011, -38, 523, 16},
                new int[]{-4011, -50, -38, 10, 16, 102, 108, 523, 2938});
    }

    @Test
    public void testSortArrayWithDuplicateValues() {
        testSort(new int[]{-2, -7, 1, 9, -7, 1, -2, 10, -7, -7},
                new int[]{-7, -7, -7, -7, -2, -2, 1, 1, 9, 10});
    }

    @Test
    public void testSortVeryLargeArray() {
        int[] src = new Random().ints(100000, -100000, 100000).toArray();
        int[] copy = Arrays.copyOf(src, src.length);
        Arrays.sort(copy);
        testSort(src, copy);
    }
}
