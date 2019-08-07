package DataStructures.Graph.Unweighted.Algorithm;

import DataStructures.Graph.Unweighted.Graph;

/**
 * Топологическая сортировка графа. Метод преемников.
 */
public class TopologicalSort  {

    /**
     * Массив, в который записываются символы в отсортированном порядке
     */
    private String[] sortedArray;

    /**
     * Топологически сортируемый граф
     */
    private Graph graph;


    public TopologicalSort(Graph graph) {
        this.graph = graph;
        this.sortedArray = new String[graph.getVertexes()];
    }

    public void sort() {


        while (graph.getVertexes() > 0) {    // Пока в графе остаются вершины
            // Ищем вершину без преемников
            int currentVertex = noSuccessors();
            if (currentVertex == -1) { // Нет ни одной вершины без преемников? В графе есть цикл
                throw new IllegalStateException("Graph has cycles!");
            }

            sortedArray[graph.getVertexes() - 1] = graph.getVertexList()[currentVertex].getLabel();  // Вставляем в вершину конец массива
            graph.deleteVertex(currentVertex); // Удаление вершины
        }

        // Выводим заполненный топологически упорядоченный массив
        for (String c : sortedArray)
            System.out.print(c);
    }

    /**
     * Возвращает вершину, не имеющую преемника
     *
     * @return индекс вершины без преемника, или 1, если таковой нет
     */

    private int noSuccessors() {
        boolean hasEdges;
        for (int row = 0; row < graph.getVertexes(); row++) {
            hasEdges = false;
            for (int col = 0; col < graph.getVertexes(); col++) {
                if (graph.getAdjacencyMatrix()[row][col]) { // Если существует ребро
                    hasEdges = true;
                    break;
                } // Переход к проверке
            } // другой вершины

            if (!hasEdges)
                return row;
        }
        return -1; // Вершина не найдена
    }



}
