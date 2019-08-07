package DataStructures.Graph.Unweighted;

public class DirectedGraph extends Graph {

    @Override
    public void addEdge(int start, int end) {
        super.getAdjacencyMatrix()[start][end] = true;
    }

}
