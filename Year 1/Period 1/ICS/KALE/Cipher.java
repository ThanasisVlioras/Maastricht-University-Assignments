public class Cipher {
    /** This is used to validate message metadata. This is the beaufort cipher, so it is set to 9, as canvas states. */
    public final String CypherId = "9";


    private String encryptOrDecrypt(String plainText, String key) {
        if (key.length() == 0) return "No key was given!";
        if (!isKeyAlphabetical(key)) return "Non alphabetical key was given";
        key = key.toLowerCase();
        String cypherText = "";

        int keyIndex = 0;
        for (char character : plainText.toCharArray()) {
            // If the character is not a letter then we just pass it through as is.
            if (!isCharAlphabetical(character)) {
                cypherText += character;
                continue;
            }

            int keyValue = key.charAt(keyIndex) - 97;
            int zeroIndexedCharacter = (int)character - (isCharUppercase(character) ? 65 : 97);

            int zeroIndexedEncryptedCharacter = (keyValue - zeroIndexedCharacter) % 26;
            if (zeroIndexedEncryptedCharacter < 0) zeroIndexedEncryptedCharacter += 26;

            char finalCharacter =  (char)(zeroIndexedEncryptedCharacter + (isCharUppercase(character) ? 65 : 97));
            cypherText += finalCharacter;

            keyIndex = (keyIndex + 1) % key.length();
        }

        return cypherText;
    }

    // Encryption and decryption are actually the same with this cypher. These are just aliases for encryptOrDecrypt.
    public String encrypt(String plainText, String key) { return encryptOrDecrypt(plainText, key); }
    public String decrypt(String plainText, String key) { return encryptOrDecrypt(plainText, key); }

    /** Checks whether a character is in A-Z. */ 
    public boolean isCharUppercase(char character) {
        int value = (int)character;
        return (value >= 65 && value <= 90);
    }

    /** Checks whether a character is in a-z. */
    public boolean isCharLowercase(char character) {
        int value = (int)character;
        return (value >= 97 && value <= 122);
    }

    /** Checks whether a character is in A-Z or in a-z. */
    public boolean isCharAlphabetical(char character) {
        return isCharUppercase(character) || isCharLowercase(character);
    }

    /** Checks whether the entire key is made of alphabetical characters */
    public boolean isKeyAlphabetical(String key) {
        key = key.toLowerCase();

        for (char character : key.toCharArray()) {
            if (!isCharAlphabetical(character)) return false;
        }

        return true;
    }
}

class CipherTest {
    public static void main(String[] args) {
        Cipher cypher = new Cipher();

        String key = "GRUMINIONBaNANA";

        String encrypted = cypher.encrypt("Hello, world! Lorem ipsum dolor sis amet", key);
        System.out.println(encrypted);
        System.out.println(cypher.decrypt(encrypted, key));

    }
}