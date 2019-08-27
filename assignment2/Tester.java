package assignment2;
import assignment2.Pangram;
import java.util.*;
public class Tester 
{
    public static void main(String[] args) 
	{ 
        Scanner sc = new Scanner(System.in); 
		String str = sc.nextLine(); //"The quick brown fox jumps over the lazy dog"; 
        sc.close();
        Pangram pangram = new Pangram();
		if (pangram.checkPangram(str) == true) 
			System.out.print(str + " is a pangram."); 
		else
            System.out.print(str+ " is not a pangram.");       

    } 
}