/*
 * Author: Tek Chand
 * Date: 16thJuly, 2019

 * You will write a program to transform words from a file into another form, such as replacing
 * vowels with an asterix.
*/
//package coursera.array_list_structure_data.week1.wordplay; 

public class WordPlay{

    public boolean isVowel(char ch) {
        String vowels = "aeiou";
        ch = Character.toLowerCase(ch);
        if(vowels.indexOf(ch) != -1){
            return true;
        } 
        else{
            return false;
        }
    }

    public String replaceVowels(String phrase, char ch){
        StringBuilder replace = new StringBuilder(phrase);
        for(int i = 0; i < phrase.length(); i++) {
            if(isVowel(phrase.charAt(i))) {
                replace.setCharAt(i, ch);
            }
        }
        return replace.toString();
    }

    public String emphasize(String phrase, char ch){
        StringBuilder emphasizeStr = new StringBuilder(phrase);
        for(int i = 0; i < phrase.length(); i++) {
            if(Character.toLowerCase(emphasizeStr.charAt(i)) == Character.toLowerCase(ch)) {
                if(i % 2 == 0) {            // an odd number location
                    emphasizeStr.setCharAt(i, '*');
                }
                else {                      // an even number location
                    emphasizeStr.setCharAt(i, '+');
                }
            }
        }
    return emphasizeStr.toString();
    }

    public static void main(String[] args) {
        WordPlay wordPlay = new WordPlay();
        System.out.println(wordPlay.emphasize("Mary Bella Abracadabra", 'a'));
        
    }
}