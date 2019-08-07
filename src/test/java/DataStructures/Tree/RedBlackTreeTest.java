package DataStructures.Tree;

import org.junit.Test;

import java.util.Random;
import java.util.function.IntConsumer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RedBlackTreeTest {

    @Test
    public void whenFindInsertedElementThenExists() {
        RedBlackTree redBlackTree = new RedBlackTree();

        int[] randomValues = new Random().ints(100).toArray();

        for (int randomValue : randomValues) {
            redBlackTree.insert(randomValue, String.valueOf(randomValue));
        }

        for (int randomValue : randomValues) {
            assertThat(redBlackTree.find(randomValue).value, is(String.valueOf(randomValue)));
        }
    }



}