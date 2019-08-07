package Algorithms.Strings;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class StringStackReverseTest {

    private StringStackReverse reverse;

    @Before
    public void setup() {
        this.reverse = new StringStackReverse();
    }

    @Test
    public void whenReversingJVMNameThenReturnsReversedString() {
        String toReverse = reverse.reverse("Java Virtual Machine");
        String reversed = "enihcaM lautriV avaJ";
        assertThat(toReverse, is(reversed));
    }

    @Test
    public void whenReversingStringFromSameCharactersThenReturnsIt() {
        String src = "1111111111111";
        String reversed = reverse.reverse(src);
        assertThat(src, is(reversed));
    }

    @Test
    public void whenReversingEmptyStringThenReturnsEmptyString() {
        assertThat("", is(reverse.reverse("")));
    }

}