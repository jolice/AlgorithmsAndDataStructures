package DataStructures.Hash;

public class Node {

    static final Node EMPTY = new Node();

    private String value;
    private int key;

    public Node() {}

    public Node(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", key=" + key +
                '}';
    }
}
