
import java.io.*;  
 public class CaesarCipher {
    public String alphabate;
    public String shiftedAlphabate;
    public CaesarCipher(int key) {
       // alphabate = "abcdefghijklmnopqrstuvwxyz";
        alphabate = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabate = alphabate.substring(key) + alphabate.substring(0, key);
    }

    public String encrypt(String input, int key){

        CaesarCipher cipher = new CaesarCipher(key);
        StringBuilder encryptedText = new StringBuilder(input); 
        for(int i = 0; i < input.length(); i++) {
            if(Character.isUpperCase(input.charAt(i))) {
                int index = alphabate.indexOf(Character.toLowerCase(input.charAt(i)));
                char ch = cipher.shiftedAlphabate.charAt(index);
                encryptedText.setCharAt(i,Character.toUpperCase(ch)); 
            }
            else {
                int index = alphabate.indexOf(input.charAt(i));
                if(index != -1) {
                    char ch = cipher.shiftedAlphabate.charAt(index);
                    encryptedText.setCharAt(i,ch); 
                }
            }
        }
        return encryptedText.toString();
    }


    public String encryptTwoKeys(String input, int key1, int key2) {
        CaesarCipher cipher1 = new CaesarCipher(key1);
        CaesarCipher cipher2 = new CaesarCipher(key2);
        CaesarCipher cipher;
        StringBuilder encryptedText = new StringBuilder(input); 
        for(int i = 0; i < input.length(); i++) {
            if(i % 2 == 0) {
                 cipher = cipher1;
            }
            else {
                 cipher = cipher2;
            }

            if(Character.isUpperCase(input.charAt(i))) {
                int index = alphabate.indexOf(Character.toLowerCase(input.charAt(i)));
                char ch = cipher.shiftedAlphabate.charAt(index);
                encryptedText.setCharAt(i,Character.toUpperCase(ch)); 
            }
            else {
                int index = alphabate.indexOf(input.charAt(i));
                if(index != -1) {
                    char ch = cipher.shiftedAlphabate.charAt(index);
                    encryptedText.setCharAt(i,ch); 
                }
            }
        }
        return encryptedText.toString();
    }



    public void testCaesar() throws IOException{
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        int key = 7;
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        System.out.println(encrypt(sb.toString(), key));
        
    } finally {
        br.close();
    }
        
    }

    public static void main(String[] args)throws IOException{
        
        String input = "Ib vwwv jm qv bpm kwvnmzmvkm zwwu eqbp gwcz pib wv nwz i aczxzqam xizbg. GMTT TWCL!";
        int key = 21;
        if(key > 26){
            key = key %26;
        }
        CaesarCipher cipher = new CaesarCipher(key);
        System.out.println(cipher.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));

    }
}
