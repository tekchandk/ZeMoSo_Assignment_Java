import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CharactersInPlay
{
    private ArrayList<String> names;
    private ArrayList<Integer> counts;

    public CharactersInPlay()
    {
        names = new ArrayList<String>();
        counts = new ArrayList<Integer>();

    }
    public void update (String person)
    {
        if(!names.contains(person))
        {
            names.add(person);
            counts.add(1);
            
        }
        else
        {
            int index =  names.indexOf(person);
            int freq_index = counts.get(index);
            counts.set(index, freq_index + 1);

        }
    }

    public void findAllCharacters() throws IOException
    {
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
                if(word.contains("."))
                {
                    String person = word.split("\\.")[0].trim();
                    update(person);
                }
            }
        }
    }

    public void charactersWithNumParts(int num1, int num2) throws IOException {
        findAllCharacters();
        System.out.println("Names who have exactly " + num1 + "-" + num2 + " speaking parts:");
        for (int k = 0; k < names.size(); k++) {
            int count = counts.get(k);
            if (count >= num1 && count <= num2) {
                System.out.println(names.get(k));
            }
        }
    }

    public void tester() throws IOException
    {
        charactersWithNumParts(10, 15);
        for (int k = 0; k < names.size(); k++) {
            int count = counts.get(k);
            // NOTE: A main character is one who has greater than 2 speaking parts
            if (count > 2) {
                System.out.println(names.get(k) + " has " + count + " speaking parts");
            }    
        }
       
    }
    public static void main(String[] args) throws IOException {
        CharactersInPlay charactersInPlay = new CharactersInPlay();
        charactersInPlay.tester();
    }
}