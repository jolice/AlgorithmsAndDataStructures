package DataStructures.Hash;

public interface HashTable {

    double MAX_LOAD_FACTOR = 0.75;

    String find(Integer key);

    void insert(Integer key, String value);

    String delete(Integer key);


}
