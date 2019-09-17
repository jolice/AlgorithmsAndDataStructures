package DataStructures.Graph.Unweighted.Algorithm;

import DataStructures.Graph.Unweighted.Graph;
import DataStructures.Graph.Vertex;
import DataStructures.Stack;

/*
Implementation for unweighted graph
 */
public class MinimumSpanningTree  {

    private Graph graph;
    private Stack<Integer> stack;

    public MinimumSpanningTree(Graph graph) {
        this.graph = graph;
        this.stack = new Stack<>(graph.getVertexes());
    }

    public void buildSpanningTree() {
        Vertex[] vertexList = graph.getVertexList();
        vertexList[0].setVisited(true); // Пометка
        stack.push(0);
        while (!stack.isEmpty()) // Пока стек не опустеет
        { // Извлечение элемента из стека
            int currentVertex = stack.peek();
            // следующий непосещенный сосед
            int v = graph.getUnvisitedVertex(currentVertex);
            if (v == -1) // Если соседей больше нет,
                stack.pop(); // извлечь элемент из стека
            else // Сосед существует
            {
                vertexList[v].setVisited(true); // Пометка
                stack.push(v); // Занесение в стек
                // Вывод ребра
                vertexList[currentVertex].display();
                vertexList[v].display();
                System.out.print(" ");
            }
        }

        graph.resetFlags();
    }



}
