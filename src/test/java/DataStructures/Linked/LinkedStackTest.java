package DataStructures.Linked;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LinkedStackTest {

    private LinkedStack<Integer> stack;

    @Before
    public void setup() {
        this.stack = new LinkedStack<>();
    }

    @Test
    public void whenPushingFiveElementsThenPopReturnsThem() {
        stack.push(21);
        stack.push(33);
        stack.push(44);
        stack.push(89);
        assertThat(stack.pop(), is(89));
        assertThat(stack.pop(), is(44));
        assertThat(stack.pop(), is(33));
        assertThat(stack.pop(), is(21));
    }

    @Test
    public void whenPeekElementThenReturnsElementOnTop() {
        stack.push(71);
        stack.push(26);
        assertThat(stack.peek(), is(26));
        assertThat(stack.peek(), is(26));
        stack.pop();
        assertThat(stack.peek(), is(71));
    }

    @Test
    public void whenPopLastElementThenStackIsEmpty() {
        stack.push(54);
        stack.push(31);
        stack.push(22);
        assertThat(stack.isEmpty(), is(false));
        stack.pop();
        assertThat(stack.isEmpty(), is(false));
        stack.pop();
        assertThat(stack.isEmpty(), is(false));
        stack.pop();
        assertThat(stack.isEmpty(), is(true));
        stack.push(1);
        assertThat(stack.isEmpty(), is(false));
        stack.pop();
        assertThat(stack.isEmpty(), is(true));
    }

}
