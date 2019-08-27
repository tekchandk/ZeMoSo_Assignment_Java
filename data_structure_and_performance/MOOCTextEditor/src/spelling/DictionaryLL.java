package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	
    // TODO: Add a constructor
    DictionaryLL()
    {
        dict = new LinkedList<String>();
    }

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
        // Implement this method
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
        // Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        // Implement this method
        if(dict.contains(s.toLowerCase()))
        {
            return true;
        } 
        else{
            return false;
        }
    }

    
}
