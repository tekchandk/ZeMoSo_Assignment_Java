import java.io.*;
import java.util.*;
public class WordsInFiles
{
    private HashMap<String, ArrayList<String>> map;
    public WordsInFiles()
    {
        map = new HashMap<String, ArrayList<String>>();
    }
    private void addWordsFromFile(File f) throws IOException
    {
        FileReader fr = new FileReader(f);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s; 
        String fileName = f.getName();    
        while((s = br.readLine()) != null)
        {
            String[] words = s.split(" ");
            for(String word : words)
            {
                if(!map.containsKey(word))
                {
                    ArrayList<String> array= new ArrayList<String>();
                    array.add(fileName);
                    map.put(word, array);
                }
                else
                {    
                    ArrayList<String> array = map.get(word);
                    if (!array.contains(fileName)) 
                    {
                        array.add(fileName);
                    }
                }
            }
        }
    }

    public void buildWordFileMap() throws IOException
    {
        map.clear();
        File dir = new File("textfiles");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) 
        {
            for (File child : directoryListing) 
            {
                addWordsFromFile(child);
            }
        }
    }

    public int maxNumber()
    {
        int max = 0;
        for(String word : map.keySet())
        {
            if(max < map.get(word).size())
            {
                max = map.get(word).size();
            }
        }
        return max;
    }

    public ArrayList<String> wordsInNumFiles(int number)
    {
        ArrayList<String> words = new ArrayList<String>();
        for(String word : map.keySet())
        {
            if(number == map.get(word).size())
            {
                words.add(word);
            }
        }
        return words;
    }
    
    public void printFilesIn (String word)
    {
        ArrayList<String> fileNames = map.get(word);
        for(int i = 0; i < fileNames.size(); i++)
        {
            System.out.println(fileNames.get(i));
        }
    }

    public void tester() throws IOException
    {
        buildWordFileMap();
        System.out.println(maxNumber());
        printFilesIn("cats");
        System.out.println(wordsInNumFiles(1));
    }
    public static void main(String[] args)  throws IOException
    {
        WordsInFiles wordsInFiles = new WordsInFiles();
        wordsInFiles.tester();
    }
}