package DataStructures.Hash;

public class OpenAddressingTableTest extends BaseHashTableTest {

    @Override
    protected HashTable getHashTable() {
        return new OpenAddressingTable(16);
    }

}
