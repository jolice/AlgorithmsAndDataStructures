package DataStructures.Hash;

public class DoubleHashingTableTest extends BaseHashTableTest {

    @Override
    protected HashTable getHashTable() {
        return new DoubleHashingTable(16);
    }
}
