package Algorithms.Encryption;

public class XOREncryptionPlain {

    public byte[] encrypt(String text, String encryptionKey) {

        byte[] encryptedData = new byte[text.length()];

        for (int i = 0; i < text.length(); i++) {
            byte b = (byte) (text.charAt(i) ^ encryptionKey.charAt(i % encryptionKey.length()));
            encryptedData[i] = b;
        }

        return encryptedData;
    }

    public String decrypt(byte[] encryptedText, String encryptionKey) {

        byte[] decryptedData = new byte[encryptedText.length];
        byte[] key = encryptionKey.getBytes();

        for (int i = 0; i < encryptedText.length; i++) {
            decryptedData[i] = (byte) (encryptedText[i] ^ key[i % key.length]);
        }

        return new String(decryptedData);
    }
}
