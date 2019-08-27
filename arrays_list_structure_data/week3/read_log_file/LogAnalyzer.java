
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;
//import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry> ();
     }

    
        
     public void readFile(String filename) {
         // complete method
        File f = new File(filename);
        try{
        BufferedReader b = new BufferedReader(new FileReader(f));
        String readLine = "";
       // System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
                LogEntry l = WebLogParser.parseEntry(readLine);
                this.records.add(l);
                //System.out.println(readLine);
            }
            b.close();
        } catch (IOException e){
            e.printStackTrace();
        }

     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
