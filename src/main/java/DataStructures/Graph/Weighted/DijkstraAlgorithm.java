package DataStructures.Graph.Weighted;

import DataStructures.Graph.Vertex;

import java.util.*;

public class DijkstraAlgorithm {

    private WeightedGraph weightedGraph;
    private DijkstraVertex[] vertexes;

    public DijkstraAlgorithm(WeightedGraph weightedGraph) {
        this.weightedGraph = weightedGraph;
    }

    /**
     * Алгоритм вычисления кратчайшего пути между двумя точками во
     * взвешенном графе. Сперва вызывает метод execute для выполнения
     * алгоритма, затем вычисляет путь на основе полученного массива.
     *
     * @param from   исходная точка
     * @param target целевая точка
     * @return путь из from в target
     */

    public Path getPath(int from, int target) {

        this.execute(from);

        List<Vertex> path = new ArrayList<>();
        DijkstraVertex step = vertexes[target];

        int distance = step.getDistance();

        if (step.getParent() == null) {
            return Path.EMPTY;
        }

        path.add(step);

        while (step.getParent() != null) {
            step = step.getParent();
            path.add(step);
        }

        Collections.reverse(path);
        return new Path(Collections.unmodifiableList(path), distance);
    }

    /**
     * Исполнительная часть алгоритма.
     * <p>
     * Сперва создает вершин меток, необходимых для работы алгоритма:
     * все из них, кроме source, имеют по умолчанию стоимость Integer.MAX_VALUE.
     * Вершина source имеет стоимость 0.
     * <p>
     * Затем в цикле вычисляет очередную наименьшуюю непосещенную вершину, посещает,
     * обрабатывает ее соседей.
     *
     * @param source исходная точка, относительно которой вычисляются расстояния
     */

    private void execute(int source) {

        Vertex[] graphVertexes = weightedGraph.getVertexes();
        int vertexCount = weightedGraph.getVertexCount();
        this.vertexes = new DijkstraVertex[vertexCount];

        // Заполняем массив алгоритма копиями вершин

        for (int i = 0; i < vertexCount; i++) {
            DijkstraVertex dijkstraVertex = new DijkstraVertex(graphVertexes[i]);
            // Расстояние от исходной точки неизвестно
            dijkstraVertex.setDistance(Integer.MAX_VALUE);
            vertexes[i] = dijkstraVertex;
        }

        // Расстояние до начальной точки всегда известно и равно 0

        vertexes[source].setDistance(0);

        // Для выполнения алгоритма необходимо N итераций, где N - число вершин в графе

        for (int i = 0; i < vertexCount; i++) {

            // Очередная минимальная непосещенная вершина
            int next = getMinimum();

            // Посещаем соседей
            this.visitNeighbours(next);

        }

    }

    /**
     * Вычисляет новое расстояние для соседей данного узла, и,
     * если необходимо, обновляет.
     *
     * @param node узел, соседи которого обрабатываются
     */

    private void visitNeighbours(int node) {
        DijkstraVertex entityNode = vertexes[node];
        // Получаем соседей. Среди них уже только непосещенные
        List<Integer> adjacentNodes = getNeighbours(node);
        for (Integer target : adjacentNodes) {

            // Расстояние до текущего узла
            int distanceToCurrent = entityNode.getDistance();

            // Расстояние от текущего узла до соседа
            int distanceFromCurrentToTarget = weightedGraph.getAdjacencyMatrix()[node][target];

            // Суммарное расстояние от начала до соседа
            int totalDistanceToTarget = distanceToCurrent + distanceFromCurrentToTarget;
            DijkstraVertex targetVertex = vertexes[target];

            // Если новое расстояние меньше текущего расстояния соседа, обновляем его
            if (targetVertex.getDistance() > totalDistanceToTarget) {
                targetVertex.setDistance(totalDistanceToTarget);
                targetVertex.setParent(entityNode);
            }
        }
        entityNode.setVisited(true);
    }

    /**
     * Ищет соседей вершины, т.е непосещенные узлы, смежные
     * с заданным.
     *
     * @param node узел, для которого происходит поиск соседей
     * @return список непосещенных соседей узла
     */

    private List<Integer> getNeighbours(int node) {
        List<Integer> neighbors = new ArrayList<>();

        // Строка смежности с текущим узлом
        int[] graphNeighbours = weightedGraph.getAdjacencyMatrix()[node];
        for (int i = 0; i < graphNeighbours.length; i++) {
            // Если есть связь (расстояние больше 0)
            if (graphNeighbours[i] > 0) {
                Vertex neighbour = vertexes[i];
                if (!neighbour.isVisited()) {
                    neighbors.add(i);
                }
            }
        }
        return neighbors;
    }

    /**
     * Возвращает индекс непосещенного узла с наименьшей стоимостью.
     * Реализуется с помощью стандартного алгоритма поиска
     * минимума в массиве.
     *
     * @return непосещенный узел с минимальной стоимостью
     */

    private int getMinimum() {
        int min = -1;
        for (int i = 0; i < vertexes.length; i++) {
            DijkstraVertex next = vertexes[i];
            if (!next.isVisited()) {
                if (min == -1) {
                    min = i;
                } else {
                    if (next.getDistance() < vertexes[min].getDistance()) {
                        min = i;
                    }
                }
            }
        }
        return min;

    }

    public static class Path {

        private static final Path EMPTY = new Path(Collections.emptyList(), 0);

        private List<Vertex> vertexes;
        private int length;

        public Path(List<Vertex> vertexes, int length) {
            this.vertexes = vertexes;
            this.length = length;
        }

        public List<Vertex> getVertexes() {
            return vertexes;
        }

        public int getLength() {
            return length;
        }
    }

}
    

