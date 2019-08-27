
/*
 * Author: Tek Chand
 * Date: 22nd July
 * Create a java program to search through the home directory and look for files that match a regular expression. 
 * The program should be able to take inputs repeatedly and should print out the full absolute path of the matching files found.
*/




package assignment1;
import java.io.*; 
import java.util.*;
import  java.util.regex.Pattern;
import java.lang.*;
public class PathDirectory{

    // Searching the files from home directory
    public void SearchFile(File[] files, String pattern, String path)
    {
        String fullPath = path;

        for (File file : files)
        {
            String fileName = file.getName();
            if(file.isDirectory())
            {
                fullPath = path+"/" + fileName;
                SearchFile(file.listFiles(), pattern, fullPath);    
            }
            else
            {
                Pattern p = Pattern.compile(pattern);
                boolean found = p.matcher(fileName).lookingAt();

                if(found)
                {
                    System.out.println("Path: " + fullPath + "/" + fileName);
                }
            }
        }
    }
}