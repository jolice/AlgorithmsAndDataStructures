package DataStructures.Hash;

public class ChainingTableTest extends BaseHashTableTest {
    @Override
    protected HashTable getHashTable() {
        return new ChainingTable(16);
    }
}
