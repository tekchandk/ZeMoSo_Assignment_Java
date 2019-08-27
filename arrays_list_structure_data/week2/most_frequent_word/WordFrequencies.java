import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies()
    {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();

    }
    public void findUnique () throws IOException
    {
        myWords.clear();
        myFreqs.clear();
        File f1=new File("macbethSmall.txt"); //Creation of File Descriptor for input file
        String[] words=null;  //Intialize the word Array
        FileReader fr = new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s;     
        while((s = br.readLine()) != null)
        {
            words = s.split(" ");
            for(String word : words)
            {
                word = word.toLowerCase();
                if(!myWords.contains(word))
                {
                    myWords.add(word);
                    myFreqs.add(1);
                    
                }
                else
                {
                    int index =  myWords.indexOf(word);
                    int freq_index = myFreqs.get(index);
                    myFreqs.set(index, freq_index + 1);

                }
            }
        }
        fr.close();
    }

    public int findIndexOfMax() throws IOException
    {
        int index = 0;
        for (int i = 0; i < myFreqs.size(); i++) {
            if (myFreqs.get(i) > myFreqs.get(index)) {
                index = i;
            }
        }
        return index;
    }

    public void tester () throws IOException
    {
        findUnique();
        System.out.println(myWords.get(findIndexOfMax()) + ": " + myFreqs.get(findIndexOfMax()));

    }

    public static void main (String[] args) throws IOException
    {
        WordFrequencies wordFrequencies = new WordFrequencies();
        wordFrequencies.tester();
    }
}