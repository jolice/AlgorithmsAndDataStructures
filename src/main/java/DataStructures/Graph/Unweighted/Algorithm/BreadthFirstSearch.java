package DataStructures.Graph.Unweighted.Algorithm;

import DataStructures.Graph.Unweighted.Graph;
import DataStructures.Graph.Vertex;
import DataStructures.Queue.CircularQueue;
import DataStructures.Queue.Queue;

public class BreadthFirstSearch  {

    private Graph graph;
    private Queue<Integer> queue;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
        this.queue = new CircularQueue<>(graph.getVertexes());
    }

    public void bfs() {
        Vertex[] vertexList = graph.getVertexList();
        vertexList[0].setVisited(true);
        vertexList[0].display();
        queue.insert(0);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove(); // Извлечение вершины в начале очереди
            // Пока остаются непосещенные соседи
            while ((v2 = graph.getUnvisitedVertex(v1)) != -1) { // Получение вершины
                vertexList[v2].setVisited(true); // Пометка
                vertexList[v2].display(); // Вывод
                queue.insert(v2); // Вставка
            }
        }
        graph.resetFlags();
    }


}
