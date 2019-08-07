package DataStructures.Graph;

public class Vertex {

    private String label;
    private boolean visited;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void display() {
        System.out.print(label);
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }
}
