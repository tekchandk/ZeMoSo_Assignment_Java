package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
	
    // TODO: Implement the dictionary interface using a TreeSet.  
     // You'll need a constructor here
     DictionaryBST()
     {
         dict = new TreeSet<String>();
     }
	
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	String wordAddToDict = word.toLowerCase();
    	if (dict.contains(wordAddToDict)) {
    		return false;
    	} else {
    		dict.add(wordAddToDict);
            return true;
    	}
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	// TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        if(dict.contains(s.toLowerCase()))
        {
            return true;
        } 
        else{
            return false;
        }
    }

}
