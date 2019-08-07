package DataStructures.Graph.Unweighted.Algorithm;

import DataStructures.Graph.Unweighted.DirectedGraph;
import DataStructures.Graph.Unweighted.Graph;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WarshallAlgorithmTest {

    @Test
    public void doTest() {
        // Используем ориентированный граф
        Graph graph = new DirectedGraph();
        graph.addVertex("A"); // 0
        graph.addVertex("B"); // 1
        graph.addVertex("C"); // 2
        graph.addVertex("D"); // 3
        graph.addVertex("E"); // 4
        graph.addVertex("F"); // 5
        graph.addVertex("G"); // 6
        graph.addVertex("H"); // 7
        graph.addEdge(0, 3); // AD
        graph.addEdge(0, 4); // AE
        graph.addEdge(1, 4); // BE
        graph.addEdge(2, 5); // CF
        graph.addEdge(3, 6); // DG
        graph.addEdge(4, 6); // EG
        graph.addEdge(5, 7); // FH
        graph.addEdge(6, 7); // GH
        new WarshallAlgorithm(graph).run();


        byte[][] expected = {
             //         A  B  C  D  E  F  G  H
             /* A */   {0, 0, 0, 1, 1, 0, 1, 1},
             /* B */   {0, 0, 0, 0, 1, 0, 1, 1},
             /* C */   {0, 0, 0, 0, 0, 1, 0, 1},
             /* D */   {0, 0, 0, 0, 0, 0, 1, 1},
             /* E */   {0, 0, 0, 0, 0, 0, 1, 1},
             /* F */   {0, 0, 0, 0, 0, 0, 0, 1},
             /* G */   {0, 0, 0, 0, 0, 0, 0, 1},
             /* H */   {0, 0, 0, 0, 0, 0, 0, 0},
        };

        final int vertexes = graph.getVertexes();
        boolean[][] matrix = graph.getAdjacencyMatrix();

        for (int i = 0; i < vertexes - 1; i++) {
            for (int j = 0; j < vertexes - 1; j++) {
                byte value = (byte) (matrix[i][j] ? 1 : 0);
                assertThat(expected[i][j], is(value));
            }
        }

    }

}