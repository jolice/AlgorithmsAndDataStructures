package Algorithms.Strings;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class BracketStackValidationTest {

    @Test
    public void evaluate() {
        BracketStackValidation bracketStackValidation = new BracketStackValidation();
        assertThat(bracketStackValidation.evaluate("c[d]"), is(true));
        assertThat(bracketStackValidation.evaluate("a{b[c]d}e"), is(true));
        assertThat(bracketStackValidation.evaluate("a{b(c]d}e"), is(false));
        assertThat(bracketStackValidation.evaluate("a[b{c}d]e}"), is(false));
        assertThat(bracketStackValidation.evaluate("a{b(c)"), is(true));
    }
}