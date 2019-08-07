package Algorithms.Recursion;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnagramTest {

    private Anagram anagram;
    private ByteArrayOutputStream mem;

    @Before
    public void loadCustom() {
        this.mem = new ByteArrayOutputStream();
        System.setOut(new PrintStream(this.mem));
        this.anagram = new Anagram();
    }


    @Test
    public void whenTwoLettersThenTwoAnagrams() {
        anagram.displayAnagrams("ab");
        String expected = "[a, b] [b, a]";
        assertThat(this.mem.toString().trim(), is(expected));
    }

    @Test
    public void whenThreeLettersThenThreeAnagrams() {
        anagram.displayAnagrams("abc");
        String expected = "[a, b, c] [a, c, b] [b, c, a] [b, a, c] [c, a, b] [c, b, a]";
        assertThat(this.mem.toString().trim(), is(expected));
    }

    @Test
    public void whenFourLettersThenFourAnagrams() {
        anagram.displayAnagrams("abcd");
        String expected = "[a, b, c, d] [a, b, d, c] [a, c, d, b] [a, c, b, d] [a, d, b, c] [a, d, c, b]" +
                " [b, c, d, a] [b, c, a, d] [b, d, a, c] [b, d, c, a] [b, a, c, d] [b, a, d, c] " +
                "[c, d, a, b] [c, d, b, a] [c, a, b, d] [c, a, d, b] [c, b, d, a] [c, b, a, d]" +
                " [d, a, b, c] [d, a, c, b] [d, b, c, a] [d, b, a, c] [d, c, a, b] [d, c, b, a]";
        assertThat(this.mem.toString().trim(), is(expected));

    }

}