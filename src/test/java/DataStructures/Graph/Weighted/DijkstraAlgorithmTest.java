package DataStructures.Graph.Weighted;

import DataStructures.Graph.Vertex;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DijkstraAlgorithmTest {

    private WeightedGraph weightedGraph;

    @Test
    public void testSubway() {

        weightedGraph = new WeightedGraph();

        weightedGraph.addVertex("Охотный ряд"); // 0
        weightedGraph.addVertex("Лубянка"); // 1
        weightedGraph.addVertex("Чистые пруды"); // 2
        weightedGraph.addVertex("Сретенский бульвар"); // 3
        weightedGraph.addVertex("Чкаловская"); // 4
        weightedGraph.addVertex("Римская"); // 5
        weightedGraph.addVertex("Крестьянская застава"); // 6

        weightedGraph.addEdge(0, 1, 2);
        weightedGraph.addEdge(1, 2, 2);
        weightedGraph.addEdge(2, 3, 3);
        weightedGraph.addEdge(3, 4, 3);
        weightedGraph.addEdge(4, 5, 3);
        weightedGraph.addEdge(5, 6, 3);
        weightedGraph.addEdge(1, 5, 20);

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(weightedGraph);
        DijkstraAlgorithm.Path path = dijkstraAlgorithm.getPath(0, 6);

        System.out.println(path.getVertexes());
        System.out.println("Время: " + path.getLength() + " мин ");
    }

    @Test
    public void whenFindShortestPathThenFound() {
        weightedGraph = new WeightedGraph();
        weightedGraph.addVertex("A"); // 0 (исходная вершина)
        weightedGraph.addVertex("B"); // 1
        weightedGraph.addVertex("C"); // 2
        weightedGraph.addVertex("D"); // 3
        weightedGraph.addVertex("E"); // 4
        weightedGraph.addEdge(0, 1, 50); // AB 50
        weightedGraph.addEdge(0, 3, 80); // AD 80
        weightedGraph.addEdge(1, 2, 60); // BC 60
        weightedGraph.addEdge(1, 3, 90); // BD 90
        weightedGraph.addEdge(2, 4, 40); // CE 40
        weightedGraph.addEdge(3, 2, 20); // DC 20
        weightedGraph.addEdge(3, 4, 70); // DE 70
        weightedGraph.addEdge(4, 1, 50); // EB 50

        // Neighbours

        assertPath(0, 1, "A", "B");
        assertPath(0, 3, "A", "D");
        assertPath(3, 2, "D", "C");
        assertPath(4, 1, "E", "B");

        // More complex

        assertPath(0, 2, "A", "D", "C");
        assertPath(0, 4, "A", "D", "C", "E");
        assertPath(1, 4, "B", "C", "E");
    }

    private void assertPath(int from, int to, String... expectedPath) {
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(weightedGraph);
        List<Vertex> path = dijkstraAlgorithm.getPath(from, to).getVertexes();

        String[] charPath = new String[path.size()];
        for (int i = 0; i < charPath.length; i++) {
            charPath[i] = path.get(i).getLabel();
        }

        assertThat(charPath, is(expectedPath));

    }
}