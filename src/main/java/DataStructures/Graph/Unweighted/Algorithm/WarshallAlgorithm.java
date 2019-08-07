package DataStructures.Graph.Unweighted.Algorithm;

import DataStructures.Graph.Unweighted.Graph;


public class WarshallAlgorithm  {

    private Graph graph;

    public WarshallAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public void run() {

        boolean[][] adjacencyMatrix = graph.getAdjacencyMatrix();

        // Перебор строк
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            // Перебор ячеек строки
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                // Если существует ребро I -> J
                if (adjacencyMatrix[i][j]) {
                    for (int k = 0; k < adjacencyMatrix.length; k++) {
                        // Если существует ребро K -> I
                        if (adjacencyMatrix[k][i])
                            // То существует ребро K -> J (K -> I -> J)
                            adjacencyMatrix[k][j] = true;
                    }
                }
            }
        }
    }

}
