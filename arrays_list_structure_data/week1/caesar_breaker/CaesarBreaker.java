public class CaesarBreaker {
    
    
    public int[] countLetters(String message) {
        String alphabhate = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }

    public int maxIndex(int[] values) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > values[max]) {
                max = i;
            }
        }
        return max;
    }

    public String halfOfString(String message, int start) {
        StringBuilder halfString = "";
        for (int i = start; i < message.length(); i += 2) {
            halfString = halfString + message.charAt(i);
        }
        return halfString;
    }

    public int getKey(String s) {
        int maxInd = maxIndex(countLetters(s));
        int key = maxInd - 4;
        if (maxInd < 4) {
            key = 26 - (4 - maxInd);
        }
        return key;
    }
    
    CaesarCipher cc = new CaesarCipher();
    String message = cc.encrypt(encrypted, 26 - key);


    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(encrypted, 26 - key);
    }
    public String decryptTwoKeys(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        String halfString1 = halfOfString(encrypted, 0);
        String halfString2 = halfOfString(encrypted, 1);
        int key1 = getKey(halfString1);
        int key2 = getKey(halfString2);
        System.out.println("Key1: "+ key1 + "\n" + "Key2: "+ key2);
        return cc.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
    }
    public void testDecrypt() {
      System.out.println(decryptTwoKeys());

    }
}