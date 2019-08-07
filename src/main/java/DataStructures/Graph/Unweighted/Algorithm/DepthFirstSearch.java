package DataStructures.Graph.Unweighted.Algorithm;

import DataStructures.Graph.Unweighted.Graph;
import DataStructures.Graph.Vertex;
import DataStructures.Stack;

public class DepthFirstSearch  {

    private Graph graph;
    private Stack<Integer> stack;

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
        this.stack = new Stack<>(graph.getVertexes());
    }

    public void dfs() {
        Vertex[] vertexList = graph.getVertexList();
        vertexList[0].setVisited(true);
        vertexList[0].display();
        stack.push(0);
        while (!stack.isEmpty()) {
            // Получение непосещенной вершины, смежной к текущей
            int v = graph.getUnvisitedVertex(stack.peek());
            if (v != -1) { // // Если вершина найдена
                vertexList[v].setVisited(true); // Пометка
                vertexList[v].display(); // Вывод
                stack.push(v); // Занесение в стек
            } else {
                // Если такой вершины нет, элемент извлекается из стека
                stack.pop();
            }
        }
        // Стек пуст, работа закончена
        graph.resetFlags();
    }



}
