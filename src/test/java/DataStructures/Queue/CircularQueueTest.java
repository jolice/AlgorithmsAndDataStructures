package DataStructures.Queue;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class CircularQueueTest {

    private Queue<Integer> theQueue = new CircularQueue<>(5);

    @Test
    public void whenInsertElementsThenPollReturnsThemInProperOrder() {
        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        assertThat(theQueue.remove(), is(10));
        assertThat(theQueue.remove(), is(20));
        assertThat(theQueue.remove(), is(30));
        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);




        assertThat(theQueue.remove(), is(40));
        assertThat(theQueue.remove(), is(50));
        assertThat(theQueue.remove(), is(60));
        assertThat(theQueue.remove(), is(70));
        assertThat(theQueue.remove(), is(80));
    }


    @Test
    public void whenInsertingElementThenPeekReturnsItsValue() {
        theQueue.insert(51);
        assertThat(theQueue.peek(), is(51));
        theQueue.insert(42);
        theQueue.insert(64);
        assertThat(theQueue.peek(), is(51));
        theQueue.remove();
        assertThat(theQueue.peek(), is(42));
        theQueue.remove();
        assertThat(theQueue.peek(), is(64));
    }


    @Test
    public void whenInsertingElementsThenQueueIsFull() {
        for (int i = 0; i < 5; i++) {
            theQueue.insert(i * 10);
        }
        assertThat(theQueue.isFull(), is(true));
    }

    @Test
    public void whenRemovingLastElementThenQueueIsEmpty() {
        for (int i = 0; i < 5; i++) {
            theQueue.insert(i * 10);
        }
        for (int i = 0; i < 5; i++) {
            theQueue.remove();
        }
        assertThat(theQueue.isEmpty(), is(true));
    }

    @Test
    public void whenFillingTheQueueThenToStringIsCorrect() {
        for (int i = 0; i < 5; i++) {
            theQueue.insert((i + 1) * 10 + 30);
        }
        assertThat(theQueue.toString(), is("[40, 50, 60, 70, 80]"));
    }

    @Test
    public void whenFrontLessThanRearThenToStringIsCorrect() {
        theQueue.insert(40);
        theQueue.insert(50);
        theQueue.insert(60);
        assertThat(theQueue.toString(), is("[40, 50, 60]"));
    }

    @Test
    public void whenFrontGreaterThanRearThenToStringIsCorrect() {
        for (int i = 0; i < 5; i++) {
            theQueue.insert(i);
        }
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.insert(21);
        theQueue.insert(44);
        assertThat(theQueue.toString(), is("[3, 4, 21, 44]"));
    }

    @Test
    public void whenQueueIsFullThenToStringIsCorrect() {
        for (int i = 0; i < 5; i++) {
            theQueue.insert(i);
        }
        assertThat(theQueue.toString(), is("[0, 1, 2, 3, 4]"));
    }

    @Test
    public void whenQueueIsEqualToRearThenToStringIsCorrect() {
        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);
        assertThat(theQueue.toString(), is("[40, 50, 60, 70, 80]"));
    }



}