package DataStructures.Graph.Weighted;

import DataStructures.Graph.Vertex;

public class DijkstraVertex extends Vertex {

    private DijkstraVertex parent;
    private int distance;

    public DijkstraVertex(Vertex vertex) {
        super(vertex.getLabel());
    }

    public DijkstraVertex getParent() {
        return parent;
    }

    public int getDistance() {
        return distance;
    }

    public void setParent(DijkstraVertex parent) {
        this.parent = parent;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
