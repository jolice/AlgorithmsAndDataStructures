package Algorithms.Encryption;


import java.util.Random;

public class XOREncryptionRandom {

    public byte[] key(String text) {
        byte[] key = new byte[text.getBytes().length * 8];
        Random random = new Random();
        for (int i = 0; i < key.length; i += 8) {
            for (int j = i; j < i + 8; j++) {
                key[j] = (byte) (random.nextBoolean() ? 0 : 1);
            }
        }
        return key;
    }

    public byte[] encrypt(String text, byte[] key) {

        byte[] textBytes = text.getBytes();
        byte[] encryptedBits = new byte[textBytes.length * 8];

        int bitCount = 0;
        for (byte textByte : textBytes) {
            for (int i = 0; i < 8; i++) {
                byte bin = (byte) ((textByte & 128) == 0 ? 0 : 1);
                encryptedBits[bitCount] = (byte) (bin ^ key[bitCount]);
                textByte <<= 1;
                bitCount++;
            }
        }
        return encryptedBits;
    }


    public byte[] decrypt(byte[] encrypted, byte[] key) {
        byte[] decryptedResult = new byte[encrypted.length / 8];
        int bitCount = 0;
        for (int i = 0; i < encrypted.length; i += 8) {
            StringBuilder byteBuilder = new StringBuilder();
            for (int j = i; j < i + 8; j++) {
                byte xor = (byte) (encrypted[j] ^ key[bitCount]);
                byteBuilder.append(xor);
                bitCount++;
            }

            decryptedResult[i / 8] = (byte) Integer.parseInt(byteBuilder.toString(), 2);
        }
        return decryptedResult;
    }

   
}
