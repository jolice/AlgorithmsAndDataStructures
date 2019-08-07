package DataStructures.Graph.Unweighted;


import DataStructures.Graph.Vertex;

@SuppressWarnings("ManualArrayCopy")
public class Graph {

    /**
     * Максимальное количество вершин в графе
     */
    private static final int MAX_VERTEXES = 20;

    /**
     * Массив вершин
     */
    private Vertex[] vertexList;

    /**
     * Матрица смежности
     */
    private boolean[][] adjacencyMatrix;

    /**
     * Текущее количество вершин
     */
    private int vertexes;

    public Graph() {
        vertexList = new Vertex[MAX_VERTEXES];
        adjacencyMatrix = new boolean[MAX_VERTEXES][MAX_VERTEXES];
    }

    /**
     * Вводит вершину в граф
     *
     * @param lab значение вершины
     */
    public void addVertex(String lab) {
        vertexList[vertexes++] = new Vertex(lab);
    }

    /**
     * Добавляет ребро в граф, соединяя две вершины.
     * В неориентированном графе пути между двумя вершинами
     * существуют в обоих направлениях: из А в Б и из Б в А,
     * поэтому для связи вершин нужно внести записи в строки
     * обоих вершин: [X][Y] и [Y][X].
     *
     * @param start первая вершина
     * @param end   вторая вершина
     */
    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = true;
        adjacencyMatrix[end][start] = true;
    }

    /**
     * Возвращает матрицу смежности.
     *
     * @return матрица  смежности
     */
    public boolean[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    /**
     * Сбрасывает флаги посещения вершин после обхода графа
     */

    public void resetFlags() {
        for (int j = 0; j < vertexes; j++)
            vertexList[j].setVisited(false);
    }

    /**
     * Удаляет вершину из графа.
     *
     * @param vertex удаляемая вершина
     */
    public void deleteVertex(int vertex) {
        if (vertex < vertexes - 1) {

            // Сдвигаем элементы массива вершин вниз, замещая удаляемую
            for (int j = vertex; j < vertexes - 1; j++)
                vertexList[j] = vertexList[j + 1];

            // Сдвигаем строки матрицы [vertex, length] смежности вниз, замещая удаляемую строку
            for (int row = vertex; row < vertexes - 1; row++)
                for (int col = 0; col < vertexes; col++)
                    adjacencyMatrix[row][col] = adjacencyMatrix[row + 1][col];

            // Сдвигаем столбцы матрицы [vertex, length] влево, замещая удаляемый столбец
            for (int col = vertex; col < vertexes - 1; col++)
                for (int row = 0; row < vertexes - 1; row++)
                    adjacencyMatrix[row][col] = adjacencyMatrix[row][col + 1];
        }

        // Уменьшаем число вершин графа на единицу
        vertexes--;
    }

    /**
     * Возвращает непосещенную вершину, смежную с заданной
     *
     * @param v вершина, среди смежных с которой будет искаться непосещенная
     * @return непосещенная вершина, смежная с заданной
     */

    public int getUnvisitedVertex(int v) {
        for (int j = 0; j < vertexes; j++)
            if (adjacencyMatrix[v][j] && !vertexList[j].isVisited())
                return j;
        return -1;
    }

    /**
     * Геттер для количества вершин.
     * Не равно длине массива вершин!
     *
     * @return количество вершин в графе
     */
    public int getVertexes() {
        return vertexes;
    }


    public Vertex[] getVertexList() {
        return vertexList;
    }
}
