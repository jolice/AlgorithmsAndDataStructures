package Algorithms.Encryption;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XOREncryptionRandomTest {

    private static final String TEXT = "text";

    @Test
    public void doTest() {
        XOREncryptionRandom xorEncryptionRandom = new XOREncryptionRandom();
        byte[] rndKey = xorEncryptionRandom.key(TEXT);
        byte[] encrypted = xorEncryptionRandom.encrypt(TEXT, rndKey);
        byte[] decrypted = xorEncryptionRandom.decrypt(encrypted, rndKey);
        assertEquals(TEXT, new String(decrypted));
    }
}