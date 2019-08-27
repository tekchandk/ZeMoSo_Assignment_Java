package assignment1;
import java.io.*; 
import java.util.*;
import  java.util.regex.Pattern;
import assignment1.PathDirectory;
public class Tester {

    public static void main(String args[]) throws IOException 
    {
        System.out.println("Enter the regex pattern for searching the file from home directory: ");
        Scanner s1 = new Scanner(System.in);
        String pattern = s1.nextLine();
        System.out.println("Press quit to terminate: ");
        while (!pattern.equals("quit"))
        {
            File f = new File(".");
            File[] files = f.listFiles(); 
            String path = "";
            PathDirectory pathDirectory= new PathDirectory();
            pathDirectory.SearchFile(files, pattern, path);
            pattern = s1.nextLine();
        }
    }

}
