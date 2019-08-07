package Algorithms.Encryption;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XOREncryptionPlainTest {

    @Test
    public void doTest() {
        XOREncryptionPlain xorEncryption = new XOREncryptionPlain();
        byte[] encrypted = xorEncryption.encrypt("hello world!", "test key");
        String decrypted = xorEncryption.decrypt(encrypted, "test key");
        assertEquals("hello world!", decrypted);
    }



}