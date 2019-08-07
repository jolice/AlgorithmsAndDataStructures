package DataStructures.Graph.Unweighted.Algorithm;

import DataStructures.Graph.Unweighted.DirectedGraph;
import DataStructures.Graph.Unweighted.Graph;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TopologicalSortTest {

    @Test
    public void run() {
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
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
        new TopologicalSort(graph).sort();
        assertThat(outputStream.toString().trim(), is("BAEDGCFH"));
    }
}