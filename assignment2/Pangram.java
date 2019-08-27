
/*
 * Author: Tek Chand
 * Date: 22nd July, 2019
 * Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive). 
 * Write time and space complexity of your solution as comments in the source file.
*/ 
package assignment2;
import java.util.Scanner;
public class Pangram 
{ 

	// Returns true if the string 
	// is pangram else false 
	public static boolean checkPangram (String str) 
	{ 
		boolean[] mark = new boolean[26]; 

		// For indexing in mark[] 
		int index = 0; 

		// Traverse all characters 
		for (int i = 0; i < str.length(); i++) 
		{ 
			// If uppercase character, subtract 'A' 
			// to find index. 
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') 
			{
				index = str.charAt(i) - 'A'; 
			}
			// If lowercase character, subtract 'a' 
			// to find index. 
			else if('a' <= str.charAt(i) && str.charAt(i) <= 'z') 
			{				
				index = str.charAt(i) - 'a'; 
			}

			// Mark current character 
			mark[index] = true; 
		} 

		// Return false if any character is unmarked 
		for (int i = 0; i <= 25; i++) 
			if (mark[i] == false) 
			{
				return false; 
			}

		// If all characters were present 
		return (true); 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
        Scanner sc = new Scanner(System.in); 
		String str = sc.nextLine();//"The quick brown fox jumps over the lazy dog"; 
        sc.close();
		if (checkPangram(str) == true) 
			System.out.print(str + " is a pangram."); 
		else
            System.out.print(str+ " is not a pangram."); 
            

    } 
    
} 
