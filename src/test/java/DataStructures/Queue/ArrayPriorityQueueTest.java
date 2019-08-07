package DataStructures.Queue;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class ArrayPriorityQueueTest  {

    private Queue<Integer> thePQ = new ArrayPriorityQueue<>(5);

    @Test
    public void whenInsertingRandomOrderThenReturnsInPriorityOrder() {
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        assertThat(thePQ.remove(), is(10));
        assertThat(thePQ.remove(), is(20));
        assertThat(thePQ.remove(), is(30));
        assertThat(thePQ.remove(), is(40));
        assertThat(thePQ.remove(), is(50));
    }


    @Test
    public void whenInsertingElementThenPeekReturnsItsValueOrdered() {
        thePQ.insert(51);
        assertThat(thePQ.peek(), is(51));
        thePQ.insert(42);
        thePQ.insert(64);
        assertThat(thePQ.peek(), is(42));
        thePQ.remove();
        assertThat(thePQ.peek(), is(51));
        thePQ.remove();
        assertThat(thePQ.peek(), is(64));
    }

    @Test
    public void whenInsertingElementsThenQueueIsFull() {
        for (int i = 0; i < 5; i++) {
            thePQ.insert(i * 10);
        }
        assertThat(thePQ.isFull(), is(true));
    }

    @Test
    public void whenRemovingLastElementThenQueueIsEmpty() {
        for (int i = 0; i < 5; i++) {
            thePQ.insert(i * 10);
        }
        for (int i = 0; i < 5; i++) {
            thePQ.remove();
        }
        assertThat(thePQ.isEmpty(), is(true));
    }

  
}