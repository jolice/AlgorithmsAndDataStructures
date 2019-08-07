package Algorithms.Recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest {

    @Test
    public void whenFactorialThenReturnsCorrectResult() {
        Factorial factorial = new Factorial();
        assertEquals(factorial.factorial(1), 1);
        assertEquals(factorial.factorial(2), 2);
        assertEquals(factorial.factorial(3), 6);
        assertEquals(factorial.factorial(4), 24);
        assertEquals(factorial.factorial(5), 120);
    }
}