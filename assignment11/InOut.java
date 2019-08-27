/* Date: 8th July, 2019
 * Author: Tek Chand
 * Using TextFile and a Map<Character,Integer>, create a program that takes the file name as a command line argument 
 * and counts the occurrence of all the different characters. Save the results in a text file.
*/

package assignment11;
import java.io.*; 
import java.util.HashMap;
import java.util.Scanner;

public class InOut
{ 
	HashMap<Character, Integer> map;
	public InOut()
	{
		map = new HashMap<Character, Integer>();
	}

	public void occurance(File file) throws IOException 
	{
		FileInputStream fileStream = new FileInputStream(file); 
		InputStreamReader input = new InputStreamReader(fileStream); 
		BufferedReader reader = new BufferedReader(input); 
		String line = "";
		while((line = reader.readLine()) != null) 
		{ 
			// Reading the chracters in the string line
			for(int i = 0; i < line.length(); i++)
			{
				char ch = line.charAt(i);
				
				if(!map.containsKey(ch))    // if character is not found in map, count will be 1
				{
					map.put(ch, 1);
				}
				else
				{
					int count = map.get(ch);
					map.put(ch, count + 1);
				}

			}
		}

		// Create a new text file output.txt
		File outputFile = new File("assignment11/output.txt");
		FileWriter fw = new FileWriter(outputFile); 

		// Change map to string
		for(char ch : map.keySet())
		{
			fw.write(String.valueOf(ch) + ": " + Integer.toString(map.get(ch)) +"\n");  
		} 
		fw.close(); 
		//System.out.println(map);
	}

	public void tester() throws IOException 
	{
		Scanner sc = new Scanner(System.in); 
        // String input 
        String fileName = sc.nextLine(); 
		File file = new File(fileName);
		occurance(file);
	}

	public static void main(String[] args) throws IOException 
	{
		InOut inOut = new InOut();
		inOut.tester();
	}
} 
