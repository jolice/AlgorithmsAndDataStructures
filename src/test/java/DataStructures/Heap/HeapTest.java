package DataStructures.Heap;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HeapTest {

    @Test
    public void whenInsertThenPolledInRightOrder() {

        Heap heap = new Heap(16);

        heap.insert(5);
        heap.insert(7);
        heap.insert(1);
        heap.insert(21);
        heap.insert(3);
        heap.insert(4);
        heap.insert(8);
        heap.insert(51);
        heap.insert(32);
        heap.insert(14);

        assertThat(heap.remove(), is(51));
        assertThat(heap.remove(), is(32));
        assertThat(heap.remove(), is(21));
        assertThat(heap.remove(), is(14));
        assertThat(heap.remove(), is(8));
        assertThat(heap.remove(), is(7));
        assertThat(heap.remove(), is(5));
        assertThat(heap.remove(), is(4));
        assertThat(heap.remove(), is(3));
        assertThat(heap.remove(), is(1));

    }


}