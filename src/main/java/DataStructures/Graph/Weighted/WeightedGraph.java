package DataStructures.Graph.Weighted;

import DataStructures.Graph.Vertex;

public class WeightedGraph {

    private static final int MAX_VERTEXES = 20;

    private Vertex[] vertexes;
    private int[][] adjacencyMatrix;
    private int vertexCount;

    public WeightedGraph() {
        vertexes = new Vertex[MAX_VERTEXES];
        adjacencyMatrix = new int[MAX_VERTEXES][MAX_VERTEXES];
    }

    public void addVertex(String lab) {
        vertexes[vertexCount++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjacencyMatrix[start][end] = weight;
    }

    public Vertex[] getVertexes() {
        return vertexes;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public int getMaxVertexes() {
        return vertexes.length;
    }
}
