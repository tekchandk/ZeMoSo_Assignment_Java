import java.io.*;
import java.lang.*;
public class WordLengths {

    public void countWordLengths(int[] counts, File file) {
        try{
            BufferedReader b = new BufferedReader(new FileReader(file));
            String readLine = "";
           // System.out.println("Reading file using Buffered Reader");
                while ((readLine = b.readLine()) != null) {
                    String[] words = readLine.split(" ");
                    for(String word: words) {
                        int length = word.length();
                        if(!Character.isLetter(word.charAt(0))) {
                            length--;
                        }

                        if(!Character.isLetter(word.charAt(word.length() - 1)) && (word.length() != 1)) {
                            length--;
                        }
                        counts[length]++;
                    }
                }
                b.close();
            } catch (IOException e){
                e.printStackTrace();
            }
            System.out.println(indexOfMax(counts));
    }

    public int indexOfMax(int[] values) {
        int max = 1;
        for(int i = 1; i < values.length; i++) {
            if(values[i] > values[max]) {
                max = i;
            }
        }
        return max;
    }

    public void testCountWordLengths() {
        File file = new File("lotsOfWords.txt");
        int[] counts = new int[5000];
        countWordLengths(counts,file);
    }

    public static void main(String[] args) {
        WordLengths wordLengths = new WordLengths();
        wordLengths.testCountWordLengths();

    }

}