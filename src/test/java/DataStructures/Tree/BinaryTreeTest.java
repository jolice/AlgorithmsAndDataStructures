package DataStructures.Tree;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BinaryTreeTest {

    private BinaryTree tree;
    private int[] contents;

    @Before
    public void setUp() {
        this.contents = new int[]{5, 1, 10, 3, 0, 8, 9, 20, 2};
        this.tree = new BinaryTree();
        for (int data : contents) {
            tree.insert(data, String.valueOf(data));
        }


        /* -------------------------------

        Графическое представление этого дерева:

                     5
                    / \
                   /   \
                  /     \
                 /       \
                 1       10
                / \     / \
               /   \   /   \
               0   3   8   20
                  /     \
                 2      9

           ------------------------------- */
    }

    // Max / min

    @Test
    public void whenMaxThenReturnsNodeWithMaxValue() {
        assertThat(tree.max().getId(), is(20));
    }

    @Test
    public void whenMinThenReturnsNodeWithMinValue() {
        assertThat(tree.min().getId(), is(0));
    }

    @Test
    public void whenFindThenReturnsNodesWithSameValues() {
        assertThat(tree.find(5).getValue(), is("5"));
        assertThat(tree.find(3).getValue(), is("3"));
        assertThat(tree.find(9).getValue(), is("9"));
        assertThat(tree.find(20).getValue(), is("20"));
    }

    @Test
    public void whenFindByAbsentKeyThenReturnsNull() {
        for (int i = 21; i < 35; i++) {
            assertNull(tree.find(i));
        }
        assertNull(tree.find(-1));
        assertNull(tree.find(101));

    }

    @Test
    public void whenGetHeightThenReturnsCorrectHeight() {
        assertThat(tree.height(), is(4));
    }

    @Test
    public void whenInsertThenTreeContainsInsertedItem() {
        int[] values = {-2, -6, -8, 4, 6, 7, 11, 19, 21, -10};
        for (int i : values) {
            assertNull(tree.find(i));
            String data = String.valueOf(i);
            tree.insert(i, data);
            assertThat(tree.find(i).getValue(), is(data));
        }
    }

    @Test
    public void whenDeleteNodeWithNoChildrenThenNodeIsDeleted() {
        removeNode(0);
    }

    @Test
    public void whenDeleteNodeWithOneLeftChildThenNodeIsDeleted() {
        removeNode(3);
    }

    @Test
    public void whenDeleteNodeWithOneRightChildThenNodeIsDeleted() {
        removeNode(8);
    }

    @Test
    public void whenDeleteNodeWithTwoChildrenThenNodeReplacedBySuccessor() {
        removeNode(10);
    }

    @Test
    public void whenRemoveRootNodeThenRootNodeReplacedBySuccessor() {
        removeNode(5);

    }



    private void removeNode(int id) {
        String data = String.valueOf(id);
        assertThat(tree.find(id).getValue(), is(data));
        tree.delete(id);
        assertNull(tree.find(id));

        // Проверим, содержит ли дерево остальные элементы после удаления
        for (int i : contents) {
            if (i != id)
                assertThat(tree.find(i).getValue(), is(String.valueOf(i)));
        }

        // Проверим, нормально ли работают вставка после удаления

        whenInsertThenTreeContainsInsertedItem();
    }

    @Test
    public void traverseInOrder() {
        traverse("inOrder", new int[] {0, 1, 2, 3, 5, 8, 9, 10, 20});
    }

    @Test
    public void traversePreOrder() {
        traverse("preOrder", new int[]{5, 1, 0, 3, 2, 10, 8, 9, 20});
    }

    @Test
    public void traversePostOrder() {
      traverse("postOrder",new int[]{0, 2, 3, 1, 9, 8, 20, 10, 5});
    }

    private void traverse(String type, int[] expectedResult) {
        PrintStream old = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);
        System.setOut(ps);
        switch (type) {
            case "inOrder":
                tree.traverseInOrder();
                break;
            case "postOrder":
                tree.traversePostOrder();
                break;
            case "preOrder":
                tree.traversePreOrder();
                break;
            default:
                throw new IllegalArgumentException(type);
        }
        System.setOut(old);
        assertThat(Arrays.toString(expectedResult), is(Arrays.toString(out.toString().split("\\n"))));

    }
}